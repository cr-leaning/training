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
 * ユーザ情報テーブルクラス
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="USER_INFO", schema="cr_prj")
public class UserInfo extends BaseEntity {

  /**
   * 連番
   */
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SEQ_NO")
  private Integer seqNo;

  /**
   * ID
   */
  @Column(name="USER_ID")
  private String userId;

  /**
   * 名前
   */
  @Column(name="NAME")
  private String name;

  /**
   * パスワード
   */
  @Column(name="PASSWORD")
  private String password;

  
}
