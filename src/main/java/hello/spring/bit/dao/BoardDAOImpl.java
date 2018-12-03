package hello.spring.bit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import hello.spring.bit.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession session;

	@Override
	public boolean boardInsert(BoardDTO board) {
		
		int num = 0;

		if (session.selectOne("board.getMaxCount") == null)
			num = 1; // 디비에 글 목록이 없을 경우 처음 글로 등록
		else
			num = (Integer) session.selectOne("board.getMaxCount") + 1;

		Map<String, Object> board_map = new HashMap<String, Object>();
		board_map.put("num", num);
		board_map.put("BOARD_NAME", board.getBOARD_NAME());
		board_map.put("BOARD_PASS", board.getBOARD_PASS());
		board_map.put("BOARD_SUBJECT", board.getBOARD_SUBJECT());
		board_map.put("BOARD_CONTENT", board.getBOARD_CONTENT());
		board_map.put("BOARD_FILE", 0);
		board_map.put("BOARD_RE_REF", num);
		board_map.put("BOARD_RE_LEV", 0);
		board_map.put("BOARD_RE_SEQ", 0);
		board_map.put("BOARD_READCOUNT", 0);

		int flag = session.insert("board.insertBoard", board_map);

		// 글이 등록이 성공하면 1 반환
		if (flag > 0) {
			return true;
		} else
			return false;
	}

	@Override
	public int getListCount() {

		int x = (Integer) session.selectOne("board.getCount");

		return x;

	}

	@Override
	public List<BoardDTO> getBoardList(int page, int limit) {
		// TODO Auto-generated method stub
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);

		List<BoardDTO> boardList = session.selectList("board.getList", map);

		return boardList;
	}

	@Override
	public BoardDTO getDetail(int num) {
		
		BoardDTO dto = session.selectOne("board.selectDetail", num);
		return dto;
	}

	@Override
	public int boardReply(BoardDTO board) {
		// TODO Auto-generated method stub
		int num = 0;
		int re_ref = board.getBOARD_RE_REF();
		int re_lev = board.getBOARD_RE_LEV();
		int re_seq = board.getBOARD_RE_SEQ();

		if (session.selectOne("board.getMaxCount") == null)
			num = 1; // 디비에 글 목록이 없을 경우 처음 글로 등록
		else
			num = (Integer) session.selectOne("board.getMaxCount") + 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("re_ref", re_ref);
		map.put("re_seq", re_seq);

		session.update("board.updateReply", map);

		re_seq = re_seq + 1;
		re_lev = re_lev + 1;

		Map<String, Object> board_map = new HashMap<String, Object>();
		board_map.put("num", num);
		board_map.put("BOARD_NAME", board.getBOARD_NAME());
		board_map.put("BOARD_PASS", board.getBOARD_PASS());
		board_map.put("BOARD_SUBJECT", board.getBOARD_SUBJECT());
		board_map.put("BOARD_CONTENT", board.getBOARD_CONTENT());
		board_map.put("BOARD_FILE", "");
		board_map.put("BOARD_RE_REF", re_ref);
		board_map.put("BOARD_RE_LEV", re_lev);
		board_map.put("BOARD_RE_SEQ", re_seq);
		board_map.put("BOARD_READCOUNT", 0);

		int flag = session.insert("board.insertBoard", board_map);

		// 글이 등록이 성공하면 1 반환
		if (flag > 0)
			return num;
		else
			return 0;

	}

	@Override
	public boolean boardModify(BoardDTO modifyboard) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b1", modifyboard.getBOARD_SUBJECT());
		map.put("b2", modifyboard.getBOARD_CONTENT());
		map.put("b3", modifyboard.getBOARD_NUM());

		int f = session.update("board.updateBoard", map);
		if (f > 0) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean boardDelete(int num) {
		// TODO Auto-generated method stub
		int d = session.delete("board.deleteBoard", num);
		if (d > 0)
			return true;
		else
			return false;
	}

	@Override
	public void setReadCountUpdate(int num) {
		// TODO Auto-generated method stub
		session.update("board.updateCount", num);
	}

	@Override
	public boolean isBoardWriter(int num, String pass) {
		// TODO Auto-generated method stub
		BoardDTO dto = session.selectOne("board.selectWrite", num);
		if (pass.equals(dto.getBOARD_PASS())) {
			return true;
		}
		return false;
	}

}
