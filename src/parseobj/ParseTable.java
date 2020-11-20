package parseobj;

import java.util.ArrayList;
import java.util.List;

/**
 * 表对象
 */
public class ParseTable {

  /**
   * 表ID
   */
  public String tableId;

  /**
   * 表名称
   */
  private String tableName;

  /**
   * 表Code
   */
  private String tableCode;

  /**
   * 模型表类型
   */
  private String tableType;

  /**
   * 描述
   */
  private String remark;


  /**
   * 表字段
   */
  private List<ParseColumn> columns = new ArrayList<>();


  /**
   * 表索引
   */
  private List<ParseIndex> indexs = new ArrayList<>();

  /**
   * 表关联关系
   */
  private List<ParseReference> references = new ArrayList<>();


  /**
   * Gets the value of tableId.
   *
   * @return the value of tableId
   */
  public String getTableId() {
    return tableId;
  }

  /**
   * Sets the tableId.
   *
   * <p>You can use getTableId() to get the value of tableId</p>
   *
   * @param tableId tableId
   */
  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  /**
   * Gets the value of tableName.
   *
   * @return the value of tableName
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * Sets the tableName.
   *
   * <p>You can use getTableName() to get the value of tableName</p>
   *
   * @param tableName tableName
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  /**
   * Gets the value of tableCode.
   *
   * @return the value of tableCode
   */
  public String getTableCode() {
    return tableCode;
  }

  /**
   * Sets the tableCode.
   *
   * <p>You can use getTableCode() to get the value of tableCode</p>
   *
   * @param tableCode tableCode
   */
  public void setTableCode(String tableCode) {
    this.tableCode = tableCode;
  }

  /**
   * Gets the value of columns.
   *
   * @return the value of columns
   */
  public List<ParseColumn> getColumns() {
    return columns;
  }

  /**
   * Sets the columns.
   *
   * <p>You can use getColumns() to get the value of columns</p>
   *
   * @param columns columns
   */
  public void setColumns(List<ParseColumn> columns) {
    this.columns = columns;
  }

  /**
   * Gets the value of indexs.
   *
   * @return the value of indexs
   */
  public List<ParseIndex> getIndexs() {
    return indexs;
  }

  /**
   * Sets the indexs.
   *
   * <p>You can use getIndexs() to get the value of indexs</p>
   *
   * @param indexs indexs
   */
  public void setIndexs(List<ParseIndex> indexs) {
    this.indexs = indexs;
  }

  /**
   * Gets the value of references.
   *
   * @return the value of references
   */
  public List<ParseReference> getReferences() {
    return references;
  }

  /**
   * Sets the references.
   *
   * <p>You can use getReferences() to get the value of references</p>
   *
   * @param references references
   */
  public void setReferences(
      List<ParseReference> references) {
    this.references = references;
  }

  /**
   * Gets the value of tableType.
   *
   * @return the value of tableType
   */
  public String getTableType() {
    return this.tableType;
  }

  /**
   * Sets the tableType.
   *
   * <p>You can use getTableType() to get the value of tableType</p>
   *
   * @param tableType tableType
   */
  public void setTableType(String tableType) {
    this.tableType = tableType;
  }

  /**
   * Gets the value of remark.
   *
   * @return the value of remark
   */
  public String getRemark() {
    return this.remark;
  }

  /**
   * Sets the remark.
   *
   * <p>You can use getRemark() to get the value of remark</p>
   *
   * @param remark remark
   */
  public void setRemark(String remark) {
    this.remark = remark;
  }
}
