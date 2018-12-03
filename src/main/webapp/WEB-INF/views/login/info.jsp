<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="hello.spring.bit.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>



<body>

<center>
<h1> Member Information </h1>
<table>
<tr><td>ID : </td><td>${UserDTO.id}</td></tr>
<tr><td>PASS : </td><td>${UserDTO.pw}</td></tr>
<tr><td>NAME : </td><td>${UserDTO.name}</td></tr>
<tr><td>E-MAIL : </td><td>${UserDTO.email}</td></tr>
<tr><td>ADDRESS : </td><td>${UserDTO.address}</td></tr>
</center>

</table>

	
</body>
</html>