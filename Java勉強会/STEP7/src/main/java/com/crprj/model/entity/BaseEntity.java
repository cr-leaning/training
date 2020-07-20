package com.crprj.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
  
  /**
   * ステータスフラグ
   */
  @Column(name="STATUS_FLG")
  private Byte statusFlg;

  /**
   * 登録ユーザ
   */
  @Column(name="REG_USER")
  private Integer regUser;

  /**
   * 登録日
   */
  @Column(name="REG_DATE")
  private Date regDate;

  /**
   * 更新ユーザ
   */
  @Column(name="UPD_USER")
  private Integer updUser;

  /**
   * 更新日
   */
  @Column(name="UPD_DATE")
  private Date updDate;

}
