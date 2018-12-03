package hello.spring.bit.service;

import java.util.List;
import org.springframework.ui.Model;
import hello.spring.bit.dto.BoardDTO;

public interface BoardService {
	
	//boolean boardInsert(BoardDTO board); // 글 등록하기
	//int boardReply(BoardDTO board); 	// 글 답변
	//boolean boardModify(BoardDTO modifyboard); // 글 수정
	//boolean boardDelete(int num); // 글 삭제
	
	List<BoardDTO> getBoardList(Model model); //글 목록 보기
	BoardDTO getDetail(Model model); //글 내용 보기
	void setReadCountUpdate(Model model); // 조회수 업뎃
	boolean isBoardWriter(Model model); // 글 쓴이인지 확인

}
