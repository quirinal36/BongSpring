package com.bong.patientphoto.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.service.OPRecordService;
import com.bong.patientphoto.vo.Board;
import com.bong.patientphoto.vo.OPRecord;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class OPRecordController extends BacoderController {

	private byte[] getSignatureKey() {
		String signature = "abcd1234";
		return signature.getBytes();
	}
	
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
	public void sendToken() {
		logger.info("send token");
		getInfo("abcd1234");
	}
	@RequestMapping(value="/isToken", method=RequestMethod.GET)
	public void isTokenValid(HttpServletResponse resp,
			@RequestHeader(value="Authorization")Optional<String>token) {
		logger.info("is token");
		try {
			resp.setCharacterEncoding("UTF-8");
			if(token.isPresent()) {
				logger.info("token:" + token.get());
				resp.getWriter().append(token.get());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/getToken", method=RequestMethod.GET)
	public void getToken(HttpServletResponse resp,
				@RequestParam(value="id")Optional<String> id,
				@RequestParam(value="pwd")Optional<String> pwd){
		byte[] key = getSignatureKey();
		
		Date expirationDate = new Date();
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime = dateTime.plusDays(1);
		expirationDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		logger.info(expirationDate.toString());
		String jwt = 
		    Jwts.builder().setIssuer("http://trustyapp.com/")
		        .setSubject(id.get())
		        .setExpiration(expirationDate)
		        //.put("scope", "self api/buy") 
		        .signWith(SignatureAlgorithm.HS256,key)
		        .compact();
		logger.info(jwt);
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().append(jwt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/oprecord/list", method=RequestMethod.GET)
	public ModelAndView getOprecordListView(HttpServletRequest req, 
			HttpServletResponse resp,
			ModelAndView mv, 
			OPRecord record, 
			@RequestParam(value="pageNum")Optional<Integer>pageNum) {
		if(req.isUserInRole("ROLE_USER") || req.isUserInRole("ROLE_ADMIN"))
		{
			int totalCount = oprecordService.count(record);
			if(pageNum.isPresent())
			{
				record.setPageNo(pageNum.get());
			}
			else
			{
				record.setPageNo(1);
			}
			record.setTotalCount(totalCount);
			logger.info(record.toString());
			List<OPRecord> list = oprecordService.select(record);
			
			mv.addObject("record", record);
			mv.addObject("list", list);
			
			
			mv.setViewName("/oprecord/list");
		}
		else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value="/oprecord/detail/{id}", method=RequestMethod.GET)
	public ModelAndView getOprecordDetailView(ModelAndView mv, 
			@PathVariable("id")int id) {
		
		OPRecord param = new OPRecord();
		param.setId(id);
		OPRecord record = oprecordService.selectOne(param);

		mv.addObject("item", record);
		mv.setViewName("/oprecord/detail");
		return mv;
	}

	@RequestMapping(value="/oprecord/write", method=RequestMethod.GET)
	public ModelAndView getOprecordWriteView(ModelAndView mv) {
		
		mv.setViewName("/oprecord/write");
		return mv;
	}
	
	@RequestMapping(value="/oprecord/write/save", method=RequestMethod.GET)
	public ModelAndView getOprecordSaveView(ModelAndView mv, OPRecord record) {
		
		logger.info(record.toString());
		int result = oprecordService.insert(record);

		mv.setViewName("redirect:/oprecord/list");
		return mv;
	}

	@RequestMapping(value="/oprecord/update/{id}", method=RequestMethod.GET)
	public ModelAndView getOprecordUpdateView(ModelAndView mv, 
			@PathVariable("id")int id) {
		
		OPRecord param = new OPRecord();
		param.setId(id);
		OPRecord record = oprecordService.selectOne(param);

		mv.addObject("item", record);
		mv.setViewName("/oprecord/update");
		return mv;
	}
	
	@RequestMapping(value="/oprecord/update/save", method=RequestMethod.GET)
	public ModelAndView getOprecordUpdateSaveView(ModelAndView mv, OPRecord record) {
		
		logger.info(record.toString());
		int result = oprecordService.update(record);

		mv.setViewName("redirect:/oprecord/detail/"+ record.getId());
		return mv;
	}
}
