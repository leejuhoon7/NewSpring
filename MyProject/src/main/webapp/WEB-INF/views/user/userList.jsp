<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>가입일자</td>
				<td>연락처</td>
				<td>이메일</td>
				
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items = "${userList }" var = "user">
				<tr>
					<td>${user.userId }</td>
					<td>${user.userName }</td>
					<td>${user.userDate }</td>
					<td>${user.userPhone }</td>
					<td>${user.userEmail }</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>