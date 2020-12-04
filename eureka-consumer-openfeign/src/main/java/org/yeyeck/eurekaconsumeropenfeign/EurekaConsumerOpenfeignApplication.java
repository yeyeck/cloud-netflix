package org.yeyeck.eurekaconsumeropenfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeyeck.eurekaconsumeropenfeign.service.ByeService;
import org.yeyeck.eurekaconsumeropenfeign.service.HiService;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
public class EurekaConsumerOpenfeignApplication {

	@Autowired
	private HiService hiService;

	@Autowired
	private ByeService byeService;


	@Value("${server.port}")
	private Integer port;

	@GetMapping("/sayHi/{to}")
	public String sayHi(@PathVariable String to) {
		return hiService.sayHi(to) + "This is " + port;
	}

	@GetMapping("/sayBye/{to}")
	public String sayBye(@PathVariable String to) {
		return byeService.sayBye(to) + "This is " + port;
	}



	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerOpenfeignApplication.class, args);
	}

}
