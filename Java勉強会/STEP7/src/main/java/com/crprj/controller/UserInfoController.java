package com.crprj.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crprj.constants.ItemConst;
import com.crprj.constants.MessageConst;
import com.crprj.constants.ScreenConst;
import com.crprj.model.dto.UserInfoDto;
import com.crprj.model.entity.UserInfo;
import com.crprj.service.UserInfoService;

/**
 * ユーザ情報 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Controller
@RequestMapping(ScreenConst.USER_INFO)
public class UserInfoController {

  private static final Log log = LogFactory.getLog(UserInfoController.class);

  private static final String SCREEN_ID = ScreenConst.USER_INFO;
  private static final String SCREEN_LIST = SCREEN_ID + ScreenConst.SUFF_LIST;
  private static final String SCREEN_REGISTER = SCREEN_ID + ScreenConst.SUFF_REG;
  private static final String SCREEN_UPDATE = SCREEN_ID + ScreenConst.SUFF_UPD;
  private static final String SCREEN_DELETE = SCREEN_ID + ScreenConst.SUFF_DEL;
  private static final String SCREEN_REFER = SCREEN_ID + ScreenConst.SUFF_REF;

  @Autowired
  private UserInfoService userInfoService;

  /**
   * ユーザ情報一覧画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_LIST, method = RequestMethod.GET)
  public String list(Model model) {
    log.info(MessageConst.START + SCREEN_LIST);

    List<UserInfo> userInfo = userInfoService.getListData();

    model.addAttribute(ItemConst.LIST_DATA, userInfo);
    log.info(MessageConst.END + SCREEN_LIST);
    return SCREEN_LIST;
  }

  /**
   * ユーザ情報登録画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_REGISTER, method = RequestMethod.GET)
  public String register(Model model) {
    log.info(MessageConst.START + SCREEN_REGISTER);

    log.info(MessageConst.END + SCREEN_REGISTER);
    return SCREEN_REGISTER;
  }

  /**
   * ユーザ情報登録画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_REGISTER, method = RequestMethod.POST)
  public String register(Model model, 
      @RequestParam(value="id") String id,
      @RequestParam(value="name") String name,
      @RequestParam(value="password") String password) {
    log.info(MessageConst.START + SCREEN_LIST);

    UserInfoDto userInfoDto = new UserInfoDto();
    userInfoDto.setId(id);
    userInfoDto.setName(name);
    userInfoDto.setPassword(password);
    
    if (userInfoService.register(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);;
    }

    model.addAttribute(ItemConst.MSG, userInfoDto.getResultMessage());
    log.info(MessageConst.END + SCREEN_LIST);
    return SCREEN_REGISTER;
  }

}
