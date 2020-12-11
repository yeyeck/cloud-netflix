package org.yeyeck.eurekaconsumerrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeyeck.eurekaconsumerrest.service.GreetService;

@RestController
public class GreetController {
  
	private GreetService greetService;

	public GreetController(GreetService service) {
		this.greetService = service;
	}


	@GetMapping("/sayHi/{to}")
	public String sayHi(@PathVariable String to) {
		return greetService.sayHi(to);
	}
	@GetMapping("/sayBye/{to}")
	public String sayBey(@PathVariable String to) {
		return greetService.sayBye(to);
	}
}
