package com.crprj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 役割情報テーブルクラス
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="POSITION_MST", schema="cr_prj")
public class PositionMst extends BaseEntity {

  /**
   * 連番
   */
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SEQ_NO")
  private Integer seqNo;

  /**
   * 役職ID
   */
  @Column(name="POSITION_ID")
  public String positionId;

  /**
   * 役職名
   */
  @Column(name="POSITION_NAME")
  public String positionName;

  /**
   * 役職手当
   */
  @Column(name="POSITION_ALLOWANCE")
  public long positionAllowance;

  
}
