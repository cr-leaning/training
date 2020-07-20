package com.computerrescuer.demoApi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * グループマスタテーブルクラス
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class GroupMaster extends BaseEntity {

  /**
   * 連番
   */
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SEQ_NO")
  private Integer seqNo;

  /**
   * グループID
   */
  @Column(name="GROUP_ID")
  @NotBlank
  @Size(max = 10, message = "{error.size.max}")
  private String groupId;

  /**
   * 名前
   */
  @Column(name="NAME")
  @NotBlank
  @Size(max = 30, message = "{error.size.max}")
  private String name;
  
}
