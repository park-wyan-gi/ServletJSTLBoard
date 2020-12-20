<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/board.css' >
<title>게시판 수정</title>
</head>
<body>
<div class='input'>
	<h1 class='title'>게시판 수정(Servlet)</h1>
	<form name='frm_board' id='frm_board' method='post' enctype='multipart/form-data'>
		<label>작성자</label>
		<input type='text' name='worker' value='' readonly /><br/>
		
		<label>제목</label>
		<input type='text' name='subject' class='subject' maxlength='100' value='hi....' /><br/>
		
		<label></label>
		<textarea name='content' class='content'></textarea><br/>
		
		<label>첨부파일</label>		
		<div class='items'>
			<c:forEach var='i' begin='1' end='12'>
				<span class='item'>
					<label>
						<img src='http://placehold.it/150x180'><br/>
						<input type='checkbox' value='' name='delFile' />
					  삭제
					</label>
				
				</span>
			
			</c:forEach>
		
		</div>
		
		
		
		<label>첨부추가</label>
		<input type='file' name='attFile' id='btnAtt' multiple /><br/>
		
		<div>
			<label></label>
			<div id='attFile' contentEditable='true' data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
		</div>
		
		<div class='btnZone'>
			<input type='button' value='수정'    id='btnModifyR' />
			<input type='button' value='상세보기' id='btnView' />
			<input type='button' value='목록으로' id='btnList' />
		</div>
		
		<input type='hidden' name='nowPage' value='' />
		<input type='hidden' name='findStr' value='' />
		<input type='hidden' name='serial' value = ''/>
		<input type='hidden' name='pwd'/>
		
	</form>
</div>


</body>
</html>