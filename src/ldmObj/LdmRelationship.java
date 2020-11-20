package ldmObj;

/**
 * @ClassName LdmRelationship
 * @Description 外键关联对象
 * @Author zhouyh
 * @CreateTime 2020/11/19 10:10
 **/
public class LdmRelationship {

  // 可关联唯一id
  private String oid = "";
  // 对象id（全局唯一）
  private String objID = "";
  // 对象名称
  private String name = "";
  // 对象代码
  private String code = "";
  // 关联对象1
  private String obj1Ref = "";
  // 关联对象2
  private String obj2Ref = "";
  // 关联对象1对应字段
  private String obj1AttrRef = "";
  // 关联对象2对应字段
  private String obj2AttrRef = "";
  // 对象1对象2关联关系
  private String obj1Obj2 = "";
  // 对象2对象1关联关系
  private String obj2Obj1 = "";
  // 上级关联主键
  private String parentIdentifierOid = "";

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
   * Gets the value of obj1Ref.
   *
   * @return the value of obj1Ref
   */
  public String getObj1Ref() {
    return this.obj1Ref;
  }

  /**
   * Sets the obj1Ref.
   *
   * <p>You can use getObj1Ref() to get the value of obj1Ref</p>
   *
   * @param obj1Ref obj1Ref
   */
  public void setObj1Ref(String obj1Ref) {
    this.obj1Ref = obj1Ref;
  }

  /**
   * Gets the value of obj2Ref.
   *
   * @return the value of obj2Ref
   */
  public String getObj2Ref() {
    return this.obj2Ref;
  }

  /**
   * Sets the obj2Ref.
   *
   * <p>You can use getObj2Ref() to get the value of obj2Ref</p>
   *
   * @param obj2Ref obj2Ref
   */
  public void setObj2Ref(String obj2Ref) {
    this.obj2Ref = obj2Ref;
  }

  /**
   * Gets the value of obj1AttrRef.
   *
   * @return the value of obj1AttrRef
   */
  public String getObj1AttrRef() {
    return this.obj1AttrRef;
  }

  /**
   * Sets the obj1AttrRef.
   *
   * <p>You can use getObj1AttrRef() to get the value of obj1AttrRef</p>
   *
   * @param obj1AttrRef obj1AttrRef
   */
  public void setObj1AttrRef(String obj1AttrRef) {
    this.obj1AttrRef = obj1AttrRef;
  }

  /**
   * Gets the value of obj2AttrRef.
   *
   * @return the value of obj2AttrRef
   */
  public String getObj2AttrRef() {
    return this.obj2AttrRef;
  }

  /**
   * Sets the obj2AttrRef.
   *
   * <p>You can use getObj2AttrRef() to get the value of obj2AttrRef</p>
   *
   * @param obj2AttrRef obj2AttrRef
   */
  public void setObj2AttrRef(String obj2AttrRef) {
    this.obj2AttrRef = obj2AttrRef;
  }

  /**
   * Gets the value of obj1Obj2.
   *
   * @return the value of obj1Obj2
   */
  public String getObj1Obj2() {
    return this.obj1Obj2;
  }

  /**
   * Sets the obj1Obj2.
   *
   * <p>You can use getObj1Obj2() to get the value of obj1Obj2</p>
   *
   * @param obj1Obj2 obj1Obj2
   */
  public void setObj1Obj2(String obj1Obj2) {
    this.obj1Obj2 = obj1Obj2;
  }

  /**
   * Gets the value of obj2Obj1.
   *
   * @return the value of obj2Obj1
   */
  public String getObj2Obj1() {
    return this.obj2Obj1;
  }

  /**
   * Sets the obj2Obj1.
   *
   * <p>You can use getObj2Obj1() to get the value of obj2Obj1</p>
   *
   * @param obj2Obj1 obj2Obj1
   */
  public void setObj2Obj1(String obj2Obj1) {
    this.obj2Obj1 = obj2Obj1;
  }

  /**
   * Gets the value of parentIdentifierOid.
   *
   * @return the value of parentIdentifierOid
   */
  public String getParentIdentifierOid() {
    return this.parentIdentifierOid;
  }

  /**
   * Sets the parentIdentifierOid.
   *
   * <p>You can use getParentIdentifierOid() to get the value of parentIdentifierOid</p>
   *
   * @param parentIdentifierOid parentIdentifierOid
   */
  public void setParentIdentifierOid(String parentIdentifierOid) {
    this.parentIdentifierOid = parentIdentifierOid;
  }
}
