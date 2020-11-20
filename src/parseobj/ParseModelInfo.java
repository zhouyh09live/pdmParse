package parseobj;

import java.util.ArrayList;
import java.util.List;

/**
 * PDM文件对象
 */
public class ParseModelInfo {

  /**
   * modelId
   */
  private String modelId;
  /**
   * model名称
   */
  private String modelName;
  /**
   * modelCode
   */
  private String modelCode;

  /**
   * 数据库CODE 包含版本 ,例如:MYSQL50
   */
  private String dbmsCode;
  /**
   * 数据库名称,包含版本,例如:MySQL 5.0
   */
  private String dbmsName;

  /**
   * 表对象
   */
  private List<ParseTable> tables = new ArrayList<>();

  /**
   * Gets the value of modelId.
   *
   * @return the value of modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Sets the modelId.
   *
   * <p>You can use getModelId() to get the value of modelId</p>
   *
   * @param modelId modelId
   */
  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  /**
   * Gets the value of modelName.
   *
   * @return the value of modelName
   */
  public String getModelName() {
    return modelName;
  }

  /**
   * Sets the modelName.
   *
   * <p>You can use getModelName() to get the value of modelName</p>
   *
   * @param modelName modelName
   */
  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  /**
   * Gets the value of modelCode.
   *
   * @return the value of modelCode
   */
  public String getModelCode() {
    return modelCode;
  }

  /**
   * Sets the modelCode.
   *
   * <p>You can use getModelCode() to get the value of modelCode</p>
   *
   * @param modelCode modelCode
   */
  public void setModelCode(String modelCode) {
    this.modelCode = modelCode;
  }

  /**
   * Gets the value of dbmsCode.
   *
   * @return the value of dbmsCode
   */
  public String getDbmsCode() {
    return dbmsCode;
  }

  /**
   * Sets the dbmsCode.
   *
   * <p>You can use getDbmsCode() to get the value of dbmsCode</p>
   *
   * @param dbmsCode dbmsCode
   */
  public void setDbmsCode(String dbmsCode) {
    this.dbmsCode = dbmsCode;
  }

  /**
   * Gets the value of dbmsName.
   *
   * @return the value of dbmsName
   */
  public String getDbmsName() {
    return dbmsName;
  }

  /**
   * Sets the dbmsName.
   *
   * <p>You can use getDbmsName() to get the value of dbmsName</p>
   *
   * @param dbmsName dbmsName
   */
  public void setDbmsName(String dbmsName) {
    this.dbmsName = dbmsName;
  }

  /**
   * Gets the value of tables.
   *
   * @return the value of tables
   */
  public List<ParseTable> getTables() {
    return tables;
  }

  /**
   * Sets the tables.
   *
   * <p>You can use getTables() to get the value of tables</p>
   *
   * @param tables tables
   */
  public void setTables(List<ParseTable> tables) {
    this.tables = tables;
  }

}
