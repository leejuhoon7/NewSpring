<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<h1>All List</h1>
	<!-- 
   <table border="1">
      <tr>
         <th>employee_id</th>
         <th>first_name</th>
         <th>last_name</th>
         <th>email</th>
         <th>phone_number</th>
         <th>hire_date</th>
         <th>job_id</th>
         <th>salary</th>
         <th>commission_pct</th>
         <th>manager_id</th>
         <th>department_id</th>
      </tr>
      
      <c:forEach var="str" items="${allList }">
         <tr>
            <td>${str.employeeId}</td>
            <td>${str.firstName}</td>
            <td>${str.lastName}</td>
            <td>${str.email}</td>
            <td>${str.phoneNumber}</td>
            <td>${str.hireDate}</td>
            <td>${str.jobId}</td>
            <td>${str.salary}</td>
            <td>${str.commissionPct}</td>
            <td>${str.managerId}</td>
            <td>${str.departmentId}</td>
         </tr>
      </c:forEach>
   </table>
    -->
	
	<form action ="delete/210">
	<button>삭제</button>
	</form>
	
	<div id="dataList">	
	<button type ="button" onclick="location.href='insertForm'">사원등록</button>
		<table>
			<thead>
				<tr>
					<th>사원번호</th>
					<th>성</th>
					<th>이름</th>
					<th>직업</th>
					<th>급여</th>
					<th>부서번호</th>
					<th><button>삭제</button></th>

				</tr>
			</thead>


			<tbody>
				<c:forEach items="${allList }" var="empInfo">
					<tr onclick="location.href='info?employeeId=${empInfo.employeeId }'">
					
						<td>${empInfo.employeeId}</td>
						<td>${empInfo.lastName}</td>
						<td>${empInfo.firstName}</td>
						<td>${empInfo.jobId}</td>
						<td>${empInfo.salary}</td>
						<td>${empInfo.departmentId}</td>
						<td><button>삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<form action="input" >
			<input type = "hidden" name = "employeeId" id = "employeeId">
		</form>
		
		
		
		
		<script>
			let message ='${msg}';
			if(message != null && message != ''){
				alert(message);
			}
		
			$('#dataList td').click(function(){
				let empId = $(this).parent().attr('name');
				$('#input > input').val(empId);
				$('#input').prop('action', 'info')
				           .prop('method', 'get')
				           .submit();
	
			})
			
			$.ajax({
					url : 'delete' + empId,
					success :function(data){
						console.log(data);
					},
					error : function(rejec){
						console.log(reject);
					}
				})
		</script>
		
		
		<script>
		/*
		$('#dataList tr').click(function(){
			let empId = $(this).children().first().text()
			console.log(empId)
			$.ajax({
				url : 'info',
				data : {"employeeId" : empId},
				async : true,
				success : data => {
				
			console.log(data)
					
		 		
				},
				error : function(reject){
					console.log(reject);
				}
			})
		})
		*/
		</script>
		
		<script>
// 		$('tbody').empty();
// 			let thTag = $('#dataList th');
			
// 			$(empList).foreach(function(idx, obj){
// 				let tr = $('<tr/>');
// 				$(tr).append($('<td/>').text(obj.employeeId));
// 				$(tr).append($('<td/>').text(obj.lastName));
// 				$(tr).append($('<td/>').text(obj.firstName));
// 				$(tr).append($('<td/>').text(obj.jobId));
// 				$(tr).append($('<td/>').text(obj.salary));
// 				$(tr).append($('<td/>').text(obj.departmentId));
// 				$('#dataList tbody').append(tr);
				
				
// 			});
		</script>
	</div>




</body>

</html>