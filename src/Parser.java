import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import pdmObj.PdmInfo;
import pdmObj.PDMColumn;
import pdmObj.PDMIndex;
import pdmObj.PDMReference;
import pdmObj.PDMTable;

/**
 * 针对PDM 16.5的解析
 * 解析范围:
 * 1.model信息
 * 2.数据库类型
 * 3.表信息
 * 3.1 表包含字段信息
 * 3.2 表索引信息
 * 3.3 表外键信息
 */
public class Parser {

//  public static void main(String[] args) {
//    try {
//      Date start = new Date();
//      String path = "/Users/zhouyh/Desktop/sss.pdm";
//      PDM pdm = new Parser().pdmParser(path);
//      System.out.println(System.currentTimeMillis() - start.getTime());
//      System.out.println(JSON.toJSONString(pdm));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }

  /**
   * pdm解析
   *
   * @param file
   * @return
   * @throws Exception
   */
  public PdmInfo pdmParser(File file) throws Exception {

    Node model = this.getPDMModelNote(file);

    PdmInfo pdm = this.pdmModelParser(model);

    //解析 table
    pdm.setTables(pdmTableParser(model));

    Map<String, PDMColumn> pdmColumnMap = new HashMap<>(100);
    Map<String, PDMTable> pdmTableMap = new HashMap<>(100);
    for (PDMTable table : pdm.getTables()) {
      pdmTableMap.put(table.getTableId(), table);

      pdmColumnMap.putAll(table.getColumns().stream()
          .collect(Collectors.toMap(PDMColumn::getColumnId, a -> a, (k1, k2) -> k1)));
    }

    //解析关联关系
    pdm.setReferences(pdmReferenceParser(model, pdmColumnMap, pdmTableMap));

    pdmColumnMap.clear();
    pdmTableMap.clear();

    return pdm;
  }


  /**
   * 获取PDM model节点对象
   *
   * @param file
   * @return
   * @throws Exception
   */
  public Node getPDMModelNote(File file) throws Exception {
    SAXReader reader = new SAXReader();
    Document doc = reader.read(file);

    Node model = doc.selectSingleNode("//c:Children/o:Model");

    if (model == null) {
      throw new Exception("解析PDM文件失败,无法获取根节点,请检查节点://c:Children/o:Model");
    }

    return model;
  }

  /**
   * 解析dpm model属性
   *
   * @param model
   * @return
   * @throws Exception
   */
  public PdmInfo pdmModelParser(Node model) {

    PdmInfo pdm = new PdmInfo();

    pdm.setModelId(this.selectNodeAttributeValue(model, "Id"));
    pdm.setModelName(this.selectNodeText(model.selectSingleNode("a:Name")));
    pdm.setModelCode(this.selectNodeText(model.selectSingleNode("a:Code")));

    //DBMS设定,包含数据库名称和数据库类型(这里包含版本)
    //<a:Name>MySQL 5.0</a:Name>
    //<a:Code>MYSQL50</a:Code>
    Node dbms = model.selectSingleNode("//c:DBMS/o:Shortcut");
    pdm.setDbmsCode(this.selectNodeText(dbms.selectSingleNode("a:Code")));
    pdm.setDbmsName(this.selectNodeText(dbms.selectSingleNode("a:Name")));

    return pdm;
  }

  /**
   * 解析表
   *
   * @param modelNode
   * @return
   * @throws Exception
   */
  public List<PDMTable> pdmTableParser(Node modelNode) {

    List<PDMTable> tableList = new ArrayList<>();

    List<Node> tableNodeList = modelNode.selectNodes("c:Tables/o:Table");

    if (tableNodeList != null && tableNodeList.size() > 0) {
      PDMTable pdmTable = null;
      for (Node tableNode : tableNodeList) {

        pdmTable = new PDMTable();

        pdmTable.setTableId(this.selectNodeAttributeValue(tableNode, "Id"));
        pdmTable.setTableName(this.selectSingleNodeStringText(tableNode, "a:Name"));
        pdmTable.setTableCode(this.selectSingleNodeStringText(tableNode, "a:Code"));

        // 添加Columns
        List<PDMColumn> columnList = pdmColumnParser(tableNode);
        pdmTable.getColumns().addAll(columnList);

        Map<String, PDMColumn> pdmColumnMap = columnList.stream()
            .collect(Collectors.toMap(PDMColumn::getColumnId, a -> a, (k1, k2) -> k1));

        //解析key
        pdmKeysParser(tableNode, pdmColumnMap);

        // 添加Indexes
        pdmTable.getIndexs().addAll(pdmIndexParser(tableNode, pdmColumnMap));

        tableList.add(pdmTable);
      }
    }
    return tableList;
  }

  /**
   * 解析表的字段
   *
   * @param tableNode 表Node
   * @return
   */
  public List<PDMColumn> pdmColumnParser(Node tableNode) {
    List<PDMColumn> columnList = new ArrayList<>();

    List<Node> columnNodeList = tableNode.selectNodes("c:Columns/o:Column");

    if (columnNodeList != null && columnNodeList.size() > 0) {
      PDMColumn pdmColumn = null;
      for (Node columnNode : columnNodeList) {
        pdmColumn = new PDMColumn();
        pdmColumn.setColumnId(this.selectNodeAttributeValue(columnNode, "Id"));
        pdmColumn.setColumnName(selectSingleNodeStringText(columnNode, "a:Name"));
        pdmColumn.setColumnCode(selectSingleNodeStringText(columnNode, "a:Code"));
        pdmColumn.setDataType(selectSingleNodeStringText(columnNode, "a:DataType"));
        pdmColumn.setLength(selectSingleNodeIntText(columnNode, "a:Length"));
        pdmColumn.setPrecision(selectSingleNodeIntText(columnNode, "a:Precision"));
        pdmColumn.setMandatory(selectSingleNodeIntText(columnNode, "a:Column.Mandatory"));
        pdmColumn.setDefaultValue(selectSingleNodeStringText(columnNode, "a:DefaultValue"));
        pdmColumn.setComment(selectSingleNodeStringText(columnNode, "a:Comment"));
        columnList.add(pdmColumn);
      }
    }

    return columnList;
  }

  /**
   * 解析c:Keys 设置主键
   *
   * @param tableNode 表Node
   * @return
   */
  public void pdmKeysParser(Node tableNode, Map<String, PDMColumn> pdmColumnMap) {

    //主键关联的key
    String pkRefkeyId = ((Element) tableNode.selectSingleNode("c:PrimaryKey/o:Key")).attributeValue("Ref");

    List<Node> keyNodeList = tableNode.selectNodes("c:Keys/o:Key");

    if (keyNodeList != null && keyNodeList.size() > 0) {
      for (Node keyNode : keyNodeList) {

        String keyId = this.selectNodeAttributeValue(keyNode, "Id");

        if (pkRefkeyId != null && pkRefkeyId.equals(keyId)) {
          //获取keys中包含的字段
          List<Node> keyColumnNodeList = keyNode.selectNodes("c:Key.Columns/o:Column");
          if (keyColumnNodeList != null && keyColumnNodeList.size() > 0) {
            for (Node column : keyColumnNodeList) {
              String columnId = this.selectNodeAttributeValue(column, "Ref");
              if (pdmColumnMap.get(columnId) != null) {
                pdmColumnMap.get(columnId).setIsPk(1);
              }
            }
          }
        }
      }
    }
  }

  /**
   * 解析索引
   *
   * @param tableNode
   * @param pdmColumnMap
   */
  public List<PDMIndex> pdmIndexParser(Node tableNode, Map<String, PDMColumn> pdmColumnMap) {

    List<PDMIndex> indexList = new ArrayList<>();
    List<Node> indexNodeList = tableNode.selectNodes("c:Indexes/o:Index");
    if (indexNodeList != null && indexNodeList.size() > 0) {
      PDMIndex pdmIndex = null;
      for (Node indexNode : indexNodeList) {
        pdmIndex = new PDMIndex();
        pdmIndex.setId(this.selectNodeAttributeValue(indexNode, "Id"));
        pdmIndex.setName(selectSingleNodeStringText(indexNode, "a:Name"));
        pdmIndex.setCode(selectSingleNodeStringText(indexNode, "a:Code"));
        pdmIndex.setIsUnique(selectSingleNodeIntText(indexNode, "a:Unique"));

        for (Object indexColumn : indexNode.selectNodes("c:IndexColumns/o:IndexColumn")) {
          String columnId = this.selectSingleNodeAttributeValue(((Element) indexColumn), "c:Column/o:Column", "Ref");

          if (pdmColumnMap.get(columnId) != null) {
            pdmIndex.getColumns().add(pdmColumnMap.get(columnId).getColumnCode());
          }
        }
        indexList.add(pdmIndex);
      }
    }

    return indexList;
  }


  /**
   * 解析关联关系
   *
   * @param modelNode
   * @return
   */
  public List<PDMReference> pdmReferenceParser(Node modelNode, Map<String, PDMColumn> pdmColumnMap,
      Map<String, PDMTable> pdmTableMap) {

    List<PDMReference> referenceList = new ArrayList<>();

    PDMReference pdmReference = null;
    for (Object reference : modelNode.selectNodes("c:References/o:Reference")) {
      Node referenceNode = (Node) reference;
      pdmReference = new PDMReference();
      pdmReference.setId(this.selectNodeAttributeValue(referenceNode, "Id"));
      pdmReference.setName(selectSingleNodeStringText(referenceNode, "a:Name"));
      pdmReference.setCode(selectSingleNodeStringText(referenceNode, "a:Code"));

      // 添加ParentTable
      String parentTableId = this.selectSingleNodeAttributeValue(referenceNode, "c:ParentTable/o:Table", "Ref");

      if (pdmTableMap.get(parentTableId) != null) {
        pdmReference.setParentTableName(pdmTableMap.get(parentTableId).getTableCode());
      }

      // 添加ChildTable
      String childTableId = this.selectSingleNodeAttributeValue(referenceNode, "c:ChildTable/o:Table", "Ref");
      if (pdmTableMap.get(childTableId) != null) {
        pdmReference.setChildTableName(pdmTableMap.get(childTableId).getTableCode());
      }

      Node referenceJoinNode = referenceNode.selectSingleNode("c:Joins/o:ReferenceJoin");

      // 添加关联字段
      if (referenceJoinNode != null) {

        String parentColumnId = selectSingleNodeAttributeValue(referenceJoinNode, "c:Object1/o:Column", "Ref");

        //parentColumnCode
        if (pdmColumnMap.get(parentColumnId) != null) {
          pdmReference.setParentColumnCode(pdmColumnMap.get(parentColumnId).getColumnCode());
        }

        String childColumnId = selectSingleNodeAttributeValue(referenceJoinNode, "c:Object2/o:Column", "Ref");

        //childColumnCode
        if (pdmColumnMap.get(childColumnId) != null) {
          pdmReference.setChildColumnCode(pdmColumnMap.get(parentColumnId).getColumnCode());
        }
      }
      referenceList.add(pdmReference);
    }
    return referenceList;
  }


  /**
   * 获取节点的属性值
   *
   * @param parentNode
   * @param attributeValueKey
   * @return
   */
  private String selectSingleNodeAttributeValue(Node parentNode, String childNodeName, String attributeValueKey) {

    if (parentNode == null) {
      return "";
    }

    Node childNode = parentNode.selectSingleNode(childNodeName);
    return selectNodeAttributeValue(childNode, attributeValueKey);
  }

  /**
   * 获取节点的属性值
   *
   * @param node
   * @param attributeValueKey
   * @return
   */
  private String selectNodeAttributeValue(Node node, String attributeValueKey) {
    if (node != null) {
      return ((Element) node).attributeValue(attributeValueKey);
    } else {
      return "";
    }
  }


  /**
   * parentNode.selectSingleNode --> .getText
   *
   * @param parentNode
   * @param childNodeName
   * @return
   */
  private String selectSingleNodeStringText(Node parentNode, String childNodeName) {

    if (parentNode == null) {
      return "";
    }
    Node childNode = parentNode.selectSingleNode(childNodeName);
    return selectNodeText(childNode);
  }

  /**
   * parentNode.selectSingleNode --> Integer.parseInt .getText
   *
   * @param parentNode
   * @param childNodeName
   * @return
   */
  private int selectSingleNodeIntText(Node parentNode, String childNodeName) {
    if (parentNode == null) {
      return 0;
    }

    Node childNode = parentNode.selectSingleNode(childNodeName);
    String textStr = selectNodeText(childNode);
    if (StringUtils.isNumeric(textStr)) {
      return Integer.parseInt(textStr);
    } else {
      return 0;
    }
  }

  /**
   * 获取node的text值,如果为空则返回空字符串
   *
   * @param node
   * @return
   */
  private String selectNodeText(Node node) {
    if (node != null) {
      return node.getText();
    } else {
      return "";
    }
  }
}
