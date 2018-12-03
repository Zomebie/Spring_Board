<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
request.setCharacterEncoding("utf-8");
String userId=(String)session.getAttribute("userId"); 

%>
 

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>

	<center>
		<h2>${userDTO.id}님 환영합니다 ~</h2>
		<a href="board_list"> 게시판 </a><br> <br>

		<%
	if( userId.equals("admin")){
		out.println("<a href='admin'>관리자 페이지</a><br><br>");
		
	}
		
%>
		<input type="submit" value="Logout" onclick="location.href='logout'" />

	</center>


</body>
</html>