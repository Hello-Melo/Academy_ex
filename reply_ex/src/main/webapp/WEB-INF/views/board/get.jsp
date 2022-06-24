<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jspf" %>
<div class="container">
	<div class="title">
		<h2>제목 : ${board.title}</h2>
	</div>
	<div class="content">
		내용 : <p>${board.content}</p>
	</div>
	<div>
		작성자 : ${board.writer}	
	</div>
	<a href="list" class="list">목록으로</a>	
</div>
<style>
	.container div {outline: 1px solid blue; padding : 10px 0;}
	.list { padding: 5px 0; display: inline-block;}
</style>
<%@ include file="../layout/footer.jspf" %>