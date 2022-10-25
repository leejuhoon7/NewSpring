<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/headers.css" rel="stylesheet">
  </head>
  
<div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link active" aria-current="page">홈</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/userList" class="nav-link">전체조회</a></li>
        <li class="nav-item"><a href="#" class="nav-link">단건조회</a></li>
        <li class="nav-item"><a href="#" class="nav-link">유저등록</a></li>
        <li class="nav-item"><a href="#" class="nav-link">유저수정</a></li>
      </ul>
    </header>
  </div>