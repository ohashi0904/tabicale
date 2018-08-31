<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<meta http-equiv="refresh" content="3;URL='HomeAction'" />
<title>決済完了</title>
</head>
<body>
<div id=page>
<jsp:include page="header.jsp" />
<div id="contents_sub">
	<h1>決済完了画面</h1>
	<div class="success">
		決済が完了しました。
	</div>
</div>
</div>
<s:include value="footer.jsp" />
</body>
</html>