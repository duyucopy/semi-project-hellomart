package com.itwill.hellomart.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class BoardDao {
	private DataSource dataSource;
	
	public BoardDao() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));;
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	/**
	 * 상품게시판에 새로운 게시물을 추가하는 메써드.
	 * @throws Exception 
	 */
	public int create(Board board, String sUserId,int p_no) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(BoardSQL.BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, sUserId);
			pstmt.setInt(4, p_no);
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			con.close();
		}
		
	}
	/**
	 * 상품게시판에 답글 게시물을 추가하는 메써드
	 */
	public int createReply(Board board, String sUserId,int p_no) throws Exception{
		Connection con =null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			// 댓글을 작성할 대상글(원글)의 정보를 조회
			Board temp = this.findBoard(board.getBoadrno(), sUserId, p_no);
			
		} finally {
			
		}
		return count;
	}
	/**
	 * 상품게시판에 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	public ArrayList<Board> findBoardList(int start, int last, String sUserId,int p_no) throws Exception{
		System.out.println("" + start + " ~ " + last);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// 조회 결과에 접근하는 참조 변수
		// 데이터베이스의 데이터를 읽어서 저장할 객체 컬렉션
		ArrayList<Board> boards = new ArrayList<Board>();
		
		return boards;
	}
	/**
	 * 상품게시판에 답변게시물 존재여부확인메쏘드
	 */
	public boolean countReplay(Board board, String sUserId,int p_no) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean isExist = false;
		int cnt = 0;
		
		return isExist;
	}
	/**
	 * 상품게시판에 게시물을 삭제하는 메써드.
	 */
	public int remove(int boardNo, String sUserId,int p_no) throws Exception{

		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		return count;
	}
	/**
	 * 상품게시판에 게시물내용을 수정하는 메써드.
	 */
	public int update(Board board, String sUserId,int p_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		return count;
	}
	/**
	 * 상품게시판에 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	public Board findBoard(int boardNo, String sUserId,int p_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		
		return board;
	}
	/**
	 * 상품게시판에 게시물 조회수를 1 증가.
	 */
	public void increaseReadCount(int number, int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
	}
	/**
	 * 상품게시판에 게시물 총 건수를 조회, 반환
	 */
	public int getBoardCount(int p_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		return count;
	}
}
