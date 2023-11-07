package com.klef.jfsd.springboot.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.*;
import com.klef.jfsd.springboot.repository.CaptchaRepository;
@Service
public class CaptchaManager {
  
  @Autowired
  CaptchaRepository CR;
  
  public String ramdomText(int CaptchaLength)
  {
    String captcha = "abcdefghijklmnopqrstuvwxyz";
    StringBuffer captchaBuffer = new StringBuffer();
    Random rnd = new Random();
    while(captchaBuffer.length() < CaptchaLength)
    {
      int index = (int) (rnd.nextFloat() * captcha.length());
      String ch = captcha.substring(index, index + 1);
      captchaBuffer.append(ch);
    }
    return captchaBuffer.toString();
  }
  
  public byte[] generateCaptcha(String txt)
  {
    Long id = (long) 1;
    CR.deleteById(id);
    CaptchaEntity C = new CaptchaEntity();
    C.setId(id);
    C.setCaptcha(txt);
    CR.save(C);
    
    int width = 160, height = 35;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.OPAQUE);
    Graphics graphics = image.createGraphics();
    graphics.setFont(new Font("Arial", Font.BOLD, 20));
    graphics.setColor(Color.BLUE);
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(Color.YELLOW);
    graphics.drawString(txt, 40, 25);
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    try
    {
      ImageIO.write(image, "png", bout);
    }catch(Exception e)
    {
      new RuntimeException(e);
    }
    return bout.toByteArray();
  }
  
  public String validateCaptcha(String txt)
  {
    Long id = (long) 1;
    CaptchaEntity tmp = CR.findById(id).get();
    if(txt.compareTo(tmp.getCaptcha())==0)
      return "Validation Success";
    
    return "Validation Failed";
  }
}
