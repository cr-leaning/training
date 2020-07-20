package com.crprj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crprj.constants.MessageConst;
import com.crprj.enums.ResultCodeEnum;
import com.crprj.model.dto.UserInfoDto;
import com.crprj.model.entity.UserInfo;
import com.crprj.repository.UserInfoRepository;

@Service
public class UserInfoService {

  @Autowired
  private UserInfoRepository userInforepository;
  
  /**
   * 一覧用データ取得
   * @return
   */
  public List<UserInfo> getListData() {
    return userInforepository.findAll();
  }

  /**
   * データ登録
   * @param userInfoDto
   * @return
   */
  public boolean register(UserInfoDto userInfoDto) {
    if (userInfoDto.getId() == null && userInfoDto.getId().equals("")) {
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.NOT_USER_ID);
      return false;
    }
    if (userInfoDto.getPassword() == null && userInfoDto.getPassword().equals("")) {
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.NOT_PASSWORD);
      return false;
    }
    UserInfo userInfo = new UserInfo();
    userInfo.setId(userInfoDto.getId());
    userInfo.setName(userInfoDto.getName());
    userInfo.setPassword(userInfoDto.getPassword());
    userInfo.setRegDate(new Date());
    userInfo.setUpdDate(new Date());
    userInforepository.save(userInfo);
    return false;
  }

}
