package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.FreeBoard;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>{
	/***
	 * 조회수 증가(JPQL 문법)
	 */
	
	@Query("update FreeBoard b set b.readnum=b.readnum+1 where b.bno=?1")
	@Modifying //DDL 또는 DML 문장
	int readnumUpdate(Long bno);
}
