<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="hello.spring.bit.dto.BoardDTO"%>
<%
	BoardDTO board = (BoardDTO) request.getAttribute("boardDTO");
%>

<html>
<head>
<title>MVC �Խ���</title>
</head>

<body>
	<!-- �Խ��� ���� -->
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">MVC �Խ���</td>
		</tr>

		<tr>
			<td style="font-family: ����; font-size: 12" height="16">
				<div align="center">�� ��&nbsp;&nbsp;</div>
			</td>

			<td style="font-family: ����; font-size: 12"><%=board.getBOARD_SUBJECT()%>
			</td>
		</tr>

		<tr bgcolor="cccccc">
			<td colspan="2" style="height: 1px;"></td>
		</tr>

		<tr>
			<td style="font-family: ����; font-size: 12">
				<div align="center">�� ��</div>
			</td>
			<td style="font-family: ����; font-size: 12">
				<table border=0 width=490 height=250 style="table-layout: fixed">
					<tr>
						<td valign=top style="font-family: ����; font-size: 12"><%=board.getBOARD_CONTENT()%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="font-family: ����; font-size: 12">
				<div align="center">÷������</div>
			</td>
			<td style="font-family: ����; font-size: 12">
				<%
					if (!(board.getBOARD_FILE() == null)) {
				%> <a
				href="./boardupload/<%=board.getBOARD_FILE()%>"> <%=board.getBOARD_FILE()%>
			</a> <%
 	}
 %>
			</td>
		</tr>

		<tr bgcolor="cccccc">
			<td colspan="2" style="height: 1px;"></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>

		<tr align="center" valign="middle">
			<td colspan="5"><font size=2> <a
					href="board_reply?num=<%=board.getBOARD_NUM()%>">
						[�亯] </a>&nbsp;&nbsp; <a
					href="board_modify?num=<%=board.getBOARD_NUM()%>"> [����] </a>&nbsp;&nbsp;
					<a href="board_delete?num=<%=board.getBOARD_NUM()%>"> [����]
				</a>&nbsp;&nbsp; <a href="board_list">[���]</a>&nbsp;&nbsp;
			</font></td>
		</tr>
	</table>
	<!-- �Խ��� ���� -->
</body>
</html>