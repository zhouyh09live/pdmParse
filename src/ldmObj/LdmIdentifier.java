package ldmObj;

/**
 * @ClassName LdmIdentifier
 * @Description 实体类中的关联对象
 * @Author zhouyh
 * @CreateTime 2020/11/19 10:10
 **/
public class LdmIdentifier {

  // 可关联唯一id
  private String oid = "";
  // 对象id（全局唯一）
  private String objID = "";
  // 对象名称
  private String name = "";
  // 对象代码
  private String code = "";
  // 关联对象oid
  private String refOid = "";

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
   * Gets the value of refOid.
   *
   * @return the value of refOid
   */
  public String getRefOid() {
    return this.refOid;
  }

  /**
   * Sets the refOid.
   *
   * <p>You can use getRefOid() to get the value of refOid</p>
   *
   * @param refOid refOid
   */
  public void setRefOid(String refOid) {
    this.refOid = refOid;
  }
}
