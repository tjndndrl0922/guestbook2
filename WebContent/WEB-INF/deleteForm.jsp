<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/guestbook2/gbc" method="get">
		 비밀번호<input type="text" name="password">
		 <button type="submit">확인</button><br>
		 <input type="text" name="no" value="<%=no%>">
		 <input type="text" name="action" value="delete">
	</form>
	 <a href="/guestbook2/gbc?action=addList">메인으로 돌아가기</a>
</body>
</html>