<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="updateBoardInfo" action="updateForm" method="post">
		<div>
			<h3>게시글 등록</h3>
		</div>
		<table>
			<tr>
				<th>글 번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image}"></td>
			</tr>
			<tr>
				<th>수정일</th>
				<td><input type="date" name="updatedate" value="${boardInfo.updatedate}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='list'">목록</button>
	</form>
</body>
</html>