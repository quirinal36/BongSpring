package com.bong.patientphoto.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class Token {
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private static String signature = "privateKey";
			
	public byte[] getSignatureKey() {
	
		return this.signature.getBytes();
	}
	
	public boolean IsValidToken(String token) {
		
		Jws<Claims> jws;
		try {
		    jws = Jwts.parser()         // (1)
		    .setSigningKey(getSignatureKey())         // (2)
		    .parseClaimsJws(token); // (3)
		    String sub = jws.getBody().getSubject();
		    logger.info("authorized Token : " + sub);
		   
		    // we can safely trust the JWT
		     return true;
		}
		catch (JwtException ex) {       // (4)
		    logger.info("Un-authorized : "+ ex.toString());
		    // we *cannot* use the JWT as intended by its creator
		    return false;
		}

	}
}
