package com.crprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crprj.constants.ItemConst;
import com.crprj.constants.MessageConst;
import com.crprj.constants.ScreenConst;
import com.crprj.model.dto.UserInfoDto;
import com.crprj.model.entity.UserInfo;
import com.crprj.service.UserInfoService;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザ情報 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Slf4j
@Controller
@RequestMapping(ScreenConst.USER_INFO)
public class UserInfoController {

  private static final String SCREEN_ID = ScreenConst.USER_INFO;
  private static final String SCREEN_LIST = SCREEN_ID + ScreenConst.SUFF_LIST;
  private static final String SCREEN_REGISTER = SCREEN_ID + ScreenConst.SUFF_REG;
  private static final String SCREEN_UPDATE = SCREEN_ID + ScreenConst.SUFF_UPD;
  private static final String SCREEN_DELETE = SCREEN_ID + ScreenConst.SUFF_DEL;
  private static final String SCREEN_CONFIRM = SCREEN_ID + ScreenConst.SUFF_CONF;
  private static final String SCREEN_REFER = SCREEN_ID + ScreenConst.SUFF_REF;

  @Autowired
  private UserInfoService userInfoService;
  @Autowired
  private HttpSession session;

  /**
   * ユーザ情報一覧画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_LIST, method = RequestMethod.GET)
  public String list(Model model) {
    log.info(MessageConst.START + SCREEN_LIST);

    List<UserInfo> userInfoLst = userInfoService.getListData();

    model.addAttribute(ItemConst.LIST_DATA, new Gson().toJson(userInfoLst));
    log.info(MessageConst.END + SCREEN_LIST);
    return SCREEN_LIST;
  }

  /**
   * ユーザ情報 登録画面（表示）
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_REGISTER, method = RequestMethod.GET)
  public String register(UserInfoDto userInfoDto, Model model) {
    log.info(MessageConst.START + SCREEN_REGISTER);

    log.info(MessageConst.END + SCREEN_REGISTER);
    return SCREEN_REGISTER;
  }

  /**
   * ユーザ情報 確認画面
   * 
   * @param countryForm
   * @param bindingResult
   * @param model
   * @return
   */
  @RequestMapping(SCREEN_CONFIRM)
  public String confirm(Model model, @Validated UserInfoDto userInfoDto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return SCREEN_REGISTER;
    }
    // TODO パスワードの暗号化

    return SCREEN_CONFIRM;
  }

  /**
   * ユーザ情報 確認画面（戻る）
   * 
   * @param countryForm
   * @param bindingResult
   * @param model
   * @return
   */
  @RequestMapping("back")
  public String back(UserInfoDto userInfoDto, RedirectAttributes redirectAttributes) {

    redirectAttributes.addFlashAttribute(SCREEN_REGISTER, userInfoDto);

    return "redirect:/" + SCREEN_ID + "/" + SCREEN_REGISTER;
  }


  /**
   * ユーザ情報登録画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = SCREEN_REGISTER, method = RequestMethod.POST)
  public String register(Model model, UserInfoDto userInfoDto) {
    log.info(MessageConst.START + SCREEN_REGISTER + "post");

    if (userInfoService.register(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);;
    }

    model.addAttribute(ItemConst.MSG, userInfoDto.getResultMessage());
    log.info(MessageConst.END + SCREEN_REGISTER + "post");
    return SCREEN_REGISTER;
  }

}
