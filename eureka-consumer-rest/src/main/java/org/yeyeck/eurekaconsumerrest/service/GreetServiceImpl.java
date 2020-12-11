package org.yeyeck.eurekaconsumerrest.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GreetServiceImpl implements GreetService {

  @Value("${server.port}")
	private Integer port;

  private RestTemplate restTemplate;

  public GreetServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  @HystrixCommand(fallbackMethod = "hiError")
  public String sayHi(String to) {
    return  restTemplate.getForObject("http://service-hi/sayHi/" + to, String.class) + "This is " + port + "!";
  }

  @Override
  public String sayBye(String to) {
    return  restTemplate.getForObject("http://service-bye/sayBye/" + to, String.class) + "This is " + port + "!";
  }

  public String hiError(String to) {
    return "Say Hi error, " + to + ".";
  }
  
}
