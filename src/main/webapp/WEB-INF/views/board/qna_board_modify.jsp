<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="hello.spring.bit.dto.BoardDTO"%>
<%
	BoardDTO board = (BoardDTO) request.getAttribute("boardDTO");
%>

<html>
<head>
	<title>MVC �Խ���</title>
	<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>

<body>
<!-- �Խ��� ���� -->
<form action="board_modify2" method="post" name="modifyform">
<input type="hidden" name="num" value=<%=board.getBOARD_NUM() %>>
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">MVC �Խ���</td>
	</tr>
	<tr>
		<td height="16" style="font-family:����; font-size:12">
			<div align="center">�� ��</div>
		</td>
		<td>
			<input name="BOARD_SUBJECT" size="50" maxlength="100" 
				value="<%=board.getBOARD_SUBJECT()%>">
		</td>
	</tr>
	<tr>
		<td style="font-family:����; font-size:12">
			<div align="center">�� ��</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15">
			<%=board.getBOARD_CONTENT() %>
			</textarea>
		</td>
	</tr>
	<%if(!(board.getBOARD_FILE()==null)){ %>
	<tr>
		<td style="font-family:����; font-size:12">
			<div align="center">���� ÷��</div>
		</td>
		<td>
			&nbsp;&nbsp;<%=board.getBOARD_FILE() %>
		</td>
	</tr>
	<%} %>
	<tr>
		<td height="16" style="font-family:����; font-size:12">
			<div align="center">��й�ȣ</div>
		</td>
		<td>
			<input name="BOARD_PASS" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="javascript:modifyboard()">[����]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[�ڷ�]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</form>
<!-- �Խ��� ���� -->
</body>
</html>