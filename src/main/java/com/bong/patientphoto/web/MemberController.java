package com.bong.patientphoto.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.service.DepartmentService;
import com.bong.patientphoto.service.PersonService;
import com.bong.patientphoto.service.UserService;
import com.bong.patientphoto.vo.Department;
import com.bong.patientphoto.vo.Person;
import com.bong.patientphoto.vo.UserVO;

import javax.annotation.Resource;

@Controller
public class MemberController  {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	PersonService personService;
	
	@Resource(name="userService")
	protected UserService userService;
	
	/**
	 * 회원가입 화면
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/join_step1", method=RequestMethod.GET)
	public ModelAndView getJoinStep1View(ModelAndView mv) {
		
		mv.setViewName("/member/join_step1");
		return mv;
	}
	/**
	 * 회원가입 프로세스
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/member/join_step2", method=RequestMethod.GET)
	public ModelAndView getJoinStep2View(ModelAndView mv, UserVO user, HttpServletRequest req) {
		if(req.isUserInRole("ROLE_USER") || req.isUserInRole("ROLE_ADMIN")) {
			mv.setViewName("redirect:/");
		}else {
			List<Department> departmentList = departmentService.select();
			mv.addObject("departmentList", departmentList);
			mv.addObject("user", user);
			mv.setViewName("/member/join_step2");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String memberInsert(ModelAndView mv, 
			Person person, HttpServletResponse resp) throws IOException {
		logger.info(person.toString());
		int result = personService.insert(person);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
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
	@RequestMapping(value= {"/member/login", "/login"}, method= {RequestMethod.GET, RequestMethod.POST})
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
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView getAdminView(ModelAndView mv, HttpServletRequest req) {
		if(req.isUserInRole("ROLE_ADMIN")) {
			List<UserVO> list = userService.select();
			mv.addObject("list", list);
		}
		mv.setViewName("/member/list");
		return mv;
	}
	@RequestMapping(value="/admin/update")
	public void updateUser(UserVO user
			, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(req.isUserInRole("ROLE_ADMIN")) {
			int result = userService.update(user);
			resp.getWriter().append("{\"result\":" + result +"}");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/member/get/{uniqueId}")
	public Person isExistMember(@PathVariable(value="uniqueId")Optional<String> uniqueId) {
		Person person = new Person();
		if(uniqueId.isPresent()) {
			person.setUniqueId(uniqueId.get());
			person = personService.selectOne(person);
		}
		
		return person;
	}
}
