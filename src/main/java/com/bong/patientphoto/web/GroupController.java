package com.bong.patientphoto.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.util.Token;
import com.bong.patientphoto.vo.BoardBase;
import com.bong.patientphoto.vo.Group;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class GroupController extends BacoderController {

	@RequestMapping(value= "api/groupListAll", method=RequestMethod.GET)
	public void getBoardListAPI(   
			@RequestParam(value="token")Optional<String> tokenStr,
			HttpServletRequest request, HttpServletResponse response, Group group) {
		
		int userLevel = 0;
		int userNum = 0;

		
		if(tokenStr.isPresent() && tokenStr.get().length() > 0) {
			logger.info("token: "+tokenStr);
			Token token = new Token();
			if(token.getUserLevelByToken(tokenStr.get()) > 0) {
				userLevel = token.getUserLevelByToken(tokenStr.get());
				userNum = token.getIdByToken(tokenStr.get());
			}
		} else {
			logger.info("token not found!@#!@#!@#!@#!@#!@#");
		}
		logger.info("getUserLevelByToken :"+ userLevel);
	
		logger.info("userNum: "+userNum);
		List<Group> list;
		group.setUserLevel(userLevel);
		group.setUserId(userNum);
				
		list = groupService.select(group);
		logger.info("list : "+ list.toString());

		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public ModelAndView initPage(ModelAndView mv, 
			@RequestParam(value="search", required=false)String search,
			@RequestParam(value="groupId", required=false)Optional<Integer> groupId,
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById,
			HttpServletRequest request, Group group) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
		}

		UserVO user = getUser();
		

		// user의 가입한 그룹이 있으면 메인 리스트로, 없으면 /group/select로 분기 
		if(user != null && user.getGroupCount() > 0)
		{
//			logger.info("getGroupCount :"+ user.getGroupCount());
			mv.setViewName("redirect:/list");
			
		} else  { //가입하지 않았거나, 가입한 그룹이 없을 경우 
			//logger.info("getInitGroupId :"+ user.getInitGroupId());
			mv.addObject("user", user);
			
			List<Group> list;
			if(user != null && user.getUserLevel() > 0) { //group list 공개 유저레벨 확인 
				group.setUserLevel(user.getUserLevel());
			} else {
				group.setUserLevel(0);
			}
//			logger.info("getUserLevel#$#$#$#$#$#$#$ : "+ group.getUserLevel());

			
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
			HttpServletRequest request, Group group) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
		}

		UserVO user = getUser();
		

		if(user != null)
		{
			mv.addObject("user", user);
			
			List<Group> list;
			
			group.setUserId(user.getId());
			group.setUserLevel(user.getUserLevel());
			
			list = groupService.selectMy(group);
			//logger.info("list : "+ list.toString());

			mv.addObject("list", list);
			mv.setViewName("/group/select");
			
		} else  {  //로그인 확인
			mv.setViewName("/member/login");

		}

		return mv;
	}
	
	@RequestMapping(value= "/joinGroup", method=RequestMethod.GET)
	public ModelAndView joinGroup(ModelAndView mv, 
			@RequestParam(value="groupId", required=true)int groupId,
			HttpServletRequest request, Group group) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
		}

		UserVO user = getUser();
		
		if(user != null)
		{
			group.setId(groupId);
			Group group2 = groupService.selectOne(group);
			group2.setUserId(user.getId());
			
			int result = groupService.join(group2);

			mv.setViewName("redirect:/myGroup");
			
		} else  {
			mv.setViewName("/member/login");
		}

		return mv;
	}
	@RequestMapping(value= "/joinDefaultGroup", method=RequestMethod.GET)
	public int joinDefaultGroup( 
			@RequestParam(value="userId", required=true)int userId,
			HttpServletRequest request, Group group) {
		
		group.setId(1);
		group.setUserId(userId);	
		group.setDefaultUserLevel(2);
		int result = groupService.join(group);
		
		return result;
	}
}
