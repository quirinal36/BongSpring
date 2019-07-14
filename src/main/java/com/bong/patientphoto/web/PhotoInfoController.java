package com.bong.patientphoto.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.vo.PhotoInfo;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class PhotoInfoController extends BacoderController{
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping(value="/photoInfo/save")
	public String savePhotoInfo(PhotoInfo photoInfo) {
		JSONObject json = new JSONObject();
		json.put("result", 1);
		JSONArray jsonarray = new JSONArray(photoInfo.getPhoto());
		logger.info("length: "+jsonarray.length());
		for(int i=0; i<jsonarray.length(); i++) {
			logger.info(jsonarray.get(i).toString());
			// 데이터베이스 PhotoInto 테이블 수정
		}
		
		logger.info(photoInfo.toString());
		return json.toString();
	}
	@RequestMapping(value="/photoInfo/list")
	public ModelAndView getListView(ModelAndView mv, PhotoInfo photoInfo) {
		int totalCount = photoInfoService.selectTotal(photoInfo);
		photoInfo.setTotalCount(totalCount);
		
		List<PhotoInfo> list = photoInfoService.select(photoInfo);
		logger.info(list.toString());
		mv.addObject("list", list);
		
		mv.addObject("info", photoInfo);
		mv.setViewName("/photoInfo/list");
		return mv;
	}
	/**
	 * 
	 * @param mv
	 * @param info
	 * @param resp
	 * @param files
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/photoInfo/insert", method=RequestMethod.POST)
	public ModelAndView memberInsert(ModelAndView mv, 
			PhotoInfo info, HttpServletResponse resp,
			@RequestParam(value="fileUri")String[] files) throws IOException {
		logger.info(info.toString());
		List<PhotoInfo> infoList = new ArrayList<PhotoInfo>();
		
		for(String file: files) {
			logger.info(file);
			PhotoInfo newInfo = new PhotoInfo();
			
			try {
				newInfo = (PhotoInfo) info.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			newInfo.setPhotoUrl(file);
			// file name , copy 
			infoList.add(newInfo);
		}
		int result = photoInfoService.insert(infoList);
		
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
	
	@RequestMapping(value="/photoInfo/detail", method=RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv, PhotoInfo photo) {
		photo = photoInfoService.selectOne(photo);
		mv.addObject("info", photo);
		return mv;
	}
}
