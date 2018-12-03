<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login page</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<center>

		<h1>Login</h1>
		<hr>
		
		<form action="home_login" method="post">
			<b> ID: <input type="text" name="id" /> <br>
			<br> <b> PASS: <input type="password" name="pw" /> <br>
				<br> <input type="submit" value="login" /><br>
				<br>
		</form>

		<form action="join_write">
			<input type="submit" value="join" />
		</form>


	</center>
</body>
</html>