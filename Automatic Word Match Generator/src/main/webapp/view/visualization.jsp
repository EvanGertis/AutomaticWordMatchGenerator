<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title>Tree Traversals</title>
<!-- stuff for styling -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
<!-- stuff for d3 -->
<script src="${pageContext.request.contextPath}/static/js/d3.v3.5.5.min.js" charset="utf-8"></script>
<!-- data stuff -->
<script src="${pageContext.request.contextPath}/static/js/data.js"></script>

<body>
	<div id="title">Tree Traversals</div>
	<div id="button-wrapper">
		<button id="dft" onclick="dft()">Depth First</button>
		<button id="bft" onclick="bft()">Breadth First</button>
		<button id="reset" onclick="resetTraversal()">Reset</button>
	</div>
	<div id="tree-container"></div>
	<a href="/exercises/show/${visualization.exerciseId}">Go back to exercise</a>
</body>

<script src="${pageContext.request.contextPath}/static/js/treeTraversal.js"></script>
<%@ include file="footer.jsp" %>