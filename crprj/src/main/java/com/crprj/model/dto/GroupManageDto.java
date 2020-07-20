package com.crprj.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザ情報画面用DTO
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class GroupManageDto extends BaseDto {

  /** SEQ_NO */
  private Integer seqNo;;

  /** 事業部ID */
  @NotBlank
  @Size(max = 20, message = "{error.size.max}")
  private String groupId;

  /** 事業部名 */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String groupName;

  /** 登録日時 */
  @NotBlank
  @Size(max = 50, message = "{error.size.max}")
  private Integer registrationDate;
  
  /** 登録者名 */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String registrationName;
  
  /** 更新日時 */
  @NotBlank
  @Size(max = 50, message = "{error.size.max}")
  private Integer resetDate;
  
  /** 更新者名 */
  @NotBlank
  @Size(max = 100, message = "{error.size.max}")
  private String resetName;
  
}
