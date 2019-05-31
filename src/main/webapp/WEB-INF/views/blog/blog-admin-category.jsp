<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<jsp:include page="/WEB-INF/views/includes/admin-header.jsp" />
		      	<table class="admin-cat" data-title="테스트">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items="${categoryList}" var="categoryVo" varStatus="i">
						<tr data-no="${categoryVo.no}">
							<td>${i.index + 1}</td>
							<td>${categoryVo.title}</td>
							<td>${categoryVo.postCount}</td>
							<td>${categoryVo.description}</td>
							<td><img class="deleteImg" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>
					</c:forEach>		  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<form id="categoryForm">
		      			<input type="hidden" name="blogId" value="${blogId}"/>
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="title"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="description"></td>
			      		</tr>
			      		<tr>
			      			<td class="s">&nbsp;</td>
			      			<td><input type="submit" value="카테고리 추가"></td>
			      		</tr>
			      	</form>	      		      		
		      	</table> 
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blog-footer.jsp" />
	</div>
	<script>
	$(function(){
		$('input[type=submit]').click(function(event){
			event.preventDefault();
			var form = $("#categoryForm");
			console.log("test");	
			$.ajax({
				url: "${pageContext.servletContext.contextPath}/${blogId}/admin/category", 
				type: "post", 
				dataType: "text",
				data: form.serialize(),
				success: function(response){
					if(response.result != "success"){
						console.log(response);
						location.reload();
						return;
					}
					console.log(response);
					if(response.data == true){
						console.log("ajax :" + response.data);
						location.reload();
						return;
					}
					
				},
				error: function(xhr, error){
					console.error("error:" + error);
				}
			});
		});
		$(".deleteImg").click(function(event){
			var categoryNo = $(this).closest("tr").data("no");
			$.post("${pageContext.servletContext.contextPath}/${blogId}/admin/category/remove",
			        {categoryNo: categoryNo},
			        function(data){
			        	console.log(data);
			        	location.reload();
			       	});
		});
	});
	</script>
</body>
</html>