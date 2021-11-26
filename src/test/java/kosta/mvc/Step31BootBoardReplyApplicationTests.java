package kosta.mvc;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.domain.Reply;
import kosta.mvc.repository.FreeBoardRepository;
import kosta.mvc.repository.ReplyRepository;

@SpringBootTest
@Transactional
@Commit
class Step31BootBoardReplyApplicationTests {

	@Autowired
	private FreeBoardRepository rep;
	
	@Autowired
	private ReplyRepository replyRep;
	
	@Test
	void insert() {
		for(int i=0; i < 100; i++) {
			FreeBoard board = FreeBoard.builder().subject("제목" + i).writer("user" + i).content("freeBoard" + i).password("1234").build();
			
			rep.save(board);
		}
	}
	
	@Test
	void insertReply() {
		FreeBoard board = rep.findById(99L).orElse(null);
		for(int i=0; i < 5; i++) {
			Reply reply = new Reply(null, "리뷰내용" + i, null, board);
			replyRep.save(reply);
		}
	}

}
