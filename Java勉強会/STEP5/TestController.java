package com.crmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * テスト コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

  private static final String INPUT_MSG = "名前を入力して下さい";
  private static final String RES_MSG1 = "こんにちは";
  private static final String RES_MSG2 = "様";
  
  @RequestMapping(value = "/", method=RequestMethod.GET)
  public String index(Model model) {
    model.addAttribute("msg", INPUT_MSG);
    return "index";
  }

  @RequestMapping(value = "/", method=RequestMethod.POST)
  public String index(@RequestParam("text1")String text1, Model model) {
    model.addAttribute("msg", RES_MSG1 + text1 + RES_MSG2);
    model.addAttribute("value", text1);
    return "index";
  }

}
