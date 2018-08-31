<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/purchaseHistory.css">
<title>商品購入履歴</title>
</head>
<body>
<div id="page">
<div>
<jsp:include page="header.jsp" />
</div>
<div id="contents">
<h1>商品購入履歴画面</h1>
<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
<table style="table-layout: fixed;" class="horizontal-list-table">
	<thead>
		<tr>
			<th><s:label value="商品名"/></th>
			<th><s:label value="ふりがな"/></th>
			<th><s:label value="商品画像"/></th>
			<th><s:label value="個数"/></th>
			<th><s:label value="値段"/></th>
			<th><s:label value="発売会社名"/></th>
			<th><s:label value="発売年月日"/></th>
		</tr>
	<tbody>
<s:iterator value="#session.purchaseHistoryInfoDtoList">
	<tr>
		<td><div class="historydetails"><s:property value="productName"/></div></td>
		<td><div class="historydetails"><s:property value="productNameKana"/></div></td>
		<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="image"/></td>
		<td><s:property value="productCount"/>個</td>
		<td><s:property value="price*productCount"/>円</td>
		<td><div class="historydetails"><s:property value="releaseCompany"/></div></td>
		<td><s:property value="releaseDate"/></td>
	</tr>
</s:iterator>
	</tbody>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:form action="DeletePurchaseHistoryAction">
	<s:submit value="削除" class="submit_btn" />
</s:form>
</div>
</div>
</s:if>
<s:else>
<div class="info">
商品購入履歴情報はありません。
</div>
</s:else>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>