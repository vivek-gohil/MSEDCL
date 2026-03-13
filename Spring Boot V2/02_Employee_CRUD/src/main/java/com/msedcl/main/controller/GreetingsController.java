package com.msedcl.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("myfirstapi")
public class GreetingsController {

	public GreetingsController() {
		log.info("GreetingsController object created!!");
	}

	@DeleteMapping("greetdelete")
	public ResponseEntity<String> deleteTesting() {
		log.info("deleteTesting()");
		return ResponseEntity.status(HttpStatus.OK).body("Testing Delete mapping!!");
	}

	@PutMapping("greetput")
	public ResponseEntity<String> putTesting() {
		log.info("putTesting()");
		return ResponseEntity.status(HttpStatus.OK).body("Testing Put mapping!!");
	}

	// endpoint :: http://localhost:8181/myfirstapi/postgreet
	@PostMapping("greetpost")
	public ResponseEntity<String> newGreetings() {
		log.info("newGreetings()");
		return ResponseEntity.status(HttpStatus.OK).body("Testing POST mapping!!");
	}

	// endpoint :: http://localhost:8181/myfirstapi/greet
	@GetMapping("greetget")
	public ResponseEntity<String> greetings() {
		log.info("greetings()");
		return ResponseEntity.status(HttpStatus.OK).body("Hello, Welcome to Spring Boot :)");
	}

}
