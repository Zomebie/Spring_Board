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
	

	// 로그인 성공 후 메인 페이지에서 게시판클릭 하면 게시판 목록 페이지
	@RequestMapping("board_list")
	public String board_list(Model model, HttpServletRequest request) {

		model.addAttribute("request", request);

		List<BoardDTO> boardList = boardService.getBoardList(model); // 리스트 받아오기
		model.addAttribute("boardlist", boardList);
		
		return "board/qna_board_list";

	}

	// [페이지 전환] 게시판 목록 페이지에서 "글쓰기"버튼 누르면 글쓰는 페이지 전환
	@RequestMapping("board_write")
	public String board_write() {

		return "board/qna_board_write";

	}

	// 글쓰기 페이지에서 쓴 글을 "등록"
	@RequestMapping("board_add")
	public String board_add(BoardDTO board) {

		// 글 등록 여부에 따른 페이지 전환
		if (dao.boardInsert(board)) {

			return "redirect:board_list"; // 다시 컨트롤러루~

		} else
			return "board/qna_board_write";

	}

	// 글 목록 페이지에서 글 상세보기
	@RequestMapping("board_detail")
	public String board_detail(Model model, HttpServletRequest request) {

		model.addAttribute("request", request);
		boardService.setReadCountUpdate(model); // 조회수 없데이트
		BoardDTO dto = boardService.getDetail(model);

		if (dto != null) {
			model.addAttribute("boardDTO", dto);
			return "board/qna_board_view";
		}
		return "redirect:board_list";
	}

	// 글 상세보기 페이지에서 '답변'버튼 누르면 답변페이지전환
	@RequestMapping("board_reply")
	public String board_reply(Model model,HttpServletRequest request) {

		model.addAttribute("request",request);
		BoardDTO dto = boardService.getDetail(model);

		if (dto == null) {
			System.out.println("답장 페이지 이동 실패");
			return null;
		} else {
			model.addAttribute("boardDTO", dto);
			return "board/qna_board_reply";
		}

	}

	// 답변페이지에서 '등록'버튼 누르기
	@RequestMapping("board_reply2")
	public String board_reply2(HttpServletRequest request, BoardDTO board) {
		int result = 0;
		result = dao.boardReply(board);

		if (result == 0) {
			System.out.println("답장 실패");
			return null;
		}
		return "redirect:board_detail?num=" + result;
	}

	// 글 상세보기 페이지에서 수정하기
	@RequestMapping("board_modify")
	public String board_modify(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
		BoardDTO dto = boardService.getDetail(model);

		if (dto == null) {
			System.out.println("(수정)상세보기 실패");
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
			System.out.println("수정할 권한이 없다!");
			return null;
		}

		dto.setBOARD_NUM(Integer.parseInt(request.getParameter("num")));
		dto.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		dto.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

		result = dao.boardModify(dto);

		if (result == false) {
			System.out.println("게시판 수정 실패");
			return null;
		} else {

			return "redirect:board_detail?num=" + dto.getBOARD_NUM();

		}

	}

	// [페이지 전환] 글 상세보기 페이지에서 '삭제'버튼 누르기
	@RequestMapping("board_delete")
	public String board_delete() {

		return "board/qna_board_delete";
	}

	// 삭제 페이지에서 삭제로직
	@RequestMapping("board_delete2")
	public String board_delete2(HttpServletRequest request,Model model) {

		boolean result = false;
		boolean usercheck = false;
		
		model.addAttribute("request",request);
		usercheck = boardService.isBoardWriter(model);
		if (usercheck == false) {
			System.out.println("삭제할 권한이 없다구!");
			return null;
		}

		result = dao.boardDelete(Integer.parseInt(request.getParameter("num")));
		if (result == false) {
			System.out.println("게시판 삭제 실패");
			return null;
		}

		return "redirect:board_list";

	}
}
