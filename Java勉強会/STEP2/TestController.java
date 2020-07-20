package com.crmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * テスト コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @RequestMapping(value = "/")
  public String index() {
    return "index";
  }

}
