<%@page import="test.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstltest.jsp</title>
</head>
<body>
<%
	ArrayList<UserVO> list = new ArrayList<UserVO>();
	list.add(new UserVO("이순신"));
	list.add(new UserVO("홍길동"));
	list.add(new UserVO("김기자"));
	request.setAttribute("userList", list);
	request.setAttribute("content", "<u>test</u>");
	
%>
	${content}
	<c:out value="${content}" />
	<c:out value="${content}" escapeXml="false" /><br>
	
	${fn:startsWith(userList[0].username, '이')}<br>
	
총인원 ${fn:length(userList)} 명입니다.<br>
	<c:forEach items = "${userList }" var ="user" varStatus="st">
		${st.count } ${user.username }<br>
		
	</c:forEach>
	
</body>
</html>