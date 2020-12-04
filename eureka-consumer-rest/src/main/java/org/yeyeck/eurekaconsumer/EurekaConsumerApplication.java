package org.yeyeck.eurekaconsumer;

import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaConsumerApplication {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/sayHi/{to}")
	public String sayHi(@PathVariable String to) {
		return  restTemplate.getForObject("http://service-hi/sayHi/" + to, String.class) + "This is " + port + "!";
	}
	@GetMapping("/sayBye/{to}")
	public String sayBey(@PathVariable String to) {
		return  restTemplate.getForObject("http://service-bye/sayBye/" + to, String.class) + "This is " + port + "!";
	}


	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
