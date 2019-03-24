package com.bong.patientphoto.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
