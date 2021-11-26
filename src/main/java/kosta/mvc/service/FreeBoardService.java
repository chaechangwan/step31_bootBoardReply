package kosta.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.mvc.domain.FreeBoard;

public interface FreeBoardService {
   /**
    * 전체검색
    * */
	List<FreeBoard> selectAll();
	
	/**
	 * 전체검색 - Page처리
	 * */
	Page<FreeBoard> selectAll(Pageable pageable);
	
	/**
	 * 등록
	 * */
	void insert(FreeBoard board);
	
	/**
	 * 글번호 검색 
	 *   : 조회수 증가....
	 *      - state가 true이면 조회수 증가한다.
	 * */
	FreeBoard selectBy(Long bno , boolean state);
	
	/**
	 * 수정하기
	 * */
	
    FreeBoard update(FreeBoard board);
    
    /**
     * 삭제하기
     * */
    void delete(Long bno,String password);
}










