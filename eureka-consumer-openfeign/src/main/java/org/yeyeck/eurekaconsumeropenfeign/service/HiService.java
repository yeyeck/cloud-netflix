package org.yeyeck.eurekaconsumeropenfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-hi", fallback = HiServiceHystrix.class)
public interface HiService {

  @GetMapping("/sayHi/{to}")
  String sayHi(@PathVariable String to);
  
}
