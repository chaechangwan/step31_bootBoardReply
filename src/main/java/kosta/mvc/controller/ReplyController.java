package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.domain.Reply;
import kosta.mvc.service.ReplyService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
	
	private final ReplyService replyService;

	
	@RequestMapping("/write")
	public void write(long bno, Model model) {
		model.addAttribute("bno", bno);
	}
	
	@RequestMapping("/insert")
	public String insert(long bno, Reply reply) {
		
		//부모글번호를 Reply에 세팅
		reply.setFreeBoard(FreeBoard.builder().bno(bno).build());
		replyService.insert(reply);
		
		//등록 후 부모글 상세페이지로 이동
		/*
		FreeBoard board = freeBoardService.selectBy(bno, false);		
		return new ModelAndView("board/read", "board", board);
		*/
		
		return "redirect:/board/read/" + bno + "?flag=1";
	}
	
	@RequestMapping("/delete/{rno}/{bno}")
	public String delete(@PathVariable long rno, @PathVariable long bno) {

		replyService.delete(rno);
		
		return "redirect:/board/read/" + bno + "?flag=1";
	}
}
