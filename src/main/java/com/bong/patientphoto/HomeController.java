package com.bong.patientphoto;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.security.config.UserDetailService;
import com.bong.patientphoto.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserDetailService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv,
			HttpServletRequest req, Authentication authentication) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//mv.addAttribute("serverTime", formattedDate );
		mv.addObject("serverTime", formattedDate);
		if(req.isUserInRole("ROLE_USER") || req.isUserInRole("ROLE_ADMIN")) {
			String username = authentication.getName();
			UserDetails user = userService.loadUserByUsername(username);
			mv.addObject("user", user);
		}
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value="/inc/header")
	public ModelAndView getHeaderView(ModelAndView mv) {
		mv.setViewName("/inc/header");
		return mv;
	}
	@RequestMapping(value="/privacypolicy")
	public ModelAndView getPrivacyView(ModelAndView mv) {
		mv.setViewName("privacy");
		return mv;
	}
}
