package com.crprj.model.dto;

import lombok.Data;

@Data
public class UserInfoList {

  /** seqNo */
  private int seqNo;
  
  /** UserID */
  private String userId;
  
  /** 名前 */
  private String name;
  
  /** 部署 */
  private String group;
  
  /** 肩書 */
  private String position;
  
  /** 役職 */
  private String title;
  
  
}
