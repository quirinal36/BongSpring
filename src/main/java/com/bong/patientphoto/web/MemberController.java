package com.bong.patientphoto.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.service.UserService;
import com.bong.patientphoto.vo.UserVO;

import javax.annotation.Resource;

@Controller
public class MemberController  {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="userService")
	protected UserService userService;
	
	/**
	 * 회원가입 - 정보입력
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/join_step2", method=RequestMethod.GET)
	public ModelAndView getJoinStep2View(ModelAndView mv, UserVO user) {
		user.setUsername("이형구");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public ModelAndView memberInsert(ModelAndView mv, UserVO user, HttpServletResponse resp) throws IOException {
		int result = userService.insert(user);
		
		mv.addObject("user", user);
		if(result > 0) {
			mv.setViewName("redirect:/member/join_complete");	
		}else {
			mv.setViewName("redirect:/member/join_step2");
		}
		
		return mv;
	}
	/**
	 * 회원가입 - 정보입력
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/join_complete", method=RequestMethod.GET)
	public ModelAndView getJoinCompleteView(ModelAndView mv) {
		return mv;
	}
	
	/**
	 * 로그인
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView getLoginView(ModelAndView mv,
			@RequestParam(value = "loginid", required = false) String loginId,
			@RequestParam(value = "loginRedirect", required = false) String redirectUrl) {
		if (loginId != null) {
			mv.addObject("loginid", loginId);
		}
		if (redirectUrl != null) {
			mv.addObject("loginRedirect", redirectUrl);
		}
		mv.setViewName("/member/login");
		return mv;
	}
	
	/**
	 * 내정보보기
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/view", method=RequestMethod.GET)
	public ModelAndView getView(ModelAndView mv) {
		return mv;
	}
	
	@RequestMapping(value="/detail/detail", method=RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv) {
		mv.setViewName("/detail");
		return mv;
	}
}
