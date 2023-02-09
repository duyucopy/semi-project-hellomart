<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="com.itwill.hellomart.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%
Product product = new Product();
List<Product> productList = new ArrayList<Product>();
Collections.shuffle(productList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<div>
<body>
<%=sUserId %>님을 위한 추천상품
	<table width=600 cellspacing=0>
				<% for(int i = 1; i < 4; i++) { %>
					<td align=center>
					<br>
						<%=productList.subList(0, 3)  %>
					<img src="image/LG전자 오브제컬렉션 냉장고.jpg">
					<br>
					LG전자 오브제컬렉션 냉장고
					<%=product.getP_name()%> 
					<br>
					1,900,000원
					</td>
				<% } %>
			</table>



</body>
</html>