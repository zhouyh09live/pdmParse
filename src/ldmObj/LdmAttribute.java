package ldmObj;

/**
 * @ClassName LdmAttribute
 * @Description 实体类下的属性字段
 * @Author zhouyh
 * @CreateTime 2020/11/19 10:10
 **/
public class LdmAttribute {

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
  // 是否为主键
  private boolean pk = false;
  // 是否为外键
  private boolean fk = false;
  // 外键关联表名
  private String fkTblName = "";
  // 外键关联对应表的字段
  private String fkTblField = "";
  // 外键关联对应关系
  private String fkTblFieldRltn = "";
  // 数据类型
  private String dataType = "";
  // 长度
  private String length = "";
  // 小数点位数
  private String precision = "";
  // 是否可为null值
  private int mandatory = 0;
  // 默认值
  private String defVal = "";
  // 字段数据类型
  private String columnType = "";
  // 字段数据类型是否为字符
  private boolean columnTypeIsChar = false;

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
   * Gets the value of pk.
   *
   * @return the value of pk
   */
  public boolean getPk() {
    return this.pk;
  }

  /**
   * Sets the pk.
   *
   * <p>You can use getPk() to get the value of pk</p>
   *
   * @param pk pk
   */
  public void setPk(boolean pk) {
    this.pk = pk;
  }

  /**
   * Gets the value of fk.
   *
   * @return the value of fk
   */
  public boolean getFk() {
    return this.fk;
  }

  /**
   * Sets the fk.
   *
   * <p>You can use getFk() to get the value of fk</p>
   *
   * @param fk fk
   */
  public void setFk(boolean fk) {
    this.fk = fk;
  }

  /**
   * Gets the value of fkTblName.
   *
   * @return the value of fkTblName
   */
  public String getFkTblName() {
    return this.fkTblName;
  }

  /**
   * Sets the fkTblName.
   *
   * <p>You can use getFkTblName() to get the value of fkTblName</p>
   *
   * @param fkTblName fkTblName
   */
  public void setFkTblName(String fkTblName) {
    this.fkTblName = fkTblName;
  }

  /**
   * Gets the value of fkTblField.
   *
   * @return the value of fkTblField
   */
  public String getFkTblField() {
    return this.fkTblField;
  }

  /**
   * Sets the fkTblField.
   *
   * <p>You can use getFkTblField() to get the value of fkTblField</p>
   *
   * @param fkTblField fkTblField
   */
  public void setFkTblField(String fkTblField) {
    this.fkTblField = fkTblField;
  }

  /**
   * Gets the value of fkTblFieldRltn.
   *
   * @return the value of fkTblFieldRltn
   */
  public String getFkTblFieldRltn() {
    return this.fkTblFieldRltn;
  }

  /**
   * Sets the fkTblFieldRltn.
   *
   * <p>You can use getFkTblFieldRltn() to get the value of fkTblFieldRltn</p>
   *
   * @param fkTblFieldRltn fkTblFieldRltn
   */
  public void setFkTblFieldRltn(String fkTblFieldRltn) {
    this.fkTblFieldRltn = fkTblFieldRltn;
  }

  /**
   * Gets the value of dataType.
   *
   * @return the value of dataType
   */
  public String getDataType() {
    return this.dataType;
  }

  /**
   * Sets the dataType.
   *
   * <p>You can use getDataType() to get the value of dataType</p>
   *
   * @param dataType dataType
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * Gets the value of length.
   *
   * @return the value of length
   */
  public String getLength() {
    return this.length;
  }

  /**
   * Sets the length.
   *
   * <p>You can use getLength() to get the value of length</p>
   *
   * @param length length
   */
  public void setLength(String length) {
    this.length = length;
  }

  /**
   * Gets the value of precision.
   *
   * @return the value of precision
   */
  public String getPrecision() {
    return this.precision;
  }

  /**
   * Sets the precision.
   *
   * <p>You can use getPrecision() to get the value of precision</p>
   *
   * @param precision precision
   */
  public void setPrecision(String precision) {
    this.precision = precision;
  }

  /**
   * Gets the value of mandatory.
   *
   * @return the value of mandatory
   */
  public int getMandatory() {
    return this.mandatory;
  }

  /**
   * Sets the mandatory.
   *
   * <p>You can use getMandatory() to get the value of mandatory</p>
   *
   * @param mandatory mandatory
   */
  public void setMandatory(int mandatory) {
    this.mandatory = mandatory;
  }

  /**
   * Gets the value of defVal.
   *
   * @return the value of defVal
   */
  public String getDefVal() {
    return this.defVal;
  }

  /**
   * Sets the defVal.
   *
   * <p>You can use getDefVal() to get the value of defVal</p>
   *
   * @param defVal defVal
   */
  public void setDefVal(String defVal) {
    this.defVal = defVal;
  }

  /**
   * Gets the value of columnType.
   *
   * @return the value of columnType
   */
  public String getColumnType() {
    return this.columnType;
  }

  /**
   * Sets the columnType.
   *
   * <p>You can use getColumnType() to get the value of columnType</p>
   *
   * @param columnType columnType
   */
  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  /**
   * Gets the value of columnTypeIsChar.
   *
   * @return the value of columnTypeIsChar
   */
  public boolean getColumnTypeIsChar() {
    return this.columnTypeIsChar;
  }

  /**
   * Sets the columnTypeIsChar.
   *
   * <p>You can use getColumnTypeIsChar() to get the value of columnTypeIsChar</p>
   *
   * @param columnTypeIsChar columnTypeIsChar
   */
  public void setColumnTypeIsChar(boolean columnTypeIsChar) {
    this.columnTypeIsChar = columnTypeIsChar;
  }
}
