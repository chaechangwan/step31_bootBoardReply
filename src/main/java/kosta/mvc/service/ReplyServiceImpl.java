package kosta.mvc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.domain.Reply;
import kosta.mvc.repository.FreeBoardRepository;
import kosta.mvc.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

	private final FreeBoardRepository freeRepository;
	private final ReplyRepository replyRepository;
	
	@Override
	public void insert(Reply reply) {
		replyRepository.save(reply);
	}

	@Override
	public void delete(Long rno) {
		
		Reply reply = replyRepository.findById(rno).orElse(null);
		if(reply == null) {
			throw new RuntimeException("번호에 해당하는 댓글이 존재하지 않습니다.");
		}
		
		replyRepository.deleteById(rno);
	}

}
