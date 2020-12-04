package org.yeyeck.eurekaservicehi;

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
public class EurekaServiceHiApplication {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/sayHi/{to}")
	public String sayHi(@PathVariable String to) {
		return "port" + port + ":Hi, " + to + ". ";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceHiApplication.class, args);
	}

}
