package kosta.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "freeboard")
@Builder
public class FreeBoard {
	
	@Id //pk
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="free_bno_seq")
	@SequenceGenerator(sequenceName = "free_bno_seq", allocationSize = 1, name="free_bno_seq")
	private Long bno; //글번호
	
	private String subject; //제목
	private String writer; //작성자
	private String content; //내용
	private String password; //비번
	
	@CreationTimestamp
	private LocalDateTime writeDay;
	
	@UpdateTimestamp
	private LocalDateTime updateDay;
	
	private int readnum; //조회수
	
	/**
	 * cascade = CascadeType.ALL 옵션은 만약 부모 Entitiy의 상태변화가 생기면 연관관계가 있는 
	 * Entity도 상태변화를 전이시키는 옵션이다. - 영속성전이
	 * 
	 * ex) 부모의 글이 삭제되면 참조되고 있는 자식레코드도 함께 삭제된다!
	 * */
	//지연로딩이기때문에 jsp에서 get메소드호출 시 select 추가 발동한다. ex) ${board.replyList.size()}
//	@OneToMany(mappedBy = "freeBoard", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@OneToMany(mappedBy = "freeBoard", cascade = CascadeType.ALL) 
//	@OneToMany(mappedBy = "freeBoard", fetch = FetchType.EAGER)
	private List<Reply> replyList;
}
