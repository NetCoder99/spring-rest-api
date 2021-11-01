package com.example.demo.Security.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SecurityJWT {

	private static String jwtSubject = "Joe";
	private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public static String getJwtToken() {
		Date expiryDate = Date.from(ZonedDateTime.now().plusMinutes(1).toInstant());
		
		
		String jws = Jwts.builder()
				.setSubject(jwtSubject)
				.signWith(key)
				.setExpiration(expiryDate)
				.setClaims(getClaims())
				.claim(jwtSubject, expiryDate)
				.compact();
		return jws;
	}
	
	public static Map<String, String> getClaims() {
		HashMap<String, String> rtnMap = new HashMap<>();
		rtnMap.put("admin", "admin");
		rtnMap.put("user1", "user1");
		rtnMap.put("batch", "batch");
		return rtnMap;
		
	}
	
	public static String verifyJwtToken(String jwtToken) {
		try {
		    Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
		    return claims.toString();
		} catch (JwtException e) {
			throw e;
		}
	}

}
