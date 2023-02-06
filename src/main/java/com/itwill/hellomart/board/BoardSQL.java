package com.itwill.hellomart.board;

public class BoardSQL {
	//-- 상품게시판 새글쓰기
	public static final String BOARD_INSERT=
			"insert into board(boardno, title, content, groupno, step, userId, p_no) values(board_boardno_SEQ.nextval,?,?,board_boardno_SEQ.currval,1,?,?)";
	
	//--상품게시판 답글쓰기
	//-- update 현재글과 같은그룹번호들중에서현재글의 step보다큰 step을가진 게시물들의 step을 1씩 증가시킨다.
	public static final String BOARD_UPDATE_REPLY="update board set step = step + 1 where step > ? and groupno = ? and p_no=?";
	//-- insert 후기글 삽입
	public static final String BOARD_INSERT_REPLY="";
	
	public static final String BOARD_SELECT_PAGE="";
	
}
