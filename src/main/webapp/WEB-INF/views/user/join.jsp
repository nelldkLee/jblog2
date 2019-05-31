<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	$('#blog-id').change(function(){
		$('#check-button').show();
		$('#check-image').hide();
	});
	
	$('#check-button').click(function(){
		var blogId = $('#blog-id').val();
		if(blogId == ''){
			return;
		}
			
		/* ajax 통신 */
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/user/checkId?id=" + blogId, 
			type: "get", 
			dataType: "json",
			success: function(response){
				if(response.result != "success"){
					console.log(response);
					return;
				}
				
				if(response.data == true){
					alert('이미 존재하는 아이디입니다.\n다른 아이디를 사용해 주세요.');
					$("#blog-id").focus();
					$("#blog-id").val("");
					return;
				}

				$('#check-button').hide();
				$('#check-image').show();
				
			},
			error: function(xhr, error){
				console.error("error:" + error)
			}
		});
		
	});	
});
</script>
</head>
<body>
	<div class="center-content">
		<jsp:include page="/WEB-INF/views/includes/user-header.jsp" />
		<form class="join-form" id="join-form" method="post" action="">
			<label class="block-label" for="name">이름</label>
			<spring:hasBindErrors name="userVo">
					    <c:if test="${errors.hasFieldErrors('name') }">
							<p style="font-weight:bold; color:red; text-align:left; padding:0">
					            <spring:message 
						     		code="${errors.getFieldError( 'name' ).codes[0] }" 				     
						     		text="${errors.getFieldError( 'name' ).defaultMessage }" />
					        </p> 
					   </c:if>
			</spring:hasBindErrors>
			<input id="name"name="name" type="text" value="">
			
			<label class="block-label" for="blog-id">아이디</label>
			<spring:hasBindErrors name="userVo">
					    <c:if test="${errors.hasFieldErrors('id') }">
							<p style="font-weight:bold; color:red; text-align:left; padding:0">
					            <spring:message 
						     		code="${errors.getFieldError( 'id' ).codes[0] }" 				     
						     		text="${errors.getFieldError( 'id' ).defaultMessage }" />
					        </p> 
					   </c:if>
			</spring:hasBindErrors>
			<input id="blog-id" name="id" type="text"> 
			<input id="check-button" type="button" value="id 중복체크">
			<img id="check-image" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
