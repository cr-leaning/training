package com.crprj.service.impl;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.crprj.enums.OpeTypeEnum;
import com.crprj.enums.StatusEnum;
import com.crprj.model.entity.BaseEntity;

public class BaseService {

  @Autowired
  private HttpSession session;
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
