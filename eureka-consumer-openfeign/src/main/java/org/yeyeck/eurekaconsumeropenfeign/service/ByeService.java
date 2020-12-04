package org.yeyeck.eurekaconsumeropenfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-bye")
public interface ByeService {
  
  @GetMapping("/sayBye/{to}")
  String sayBye(@PathVariable String to);
}
