package com.bong.patientphoto.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.service.OPRecordService;
import com.bong.patientphoto.vo.Board;
import com.bong.patientphoto.vo.OPRecord;

@Controller
public class OPRecordController extends BacoderController {

	@RequestMapping(value="/oprecord/list", method=RequestMethod.GET)
	public ModelAndView getOprecordListView(ModelAndView mv) {
		List<OPRecord> list = oprecordService.select();
		
		mv.addObject("list", list);
		mv.setViewName("/oprecord/list");
		return mv;
	}
}
