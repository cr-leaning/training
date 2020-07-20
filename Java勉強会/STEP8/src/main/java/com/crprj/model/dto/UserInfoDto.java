package com.crprj.model.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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

  /** ユーザID */
  @NotBlank
  @Size(max = 20, message = "{error.size.max}")
  private String id;

  /** ユーザ名 */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String name;

  /** パスワード */
  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
  private String password;
  
  /** パスワード(確認) */
  private String passwordConf;

  @AssertTrue(message = "パスワードが一致しません")
  public boolean isComparePass() {
      return password.equals(passwordConf);
  }
  
}
