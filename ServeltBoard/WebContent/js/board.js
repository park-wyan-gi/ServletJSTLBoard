/**
 *  Servlet과 JSTL을 사용한 게시판 만들기 스크립트
 */

// 공통 요소--------------------------------------------
var url = 'board.do?job=';
var getID = function(id){
	return document.getElementById(id);
}

// 로그인, 로그아웃 버튼의 이벤트 처리 함수
var logInOut = function(){
	var btnLogIn = getID('btnLogin');
	var btnLogOut = getID('btnLogOut');
	
	if(btnLogIn != null){
		btnLogIn.onclick = function(){
			var frm = getID('frm_login');
			
			if(frm.mid.value == '' || frm.pwd.value == ''){
				alert('아이디와 암호는 반드시 입력해야 합니다.');
				return;
			}else{
				frm.action = 'login.do?job=login';
				frm.submit();
			}
		}
	}
	
	if(btnLogOut != null){
		btnLogOut.onclick = function(){
			location.href='login.do?job=logout';
		}
	}
}

var boardStart = function(){
	var ff = getID('frm_board');
	var btnFind = getID('btnFind');
	
	// 검색 버튼이 클릭되면
	if(btnFind != null){
		btnFind.onclick = function(){
			ff.enctype = '';
			ff.nowPage.value = 1;
			ff.action = url + 'list'; //var url = 'board.do?job=';
			ff.submit();
		}
	}
}

var goPage = function(nowPage){
	var ff = getID('frm_board');
	ff.action = url + 'list'; //var url = 'board.do?job=';
	ff.nowPage.value = nowPage;
	ff.submit();
}








