<%@page import="com.itwill.hellomart.user.UserService"%>
<%@page import="com.itwill.hellomart.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("hellomart_main.jsp");
		return;
	}
	/*
	UserService userService = new UserService();
	int result = userService.create(new User());
	int isDuplicate = 0;
	if(result == -1) {
		//아이디 중복
		isDuplicate = -1;
		out.println("<script>");
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
	}else if(result == 1) {
		//아이디 중복X
		isDuplicate = 1;
		response.sendRedirect("user_login_form.jsp");
	}
	*/
	out.println("<script>");
	out.println("alert('crush_action.jsp');");
	out.println("</script>");
	response.sendRedirect("user_write_form.jsp");
%>















