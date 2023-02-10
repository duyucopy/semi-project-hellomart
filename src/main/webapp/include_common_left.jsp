<%@page import="com.itwill.hellomart.cart.CartService"%>
<%@page import="com.itwill.hellomart.user.UserService"%>
<%@page import="com.itwill.hellomart.user.User"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sUserId=(String)session.getAttribute("sUserId");
%>	
<script type="text/javascript">
	function login_message() {
		alert('로그인하세요');
		location.href = 'user_login_form.jsp';
	}
</script>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%
		if(sUserId==null){
	%>
	     	<li><a href="user_login_form.jsp">로그인</a></li>
			<li><a href="user_write_form2.jsp">회원가입</a></li>
			<li><a href=""></a></li>
			<li><a href="javascript:login_message();">장바구니</a></li>
	<%
		}else{ 
			User sUser=new UserService().findUser(sUserId);
		    CartService cartService=new CartService();
		  	int cart_item_count = cartService.getCartListByUserId(sUserId).size();
	%>	
		<li><a href="user_view.jsp"><%=sUser.getName()+"님"%></a></li>
		<li><a href="user_logout_action.jsp">로그아웃</a></li>
		<li></li>
		<li><a href="cart_view_select_update_qty.jsp">장바구니<span class="w3-badge w3-badge-menu w3-green cart_item_count"><%=cart_item_count%></span></a></li>
		<li><a href=""></a></li>
		<li><a href="order_list.jsp">주문목록</a></li>
		<li><a href="order_list_orderitem1.jsp">주문+아이템 목록1</a></li>
		<li><a href="order_list_orderitem2.jsp">주문+아이템 목록2</a></li>
		
	<%} %>
		<li><a href="product_list.jsp">상품리스트</a></li>
		<li><span><a href="product_list.jsp?ct_no=1">가전제품</a></span></li>
		<li><span><a href="product_list.jsp?ct_no=2">전자기기</a></span></li>
		<li><span><a href="product_list.jsp?ct_no=3">가구</a></span></li>
		
</ul>
