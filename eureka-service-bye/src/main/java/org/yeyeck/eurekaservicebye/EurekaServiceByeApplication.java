package org.yeyeck.eurekaservicebye;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaServiceByeApplication {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/sayBye/{to}")
	public String sayBye(@PathVariable String to) {
		return "port" + port + ":Bye, " + to + ". ";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceByeApplication.class, args);
	}

}
