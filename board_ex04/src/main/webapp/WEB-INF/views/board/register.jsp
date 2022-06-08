<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    
    <div class="container">

<form action="${contextPath}/board/register" method="post">
제목 : <input type="text" name="title">
작성자 : <input type="text" name="writer"><Br>
본문 : <textarea rows="30" cols="70" name="contents"></textarea>
<button>글쑤끼</button> 
</form>

</div>
    
    
  <%@ include file="/WEB-INF/views/layout/footer.jsp" %>