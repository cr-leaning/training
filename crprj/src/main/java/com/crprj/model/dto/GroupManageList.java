package com.crprj.model.dto;

import lombok.Data;

@Data
public class GroupManageList {

  /** seqNo */
  private int seqNo;
  
  /** 事業部ID */
  private String groupId;
  
  /** 事業部名 */
  private String groupName;
  
  /** 登録日時 */
  private Integer registrationDate;
  
  /** 登録者名 */
  private String registrationName;
  
  /** 更新日時 */
  private Integer resetDate;
  
  /** 更新者名 */
  private String resetName;
}
