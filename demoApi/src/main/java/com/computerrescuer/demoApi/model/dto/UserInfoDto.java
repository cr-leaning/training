package com.computerrescuer.demoApi.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.computerrescuer.demoApi.model.validation.BaseValidationI.RegistValidate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザ情報DTO
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserInfoDto extends BaseDto {
  
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

  /** パスワード */
  @NotBlank(groups = {RegistValidate.class})
  @Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
  private String password;
  
  /** 所属部署 */
  private Integer groupSeqNo;

  /** 所属部署ID */
  private String groupId;

  /** 所属部署名 */
  private String groupName;


}
