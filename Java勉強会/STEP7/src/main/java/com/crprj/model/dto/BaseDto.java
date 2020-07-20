package com.crprj.model.dto;

/**
 * 基底DTO
 * @author YS
 *
 */
public class BaseDto {

  /** 結果コード */
  private int resultCode = 0;
  
  /** 結果メッセージ */
  private String resultMessage;
  
  /** 結果コード setter */
  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }
  
  /** 結果コード getter */
  public int getResultCode() {
    return this.resultCode;
  }
  
  /** 結果コード setter */
  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }
  
  /** 結果コード getter */
  public String getResultMessage() {
    return this.resultMessage;
  }
  
}
