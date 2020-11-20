package parseobj;

/**
 * 字段对象
 */
public class ParseColumn {

  /**
   * 字段ID
   */
  private String columnId;
  /**
   * 字段中文名
   */
  private String columnName;

  /**
   * 字段code
   */
  private String columnCode;

  /**
   * 字段类型
   */
  private String dataType;

  /**
   * 数据长度
   */
  private int length;

  /**
   * 数据精度
   */
  private int precision;

  /**
   * 字段是否必填:0 不填 1 必填
   */
  private int mandatory = 0;

  /**
   * 默认值
   */
  private String defaultValue;

  /**
   * 字段描述
   */
  private String comment;

  /**
   * 字段是否是主键 0 不是, 1是
   */
  private int isPk = 0;

  /**
   * 字段关联数据元Id
   */
  private String dataElementId;

  /**
   * Gets the value of columnId.
   *
   * @return the value of columnId
   */
  public String getColumnId() {
    return columnId;
  }

  /**
   * Sets the columnId.
   *
   * <p>You can use getColumnId() to get the value of columnId</p>
   *
   * @param columnId columnId
   */
  public void setColumnId(String columnId) {
    this.columnId = columnId;
  }

  /**
   * Gets the value of columnName.
   *
   * @return the value of columnName
   */
  public String getColumnName() {
    return columnName;
  }

  /**
   * Sets the columnName.
   *
   * <p>You can use getColumnName() to get the value of columnName</p>
   *
   * @param columnName columnName
   */
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   * Gets the value of columnCode.
   *
   * @return the value of columnCode
   */
  public String getColumnCode() {
    return columnCode;
  }

  /**
   * Sets the columnCode.
   *
   * <p>You can use getColumnCode() to get the value of columnCode</p>
   *
   * @param columnCode columnCode
   */
  public void setColumnCode(String columnCode) {
    this.columnCode = columnCode;
  }

  /**
   * Gets the value of dataType.
   *
   * @return the value of dataType
   */
  public String getDataType() {
    return dataType;
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
  public int getLength() {
    return length;
  }

  /**
   * Sets the length.
   *
   * <p>You can use getLength() to get the value of length</p>
   *
   * @param length length
   */
  public void setLength(int length) {
    this.length = length;
  }

  /**
   * Gets the value of precision.
   *
   * @return the value of precision
   */
  public int getPrecision() {
    return precision;
  }

  /**
   * Sets the precision.
   *
   * <p>You can use getPrecision() to get the value of precision</p>
   *
   * @param precision precision
   */
  public void setPrecision(int precision) {
    this.precision = precision;
  }

  /**
   * Gets the value of mandatory.
   *
   * @return the value of mandatory
   */
  public int getMandatory() {
    return mandatory;
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
   * Gets the value of defaultValue.
   *
   * @return the value of defaultValue
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  /**
   * Sets the defaultValue.
   *
   * <p>You can use getDefaultValue() to get the value of defaultValue</p>
   *
   * @param defaultValue defaultValue
   */
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  /**
   * Gets the value of comment.
   *
   * @return the value of comment
   */
  public String getComment() {
    return comment;
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
   * Gets the value of isPk.
   *
   * @return the value of isPk
   */
  public int getIsPk() {
    return isPk;
  }

  /**
   * Sets the isPk.
   *
   * <p>You can use getIsPk() to get the value of isPk</p>
   *
   * @param isPk isPk
   */
  public void setIsPk(int isPk) {
    this.isPk = isPk;
  }

  /**
   * Gets the value of dataElementId.
   *
   * @return the value of dataElementId
   */
  public String getDataElementId() {
    return this.dataElementId;
  }

  /**
   * Sets the dataElementId.
   *
   * <p>You can use getDataElementId() to get the value of dataElementId</p>
   *
   * @param dataElementId dataElementId
   */
  public void setDataElementId(String dataElementId) {
    this.dataElementId = dataElementId;
  }
}
