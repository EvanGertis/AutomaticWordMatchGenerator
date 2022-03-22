<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <script src="${pageContext.request.contextPath}/static/js/main.js"></script>
</head>
<body>
    <div>
        <h1>${exercise.question}</h1>
        <embed class="editor" src="http://localhost:8080/HelloWorld.txt">
        <ul class="answers">
            <li id="a">${exercise.a}</li>
            <li id="b">${exercise.b}</li>
            <li id="c">${exercise.c}</li>
        </ul>
    </div>
</body>
</html>
