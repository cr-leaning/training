package com.crmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

  private static final String NO_VAL = "０以下はちょっと。。。";
  
  @RequestMapping(value = "/")
  public String index(@RequestParam("num") int num, Model model) {
    String msg;
    int res = 0;
    if (num <= 0) {
      msg = NO_VAL;
    } else {
      for (int i = 0;i <= num;i++) {
        res += i;
      }
      msg = "total: " + String.valueOf(res);
    }
    model.addAttribute("msg", msg);
    return "index";
  }

}
