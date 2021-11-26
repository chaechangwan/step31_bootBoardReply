package kosta.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_rno_seq")
	@SequenceGenerator(sequenceName = "reply_rno_seq", allocationSize = 1, name = "reply_rno_seq")
	private Long rno; //글번호
	private String content; //내용
	
	@CreationTimestamp
	private LocalDateTime regDate;//등록
	
	@ManyToOne
	@JoinColumn(name = "free_bno") //Reply테이블에 free_bno 필드 추가되고 fk설정
	private FreeBoard freeBoard;
}
