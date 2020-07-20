package com.crprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.crprj.constants.ItemConst;
import com.crprj.constants.MessageConst;
import com.crprj.constants.ScreenConst;
import com.crprj.enums.OpeTypeEnum;
import com.crprj.model.dto.UserInfoDto;
import com.crprj.model.dto.UserInfoListDto;
import com.crprj.model.validation.BaseValidationI.RegistValidate;
import com.crprj.model.validation.BaseValidationI.UpdateValidate;
import com.crprj.service.IBaseService;
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
@Transactional
@RequestMapping(ScreenConst.USER_INFO)
public class UserInfoController {

  private final String SCREEN_ID = ScreenConst.USER_INFO;
  private final String LIST_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_LIST;
  private final String REF_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_REFER;
  private final String REG_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_REGISTER;
  private final String UPD_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_UPDATE;
  private final String DEL_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_DELETE;
  private final String CONF_TEMPLATE = ScreenConst.USER_INFO + "_" + ScreenConst.SCREEN_CONFIRM;

  @Autowired
  SmartValidator smartValidator;
  
  @Autowired
  @Qualifier("UserInfo")
  private IBaseService<UserInfoDto, UserInfoListDto> userInfoService;

  /**
   * ユーザ情報一覧画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = {ScreenConst.SCREEN_LIST, "/"}, method = RequestMethod.GET)
  public String list(Model model) {
    log.debug(ScreenConst.SCREEN_LIST + " start");
    UserInfoListDto userInfoListDto = new UserInfoListDto();
    
    userInfoService.getListData(userInfoListDto);

    model.addAttribute(ItemConst.USER_INFO_LIST_DATA, new Gson().toJson(userInfoListDto.getUserInfoList()));
    log.debug(ScreenConst.SCREEN_LIST + " end");
    return this.LIST_TEMPLATE;
  }

  /**
   * ユーザ情報参照画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = ScreenConst.SCREEN_REFER, method = RequestMethod.GET)
  public String refer(Model model, @RequestParam("id")Integer id) {
    log.debug(ScreenConst.SCREEN_REFER + " start");
    UserInfoDto userInfoDto = new UserInfoDto();
    
    userInfoDto.setSeqNo(id);
    userInfoService.getData(userInfoDto);

    model.addAttribute("userInfoDto", userInfoDto);
    log.debug(ScreenConst.SCREEN_REFER + " end");
    return this.REF_TEMPLATE;
  }

  /**
   * ユーザ情報 登録画面（表示）
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = ScreenConst.SCREEN_REGISTER, method = RequestMethod.GET)
  public String register(Model model,  UserInfoDto userInfoDto) {
    log.debug(ScreenConst.SCREEN_REGISTER + " start");
    log.debug(ScreenConst.SCREEN_REGISTER + " end");
    return this.REG_TEMPLATE;
  }

  /**
   * ユーザ情報登録画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = ScreenConst.SCREEN_REGISTER, method = RequestMethod.POST)
  public String register(Model model, @Validated(RegistValidate.class) UserInfoDto userInfoDto,
      BindingResult bindingResult) {
    log.debug(ScreenConst.SCREEN_REGISTER + " start");
    if (bindingResult.hasErrors()) {
      return this.REG_TEMPLATE;
    }
    if (userInfoService.register(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);
    }
    model.addAttribute(ItemConst.RESULT_CODE, userInfoDto.getResultCode());
    model.addAttribute(ItemConst.MSG, userInfoDto.getResultMessage());
    log.debug(ScreenConst.SCREEN_REGISTER + " end");
    return this.list(model);
  }

  /**
   * ユーザ情報登録画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = ScreenConst.SCREEN_UPDATE, method = RequestMethod.POST)
  public String update(Model model, @Validated(UpdateValidate.class) UserInfoDto userInfoDto,
      BindingResult bindingResult) {
    log.debug(ScreenConst.SCREEN_UPDATE + " start");
    if (bindingResult.hasErrors()) {
      return this.UPD_TEMPLATE;
    }
    if (userInfoService.update(userInfoDto)) {
      userInfoDto.setResultMessage(MessageConst.PROC_COMP);
    }
    model.addAttribute(ItemConst.RESULT_CODE, userInfoDto.getResultCode());
    model.addAttribute(ItemConst.MSG, userInfoDto.getResultMessage());
    log.debug(ScreenConst.SCREEN_UPDATE + " end");
    return this.list(model);
  }

  /**
   * ユーザ情報 更新画面（表示）
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = ScreenConst.SCREEN_UPDATE, method = RequestMethod.GET)
  public String update(Model model, UserInfoDto userInfoDto, @RequestParam("id")Integer id) {
    log.debug(ScreenConst.SCREEN_UPDATE + " start");
    userInfoDto = new UserInfoDto();
    
    userInfoDto.setSeqNo(id);
    userInfoService.getData(userInfoDto);

    model.addAttribute("userInfoDto", userInfoDto);
    log.debug(ScreenConst.SCREEN_UPDATE + " end");
    return this.UPD_TEMPLATE;
  }

  /**
   * ユーザ情報 確認画面
   * 
   * @param countryForm
   * @param bindingResult
   * @param model
   * @return
   */
  @RequestMapping(ScreenConst.SCREEN_CONFIRM)
  public String confirm(Model model, UserInfoDto userInfoDto,
      BindingResult bindingResult) {
    log.debug(ScreenConst.SCREEN_CONFIRM + " start");

    OpeTypeEnum opType = OpeTypeEnum.getEnum(userInfoDto.getMode());
    switch (opType) {
      case REGIST:
        smartValidator.validate(userInfoDto, bindingResult, RegistValidate.class);
        break;
      case UPDATE:
        smartValidator.validate(userInfoDto, bindingResult, UpdateValidate.class);
        break;
      default:
        throw new IllegalArgumentException();
    }
    if (bindingResult.hasErrors()) {
      return this.getBackTemplate(opType);
    }

    log.debug(ScreenConst.SCREEN_CONFIRM + " end");
    return this.CONF_TEMPLATE;
  }

  /**
   * ユーザ情報 確認画面（戻る）
   * 
   * @param countryForm
   * @param bindingResult
   * @param model
   * @return
   */
  @RequestMapping(ScreenConst.ACTION_BACK)
  public String back(UserInfoDto userInfoDto, RedirectAttributes redirectAttributes) {
    log.debug(ScreenConst.ACTION_BACK + " start");

    OpeTypeEnum opType = OpeTypeEnum.getEnum(userInfoDto.getMode());
    redirectAttributes.addFlashAttribute(
        this.getBackTemplate(opType), userInfoDto);

    log.debug(ScreenConst.ACTION_BACK + " end");
    return "redirect:/" + SCREEN_ID + "/" + ScreenConst.SCREEN_REGISTER;
  }

  
  /**
   * 確認画面より戻る画面をIDをもとに判定
   * @param id
   * @return
   */
  private String getBackTemplate(OpeTypeEnum opType) {
    if (opType == OpeTypeEnum.REGIST) {
      return this.REG_TEMPLATE;
    } else {
      return this.UPD_TEMPLATE;
    }
  }
  
}
