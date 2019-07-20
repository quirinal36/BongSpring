package com.bong.patientphoto.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.Config;
import com.bong.patientphoto.vo.PatientInfo;
import com.bong.patientphoto.vo.PatientPhotoInfo;

@Controller
public class PatientInfoController extends BacoderController {
	
	@RequestMapping(value="/search/patientInfo/{patientId}")
	public @ResponseBody List<PatientInfo> getPatientIdList(HttpServletRequest req,
			HttpServletResponse resp,
			@PathVariable(value="patientId")Optional<Integer>patientId) {
		resp.setCharacterEncoding(Config.ENCODING);
		
		List<PatientInfo> result = new ArrayList<PatientInfo>();
		if(patientId.isPresent()) {
			PatientInfo input = PatientInfo.newInstance(patientId.get());
			int total = patientInfoService.count(input);
			input.setTotalCount(total);
			logger.info(input.toString());
			result = patientInfoService.select(input);
		}
		
		return result;
	}
	
	@RequestMapping(value="/patient/detail", method = RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv, PatientInfo patient) {
		List<PatientPhotoInfo> list = patientInfoService.selectDetail(patient);
		mv.addObject("list", list);
		mv.addObject("info", patient);
		mv.setViewName("/patient/detail");
		return mv;
	}
	@RequestMapping(value="/patient/myAdmList", method = RequestMethod.GET)
	public ModelAndView getAdmView(ModelAndView mv, PatientInfo patient) {
		List<PatientPhotoInfo> list = patientInfoService.selectDetail(patient);
		mv.addObject("list", list);
		mv.addObject("info", patient);
		return mv;
	}
}
