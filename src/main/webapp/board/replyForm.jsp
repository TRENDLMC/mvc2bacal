<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='contextPath' value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}

	function fn_enable(obj) {
		document.getElementById("i_title").disabled = false;
		document.getElementById("i_content").disabled = false;
		document.getElementById("i_imageFileName").disabled = false;
		document.getElementById("tr_btn_modify").style.display = "block";
		document.getElementById("tr_btn").style.display = "none";
	}

	function fn_modify_article(obj) {
		obj.action = "${contextPath}/board/modArticle.do";
		obj.submit();
	}

	function fn_remove_article(url, articleNO) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		var articleNOInput = document.createElement("input");
		articleNOInput.setAttribute("type", "hidden");
		articleNOInput.setAttribute("name", "articleNO");
		articleNOInput.setAttribute("value", articleNO);
		form.appendChild(articleNOInput);
		document.body.appendChild(form);
		form.submit();

	}
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function fn_reply_form(url, parentNO) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		var parentNOInput = document.createElement("input");
		parentNOInput.setAttribute("type", "hidden")
		parentNOInput.setAttribute("name", "parentNO")
		parentNOInput.setAttribute("value", parentNO);
		form.appendChild(parentNOInput);
		document.body.appendChild(form);
		form.submit();
	}
</script>
</head>
<body>
	<h1 style='text-align: center;'>답글 쓰기</h1>
	<form name='frmReply' method='post'
		action='${contextPath}/board/addReply.do'
		enctype='multipart/form-data'>
		<table align='center'>
			<tr>
				<td align='right'>글쓴이:&nbsp;</td>
				<td><input type='text' size='5' value='lee' disabled /></td>
			</tr>
			<tr>
				<td align='right'>글제목:&nbsp;</td>
				<td><input type='text' size='67' maxlength='100' name='title' /></td>
			</tr>
			<tr>
				<td align='right' valign='top'><br>글내용:&nbsp;</td>
				<td><textarea name='content' rows="10" cols="65"
						maxlength="4000"></textarea></td>
			</tr>
			<tr>
				<td align='right'>이미지파일 첨부:</td>
				<td><input type='file' name='imageFileName'
					onchange='readURL(this);' /></td>
				<td><img id='preview' src='#' width=200 height=200 /></td>
			</tr>
			<tr>
				<td align='right'></td>
				<td><input type='submit' value='답글 반영하기' /> <input
					type='button' value='취소' onclick="backToList(this.form)" /></td>

			</tr>
		</table>
	</form>
</body>
</html>