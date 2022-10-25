<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno }</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer }</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea rows = "3" cols = "2" style = "width : 100px" >${boardInfo.contents }</textarea></td>
		</tr>
		
		<tr>
			<th>첨부파일</th>
<%-- 			<td><img src="${pageContext.request.contextPath }/resources/${boardInfo.image}" alt="이미지" /></td> --%>
				<td> 
				<img src="<c:url value = '/resources/images/${boardInfo.image}'/>" width = 400px height = 300px>
				 </td>
		</tr>
		
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd" /></td>
		</tr>
		
	</table>
	
	<button type="button" id="updateBtn">수정</button>
	<form id=input>
		<input type="hidden" name="bno">
	</form>
	
	<script>
	let resultMsg = '${msg}';
	if (resultMsg != null && resultMsg != "") {
		alert(resultMsg);
	}
	
	$('#updateBtn').click(function(){
		let bno = ${board.bno };
		$('#input > input').val(bno);
		$('#input').prop('action', 'update')
				   .prop('method', 'get')
				   .submit()
	});
	</script>
</body>
</html>