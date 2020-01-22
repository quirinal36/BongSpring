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
public class BoardBaseController extends BacoderController {
	
	private static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vaHNib25nLnN5bm9sb2d5Lm1lIiwic3ViIjoiUGhvdG9Ub2tlbiIsImV4cCI6MTU3OTQyMjcxMiwianRpIjoiRDAwMDciLCJzY29wZSI6InBob3RvIiwicm9sZSI6MH0.EhHPN-tTc9iPjw8M7qb6r7X1H9iXRRF7_E_fAYeEKmg";
	/**
	 * 게시판 리스트뷰
	 * @param mv
	 * @param writer
	 * @return
	 */
	
	@RequestMapping(value= {"/board2/list","/board2","/list"}, method=RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, 
			@RequestParam(value="groupId", required=false)Optional<Integer> groupId,
			@RequestParam(value="search", required=false)String search,
			@RequestParam(value="page", required=false)Optional<Integer> pageNum,
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById,
			HttpServletRequest request) {
		
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			
		}
		List<BoardBase> list;
		
		BoardBase board;
		if(pageNum.isPresent()) {
			board = new BoardBase(0, pageNum.get());	
		}else {
			board = new BoardBase(0, 1);
		}
		if(groupId.isPresent()) {
			board.setGroupId(groupId.get());
		}
		
	//	board.setSearch(search);
	//	logger.info("param :" + pageNum.get());
		
		UserVO user = getUser();
		mv.addObject("user", user);
		if(user != null) {
			board.setUserLevel(user.getUserLevel());
			logger.info(user.getUserLevel()+"//user not null#################");

		}else {
			logger.info("user null#######################");
			board.setUserLevel(0);
		}
		
		mv.addObject("pageNum", board.getPageNo());
		//logger.info("param :" + board.getPageNo());
		//logger.info("board :" + board.toString());
		board.setTotalCount(boardBaseService.count(board));
		
		
		list = boardBaseService.select(board);
		//logger.info("list : "+ list.toString());

	//	mv.addObject("board", board);
		mv.addObject("list", list);
		mv.setViewName("/index");
		return mv;
	}
	
	@RequestMapping(value= "/board2/detail", method=RequestMethod.GET)
	public ModelAndView getBoardDetail(ModelAndView mv, BoardBase boardInput, BoardBase board, BoardReply reply, @RequestParam(value="boardId", required=true)int boardId ) {
		
		logger.info("boardId : "+ boardId);
		boardInput.setId(boardId);
		reply.setBoardId(boardId);
		
		List<BoardReply> replyList;
		
		board = boardBaseService.selectOne(boardInput);
		replyList = boardReplyService.select(reply);
		
		logger.info("detail : "+ board.toString());
		logger.info("replyList : "+ replyList.toString());

		UserVO user = getUser();
		mv.addObject("user", user);

		mv.addObject("board", board);
		mv.addObject("reply", replyList);
		mv.setViewName("/contents/detail");
		return mv;
	}
	
	@RequestMapping(value="/board2/detail_test")
	public ModelAndView getDetailView(ModelAndView mv) {
		mv.setViewName("/contents/detail");
		return mv;
	}
	
	/**
	 * 게시판 글 입력 뷰
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/board2/write", method=RequestMethod.GET)
	public ModelAndView getWriteView(ModelAndView mv, HttpServletRequest request) {
		//UserVO user = getUser();
		//mv.addObject("user", user);
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			
			LocalDate today = LocalDate.now();
			mv.addObject("today", today);
			
			UserVO user = getUser();
			mv.addObject("user", user);
			
			mv.setViewName("/board2/write");
		} else {
			mv.setViewName("member/login");
		}
		
		return mv;
	}
	
	/**
	 * 게시판 글 입력 프로시져
	 * 
	 * @param board : form 에 있는 정보를 맵핑해 전달한다
	 */
	@ResponseBody
	@RequestMapping(value="/board2/insert", method= RequestMethod.POST, produces = "application/json; charset=utf8")
	public String writeBoard2 (BoardBase board) {
		int result = boardBaseService.insert(board);
		return board.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/board2/delete", method=RequestMethod.POST)
	public String deleteBoardPost(BoardBase board) {
		boardBaseService.delete(board);
		return board.toString();
	}
}
