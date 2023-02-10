<%@page import="com.itwill.hellomart.address.Address"%>
<%@page import="com.itwill.hellomart.address.AddressService"%>
<%@page import="com.itwill.hellomart.order.OrderService"%>
<%@page import="com.itwill.hellomart.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>    
<%
    /*
    주문생성
    */
   	if(request.getMethod().equalsIgnoreCase("GET")){
   		response.sendRedirect("order_list.jsp");
   		return;
   	}
	String buyType=request.getParameter("buyType");
	String p_noStr=request.getParameter("p_no");
	String p_qtyStr=request.getParameter("p_qty");
	String[] cart_item_no_strArray=request.getParameterValues("cart_item_no");
	String o_option = request.getParameter("o_option");
	String addr_noStr = request.getParameter("addr_no");
	String loc = request.getParameter("loc");
	String addr_input = request.getParameter("addr_input");
	String addr_select = request.getParameter("addr_select");
	
	//String loc = request.getParameter("loc");
	OrderService orderService=new OrderService();
   	CartService cartService=new CartService();
	AddressService addressService = new AddressService();
	
	if(addr_select.equals("type")) {
			loc = addr_input;
	} else {
		
	}
   	if(buyType.equals("cart")){
   		orderService.create(sUserId,o_option,loc);
   	}else if(buyType.equals("cart_select")){
   		orderService.create(sUserId,cart_item_no_strArray,o_option,loc);	
    }else if(buyType.equals("direct")){
       	orderService.create(sUserId, 
       						Integer.parseInt(p_noStr), Integer.parseInt(p_qtyStr),
       						o_option);
   	}
   	response.sendRedirect("order_list.jsp");
    %>