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

  private static final String INPUT_MSG = "情報を入力して下さい";
  private static final String RES_MSG1 = "様が入力された値は";
  private static final String RES_MSG2 = "です。";
  private static final String RES_MSG3 = "未入力";
  private static final String ERR_MSG = "名前ぐらいは入れて！！";
  
  @RequestMapping(value = "/", method=RequestMethod.GET)
  public String index(Model model) {
    model.addAttribute("msg", INPUT_MSG);
    return "index";
  }

  @RequestMapping(value = "/", method=RequestMethod.POST)
  public String index(
      @RequestParam(value="text1", required=false)String text1,
      @RequestParam(value="check1", required=false)String check1,
      @RequestParam(value="radio1", required=false)String radio1,
      @RequestParam(value="select1", required=false)String select1,
      @RequestParam(value="select2", required=false)String[] select2,
      Model model) {
    if (text1 == null || text1.equals("")) {
      // 名前が入力されていない場合、そこで終了
      model.addAttribute("msg", ERR_MSG);
      return "index";
    }
    
    String mes;
    try {
      mes = " check:" + check1 +
          " radio:" + radio1 +
          " select:" + select1+
          "\nselect2:";
    } catch (NullPointerException e) {
      // パラメータが未入力の場合、NULLとなるため、例外を握りつぶす
      mes = "";
      e.printStackTrace();
    }
    try {
      mes += select2[0];
      for (int i = 1; i < select2.length; i++) {
        mes += "," + select2[i];
      }
    } catch (NullPointerException e) {
      mes += "null";
    }
    model.addAttribute("msg", mes + RES_MSG2);

//    //こっちのほうがスマート    
//    StringBuffer mes = new StringBuffer().append(text1).append(RES_MSG1);
//    mes.append(" check:").append(check1)
//    .append(" radio:").append(radio1)
//    .append(" select:").append(select1)
//    .append("\nselect2:");
//    if (select2.length > 0) {
//      for (String str : select2) {
//        mes.append(str).append(",");
//      }
//      mes.deleteCharAt(mes.length() - 1);
////      // Java8ならこのように書く
////      mes.append(Arrays.stream(select2).collect(Collectors.joining(", ")));
//    } else {
//      mes.append("null");
//    }
//    
//    mes.append(RES_MSG2);
//    model.addAttribute("msg", mes.toString());
    model.addAttribute("value", text1);
    return "index";
  }

}
