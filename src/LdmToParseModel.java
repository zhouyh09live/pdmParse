import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ldmObj.LdmAttribute;
import ldmObj.LdmEntity;
import ldmObj.LdmIdentifier;
import ldmObj.LdmInfo;
import ldmObj.LdmRelationship;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import parseobj.ParseColumn;
import parseobj.ParseModelInfo;
import parseobj.ParseTable;
import pdmObj.PDMColumn;
import pdmObj.PDMTable;


/**
 * @author chenjazz
 * 参考
 */
public class LdmToParseModel {

  public static boolean isTest = false;


  public static void main(String[] args) {
    LdmToParseModel app = new LdmToParseModel();
    try {
      ParseModelInfo ldmInfo = app.dealTblFromLDM("/Users/zhouyh/Desktop/LogicalDataModel_all.ldm");
      System.out.println(JSON.toJSONString(ldmInfo));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 读取LDM文件内容
   *
   * @param fileName
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public ParseModelInfo dealTblFromLDM(String fileName) throws Exception {

    ParseModelInfo parseModelInfo = new ParseModelInfo();

    // 创建saxReader对象
    SAXReader reader = new SAXReader();

    // 通过read方法读取一个文件 转换成Document对象
    Document document = reader.read(new File(fileName));

    // 获取根节点元素对象
    Element root = document.getRootElement();

    // 获取RootObject节点元素对象
    Element objElm = root.element("RootObject");

    // 获取Children节点元素对象
    Element childElm = objElm.element("Children");

    // 获取Model节点元素对象
    Element modelElm = childElm.element("Model");

    // 获取表和字段的基本信息
    Element entitiesElm = modelElm.element("Entities");
    if (entitiesElm != null) {
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = entitiesElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        parseModelInfo.getTables().add(dealTblAttrInfo(elm));
      }
    }

//    Map<String, ParseColumn> parseColumnHashMap = new HashMap<>(100);
//    Map<String, ParseTable> parseTableHashMap = new HashMap<>(100);
//
//    for (ParseTable table : parseModelInfo.getTables()) {
//      parseTableHashMap.put(table.getTableId(), table);
//
//      parseColumnHashMap.putAll(table.getColumns().stream()
//          .collect(Collectors.toMap(ParseColumn::getColumnId, a -> a, (k1, k2) -> k1)));
//    }

    //解析关联关系
//    // 获取Relationships节点元素对象
//    Element relsElm = modelElm.element("Relationships");
//    if (relsElm != null) {
//      // 获取Relationship元素列表，当前节点下面子节点迭代器
//      Iterator<Element> it = relsElm.elementIterator();
//      // 遍历
//      while (it.hasNext()) {
//        // 获取某个子节点对象
//        Element elm = (Element) it.next();
//        LdmRelationship ldmRelationship = dealRelShipInfo(elm);
//        ldmInfo.getRelHash().put(ldmRelationship.getOid(), ldmRelationship);
////        ldmInfo.addRelHash(ldmRelationship);
//      }
//    }

    return parseModelInfo;
  }


  /**
   * 解析数据库表信息（获取全部Attribute属性信息）
   *
   * @param node
   */
  @SuppressWarnings("unchecked")
  public ParseTable dealTblAttrInfo(Element node) throws Exception {

    ParseTable parseTable = new ParseTable();

    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    parseTable.setTableId(attribute.getText());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    parseTable.setTableName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    parseTable.setTableCode(codeElm.getTextTrim());

    // 获取Comment节点元素对象
    Element commentElm = node.element("Comment");
    if (commentElm != null) {
      parseTable.setRemark(commentElm.getTextTrim());
    }

    // 获取PrimaryIdentifier节点元素对象
    String pkOid = "";
    Element pkElm = node.element("PrimaryIdentifier");
    if (pkElm != null) {
      Element pkIdentElm = pkElm.element("Identifier");
      if (pkIdentElm != null) {
        Attribute refAttr = pkIdentElm.attribute("Ref");
        if (refAttr != null) {
          pkOid = refAttr.getText();
        }
      }
    }

    // 获取Identifiers节点元素对象
    Element attrsElm = node.element("Attributes");
    if (attrsElm != null) {
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = attrsElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        parseTable.getColumns().add(dealAttrbute(elm, pkOid));
      }
    }

    return parseTable;
  }

  /**
   * 解析属性（表字段）信息
   *
   * @param node
   * @return
   * @throws Exception
   */
  public ParseColumn dealAttrbute(Element node, String pkOid) throws Exception {
    ParseColumn parseColumn = new ParseColumn();

    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    parseColumn.setColumnId(attribute.getText());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    parseColumn.setColumnName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    parseColumn.setColumnCode(codeElm.getTextTrim());

    // 获取Code节点元素对象
    Element commentElm = node.element("Comment");
    if (commentElm != null) {
      parseColumn.setComment(commentElm.getTextTrim());
    }

    // 获取DataType节点元素对象
    Element dataTypeElm = node.element("DataType");
    if (dataTypeElm != null) {
      parseColumn.setDataType(dataTypeElm.getTextTrim().replaceAll("[^a-zA-Z]", ""));
    }

    // 获取Code节点元素对象
    Element lengthElm = node.element("Length");
    if (lengthElm != null) {
      parseColumn.setLength(this.excuteIntType(lengthElm.getTextTrim()));
    }

    Element precisionElm = node.element("Precision");
    if (precisionElm != null) {
      parseColumn.setPrecision(this.excuteIntType(precisionElm.getTextTrim()));
    }

    // 主键标识
    if (parseColumn.getColumnId().equals(pkOid)) {
      parseColumn.setIsPk(1);
    }

    // 获取LogicalAttribute.Mandatory节点元素对象
    Element mandatoryElm = node.element("LogicalAttribute.Mandatory");
    if (mandatoryElm != null) {
      if (mandatoryElm.getTextTrim().equalsIgnoreCase("1")) {
        parseColumn.setMandatory(1);
      }
    }

    // 获取DefaultValue节点元素对象
    Element defValElm = node.element("DefaultValue");
    if (defValElm != null) {
      parseColumn.setDefaultValue(defValElm.getTextTrim());
    }

    return parseColumn;
  }

  /**
   * @param textStr
   * @return
   */
  private int excuteIntType(String textStr) {
    if (StringUtils.isNumeric(textStr)) {
      return Integer.parseInt(textStr);
    } else {
      return 0;
    }
  }
}
