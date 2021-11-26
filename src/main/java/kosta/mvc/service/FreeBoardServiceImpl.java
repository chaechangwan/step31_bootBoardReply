package kosta.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;

@Service //생성 id=freeBoardServiceImpl
@RequiredArgsConstructor
@Transactional
public class FreeBoardServiceImpl implements FreeBoardService {

	private final FreeBoardRepository freeRepository; //Spring data JPA 구현체 생성해서 주입
	
	@Override
	public List<FreeBoard> selectAll() {
		return null;
	}

	@Override
	public Page<FreeBoard> selectAll(Pageable pageable) {
		return freeRepository.findAll(pageable);
	}

	@Override
	public void insert(FreeBoard board) {
		FreeBoard fb = freeRepository.save(board);
		System.out.println(fb.getBno() + "|" + fb.getSubject());

	}

	@Override
	public FreeBoard selectBy(Long bno, boolean state) {
		if(state) {
			//조회수 증가
			if(freeRepository.readnumUpdate(bno) == 0 ) {
				throw new RuntimeException(bno + "번호 오류로 조회수 증가 실패하여 검색할 수 없습니다.");
			}
		}
		
		//검색
		FreeBoard freeBoard = freeRepository.findById(bno).orElse(null);
		
		return freeBoard;
	}

	@Override
	public FreeBoard update(FreeBoard board) {
		FreeBoard dbBoard = freeRepository.findById(board.getBno()).orElse(null);
		if(dbBoard==null) throw new RuntimeException("글번호 오류로 수정될 수 없습니다.");
		
		//비밀번호 확인
		if(!dbBoard.getPassword().equals(board.getPassword())) {
			throw new RuntimeException("비밀번호 오류로 수정할 수 없습니다.");
		}
		
		//정보수정
		dbBoard.setContent(board.getContent().replace("<", "&lt;"));
		dbBoard.setSubject(board.getSubject());
		
		return dbBoard;
	}

	@Override
	public void delete(Long bno, String password) {
		FreeBoard dbBoard = freeRepository.findById(bno).orElse(null);
		if(dbBoard == null) throw new RuntimeException("글 번호 오류로 삭제할 수 없습니다.");
		
		//비밀번호 확인
		if(!dbBoard.getPassword().equals(password)) {
			throw new RuntimeException("비밀번호 오류로 수정할 수 없습니다.");
		}
		
		//글 삭제
		freeRepository.deleteById(bno);

	}

}
