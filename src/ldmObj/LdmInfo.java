package ldmObj;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName LdmInfo
 * @Description LDM文件中生成代码所需的对象集合
 * @Author zhouyh
 * @CreateTime 2020/11/19 10:09
 **/
public class LdmInfo {

  // 字段表
  private LinkedHashMap<String, LdmAttribute> attrHash = new LinkedHashMap<>();
  // 关联关系表
  private LinkedHashMap<String, LdmRelationship> relHash = new LinkedHashMap<>();
  // 外键关联关系表
  private LinkedHashMap<String, LdmRelationship> relFkHash = new LinkedHashMap<>();
  // 表对应外键列表
  private LinkedHashMap<String, List<LdmRelationship>> relFkTblHash = new LinkedHashMap<>();
  // 主键关系表
  private LinkedHashMap<String, LdmIdentifier> identHash = new LinkedHashMap<>();
  // 实体类表（数据库表）
  private LinkedHashMap<String, LdmEntity> entityHash = new LinkedHashMap<>();
  // 实体类表（数据库表）
  private LinkedHashMap<String, LdmEntity> entityCodeHash = new LinkedHashMap<>();

  /**
   * Gets the value of attrHash.
   *
   * @return the value of attrHash
   */
  public LinkedHashMap<String, LdmAttribute> getAttrHash() {
    return this.attrHash;
  }

  /**
   * Sets the attrHash.
   *
   * <p>You can use getAttrHash() to get the value of attrHash</p>
   *
   * @param attrHash attrHash
   */
  public void setAttrHash(LinkedHashMap<String, LdmAttribute> attrHash) {
    this.attrHash = attrHash;
  }

  /**
   * Gets the value of relHash.
   *
   * @return the value of relHash
   */
  public LinkedHashMap<String, LdmRelationship> getRelHash() {
    return this.relHash;
  }

  /**
   * Sets the relHash.
   *
   * <p>You can use getRelHash() to get the value of relHash</p>
   *
   * @param relHash relHash
   */
  public void setRelHash(LinkedHashMap<String, LdmRelationship> relHash) {
    this.relHash = relHash;
  }

  /**
   * Gets the value of relFkHash.
   *
   * @return the value of relFkHash
   */
  public LinkedHashMap<String, LdmRelationship> getRelFkHash() {
    return this.relFkHash;
  }

  /**
   * Sets the relFkHash.
   *
   * <p>You can use getRelFkHash() to get the value of relFkHash</p>
   *
   * @param relFkHash relFkHash
   */
  public void setRelFkHash(LinkedHashMap<String, LdmRelationship> relFkHash) {
    this.relFkHash = relFkHash;
  }

  /**
   * Gets the value of relFkTblHash.
   *
   * @return the value of relFkTblHash
   */
  public LinkedHashMap<String, List<LdmRelationship>> getRelFkTblHash() {
    return this.relFkTblHash;
  }

  /**
   * Sets the relFkTblHash.
   *
   * <p>You can use getRelFkTblHash() to get the value of relFkTblHash</p>
   *
   * @param relFkTblHash relFkTblHash
   */
  public void setRelFkTblHash(LinkedHashMap<String, List<LdmRelationship>> relFkTblHash) {
    this.relFkTblHash = relFkTblHash;
  }

  /**
   * Gets the value of identHash.
   *
   * @return the value of identHash
   */
  public LinkedHashMap<String, LdmIdentifier> getIdentHash() {
    return this.identHash;
  }

  /**
   * Sets the identHash.
   *
   * <p>You can use getIdentHash() to get the value of identHash</p>
   *
   * @param identHash identHash
   */
  public void setIdentHash(LinkedHashMap<String, LdmIdentifier> identHash) {
    this.identHash = identHash;
  }

  /**
   * Gets the value of entityHash.
   *
   * @return the value of entityHash
   */
  public LinkedHashMap<String, LdmEntity> getEntityHash() {
    return this.entityHash;
  }

  /**
   * Sets the entityHash.
   *
   * <p>You can use getEntityHash() to get the value of entityHash</p>
   *
   * @param entityHash entityHash
   */
  public void setEntityHash(LinkedHashMap<String, LdmEntity> entityHash) {
    this.entityHash = entityHash;
  }

  /**
   * Gets the value of entityCodeHash.
   *
   * @return the value of entityCodeHash
   */
  public LinkedHashMap<String, LdmEntity> getEntityCodeHash() {
    return this.entityCodeHash;
  }

  /**
   * Sets the entityCodeHash.
   *
   * <p>You can use getEntityCodeHash() to get the value of entityCodeHash</p>
   *
   * @param entityCodeHash entityCodeHash
   */
  public void setEntityCodeHash(LinkedHashMap<String, LdmEntity> entityCodeHash) {
    this.entityCodeHash = entityCodeHash;
  }
}
