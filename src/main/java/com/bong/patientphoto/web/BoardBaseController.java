package com.bong.patientphoto.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bong.patientphoto.vo.Board;
import com.bong.patientphoto.vo.BoardBase;
import com.bong.patientphoto.vo.UserVO;

@Controller
public class BoardBaseController extends BacoderController {
	/**
	 * 게시판 리스트뷰
	 * @param mv
	 * @param writer
	 * @return
	 */
	@RequestMapping(value= {"/board2/list","/board2"}, method=RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, 
			@RequestParam(value="search", required=false)String search,
			@RequestParam(value="page", required=false)Optional<Integer> pageNum,
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById ) {
		List<BoardBase> list;
		
		BoardBase board;
		if(pageNum.isPresent()) {
			board = new BoardBase(0, pageNum.get());	
		}else {
			board = new BoardBase(0, 1);
		}
	//	if(orderById.isPresent()) {
	//		board.setOrderById(orderById.get());
	//	}
		
	//	board.setSearch(search);
		mv.addObject("pageNum", board.getPageNo());
		
		board.setTotalCount(boardService.count(board));
		
		list = boardbaseService.select(board);
		mv.addObject("board", board);
		mv.addObject("list", list);
		mv.setViewName("/board2/list");
		return mv;
	}
	
}
