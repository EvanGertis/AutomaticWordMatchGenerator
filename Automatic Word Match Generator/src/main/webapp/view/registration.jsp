<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div>
    	<label id="registration-notification" style='display: none;'>Successfully Registered</label>
    	<label id="unsuccessful-registration-notification" style='display: none;'>Unsuccesful Registration</label>
		<table style="with: 50%">
			<tr>
				<td>Username</td>
				<td><input id="username" type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Billing Address</td>
				<td><input id="billing_address" type="text" name="billing_address" /></td>
			</tr>
			<tr>
				<td>Billing Province</td>
				<td><input id="billing_province" type="text" name="billing_province" /></td>
			</tr>
			<tr>
				<td>Billing Country</td>
				<td><input id="billing_country" type="text" name="billing_country" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input id="phone_number" type="text" name="phone_number" /></td>
			</tr>
			<tr>
				<td>Zip</td>
				<td><input id="zip" type="text" name="zip" /></td>
			</tr>
		</table>
		<input id="submit" class="btn btn-primary" type="submit" value="Submit" />
    </div>
</body>
</html>
<script src="${pageContext.request.contextPath}/static/js/registration.js"></script>
<%@ include file="footer.jsp" %>
