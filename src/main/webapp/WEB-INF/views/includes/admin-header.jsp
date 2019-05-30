<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="function"
	uri="http://java.sun.com/jsp/jstl/functions"%>
<ul class="admin-menu">
	<li	<c:if test="${selected eq 'basic' }">class="selected"</c:if>><a href="${pageContext.request.contextPath}/${blogId}/admin/basic">기본설정</a></li>
	<li <c:if test="${selected eq 'category' }">class="selected"</c:if>><a href="${pageContext.request.contextPath}/${blogId}/admin/category">카테고리</a></li>
	<li <c:if test="${selected eq 'write' }">class="selected"</c:if>><a href="${pageContext.request.contextPath}/${blogId}/admin/write">글작성</a></li>
</ul>