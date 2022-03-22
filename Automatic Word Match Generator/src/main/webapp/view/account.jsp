<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet"
      href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.7.1/styles/default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <div>
        <ul class="list-group">
        	<li class="list-group-item">AccountId: ${account.id}</li>
        	<li class="list-group-item">UserId: ${account.getUserId()}</li>
        	<li class="list-group-item">Billing Address: ${account.getBillingAddress()}</li>
        	<li class="list-group-item">Billing Province: ${account.getBillingProvince()}</li>
        	<li class="list-group-item">Billing Country: ${account.getBillingCountry()}</li>
        	<li class="list-group-item">Phone Number: ${account.getPhoneNumber()}</li>
        	<li class="list-group-item">Zip: ${account.getZip()}</li>
        </ul>
        <label>Books</label>
        <ul id="books" account-id="${account.getId()}"></ul> 
        <a href="/user/show/${account.getUserId()}">Go back to user account</a>
    </div>
</body>
</html>
<script src="${pageContext.request.contextPath}/static/js/account.js"></script>
<%@ include file="footer.jsp" %>
