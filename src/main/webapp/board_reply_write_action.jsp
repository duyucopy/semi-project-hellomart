<%@page import="com.itwill.hellomart.board.BoardService"%>
<%@page import="com.itwill.hellomart.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>     
<%
	//Board객체를 생성하고 입력된데이타를 읽어서 객체에저장
	Board board=new Board();
	/*
	원글boardno
	*/
	board.setBoardno(
			Integer.parseInt(request.getParameter("boardno")));
	/*
	답글 데이타
	*/
	board.setTitle(request.getParameter("title"));
	board.setUserId(request.getParameter("writer"));
	board.setContent(request.getParameter("content"));
	BoardService.getInstance().createReplay(board, request.getParameter("writer"));
	
	String pageno = "1";
	if(request.getParameter("pageno")!=null){
		pageno=request.getParameter("pageno");
	}
	response.sendRedirect(
			String.format("board_list.jsp?pageno=%s",pageno));
	
%>