<%@page import="com.itwill.hellomart.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.hellomart.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
ProductService productService = new ProductService();
List<Product> productList = productService.findAll();
%>
<ul>
	<li><%out.print(productList);%></li>

</ul>

