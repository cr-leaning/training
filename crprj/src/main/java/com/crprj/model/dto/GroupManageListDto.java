package com.crprj.model.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザ情報画面用DTO
 * @author YS
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class GroupManageListDto extends BaseDto {

  /** ユーザ情報一覧 */
  private List<GroupManageListDto> groupManageListDto;

}