package hello.spring.bit.service;

import java.util.List;
import org.springframework.ui.Model;
import hello.spring.bit.dto.BoardDTO;

public interface BoardService {
	
	//boolean boardInsert(BoardDTO board); // �� ����ϱ�
	//int boardReply(BoardDTO board); 	// �� �亯
	//boolean boardModify(BoardDTO modifyboard); // �� ����
	//boolean boardDelete(int num); // �� ����
	
	List<BoardDTO> getBoardList(Model model); //�� ��� ����
	BoardDTO getDetail(Model model); //�� ���� ����
	void setReadCountUpdate(Model model); // ��ȸ�� ����
	boolean isBoardWriter(Model model); // �� �������� Ȯ��

}
