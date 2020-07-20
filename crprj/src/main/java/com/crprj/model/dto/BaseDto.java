package com.crprj.model.dto;

import com.crprj.enums.ResultCodeEnum;

import lombok.Data;

/**
 * 基底DTO
 * @author YS
 *
 */
@Data
public class BaseDto {

  /** 結果コード */
  private int resultCode = ResultCodeEnum.OK.getValue();
  
  /** 結果メッセージ */
  private String resultMessage;
  
}
