<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판</h1>
	<div id="boardList">
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.bno }</td>
					<td>${board.title }</td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate }" 
					pattern="yyyy년MM월dd일" /></td>
					<td><button type = "button">삭제</button></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form id="input">
			<input type="hidden" name="bno">
		</form>
	</div>
	<script>
		let resultMsg = '${msg}';
		if(resultMsg != null && resultMsg != ""){
			alert(resultMsg);
		}
		
		$('#boardList td').click(function() {
			let bno = $(this).parent().attr('name');
			$('#input > input').val(bno);
			$('#input').prop('action','info')
					   .prop('method', 'get')
					   .submit();
		});
		

		$('#boardList button').on('click', function(){
			
			let bno = $(this).closest('tr').attr('name');
			console.log(typeof bno);
			console.log(bno);
			$('#input > input').val(bno);
			$('#input').prop('action','delete')
					   .prop('method', 'get')
					   .submit();
			
			return false;
		});
	</script>
	
</body>
</html>