<%@page import="com.itwill.hellomart.user.UserService"%>
<%@page import="com.itwill.hellomart.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("hellomart_main.jsp");
		return;
	}
	String userId = request.getParameter("userId");
	
	
	UserService userService = new UserService();
	 
	if(userService.isDuplicateId(userId)) {
		//아이디 중복
		String msg1 = userId + "는 이미 존재하는 아이디입니다.";
		out.println("<script>");
		out.println("alert('" + msg1 + "');");
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
	}else if(!userService.isDuplicateId(userId)) {
		
		
	}
%>















