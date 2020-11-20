package parseobj;

public class ParseReference {

  private String id;
  private String name;
  private String code;

  /**
   * 父表 表名
   */
  private String parentTableName;
  /**
   * 子表 表名
   */
  private String childTableName;

  /**
   * 父表 字段名
   */
  private String parentColumnCode;

  /**
   * 子表 字段名
   */
  private String childColumnCode;

  /**
   * Gets the value of id.
   *
   * @return the value of id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * <p>You can use getId() to get the value of id</p>
   *
   * @param id id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the value of name.
   *
   * @return the value of name
   */
  public String getName() {
    return name;
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
    return code;
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
   * Gets the value of parentTableName.
   *
   * @return the value of parentTableName
   */
  public String getParentTableName() {
    return parentTableName;
  }

  /**
   * Sets the parentTableName.
   *
   * <p>You can use getParentTableName() to get the value of parentTableName</p>
   *
   * @param parentTableName parentTableName
   */
  public void setParentTableName(String parentTableName) {
    this.parentTableName = parentTableName;
  }

  /**
   * Gets the value of childTableName.
   *
   * @return the value of childTableName
   */
  public String getChildTableName() {
    return childTableName;
  }

  /**
   * Sets the childTableName.
   *
   * <p>You can use getChildTableName() to get the value of childTableName</p>
   *
   * @param childTableName childTableName
   */
  public void setChildTableName(String childTableName) {
    this.childTableName = childTableName;
  }

  /**
   * Gets the value of parentColumnCode.
   *
   * @return the value of parentColumnCode
   */
  public String getParentColumnCode() {
    return parentColumnCode;
  }

  /**
   * Sets the parentColumnCode.
   *
   * <p>You can use getParentColumnCode() to get the value of parentColumnCode</p>
   *
   * @param parentColumnCode parentColumnCode
   */
  public void setParentColumnCode(String parentColumnCode) {
    this.parentColumnCode = parentColumnCode;
  }

  /**
   * Gets the value of childColumnCode.
   *
   * @return the value of childColumnCode
   */
  public String getChildColumnCode() {
    return childColumnCode;
  }

  /**
   * Sets the childColumnCode.
   *
   * <p>You can use getChildColumnCode() to get the value of childColumnCode</p>
   *
   * @param childColumnCode childColumnCode
   */
  public void setChildColumnCode(String childColumnCode) {
    this.childColumnCode = childColumnCode;
  }
}
