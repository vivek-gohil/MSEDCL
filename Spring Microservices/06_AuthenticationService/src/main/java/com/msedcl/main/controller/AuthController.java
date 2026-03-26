package com.msedcl.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.security.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	public AuthController() {
		log.info("AuthController object created");
	}

	@PostMapping("login")
	public String login(@RequestParam String username) {
		log.info("Request received to generate token for username :: " + username);
		return jwtUtil.generateToken(username);
	}
}