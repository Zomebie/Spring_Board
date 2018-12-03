package hello.spring.bit.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import hello.spring.bit.dao.BoardDAO;
import hello.spring.bit.dto.BoardDTO;
import hello.spring.bit.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardDAO dao;
	

	// �α��� ���� �� ���� ���������� �Խ���Ŭ�� �ϸ� �Խ��� ��� ������
	@RequestMapping("board_list")
	public String board_list(Model model, HttpServletRequest request) {

		model.addAttribute("request", request);

		List<BoardDTO> boardList = boardService.getBoardList(model); // ����Ʈ �޾ƿ���
		model.addAttribute("boardlist", boardList);
		
		return "board/qna_board_list";

	}

	// [������ ��ȯ] �Խ��� ��� ���������� "�۾���"��ư ������ �۾��� ������ ��ȯ
	@RequestMapping("board_write")
	public String board_write() {

		return "board/qna_board_write";

	}

	// �۾��� ���������� �� ���� "���"
	@RequestMapping("board_add")
	public String board_add(BoardDTO board) {

		// �� ��� ���ο� ���� ������ ��ȯ
		if (dao.boardInsert(board)) {

			return "redirect:board_list"; // �ٽ� ��Ʈ�ѷ���~

		} else
			return "board/qna_board_write";

	}

	// �� ��� ���������� �� �󼼺���
	@RequestMapping("board_detail")
	public String board_detail(Model model, HttpServletRequest request) {

		model.addAttribute("request", request);
		boardService.setReadCountUpdate(model); // ��ȸ�� ������Ʈ
		BoardDTO dto = boardService.getDetail(model);

		if (dto != null) {
			model.addAttribute("boardDTO", dto);
			return "board/qna_board_view";
		}
		return "redirect:board_list";
	}

	// �� �󼼺��� ���������� '�亯'��ư ������ �亯��������ȯ
	@RequestMapping("board_reply")
	public String board_reply(Model model,HttpServletRequest request) {

		model.addAttribute("request",request);
		BoardDTO dto = boardService.getDetail(model);

		if (dto == null) {
			System.out.println("���� ������ �̵� ����");
			return null;
		} else {
			model.addAttribute("boardDTO", dto);
			return "board/qna_board_reply";
		}

	}

	// �亯���������� '���'��ư ������
	@RequestMapping("board_reply2")
	public String board_reply2(HttpServletRequest request, BoardDTO board) {
		int result = 0;
		result = dao.boardReply(board);

		if (result == 0) {
			System.out.println("���� ����");
			return null;
		}
		return "redirect:board_detail?num=" + result;
	}

	// �� �󼼺��� ���������� �����ϱ�
	@RequestMapping("board_modify")
	public String board_modify(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
		BoardDTO dto = boardService.getDetail(model);

		if (dto == null) {
			System.out.println("(����)�󼼺��� ����");
			return null;
		} else {
			model.addAttribute("boardDTO", dto);
			return "board/qna_board_modify";
		}

	}

	@RequestMapping("board_modify2")
	public String board_modify2(Model model,HttpServletRequest request, BoardDTO dto) {

		boolean result = false;
		
		model.addAttribute("request",request);
		if (boardService.isBoardWriter(model)==false) {
			System.out.println("������ ������ ����!");
			return null;
		}

		dto.setBOARD_NUM(Integer.parseInt(request.getParameter("num")));
		dto.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		dto.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

		result = dao.boardModify(dto);

		if (result == false) {
			System.out.println("�Խ��� ���� ����");
			return null;
		} else {

			return "redirect:board_detail?num=" + dto.getBOARD_NUM();

		}

	}

	// [������ ��ȯ] �� �󼼺��� ���������� '����'��ư ������
	@RequestMapping("board_delete")
	public String board_delete() {

		return "board/qna_board_delete";
	}

	// ���� ���������� ��������
	@RequestMapping("board_delete2")
	public String board_delete2(HttpServletRequest request,Model model) {

		boolean result = false;
		boolean usercheck = false;
		
		model.addAttribute("request",request);
		usercheck = boardService.isBoardWriter(model);
		if (usercheck == false) {
			System.out.println("������ ������ ���ٱ�!");
			return null;
		}

		result = dao.boardDelete(Integer.parseInt(request.getParameter("num")));
		if (result == false) {
			System.out.println("�Խ��� ���� ����");
			return null;
		}

		return "redirect:board_list";

	}
}
