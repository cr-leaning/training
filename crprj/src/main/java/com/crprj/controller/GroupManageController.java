package com.crprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crprj.constants.ItemConst;
import com.crprj.constants.ScreenConst;
import com.crprj.model.dto.GroupManageListDto;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * グループマスタ画面 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Slf4j
@Controller
@Transactional
public class GroupManageController {

  private final String SCREEN_ID = ScreenConst.GROUP_MANAGE;

  /**
   * グループマスタ管理画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(
      value = {"SCREEN_ID", "/groupManage"},
      method = RequestMethod.GET)
  public String top(Model model) {
    log.debug(SCREEN_ID + " start");

    // グループマスタ一覧取得クラスをインスタンス化
    GroupManageListDto groupManageListDto = new GroupManageListDto();
    model.addAttribute(ItemConst.USER_INFO_LIST_DATA, new Gson().toJson(groupManageListDto.getGroupManageListDto()));

    log.debug(SCREEN_ID + " end");
    return this.SCREEN_ID;
  }

}