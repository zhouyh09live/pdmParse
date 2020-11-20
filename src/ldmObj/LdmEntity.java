package ldmObj;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LdmEntity
 * @Description 实体类
 * @Author zhouyh
 * @CreateTime 2020/11/19 10:09
 **/
public class LdmEntity {

  // 可关联唯一id
  private String oid = "";
  // 对象id（全局唯一）
  private String objID = "";
  // 对象名称
  private String name = "";
  // 对象代码
  private String code = "";
  // 注释
  private String comment = "";
  // 主键对象id
  private String pkOid = "";
  // 外键对象id列表
  private List<String> fkOidList = new ArrayList<>();
  // 关联关系表
  private List<LdmIdentifier> identList = new ArrayList<>();
  // 字段表
  private List<LdmAttribute> attrList = new ArrayList<>();

  /**
   * Gets the value of oid.
   *
   * @return the value of oid
   */
  public String getOid() {
    return this.oid;
  }

  /**
   * Sets the oid.
   *
   * <p>You can use getOid() to get the value of oid</p>
   *
   * @param oid oid
   */
  public void setOid(String oid) {
    this.oid = oid;
  }

  /**
   * Gets the value of objID.
   *
   * @return the value of objID
   */
  public String getObjID() {
    return this.objID;
  }

  /**
   * Sets the objID.
   *
   * <p>You can use getObjID() to get the value of objID</p>
   *
   * @param objID objID
   */
  public void setObjID(String objID) {
    this.objID = objID;
  }

  /**
   * Gets the value of name.
   *
   * @return the value of name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name.
   *
   * <p>You can use getName() to get the value of name</p>
   *
   * @param name name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the value of code.
   *
   * @return the value of code
   */
  public String getCode() {
    return this.code;
  }

  /**
   * Sets the code.
   *
   * <p>You can use getCode() to get the value of code</p>
   *
   * @param code code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Gets the value of comment.
   *
   * @return the value of comment
   */
  public String getComment() {
    return this.comment;
  }

  /**
   * Sets the comment.
   *
   * <p>You can use getComment() to get the value of comment</p>
   *
   * @param comment comment
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * Gets the value of pkOid.
   *
   * @return the value of pkOid
   */
  public String getPkOid() {
    return this.pkOid;
  }

  /**
   * Sets the pkOid.
   *
   * <p>You can use getPkOid() to get the value of pkOid</p>
   *
   * @param pkOid pkOid
   */
  public void setPkOid(String pkOid) {
    this.pkOid = pkOid;
  }

  /**
   * Gets the value of fkOidList.
   *
   * @return the value of fkOidList
   */
  public List<String> getFkOidList() {
    return this.fkOidList;
  }

  /**
   * Sets the fkOidList.
   *
   * <p>You can use getFkOidList() to get the value of fkOidList</p>
   *
   * @param fkOidList fkOidList
   */
  public void setFkOidList(List<String> fkOidList) {
    this.fkOidList = fkOidList;
  }

  /**
   * Gets the value of identList.
   *
   * @return the value of identList
   */
  public List<LdmIdentifier> getIdentList() {
    return this.identList;
  }

  /**
   * Sets the identList.
   *
   * <p>You can use getIdentList() to get the value of identList</p>
   *
   * @param identList identList
   */
  public void setIdentList(List<LdmIdentifier> identList) {
    this.identList = identList;
  }

  /**
   * Gets the value of attrList.
   *
   * @return the value of attrList
   */
  public List<LdmAttribute> getAttrList() {
    return this.attrList;
  }

  /**
   * Sets the attrList.
   *
   * <p>You can use getAttrList() to get the value of attrList</p>
   *
   * @param attrList attrList
   */
  public void setAttrList(List<LdmAttribute> attrList) {
    this.attrList = attrList;
  }
}
