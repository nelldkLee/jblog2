<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4 id="mainTitle">글이 없습니다.</h4>
					<p id="mainContent">
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList}" var="postVo" varStatus="status">
						<li><a class="post" href="" data-no="${postVo.no}"
							data-content="${postVo.content}" data-title="${postVo.title}">${postVo.title}</a>
							<span>${postVo.regDate}</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<c:choose>
					<c:when test="${not empty blogVo.logo}">
						<img src="${pageContext.request.contextPath}${blogVo.logo}">
					</c:when>
					<c:otherwise>
						<img
							src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList}" var="category">
					<li
						<c:if test="${categoryNo eq category.no}">class='selected'</c:if>>
						<a
						href="${pageContext.request.contextPath}/${blogVo.blogId}/${category.no}">${category.title}(${category.postCount})</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blog-footer.jsp" />

	</div>
	<script>
		$(document).ready(function(){
			var firstPost = $(".blog-list a:first");
			var mainContent = $("#mainContent");
			var mainTitle = $("#mainTitle");
			if(firstPost){
				console.log(firstPost);
				mainContent.text(firstPost.data("content"));
				mainTitle.text(firstPost.data("title"));
			}
			
			$(".post").click(function(event){
				event.preventDefault();
				var targetPost = $(this);
				mainTitle.text(targetPost.data("title"));
				mainContent.text(targetPost.data("content"));
			});	
		});
		
	</script>
</body>
</html>