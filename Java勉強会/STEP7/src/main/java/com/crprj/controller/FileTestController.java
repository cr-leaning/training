package com.crprj.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * スキルシート管理 コントローラークラス
 * 
 * @author suzuki yuuki
 *
 */
@Controller
@RequestMapping("/skillsheet")
public class FileTestController {

  private static String test = "<FileObj:File_Name>ファイル名</FileObj:File_Name>";
  
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String getSkillSheetManage(HttpServletResponse response) {

    response.setHeader( "Content-Disposition"," attachment;filename=data.zip");
    response.setContentType("application/zip; charset=UTF-8");

    byte[] data = test.getBytes();
    try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());) {
      ByteArrayOutputStream objBos = new ByteArrayOutputStream();
      OutputStreamWriter objOsw = new OutputStreamWriter(objBos, "Shift_JIS");
      
      objOsw.write(test);
      objOsw.close();
      
      ZipEntry objZe = new ZipEntry("test.xml");
      objZe.setMethod(ZipOutputStream.DEFLATED);
      zos.putNextEntry(objZe);
      byte[] aryByt = objBos.toByteArray();
      zos.write(aryByt, 0, aryByt.length);
      
      zos.closeEntry();
    } catch (Exception e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
    
    return "get";
  }

}
