<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <script src="${pageContext.request.contextPath}/static/js/main.js"></script>
</head>
<body>
    <div>
        Exercise id: ${exercise.id}<br>
        Chapter id: ${exercise.chapterId}<br>
        Exercise: ${exercise.exercise}<br>
        Answer: ${exercise.answer}<br>
    </div>
</body>
</html>
