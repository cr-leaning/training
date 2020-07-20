package com.computerrescuer.demoApi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.computerrescuer.demoApi.model.validation.BaseValidationI.RegistValidate;
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
  @NotBlank
  @Size(max = 20, message = "{error.size.max}")
  private String userId;

  /**
   * 名前
   */
  @Column(name="NAME")
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String name;

  /**
   * パスワード
   */
  @Column(name="PASSWORD")
  @NotBlank(groups = {RegistValidate.class})
  @Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
  private String password;

  /** 所属部署 */
  private Integer groupSeqNo;

  /** 所属部署存在チェック */
  @AssertTrue(message = "指定した部署が存在しません")
  public boolean isComparePass() {
    if (this.groupSeqNo == null) {
      return true;
    }

    // TODO チェック処理
    return true;
  }
  
}
