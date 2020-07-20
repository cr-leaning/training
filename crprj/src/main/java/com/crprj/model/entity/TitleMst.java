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
 * 肩書マスタテーブルクラス
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="TITLE_MST", schema="cr_prj")
public class TitleMst extends BaseEntity {

  /**
   * 連番
   */
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SEQ_NO")
  private Integer seqNo;

  /**
   * 肩書ID
   */
  @Column(name="TITLE_ID")
  private String titleId;

  /**
   * 肩書名
   */
  @Column(name="TITLE_NAME")
  private String titleName;

}
