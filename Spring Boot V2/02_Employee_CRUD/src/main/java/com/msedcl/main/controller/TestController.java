package com.msedcl.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("greetapi")
public class TestController {
	@GetMapping("greet")
	public String getMethodName() {
		log.info("Working");
		return "Hello";
	}

}
