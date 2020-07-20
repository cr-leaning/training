package com.crprj.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crprj.constants.ScreenConst;

import lombok.extern.slf4j.Slf4j;

/**
 * 役職マスタ画面 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Slf4j
@Controller
@Transactional
public class PositionManageController {

	  private final String SCREEN_ID = ScreenConst.POSITION_MANAGE;

	  /**
	   * 役職マスタ管理画面
	   * 
	   * @param model
	   * @return
	   */
	  @RequestMapping(value = {"SCREEN_ID", "/positionManage"}, method = RequestMethod.GET)
	  public String top(Model model) {
	    log.debug(SCREEN_ID + " start");


	    log.debug(SCREEN_ID + " end");
	    return this.SCREEN_ID;
	  }

	}