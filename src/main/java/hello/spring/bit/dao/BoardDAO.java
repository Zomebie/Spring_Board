package hello.spring.bit.dao;

import java.util.List;
import org.springframework.ui.Model;
import hello.spring.bit.dto.BoardDTO;

public interface BoardDAO {
	boolean boardInsert(BoardDTO board); // �� ����ϱ�
	int getListCount(); //�Խ��� ���� ���� ���ϱ� 
	List <BoardDTO> getBoardList(int page,int limit); //�� ��� ����
	BoardDTO getDetail(int num); //�� ���� ����
	int boardReply(BoardDTO board); 	// �� �亯
	boolean boardModify(BoardDTO modifyboard); // �� ����
	boolean boardDelete(int num); // �� ����
	void setReadCountUpdate(int num); // ��ȸ�� ����
	boolean isBoardWriter(int num,String pass); // �� �������� Ȯ��
}
