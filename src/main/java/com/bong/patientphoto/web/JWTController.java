package com.bong.patientphoto.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bong.patientphoto.util.Token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class JWTController extends BacoderController {

	
	private String getInfo(String token) {
		StringBuilder url = new StringBuilder();
		url.append("http://localhost:8080/isToken");
		Header authHeader = new BasicHeader(HttpHeaders.AUTHORIZATION, token);
		List<Header> headers = new ArrayList<Header>();
		headers.add(authHeader);
		
		HttpClient httpClient = HttpClientBuilder.create()					
				.setMaxConnTotal(100) // connection pool 적용
				.setMaxConnPerRoute(5) // connection pool 적용
				.setDefaultHeaders(headers)
				.build();
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(); 
		factory.setReadTimeout(5000); // 읽기시간초과, ms 
		factory.setConnectTimeout(3000); // 연결시간초과, ms 
		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
		
		RestTemplate restTemplate = new RestTemplate(factory); 
		logger.info(url.toString());
		
		String result = restTemplate.getForObject(url.toString(), String.class);
		return result;
	}
	@RequestMapping(value="/sendToken", method=RequestMethod.GET)
	public void sendToken(HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		logger.info("send token");
		resp.getWriter().append("send token");
		getInfo("1yJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vaHNib25nLnN5bm9sb2d5Lm1lIiwic3ViIjoidXNlcnMvYm9uZyIsImV4cCI6MTMwMDgxOSwibmFtZSI6Ikh3YW5nc2UgQm9uZyIsInNjb3BlIjoic2VsZiBncm91cHMvYWRtaW5zIn0.w5eYnbsAvMvgRN7zoWFIGEiE159lutX2oGtMAH73Isc");
	}
	
	
	@RequestMapping(value="/isToken", method=RequestMethod.GET)
	public void isTokenValid(HttpServletResponse resp,
			@RequestHeader(value="Authorization")Optional<String>token) throws IOException {
		logger.info("is token");
		resp.setCharacterEncoding("UTF-8");
		if(token.isPresent()) {
			logger.info("token:" + token.get());
			resp.getWriter().append(token.get());
			
			Token auth = new Token();
			if(auth.IsValidToken(token.get())) {
				logger.info("token OK");
			} else {
				logger.info("Invalid token");
			}
			
		}
		else {
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().append("token not found!");
		}
		
	}
	@RequestMapping(value="/auth/getToken", method=RequestMethod.GET)
	public void getToken(HttpServletResponse resp,
				@RequestParam(value="id")Optional<String> id,
				@RequestParam(value="pwd")Optional<String> pwd) throws UnsupportedEncodingException{
		
		Token auth = new Token();
		
		Date expirationDate = new Date();
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime = dateTime.plusDays(1);
		expirationDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		logger.info(expirationDate.toString());
		String jwt = 
		    Jwts.builder()
		    .setIssuer("http://hsbong.synology.me")
			  .setSubject("users/bong")
			  .setExpiration(new Date(1300819380))
			  .claim("name", "Hwangse Bong")
			  .claim("scope", "self groups/admins")
			  .signWith(
			    SignatureAlgorithm.HS256,
			    auth.getSignatureKey()
			  )
			  .compact();
		logger.info(jwt);
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().append(jwt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
