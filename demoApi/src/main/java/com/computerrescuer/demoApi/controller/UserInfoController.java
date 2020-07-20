package com.computerrescuer.demoApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.computerrescuer.demoApi.model.dto.UserInfoDto;
import com.computerrescuer.demoApi.model.validation.BaseValidationI.RegistValidate;
import com.computerrescuer.demoApi.model.validation.BaseValidationI.UpdateValidate;
import com.computerrescuer.demoApi.service.IBaseService;
import com.computerrescuer.demoApi.util.constants.MessageConst;
import com.computerrescuer.demoApi.util.constants.UrlConst;
import com.computerrescuer.demoApi.util.enums.ResultCodeEnum;

/**
 * ユーザ情報 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@RestController
@RequestMapping(UrlConst.USER_INFO)
public class UserInfoController {

  @Autowired
  SmartValidator smartValidator;
  
  @Autowired
  @Qualifier("UserInfo")
  private IBaseService<UserInfoDto> userInfoService;

  /**
   * ユーザ情報一覧取得
   * 
   * @return
   */
  @GetMapping
  public List<UserInfoDto> list() {
    return userInfoService.getListData();
  }

  /**
   * ユーザ情報取得
   * 
   * @param id
   * @return
   */
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public UserInfoDto refer(@PathVariable("id")Integer id) {
    var userInfoDto = new UserInfoDto();
    
    userInfoDto.setSeqNo(id);
    userInfoService.getData(userInfoDto);

    return userInfoDto;
  }

  /**
   * ユーザ情報登録
   * 
   * @return
   */
  @RequestMapping(method = RequestMethod.POST)
  public UserInfoDto register(@Validated(RegistValidate.class) @RequestBody UserInfoDto userInfoDto,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      // TODO エラー情報の設定
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.PROC_FAILD);
      // return userInfoDto;
      throw new IllegalArgumentException();
    }
    if (userInfoService.register(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);
    }
    return userInfoDto;
  }

  /**
   * ユーザ情報更新
   * 
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.PATCH)
  public UserInfoDto update(@Validated(UpdateValidate.class) @RequestBody UserInfoDto userInfoDto,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      // TODO エラー情報の設定
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.PROC_FAILD);
      // return userInfoDto;
      
      throw new IllegalArgumentException();
    }
    if (userInfoService.update(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);
    }
    return userInfoDto;
  }

  /**
   * ユーザ情報取得
   * 
   * @param id
   * @return
   */
  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id")Integer id) {
    UserInfoDto userInfoDto = new UserInfoDto();
    
    userInfoDto.setSeqNo(id);
    userInfoService.delete(userInfoDto);
  }


}
