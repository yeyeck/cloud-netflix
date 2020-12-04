package org.yeyeck.eurekaconsumeropenfeign.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystrix implements HiService{

  @Override
  public String sayHi(String to) {
    return "Say Hi error, " + to + ".";
  }
  
}
