<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestBookVo"%>

<%
	List<GuestBookVo> guestList = (List<GuestBookVo>) request.getAttribute("gList");

System.out.println("====addList.jsp====");
System.out.println(guestList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook2/gbc" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td><button type="submit">확인</button></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="insert">
	</form>

	<br>
	<%
		for (int i = 0; i < guestList.size(); i++) {
	%>
	<table border="1">
		<tr>
			<td><%=guestList.get(i).getNo()%></td>
			<td><%=guestList.get(i).getName()%></td>
			<td><%=guestList.get(i).getRegDate()%></td>
			<td><a href="/guestbook2/gbc?action=deleteForm">삭제</a></td>
		</tr>
		<tr>
			<td><%=guestList.get(i).getContent()%></td>
		</tr>
	</table>

	<%
		}
	%>



</body>
</html>