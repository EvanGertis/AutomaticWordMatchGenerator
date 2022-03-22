<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Exercise</title>
    <link rel="stylesheet"
      href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/styles/default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <div>
        <h1>${exercise.question}</h1>
        <c:if test="${fn:contains(exercise.exercise, 'PNG')}">
        	<img src="${pageContext.request.contextPath}/static/images/${exercise.exercise}/"/>
        </c:if>
        <c:if test="${fn:contains(exercise.exercise, 'txt')}">
       		<iframe class="editor language-java" src="/${exercise.exercise}/"></iframe>
        </c:if>
        <div>
	       	<label>Please click on an answer to see if your selection is correct.</label>
	        <ul class="answers" class="list-group" exercise-id="${exercise.id}">
	            <li id="a" class="btn list-group-item" value="1">${exercise.one}</li>
	            <li id="b" class="btn list-group-item" value="2">${exercise.two}</li>
	            <li id="c" class="btn list-group-item" value="3">${exercise.three}</li>
	        </ul>
        </div>
        <c:if test="${exercise.hasVisualization}">
        	<a class="btn btn-primary" href="/visualization/show/${exercise.id}">click here to see a visualization</a>
        </c:if>
        <a class="btn btn-primary" href="/chapter/show/${exercise.chapterId}">Go back to chapter</a>
    </div>
</body>
</html>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/highlight.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<%@ include file="footer.jsp" %>