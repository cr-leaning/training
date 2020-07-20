package com.crprj.model.dto;

import lombok.Data;

/**
 * 基底DTO
 * @author YS
 *
 */
@Data
public class BaseDto {

  /** 結果コード */
  private int resultCode = 0;
  
  /** 結果メッセージ */
  private String resultMessage;
  
}
