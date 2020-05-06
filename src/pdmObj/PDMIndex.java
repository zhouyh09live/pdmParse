package pdmObj;

import java.util.ArrayList;
import java.util.List;

public class PDMIndex {

  private String id;
  private String name;
  private String code;
  /**
   * 唯一索引标识 1 是,0不是
   */
  private int isUnique;

  /**
   * 索引包含的字段名称
   */
  private List<String> columns = new ArrayList<>();

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
   * Gets the value of isUnique.
   *
   * @return the value of isUnique
   */
  public int getIsUnique() {
    return isUnique;
  }

  /**
   * Sets the isUnique.
   *
   * <p>You can use getIsUnique() to get the value of isUnique</p>
   *
   * @param isUnique isUnique
   */
  public void setIsUnique(int isUnique) {
    this.isUnique = isUnique;
  }

  /**
   * Gets the value of columns.
   *
   * @return the value of columns
   */
  public List<String> getColumns() {
    return columns;
  }

  /**
   * Sets the columns.
   *
   * <p>You can use getColumns() to get the value of columns</p>
   *
   * @param columns columns
   */
  public void setColumns(List<String> columns) {
    this.columns = columns;
  }
}
