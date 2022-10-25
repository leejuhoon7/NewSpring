<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<th>번호</th>
				<th>제목</th>
				<th>표지</th>
				<th>출판일</th>
				<th>가격</th>
				<th>작가</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bookInfo">
				<tr>
					<td>${bookInfo.bookNo}</td>
					<td>${bookInfo.bookName}</td>
					<td><img width="100px" height="100px" src ="${pageContext.request.contextPath}/resources/images/${bookInfo.bookCoverimg}"></td>
					<td>${bookInfo.bookDate}</td>
					<td>${bookInfo.bookPrice}</td>
					<td>${bookInfo.bookPublisher}</td>
					<td>${bookInfo.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>