package com.msedcl.main.customer.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//READS :: Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
		String authHeader = request.getHeader("Authorization");

		//Check Bearer :: Ensures correct format
		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			//Extract token and Removes "Bearer "
			String token = authHeader.substring(7);
			
			// Extract username (VALIDATION happens here)
			String username = jwtUtil.extractUsername(token);

			//Create Authentication object as below
			//User = vivek
			//Authenticated = YES
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
					new ArrayList<>());

			//This tells Spring: User is authenticated
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		//Continue request
		filterChain.doFilter(request, response);
	}
}
