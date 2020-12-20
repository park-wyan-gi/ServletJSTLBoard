<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:choose>
	<c:when test="${empty sessionScope.mid }">
		<!--  로그인 전 페이지  -->
    <form name='frm_login' id='frm_login' method='post'>
        <label>아이디</label>
        <input type='text' name='mid' size='10' />
        
        <label>암호</label>
        <input type='password' name='pwd' size='12' />
        
        <input type='button' value='로그인' id='btnLogin' />
    </form>
	</c:when>
	<c:otherwise>    
		<!-- 로그인 후 -->
		<span> 방가~ 방가~</span>    
		<input type='button' value='로그아웃' id='btnLogOut' />
	</c:otherwise>
</c:choose>    
<script>
	logInOut();
</script>