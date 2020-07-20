package com.computerrescuer.demoApi.service.impl;

import java.util.Date;
import com.computerrescuer.demoApi.model.entity.BaseEntity;
import com.computerrescuer.demoApi.util.enums.OpeTypeEnum;
import com.computerrescuer.demoApi.util.enums.StatusEnum;

public class BaseService {

  protected BaseService(){
  }
  
  /**
   * Entity共通項目設定
   * @param entity
   * @param ope
   */
  protected void setEntityComItem(BaseEntity entity, OpeTypeEnum ope){
    Date date = new Date();
    //TODO ユーザ情報
    entity.setUpdUser(0);
    entity.setUpdDate(date);
    switch (ope) {
      case REGIST:
        //TODO ユーザ情報
        entity.setRegUser(0);
        entity.setRegDate(date);
      case UPDATE:
        entity.setStatusFlg(StatusEnum.VALID.getValue());
        break;
      case DELETE:
        entity.setStatusFlg(StatusEnum.INVALID.getValue());
        break;
      default:
        throw new IllegalArgumentException("enum : " + ope.name());
    }
  }
}
