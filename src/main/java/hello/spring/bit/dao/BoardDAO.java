package hello.spring.bit.dao;

import java.util.List;
import org.springframework.ui.Model;
import hello.spring.bit.dto.BoardDTO;

public interface BoardDAO {
	boolean boardInsert(BoardDTO board); // 글 등록하기
	int getListCount(); //게시판 글의 개수 구하기 
	List <BoardDTO> getBoardList(int page,int limit); //글 목록 보기
	BoardDTO getDetail(int num); //글 내용 보기
	int boardReply(BoardDTO board); 	// 글 답변
	boolean boardModify(BoardDTO modifyboard); // 글 수정
	boolean boardDelete(int num); // 글 삭제
	void setReadCountUpdate(int num); // 조회수 업뎃
	boolean isBoardWriter(int num,String pass); // 글 쓴이인지 확인
}
