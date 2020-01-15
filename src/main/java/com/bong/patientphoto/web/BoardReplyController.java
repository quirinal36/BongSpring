package com.bong.patientphoto.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bong.patientphoto.vo.Board;
import com.bong.patientphoto.vo.BoardBase;
import com.bong.patientphoto.vo.BoardReply;
import com.bong.patientphoto.vo.PhotoInfo;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class BoardReplyController extends BacoderController {
	
	/**
	 * 게시판 글 입력 프로시져
	 * 
	 * @param board : form 에 있는 정보를 맵핑해 전달한다
	 */
	@ResponseBody
	@RequestMapping(value="/board2/insertReply", method= RequestMethod.POST, produces = "application/json; charset=utf8")
	public String writeBoard2 (BoardReply reply) {
		int result = boardReplyService.insert(reply);
		return reply.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/board2/deleteReply", method= RequestMethod.POST, produces = "application/json; charset=utf8")
	public String deleteReply (BoardReply reply) {
		int result = boardReplyService.delete(reply);
		return reply.toString();
	}
}
