package com.msedcl.main.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// This is your secret password for signing JWT
	private final String SECRET = "vivek-secret-vivek-secret-vivek-secret";
 

	//	Converts your string secret → cryptographic key
	//	Uses HMAC-SHA algorithm (HS256)
	private Key getSignKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username) // This is your user identity
				.setIssuedAt(new Date()) // When token was created
				.setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Token expiry (1 hour)
				.signWith(getSignKey()) // Signs token using SECRET
				.compact(); //Builds final JWT string:
	}

	public String extractUsername(String token) {
		return getClaims(token).getSubject(); // Parses token and Returns "sub" value
	}

	
	//Step 1: Parse token
	//Step 2: Verify signature
	//Step 3: Check expiry
	//Step 4: Return claims
	private Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
}