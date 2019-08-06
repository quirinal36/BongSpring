package com.bong.patientphoto.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class Token {
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private static String signature = "qhdghkdtpqoralrudqhdcksdnqhdtjdus";
			
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
		    String exp = jws.getBody().getExpiration().toString();
		    String scope = jws.getBody().get("scope").toString();
		    logger.info("authorized Token : " + sub + "/" + exp + "/" + scope);
		   
		    // we can safely trust the JWT
		     return true;
		}
		catch (JwtException ex) {       // (4)
		    logger.info("Un-authorized : "+ ex.toString());
		    // we *cannot* use the JWT as intended by its creator
		    return false;
		}
	}
	public boolean IsValidPhotoToken(String token) {
	
//		try {
//			Claims claims = Jwts.parser()         
//				       .setSigningKey(getSignatureKey())
//				       .parseClaimsJws(token).getBody();
//			
//		   int role = (int) claims.get("role");
//		   String subject = claims.getSubject();
//		   String userId = claims.getId();
//		   Date expirationDate = claims.getExpiration();
//
//		   logger.info("authorized Token : "+ claims.getSubject() + "/" + expirationDate);
//		  
//		   if(!subject.equals("RefreshToken")) { //refresh token은 사진조회 불가
//			    logger.info("refresh token은 사진조회 불가");
//		    	return true;
//		    } else {
//		    	return false;
//		    } 
//		}
//		catch (ExpiredJwtException e) {
//			logger.info("Expired : "+ e.getMessage());
//		    return -1;
//		}
//		catch (JwtException ex) {       // (4)
//		    logger.info("Un-authorized : "+ ex.getMessage());
//		    // we *cannot* use the JWT as intended by its creator
//		    return 0;
//		}
		
		Jws<Claims> jws;
		try {
		    jws = Jwts.parser()         // (1)
		    .setSigningKey(getSignatureKey())         // (2)
		    .parseClaimsJws(token); // (3)
		    String sub = jws.getBody().getSubject();
		    String exp = jws.getBody().getExpiration().toString();
		    String scope = jws.getBody().get("scope").toString();
		    int role = (int) jws.getBody().get("role");
		    logger.info("authorized Token : " + sub + "/" + exp + "/" + scope);
		   
		    // we can safely trust the JWT
		    if(!sub.equals("RefreshToken")) { //refresh token은 사진조회 불가
		    	if(role > 0 || scope.equals("photo")) {
		    		return true;
		    	} else {
		    		logger.info("사진 정보에 접근이 불가능한 토큰입니다.");
			    	return false;
		    	}
		    } else {
		    	logger.info("refresh token은 사진조회 불가");
		    	return false;
		    }
		}	
		catch (ExpiredJwtException e) {
			logger.info("Expired : "+ e.getMessage());
		    return false;
		
		}	
		catch (JwtException ex) {       // (4)
		    logger.info("Un-authorized : "+ ex.toString());
		    // we *cannot* use the JWT as intended by its creator
		    return false;
		}
	}
}
