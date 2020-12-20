<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/board.css' >
<title>게시판 상세보기</title>
</head>
<body>
<div class='view'>
	<h1 class='title'>게시판 상세보기(Servlet)</h1>
	
	<div>
		<span class='label'>순 번</span>
		<span>100</span>
	</div>
	
	<div>
		<span class='label'>작성자</span>
		<strong>홍길동</strong>
		<span>[ 2020-01-01] 조회수 : 1,000</span>
	</div>
	
	<div>
		<span class='label'>제 목</span>
		<span>hi...</span>
	</div>
	
	<div class='content'>
		IT여행자와 함께 만들어 보는 Servlet과 JSTL을 사용한 게시판 만들기 입니다.
	</div>
	
	<!--  첨부 파일  -->
	<div>
		<c:forEach var='i' begin='1' end='12'>
			<span class='item'>
				<a href='' download=''>
					<img src='http://placehold.it/150x180'><br/>
					<span class='img_label'>파일${i }</span>
				</a>
			</span>
		</c:forEach>		
	</div>
	
	<div class='btnZone'>
		<input type='button' value='삭제' id='btnDeleteR' />
		<input type='button' value='수정' id='btnModify' />
		<input type='button' value='댓글' id='btnRelp' />
		<input type='button' value='목록' id='btnList' />
	</div>
	
	<form name='frm_board' method='post'>
		<input type='hidden' name='serial' value='' />
		<input type='hidden' name='nowPage' value='' />
		<input type='hidden' name='findStr' value='' />
		<input type='hidden' name='pwd'/>
	</form>
	
</div>
</body>
</html>









