<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/board.css' >
<title>Insert title here</title>
</head>
<body>
<div class='list'>
	<h1 class='title'>게시물 조회(Servlet)</h1>
	<form name='frm_board' method='post' id='frm_board'>
		<input type='button' name='btnInsert' id='btnInsert' value='입력' />
		
		<div class='find'>
			<input type='text' size='40' name='findStr' value='${page.findStr }' />
			<input type='button' name='btnFind' id='btnFind' value='검색' />
			
			<input type='hidden' name='serial' />
			<input type='hidden' name='nowPage' value='' />
		</div>
	</form>
	
	<div class='items_title'>
		<span class='serial'>순번</span>
		<span class='subject'>제목</span>
		<span class='mdate'>작성일</span>
		<span class='worker'>작성자</span>
		<span class='hit'>조회수</span>
	</div>
	
	<div class='items_list'>
		<c:forEach var='i' items='${list }'>
			<div class='items'>
				<span class='serial'>${i.serial }</span>
				<span class='subject'>${i.subject } (i.attCnt)</span>
				<span class='mdate'>${i.mDate }</span>
				<span class='worker'>${i.worker }</span>
				<span class='hit'>${i.hit }</span>
			</div>
		</c:forEach>
	</div>
	
	<div class='paging'>
		
		<c:if test='${page.startPage>1 }'>		
			<input type='button' value='맨첨' onclick = 'goPage(1)'/>
			<input type='button' value='이전' onclick='goPage(${page.startPage-1})'/>
		
		</c:if>
		
		<c:forEach var='i' begin='${page.startPage }' end='${page.endPage }'>
			<input type='button' value='${i }' ${page.nowPage == i ? 'disabled': '' }
			                onclick = 'goPage(${i})'/>
		</c:forEach>

		<c:if test='${page.totPage > page.endPage }'>
			<input type='button' value='다음' onclick = 'goPage(${page.endPage+1})'/>
			<input type='button' value='맨끝' onclick = 'goPage(${page.totPage})'/>
		</c:if>
	</div>
	<script>
	  boardStart();p
	</script>
</div>
</body>
</html>













