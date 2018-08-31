<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/cart.css">
<title>カート画面</title>
<script type="text/javascript">
	function goDeleteCartAction() {
		document.getElementById("form").action='DeleteCartAction';
	}
	history.forward();
</script>
</head>
<body>
<div id="page">
<jsp:include page="header.jsp" />
<div id="contents">
<h1>カート画面</h1>
<s:if test="#session.checkListErrorMessageList != null">
	<div  class="error-message">
	<s:iterator value='#session.checkListErrorMessageList'>
		<s:property />
	</s:iterator>
	</div>
</s:if>

<s:if test="#session.cartInfoDtoList.size()>0">
	<s:form id="form" action="SettlementConfirmAction">
		<table style="table-layout: fixed;" class="horizontal-list-table" border="1">
			<thead>
				<tr>
					<th><s:label value="#"/></th>
					<th><s:label value="商品名"/></th>
					<th><s:label value="ふりがな"/></th>
					<th><s:label value="商品画像"/></th>
					<th><s:label value="値段"/></th>
					<th><s:label value="発売会社名"/></th>
					<th><s:label value="発売年月日"/></th>
					<th><s:label value="購入個数"/></th>
					<th><s:label value="合計金額"/></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.cartInfoDtoList">
					<tr>
						<td><s:checkbox name="checkList" value="checked" fieldValue="%{productId}"/></td>
						<s:hidden name="productId" value="%{productId}"/>
						<td><div class="cartdetails"><s:property value="productName"/></div></td>
						<td><div class="cartdetails"><s:property value="productNameKana"/></div></td>
						<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="100%" height="140px" /></td>
						<td><s:property value="price"/>円</td>
						<td><div class="cartdetails"><s:property value="releaseCompany"/></div></td>
						<td><s:property value="releaseDate"/></td>
						<td><s:property value="productCount"/></td>
						<td><s:property value="subtotal"/>円</td>
					</tr>
					<s:hidden name="productName" value="%{productName}"/>
					<s:hidden name="productNameKana" value="%{productNameKana}"/>
					<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
					<s:hidden name="imageFileName" value="%{imageFileName}"/>
					<s:hidden name="price" value="%{price}"/>
					<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
					<s:hidden name="releaseDate" value="%{releaseDate}"/>
					<s:hidden name="productCount" value="%{productCount}"/>
					<s:hidden name="subtotal" value="%{subtotal}"/>
				</s:iterator>
			</tbody>
		</table>
			<h1 id="cartTotalPrice">カート合計金額:<s:property value="#session.totalPrice"/>円</h1>
		<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:submit value="決済" class="submit_btn"/>
			</div>
		</div>
		<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:submit value="削除" class="submit_btn" onclick="this.form.action='DeleteCartAction'"/>
			</div>
		</div>
	</s:form>
</s:if>
<s:else>
	<div class="no_info_messeage">
		カート情報はありません
	</div>
</s:else>
</div>
</div>
	<s:include value="footer.jsp"/>
</body>
</html>