package com.crprj.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
  
  /**
   * ステータスフラグ
   */
  @NotNull
  @Column(name="STATUS_FLG")
  private int statusFlg;

  /**
   * 登録ユーザ
   */
  @Column(name="REG_USER")
  private Integer regUser;

  /**
   * 登録日
   */
  @NotNull
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
  @NotNull
  @Column(name="UPD_DATE")
  private Date updDate;

}
