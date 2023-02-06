package com.itwill.hellomart.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	/**
	 * 상품게시판에 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	
	/**
	 * 상품게시판에 답변게시물 존재여부확인메쏘드
	 */
	
	/**
	 * 상품게시판에 게시물을 삭제하는 메써드.
	 */
	
	/**
	 * 상품게시판에 게시물내용을 수정하는 메써드.
	 */
	
	/**
	 * 상품게시판에 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	
	/**
	 * 상품게시판에 게시물 조회수를 1 증가.
	 */
	
	/**
	 * 상품게시판에 게시물 총 건수를 조회, 반환
	 */
	
}
