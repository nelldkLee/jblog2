<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="function"
	uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="header">
	<h1>${blogVo.title}</h1>
	<ul>
		<c:choose>
			<c:when test="${empty authUser}">
				<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>	
		
		<c:if test="${authUser.id eq blogVo.blogId}">
			<li><a href="${pageContext.request.contextPath}/${blogVo.blogId}">홈으로</a></li>	
			<li><a href="${pageContext.request.contextPath}/${blogVo.blogId}/admin/basic">블로그 관리</a></li>
		</c:if>
	</ul>
</div>