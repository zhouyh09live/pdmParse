import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.DEFAULT;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ldmObj.LdmAttribute;
import ldmObj.LdmEntity;
import ldmObj.LdmIdentifier;
import ldmObj.LdmInfo;
import ldmObj.LdmRelationship;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;


/**
 * @author chenjazz
 * 参考
 */
public class LdmMainReader {

  public static boolean isTest = false;


  public static void main(String[] args) {
    LdmMainReader app = new LdmMainReader();
    try {
      LdmInfo ldmInfo = app.dealTblFromLDM("/Users/zhouyh/Desktop/LogicalDataModel_all.ldm", "tmpXmlFileName");
      System.out.println(JSON.toJSONString(ldmInfo));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 读取LDM文件内容
   *
   * @param fileName
   * @param tmpXmlFileName
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public LdmInfo dealTblFromLDM(String fileName, String tmpXmlFileName) throws Exception {
    LdmInfo ldmInfo = new LdmInfo();
    // 创建saxReader对象
    SAXReader reader = new SAXReader();
    // 通过read方法读取一个文件 转换成Document对象
    Document document = reader.read(new File(fileName));
    //
    writer(document, "src//" + tmpXmlFileName + ".xml");

    // 获取根节点元素对象
    Element root = document.getRootElement();
    // if (isTest) {
    // showNodeInfo(root);
    // }

    // 获取RootObject节点元素对象
    Element objElm = root.element("RootObject");
    // if (isTest) {
    // showNodeInfo(objElm);
    // }

    // 获取Children节点元素对象
    Element childElm = objElm.element("Children");
    // if (isTest) {
    // showNodeInfo(childElm);
    // }

    // 获取Model节点元素对象
    Element modelElm = childElm.element("Model");
    // if (isTest) {
    // showNodeInfo(modelElm);
    // }

    // 获取Entities节点元素中的全部EntityAttribute对象
    Element entitiesElm = modelElm.element("Entities");
    if (entitiesElm != null) {
      // if (isTest) {
      // showNodeInfo(entitiesElm);
      // }
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = entitiesElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        // if (isTest) {
        // showNodeInfo(elm);
        // }
        dealTblAttrInfo(elm, ldmInfo);
      }
    }

    // 获取Relationships节点元素对象
    Element relsElm = modelElm.element("Relationships");
    if (relsElm != null) {
      if (isTest) {
        showNodeInfo(relsElm);
      }
      // 获取Relationship元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = relsElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        // if (isTest) {
        // showNodeInfo(elm);
        // }
        LdmRelationship ldmRelationship = dealRelShipInfo(elm);
        ldmInfo.getRelHash().put(ldmRelationship.getOid(), ldmRelationship);
//        ldmInfo.addRelHash(ldmRelationship);
      }
    }

    // 获取Entities节点元素对象
    if (entitiesElm != null) {
      // if (isTest) {
      // showNodeInfo(entitiesElm);
      // }
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = entitiesElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        // if (isTest) {
        // showNodeInfo(elm);
        // }
        dealTblInfo(elm, ldmInfo);
      }
    }
    return ldmInfo;
  }

  /**
   * 遍历当前节点元素下面的所有(元素的)子节点
   *
   * @param node
   */
  @SuppressWarnings("unchecked")
  public void showNodeInfo(Element node) {
    System.out.println("当前节点的名称：[" + node.getName() + "]");
    // 获取当前节点的所有属性节点
    List<Attribute> list = node.attributes();
    // 遍历属性节点
    if (list != null && list.size() > 0) {
      System.out.println("遍历属性节点:");
      for (Attribute attr : list) {
        System.out.println("[" + attr.getText() + "]-----[" + attr.getName() + "]---[" + attr.getValue() + "]");
      }
      System.out.println("<----------------------->");
    }

    if (!(node.getTextTrim().equals(""))) {
      System.out.println("文本内容：[" + node.getText() + "]");
    }

    // 当前节点下面子节点迭代器
    Iterator<Element> it = node.elementIterator();
    // 遍历
    while (it.hasNext()) {
      // 获取某个子节点对象
      Element e = it.next();
      // 对子节点进行遍历
      System.out.println("当前子节点的名称：[" + e.getName() + "]");
    }
  }

  /**
   * 遍历当前节点元素下面的所有(元素的)子节点
   *
   * @param attribute
   */
  public void showNodeInfo(Attribute attribute) {
    System.out.println(
        "[" + attribute.getText() + "]-----[" + attribute.getName() + "]---[" + attribute.getValue() + "]");
  }

  /**
   * 把document对象写入新的文件
   *
   * @param document
   * @param fileName
   * @throws Exception
   */
  public void writer(Document document, String fileName) throws Exception {
    // 紧凑的格式
    // OutputFormat format = OutputFormat.createCompactFormat();
    // 排版缩进的格式
    OutputFormat format = OutputFormat.createPrettyPrint();
    // 设置编码
    format.setEncoding("UTF-8");
    // 创建XMLWriter对象,指定了写出文件及编码格式
    // XMLWriter writer = new XMLWriter(new FileWriter(new
    // File("src//a.xml")),format);
    XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "UTF-8"),
        format);
    // 写入
    writer.write(document);
    // 立即写入
    writer.flush();
    // 关闭操作
    writer.close();
  }

  /**
   * 解析数据库表信息（获取全部Attribute属性信息）
   *
   * @param node
   * @param ldmInfo
   */
  @SuppressWarnings("unchecked")
  public void dealTblAttrInfo(Element node, LdmInfo ldmInfo) throws Exception {
    LdmEntity ldmEntity = new LdmEntity();
    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    ldmEntity.setOid(attribute.getText());

    // 判断外键
    List<LdmRelationship> relList = ldmInfo.getRelFkTblHash().get(ldmEntity.getOid());
    //List<LdmRelationship> relList = ldmInfo.getRelFkTblHashByOid(ldmEntity.getOid());
    if (relList != null && relList.size() > 0) {
      for (int i = 0; i < relList.size(); i++) {
        LdmRelationship relShip = relList.get(i);
        ldmEntity.getFkOidList().add(relShip.getObj2AttrRef());
        //ldmEntity.addFkOidList(relShip.getObj2AttrRef());
      }
    }

    // 获取ObjectID节点元素对象
    Element objElm = node.element("ObjectID");
    ldmEntity.setObjID(objElm.getTextTrim());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    ldmEntity.setName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    ldmEntity.setCode(codeElm.getTextTrim());

    // 获取Comment节点元素对象
    Element commentElm = node.element("Comment");
    if (commentElm != null) {
      ldmEntity.setComment(commentElm.getTextTrim());
    }
    ldmInfo.getEntityHash().put(ldmEntity.getOid(), ldmEntity);
//    ldmInfo.addEntityHash(ldmEntity);

    // 获取Identifiers节点元素对象
    Element attrsElm = node.element("Attributes");
    if (attrsElm != null) {
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = attrsElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        LdmAttribute ldmAttribute = dealAttrbute(elm);
        ldmInfo.getAttrHash().put(ldmAttribute.getOid(), ldmAttribute);
//        ldmInfo.addAttrHash(ldmAttribute);
      }
    }
  }

  /**
   * 解析数据库表信息
   *
   * @param node
   * @param ldmInfo
   */
  @SuppressWarnings("unchecked")
  public void dealTblInfo(Element node, LdmInfo ldmInfo) throws Exception {
    LdmEntity ldmEntity = new LdmEntity();
    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    ldmEntity.setOid(attribute.getText());

    // 判断外键
    List<LdmRelationship> relList = ldmInfo.getRelFkTblHash().get(ldmEntity.getOid());
    //List<LdmRelationship> relList = ldmInfo.getRelFkTblHashByOid(ldmEntity.getOid());
    if (relList != null && relList.size() > 0) {
      for (int i = 0; i < relList.size(); i++) {
        LdmRelationship relShip = relList.get(i);
        ldmEntity.getFkOidList().add(relShip.getObj2AttrRef());
//        ldmEntity.addFkOidList(relShip.getObj2AttrRef());
      }
    }

    // 获取ObjectID节点元素对象
    Element objElm = node.element("ObjectID");
    ldmEntity.setObjID(objElm.getTextTrim());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    ldmEntity.setName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    ldmEntity.setCode(codeElm.getTextTrim());

    // 获取Comment节点元素对象
    Element commentElm = node.element("Comment");
    if (commentElm != null) {
      ldmEntity.setComment(commentElm.getTextTrim());
    }

    // 获取Identifiers节点元素对象
    Element IdentsElm = node.element("Identifiers");
    if (IdentsElm != null) {
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = IdentsElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        LdmIdentifier ldmIdentifier = dealIdentInfo(elm);
        if (ldmIdentifier != null) {
          ldmEntity.getIdentList().add(ldmIdentifier);
          ldmInfo.getIdentHash().put(ldmIdentifier.getOid(), ldmIdentifier);
//          ldmEntity.addIdentList(ldmIdentifier);
//          ldmInfo.addIdentHash(ldmIdentifier);
        }
      }
    }

    // 获取PrimaryIdentifier节点元素对象
    Element pkElm = node.element("PrimaryIdentifier");
    if (pkElm != null) {
      Element pkIdentElm = pkElm.element("Identifier");
      if (pkIdentElm != null) {
        Attribute refAttr = pkIdentElm.attribute("Ref");
        if (refAttr != null) {
          ldmEntity.setPkOid(refAttr.getText());
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
        LdmAttribute ldmAttribute = dealAttrbute(elm);
        // 检查是否为主键
        if (ldmEntity.getPkOid() != null && ldmEntity.getPkOid().trim().length() > 0) {
          LdmIdentifier ldmIdentifier = ldmInfo.getIdentHash()
              .get(ldmEntity.getPkOid().trim());//ldmInfo.getIdentHashByOid(ldmEntity.getPkOid().trim());
          if (ldmIdentifier != null && ldmIdentifier.getRefOid().equalsIgnoreCase(ldmAttribute.getOid())) {
            ldmAttribute.setPk(true);
          } else {
            ldmAttribute.setPk(false);
          }
        }
        // 检查是否为外键
        if (ldmEntity.getFkOidList() != null && ldmEntity.getFkOidList().size() > 0) {
          for (int i = 0; i < ldmEntity.getFkOidList().size(); i++) {
            LdmRelationship ldmRelationship = ldmInfo.getRelFkHash().get(ldmEntity.getFkOidList().get(i).trim());
            //.getRelFkHashByOid(ldmEntity.getFkOidList().get(i).trim());
            if (ldmRelationship != null
                && ldmRelationship.getObj2AttrRef().equalsIgnoreCase(ldmAttribute.getOid())) {
              ldmAttribute.setFk(true);
              LdmEntity fkLdmEntity = ldmInfo.getEntityHash()
                  .get(ldmRelationship.getObj2Ref());//ldmInfo.getEntityHashByOid(ldmRelationship.getObj2Ref());
              if (fkLdmEntity != null) {
                ldmAttribute.setFkTblName(fkLdmEntity.getCode());
              }
              LdmAttribute fkLdmAttribute = ldmInfo.getAttrHash()
                  .get(ldmRelationship.getObj1AttrRef());//ldmInfo.getAttrHashByOid(ldmRelationship.getObj1AttrRef());
              ldmAttribute.setFkTblField(fkLdmAttribute.getCode());
              ldmAttribute.setFkTblFieldRltn(ldmRelationship.getObj1Obj2());
            } else {
              ldmAttribute.setFk(false);
              ldmAttribute.setFkTblName("");
              ldmAttribute.setFkTblField("");
            }
          }
        }
        ldmInfo.getAttrHash().put(ldmAttribute.getOid(), ldmAttribute);
        ldmEntity.getAttrList().add(ldmAttribute);
//        ldmInfo.addAttrHash(ldmAttribute);
//        ldmEntity.addAttrList(ldmAttribute);
      }
    }
    ldmInfo.getEntityHash().put(ldmEntity.getOid(), ldmEntity);
//    ldmInfo.addEntityHash(ldmEntity);
    if (isTest) {
      System.out.println(ldmEntity);
    }
  }

  /**
   * 解析标识信息
   *
   * @param node
   * @return
   * @throws Exception
   */
  public LdmIdentifier dealIdentInfo(Element node) throws Exception {
    LdmIdentifier ldmIdentifier = new LdmIdentifier();

    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    ldmIdentifier.setOid(attribute.getText());

    // 获取ObjectID节点元素对象
    Element objElm = node.element("ObjectID");
    ldmIdentifier.setObjID(objElm.getTextTrim());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    ldmIdentifier.setName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    ldmIdentifier.setCode(codeElm.getTextTrim());

    // 获取PrimaryIdentifier节点元素对象
    Element attrsElm = node.element("Identifier.Attributes");
    if (attrsElm != null) {
      Element attrElm = attrsElm.element("EntityAttribute");
      if (attrElm != null) {
        Attribute refAttr = attrElm.attribute("Ref");
        if (refAttr != null) {
          ldmIdentifier.setRefOid(refAttr.getText());
        }
      }
    }

    return ldmIdentifier;
  }

  /**
   * 解析属性（表字段）信息
   *
   * @param node
   * @return
   * @throws Exception
   */
  public LdmAttribute dealAttrbute(Element node) throws Exception {
    LdmAttribute ldmAttribute = new LdmAttribute();

    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    ldmAttribute.setOid(attribute.getText());

    // 获取ObjectID节点元素对象
    Element objElm = node.element("ObjectID");
    ldmAttribute.setObjID(objElm.getTextTrim());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    ldmAttribute.setName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    ldmAttribute.setCode(codeElm.getTextTrim());

    // 获取Code节点元素对象
    Element commentElm = node.element("Comment");
    if (commentElm != null) {
      ldmAttribute.setComment(commentElm.getTextTrim());
    }

    // 获取DataType节点元素对象
    Element dataTypeElm = node.element("DataType");
    if (dataTypeElm != null) {
      ldmAttribute.setDataType(dataTypeElm.getTextTrim().replaceAll("[^a-zA-Z]", ""));
    }

    // 获取Code节点元素对象
    Element lengthElm = node.element("Length");
    if (lengthElm != null) {
      ldmAttribute.setLength(lengthElm.getTextTrim());
    }

    Element precisionElm = node.element("Precision");
    if (precisionElm != null) {
      ldmAttribute.setPrecision(precisionElm.getTextTrim());
    }

    // 获取LogicalAttribute.Mandatory节点元素对象
    Element mandatoryElm = node.element("LogicalAttribute.Mandatory");
    if (mandatoryElm != null) {
      if (mandatoryElm.getTextTrim().equalsIgnoreCase("1")) {
        ldmAttribute.setMandatory(1);
      } else {
        ldmAttribute.setMandatory(0);
      }
    }

    // 获取DefaultValue节点元素对象
    Element defValElm = node.element("DefaultValue");
    if (defValElm != null) {
      ldmAttribute.setDefVal(defValElm.getTextTrim());
    }

    return ldmAttribute;
  }

  /**
   * 解析主外键关联关系
   *
   * @param node
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public LdmRelationship dealRelShipInfo(Element node) throws Exception {
    LdmRelationship ldmRelationship = new LdmRelationship();

    // 读取属性“Id”的值
    Attribute attribute = node.attribute("Id");
    ldmRelationship.setOid(attribute.getText());

    // 获取ObjectID节点元素对象
    Element objElm = node.element("ObjectID");
    ldmRelationship.setObjID(objElm.getTextTrim());

    // 获取Name节点元素对象
    Element nameElm = node.element("Name");
    ldmRelationship.setName(nameElm.getTextTrim());

    // 获取Code节点元素对象
    Element codeElm = node.element("Code");
    ldmRelationship.setCode(codeElm.getTextTrim());

    // 获取Entity1ToEntity2RoleCardinality节点元素对象
    Element obj1Obj2Elm = node.element("Entity1ToEntity2RoleCardinality");
    if (obj1Obj2Elm != null) {
      ldmRelationship.setObj1Obj2(obj1Obj2Elm.getTextTrim());
    }

    // 获取Entity2ToEntity1RoleCardinality节点元素对象
    Element obj2Obj1Elm = node.element("Entity2ToEntity1RoleCardinality");
    if (obj2Obj1Elm != null) {
      ldmRelationship.setObj2Obj1(obj2Obj1Elm.getTextTrim());
    }

    // 获取Object1节点元素对象
    Element obj1Elm = node.element("Object1");
    if (obj1Elm != null) {
      Element obj1EntityElm = obj1Elm.element("Entity");
      if (obj1EntityElm != null) {
        Attribute refAttr = obj1EntityElm.attribute("Ref");
        if (refAttr != null) {
          ldmRelationship.setObj1Ref(refAttr.getText());
        }
      }
    }

    // 获取Object2节点元素对象
    Element obj2Elm = node.element("Object2");
    if (obj2Elm != null) {
      Element obj2EntityElm = obj2Elm.element("Entity");
      if (obj2EntityElm != null) {
        Attribute refAttr = obj2EntityElm.attribute("Ref");
        if (refAttr != null) {
          ldmRelationship.setObj2Ref(refAttr.getText());
        }
      }
    }

    // 获取Joins节点元素对象
    Element joinsElm = node.element("Joins");
    if (joinsElm != null) {
      // 获取Entity元素列表，当前节点下面子节点迭代器
      Iterator<Element> it = joinsElm.elementIterator();
      // 遍历
      while (it.hasNext()) {
        // 获取某个子节点对象
        Element elm = (Element) it.next();
        // 获取Object1节点元素对象
        Element Object1Elm = elm.element("Object1");
        if (Object1Elm != null) {
          // 获取EntityAttribute节点元素对象
          Element Object1AttrElm = Object1Elm.element("EntityAttribute");
          Attribute refAttr = Object1AttrElm.attribute("Ref");
          if (refAttr != null) {
            ldmRelationship.setObj1AttrRef(refAttr.getText());
          }
        }
        // 获取Object1节点元素对象
        Element Object2Elm = elm.element("Object2");
        if (Object2Elm != null) {
          // 获取EntityAttribute节点元素对象
          Element Object1AttrElm = Object2Elm.element("EntityAttribute");
          Attribute refAttr = Object1AttrElm.attribute("Ref");
          if (refAttr != null) {
            ldmRelationship.setObj2AttrRef(refAttr.getText());
          }
        }
      }
    }

    // 获取ParentIdentifier节点元素对象
    Element prntIdentElm = node.element("ParentIdentifier");
    if (prntIdentElm != null) {
      Element identElm = prntIdentElm.element("Identifier");
      if (identElm != null) {
        Attribute refAttr = identElm.attribute("Ref");
        if (refAttr != null) {
          ldmRelationship.setParentIdentifierOid(refAttr.getText());
        }
      }
    }

    return ldmRelationship;
  }
}
