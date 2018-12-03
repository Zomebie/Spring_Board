package hello.spring.bit.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hello.spring.bit.dao.BoardDAO;
import hello.spring.bit.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	@Override
	public List<BoardDTO> getBoardList(Model model) {

		int page = 1;
		int limit = 10;

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int listcount = dao.getListCount(); // 총 리스트 수를 받아옴.

		// 총 페이지 수.
		int maxpage = (int) ((double) listcount / limit + 0.95); // 0.95를 더해서 올림 처리.
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;

		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		request.setAttribute("page", page); // 현재 페이지 수.
		request.setAttribute("maxpage", maxpage); // 최대 페이지 수.
		request.setAttribute("startpage", startpage); // 현재 페이지에 표시할 첫 페이지 수.
		request.setAttribute("endpage", endpage); // 현재 페이지에 표시할 끝 페이지 수.
		request.setAttribute("listcount", listcount); // 글 수.

		return dao.getBoardList(page, limit);
	}

	@Override
	public BoardDTO getDetail(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDTO dto = dao.getDetail(num);
		return dto;
	}

	@Override
	public void setReadCountUpdate(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		dao.setReadCountUpdate(num);

	}

	@Override
	public boolean isBoardWriter(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		return dao.isBoardWriter(Integer.parseInt(request.getParameter("num")),
				request.getParameter("BOARD_PASS"));
	}

	/*
	 * @Override public boolean boardInsert(BoardDTO board) {
	 * 
	 * return dao.boardInsert(board); }
	 */

	/*
	 * @Override public int boardReply(BoardDTO board) { // TODO Auto-generated
	 * method stub return dao.boardReply(board); }
	 */

	/*
	 * @Override public boolean boardModify(BoardDTO modifyboard) { // TODO
	 * Auto-generated method stub return dao.boardModify(modifyboard); }
	 */

	/*
	 * @Override public boolean boardDelete(int num) { // TODO Auto-generated method
	 * stub return dao.boardDelete(num); }
	 */

}
