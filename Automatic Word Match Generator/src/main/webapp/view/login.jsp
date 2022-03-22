<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
		<table style="with: 50%">
			<tr>
				<td>Username</td>
				<td><input id="username" type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" type="password" name="password"></td>
			</tr>
		</table>
		<input id="submit" class="btn btn-primary" type="button" value="Submit" />
		<c:if test="${not empty userId}">
			<a id="show-view-account" class="btn btn-success" href="/account/show/${userId}">view account</a>
		</c:if>
    </div>
</body>
</html>
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
<%@ include file="footer.jsp" %>