<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="hello.spring.bit.dto.UserDTO" %>
<%@ page import="java.util.Iterator" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<center>

<h1>Member List</h1>


<%
	request.setCharacterEncoding("utf-8");
	List<UserDTO> list = (List<UserDTO>)request.getAttribute("UserDTO");
	Iterator<UserDTO> iter = list.iterator();
	
	
	while (iter.hasNext()) {
		UserDTO dto = null;
	   dto = (UserDTO)iter.next();
	   String userId = dto.getId();
	   %>  
	  
	   <a href="info?userId=<%=userId%>">
	   <%out.println(userId);%></a>&nbsp;&nbsp;
	   
	   
	   
	   <a href="delete?userId=<%=userId%>">삭제</a>
	   
	   
	   </br>
	   
	   <%}%>
	
	
</center>



</body>
</html>