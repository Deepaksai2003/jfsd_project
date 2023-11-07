
package com.klef.jfsd.springboot.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.service.*;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

  @Autowired
  CaptchaManager M;
  
  @GetMapping("/getcaptcha/{length}")
  public String getCaptcha(@PathVariable("length") int length)
  {
    String txt = M.ramdomText(length);
    byte[] data = M.generateCaptcha(txt);
    return Base64.getEncoder().encodeToString(data);
  }
  
  @GetMapping("/validate/{txt}")
  public String validate(@PathVariable("txt") String txt)
  {
    return M.validateCaptcha(txt);
  }
}