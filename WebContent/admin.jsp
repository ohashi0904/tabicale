<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/admin.css">
<title>管理者画面</title>

<!-- URLの直打対策 -->
<script type="text/JavaScript">
var refinfo=document.referrer;

if (refinfo){

	}else{
	window.location.href="home.jsp";
}

history.replaceState('','','admin.jsp');
</script>

<style type="text/css">

</style>
</head>
<body>
<div id="page2">
<jsp:include page="adminHeader.jsp"/>
<h1>管理者トップ</h1>

<div class="contents-nav1">
	<a href="<s:url action='AdminProductInfoAction'/>">商品情報一覧</a>
	<a href="<s:url action='AdminUserInfoAction'/>">ユーザー情報一覧</a>
	<a href="<s:url action='AdminDestinationInfoAction'/>">宛先情報一覧</a>
</div>
<div class="contents-nav2">
	<a href="<s:url action='AdminPurchaseHistoryInfoAction'/>">購入履歴情報一覧</a>
	<a href="<s:url action='AdminCartInfoAction'/>">カート情報一覧</a>
</div>

</div>
<s:include value="footer.jsp"/>
</body>
</html>