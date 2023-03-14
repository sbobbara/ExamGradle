package com.online.exam.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author narendar
 */
@Component
public class JwtTokenUtil {

	private String secret = "java"; // this secret is used to generate token,validate token

	public static void main(String[] args) {

		JwtTokenUtil util = new JwtTokenUtil();
		String token = util.generateToken("100","narendar@cisco.com","1");
		System.out.println("Token: " + token);
		boolean isValid = util.validateJWTToken(token);
		System.out.println("isValid: " + isValid);
		if (isValid) {
			System.out.println("Subject: " + util.getSubject(token));
			System.out.println("ID: " + util.getId(token));
			System.out.println("Audience: " + util.getAudience(token));
		}
	}

	public String generateToken(String id, String user,String roleId) {
		String token = null;
		try {
			token = Jwts.builder().setId(id)// Consumer ID
					.setSubject(user) // Consumer Name
					.setAudience(roleId) // Role ID
					.setIssuer("java").setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)))
					.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secret.getBytes())).compact();
		} catch (Exception e) {
			System.out.println("Exception in generateToken(): " + e);
			e.printStackTrace();
		}
		return token;
	}

	public Claims getClaim(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(Base64.getEncoder().encode(secret.getBytes())).parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			System.out.println("Exception in getClaim(): " + e);
			e.printStackTrace();
		}
		return claims;

	}

	public String getSubject(String token) {
		String subject = null;
		Claims claim = getClaim(token);
		if (claim != null) {
			subject = claim.getSubject();

		}
		return subject;
	}

	public String getId(String token) {
		String id = null;
		Claims claim = getClaim(token);
		if (claim != null) {
			id = claim.getId();
		}
		return id;
	}

	public String getAudience(String token) {
		String aud = null;
		Claims claim = getClaim(token);
		if (claim != null) {
			aud = claim.getAudience();
		}
		return aud;
	}

	public boolean validateJWTToken(String token) {
		boolean isValid = false;
		Claims claim = getClaim(token);
		if (claim != null) {
			System.out.println("Token Expiry date: "+claim.getExpiration());
			isValid = claim.getExpiration().after(new Date(System.currentTimeMillis()));
			System.out.println("validateJWTToken: "+isValid);
		}
		return isValid;
	}
}
