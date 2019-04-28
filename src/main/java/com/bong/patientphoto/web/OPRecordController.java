package com.bong.patientphoto.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Controller
public class OPRecordController extends BacoderController {

	
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
