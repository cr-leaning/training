package com.crprj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザ情報テーブルクラス
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="GROUP_MST", schema="cr_prj")
public class GroupMst extends BaseEntity {

  /**
   * 連番
   */
  @Id
  @GeneratedValue
  @Column(name="SEQ_NO")
  public Integer seqNo;

  /**
   * ID
   */
  @Column(name="GROUP_ID")
  public String groupId;

  /**
   * ID
   */
  @Column(name="GROUP_NAME")
  public String groupName;

}
