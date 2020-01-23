package com.bong.patientphoto.web;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.vo.Group;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class GroupController extends BacoderController {

	@RequestMapping(value= {"/","/group"}, method=RequestMethod.GET)
	public ModelAndView getGroupMainList(ModelAndView mv, 
			@RequestParam(value="search", required=false)String search,
			@RequestParam(value="groupId", required=false)Optional<Integer> groupId,
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById,
			HttpServletRequest request) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
		}

		UserVO user = getUser();
		

		if(user != null)
		{
			mv.setViewName("redirect:/list");
			
		} else  {
			//logger.info("getInitGroupId :"+ user.getInitGroupId());
			mv.addObject("user", user);
			
			List<Group> list;
			Group group = null;
			
			list = groupService.select(group);
			//logger.info("list : "+ list.toString());

			mv.addObject("list", list);
			mv.setViewName("/group/select");
		}

		return mv;
	}
	
	@RequestMapping(value= "/myGroup", method=RequestMethod.GET)
	public ModelAndView getMyGroupList(ModelAndView mv, 
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById,
			HttpServletRequest request) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
		}

		UserVO user = getUser();
		

		if(user != null)
		{
			mv.addObject("user", user);
			
			List<Group> list;
			Group group = null;
			
			list = groupService.select(group);
			//logger.info("list : "+ list.toString());

			mv.addObject("list", list);
			mv.setViewName("/group/select");
			
		} else  {
			mv.setViewName("/member/login");

		}

		return mv;
	}
}
