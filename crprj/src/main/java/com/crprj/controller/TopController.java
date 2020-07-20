package com.crprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.crprj.constants.ScreenConst;
import com.crprj.service.impl.TopService;
import lombok.extern.slf4j.Slf4j;

/**
 * TOP画面 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Slf4j
@Controller
@Transactional
public class TopController {

  private final String SCREEN_ID = ScreenConst.TOP_SCREEN;

  @Autowired
  private TopService topService;

  /**
   * TOP画面
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = {SCREEN_ID, "/"}, method = RequestMethod.GET)
  public String top(Model model) {
    log.debug(SCREEN_ID + " start");
    log.debug(SCREEN_ID + " end");
    return this.SCREEN_ID;
  }

}
