package com.bong.patientphoto.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.vo.PhotoInfo;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class PhotoInfoController extends BacoderController{
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/photoInfo/insert", method=RequestMethod.POST)
	public ModelAndView memberInsert(ModelAndView mv, 
			PhotoInfo info, HttpServletResponse resp,
			@RequestParam(value="fileUri")String[] files) throws IOException {
		logger.info(info.toString());
		for(String file: files) {
			logger.info(file);
		}
		int result = photoInfoService.insert(info);
		
		mv.addObject("info", info);
		if(result > 0) {
			mv.setViewName("redirect:/photoInfo/list");	
		}else {
			mv.setViewName("redirect:/board/list");
		}
		
		return mv;
	}
	
	/**
	 * 게시판 글 입력 뷰
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/photoInfo/write", method=RequestMethod.GET)
	public ModelAndView getWriteView(ModelAndView mv) {
		UserVO user = getUser();
		mv.addObject("user", user);
		
		LocalDate today = LocalDate.now();
		mv.addObject("today", today);
		
		mv.setViewName("/photoInfo/write");
		return mv;
	}
}
