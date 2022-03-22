<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Book</title>
    <link rel="stylesheet"
      href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/styles/default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <div>
        <h1>${book.getTitle()}</h1>
        <ul class="list-group">
        	<li class="list-group-item">Author: ${book.getAuthor()}</li>
        </ul>
        <label>Chapters</label> 
        <ul id="chapters" book-id="${book.getId()}">
        </ul>
        <c:if test="${not empty userId}">
        	<a class="btn btn-primary" href="/account/show/${book.accountId}">Go back to account</a>
        </c:if>
    </div>
</body>
</html>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/highlight.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/book.js"></script>
<%@ include file="footer.jsp" %>
