<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL='admin.jsp'"/>


<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/addProductCompleteAction.css">

<title>商品追加完了画面</title>

<!-- URLの直打対策 -->
<script type="text/JavaScript" src="./js/transitionControl.js"></script>

</head>
<body>

	<jsp:include page="adminHeader.jsp"/>
	<div class="contents">
		<h1>商品追加完了画面</h1>
		<div class="contents-sub">
			<div class="success">
				<strong>商品追加が完了しました。</strong><br><br><br>
				<strong>3秒後に管理者画面に戻ります</strong>
			</div>
		</div>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>