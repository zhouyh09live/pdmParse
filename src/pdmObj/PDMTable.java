package pdmObj;

import java.util.ArrayList;
import java.util.List;

/**
 * 表对象
 */
public class PDMTable {

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
   * 表字段
   */
  private List<PDMColumn> columns = new ArrayList<>();


  /**
   * 表索引
   */
  private List<PDMIndex> indexs = new ArrayList<>();

  /**
   * 根据字段ID获取字段对象
   *
   * @param columnId
   * @return
   * @throws Exception
   */
  public PDMColumn getPDMColumnById(String columnId) {
    for (PDMColumn column : columns) {
      if (columnId.equals(column.getColumnId())) {
        return column;
      }
    }
    return null;
  }

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
  public List<PDMColumn> getColumns() {
    return columns;
  }

  /**
   * Sets the columns.
   *
   * <p>You can use getColumns() to get the value of columns</p>
   *
   * @param columns columns
   */
  public void setColumns(List<PDMColumn> columns) {
    this.columns = columns;
  }

  /**
   * Gets the value of indexs.
   *
   * @return the value of indexs
   */
  public List<PDMIndex> getIndexs() {
    return indexs;
  }

  /**
   * Sets the indexs.
   *
   * <p>You can use getIndexs() to get the value of indexs</p>
   *
   * @param indexs indexs
   */
  public void setIndexs(List<PDMIndex> indexs) {
    this.indexs = indexs;
  }
}
