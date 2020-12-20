<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet과 JSTL을 사용한 게시판</title>
<link rel='stylesheet' href='./css/index.css'>
<script src='./js/board.js'></script>
</head>
<body>

<div id='main'>
  <div id='login' ><%@include file="./login.jsp" %></div>
  <header id='header'><%@include file="./header.jsp" %></header>
  <section id='content'><jsp:include page="${(empty param.inc)? 'intro.jsp' : param.inc }"></jsp:include></section>
  <footer id='footer'><%@include file="./footer.jsp" %></footer>
</div>

</body>
</html>