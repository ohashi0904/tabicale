<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/adminHeader.css">

<title>管理者画面</title>
<style type="text/css">

</style>
</head>
<body>
<div id="header">
	<div id="header-title">
		<img src="images/gray.jpeg" alt="" width="200%" />
	</div>
	<div class="contents-list">
		<ul class="nav">
			<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			<li><a>管理者機能一覧▼</a>
			<ul>
				<li><a href='<s:url action="AdminProductInfoAction"/>'>商品情報一覧</a></li>
				<li><a href='<s:url action="AdminUserInfoAction"/>'>ユーザー情報一覧</a></li>
				<li><a href='<s:url action="AdminDestinationInfoAction"/>'>宛先情報一覧</a></li>
				<li><a href='<s:url action="AdminPurchaseHistoryInfoAction"/>'>購入履歴情報一覧</a></li>
				<li><a href='<s:url action="AdminCartInfoAction"/>'>カート情報一覧</a></li>
			</ul></li>
			<li><a href="admin.jsp">管理者トップ</a></li>
		</ul>
	</div>
</div>

</body>
</html>