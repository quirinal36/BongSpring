package com.bong.patientphoto.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bong.patientphoto.Config;
import com.bong.patientphoto.vo.PatientInfo;

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
}
