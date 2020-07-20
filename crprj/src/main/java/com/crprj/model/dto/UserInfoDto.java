package com.crprj.model.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import com.crprj.model.validation.BaseValidationI.RegistValidate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザ情報画面用DTO
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserInfoDto extends BaseDto {

  /** 処理モード */
  @NotBlank
  private String mode;
  
  /** SEQ_NO */
  private Integer seqNo;

  /** ユーザID */
  @NotBlank
  @Size(max = 20, message = "{error.size.max}")
  private String userId;

  /** 名前 */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String name;

  /** 名前（カナ） */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String kana;

  /** 性別 */
  @Size(max = 100, message = "{error.size.max}")
  private String sex;

  /** パスワード */
  @NotBlank(groups = {RegistValidate.class})
  @Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
  private String password;
  
  /** パスワード(確認) */
  private String passwordConf;
  
  /** 所属部署 */
  @Size(max = 100, message = "{error.size.max}")
  private String group;

  /** 役職 */
  @Size(max = 100, message = "{error.size.max}")
  private String position;

  /** 肩書 */
  @Size(max = 100, message = "{error.size.max}")
  private String title;

  /** 電話番号 */
  @Size(max = 100, message = "{error.size.max}")
  private String phoneNum;

  /** 電話番号（自宅） */
  @Size(max = 100, message = "{error.size.max}")
  private String phoneNum1;

  /** メールアドレス（社用） */
  @Size(max = 100, message = "{error.size.max}")
  private String mailAddr;

  /** メールアドレス（携帯） */
  @Size(max = 100, message = "{error.size.max}")
  private String mailAddr1;

  /** メールアドレス（PC） */
  @Size(max = 100, message = "{error.size.max}")
  private String mailAddr2;


  /** パスワード一致チェック */
  @AssertTrue(message = "パスワードが一致しません")
  public boolean isComparePass() {
      return StringUtils.equals(password, passwordConf);
  }
  
  // 表示用
  /** 性別 */
  private String sexDisp;


}
