<%@page import="com.itwill.hellomart.user.UserService"%>
<%@page import="com.itwill.hellomart.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function userCreate() {
		if (document.f.userId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			document.f.userId.focus();
			return;
		}
		/*
		1.아이디는 3~10자여야한다
		2.영문알파벳대문자,소문자,숫자만 가능
		3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
		*/
		if(!(document.f.userId.value.length>=3 && document.f.userId.value.length<=10)){
			alert("아이디는 5~10자여야한다");
			f.userId.value.select();
			return;
		}
	
		for(let i=0;i<document.f.userId.value.length;i++){
			if(!((document.f.userId.value.charAt(i)>='0' && document.f.userId.value.charAt(i)<='9')||
				(document.f.userId.value.charAt(i)>='a' && document.f.userId.value.charAt(i)<='z')||
				(document.f.userId.value.charAt(i)>='A' && document.f.userId.value.charAt(i)<='Z')
			)){
				alert("영문알파벳대문자,소문자,숫자만 가능");
				document.f.userId.value.select();
				return;
			}							
		}
		if(document.f.userId.value.charAt(0)>='0' && document.f.userId.value.charAt(0)<='9'){
			alert("아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)");
			document.f.userId.value.select();
			return;
		}
		
		
		/*******************************************************/
		if (document.f.password.value == "") {
			alert("비밀번호를 입력하십시요.");
			document.f.password.focus();
			return;
		}
		if (document.f.password2.value == "") {
			alert("비밀번호확인을 입력하십시요.");
			f.password2.focus();
			return;
		}
		if (document.f.name.value == "") {
			alert("이름을 입력하십시요.");
			f.name.focus();
			return;
		}
		if (document.f.email.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.email.focus();
			return;
		}
		
		document.f.action = "user_write_action.jsp";
		document.f.method='POST';
		document.f.submit();
		}
	
	function main() {
		window.location.href='hellomart_main.jsp';
	}
	
	function repassword() {
		if(document.f.password.value != ""){
			if(document.f.password.value != document.f.password2.value){
				document.getElementById('pass2').innerHTML = "비밀번호가 일치하지 않습니다."
			}else{
				document.getElementById('pass2').innerHTML = "비밀번호가 일치합니다."
			}
		}else if(document.f.password.value = "") {
			document.getElementById('pass2').innerHTML = ""
		}
	}
	
	function checkId() {
		document.getElementById('idCheck').innerHTML = "이미 존재하는 아이디입니다."
	}
	
	
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입</b></td>
								</tr>
							</table> 
							<!-- write Form  -->
							<form name="f">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="userId"
											value="" onblur="checkId()">&nbsp;&nbsp;<font id="idCheck" color="red"></font>
										</td>
										
										
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="password"
											value="">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="password2"
											value="" onkeyup="repassword()">&nbsp;&nbsp;<font id="pass2" color="red"></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="name"
											value="">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="email"
											value="">
										</td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center>
									<input type="button" value="회원 가입" onclick="userCreate();"> &nbsp; 
									<input type="button" value="메인" onclick="main();">
									</td>
								</tr>
							</table>

						</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
