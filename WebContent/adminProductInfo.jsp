<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<title>管理者商品情報一覧画面</title>

<!-- URLの直打対策 -->
<script type="text/JavaScript" src="./js/transitionControl.js"></script>
<script type="text/javascript">
	function alertFunction(){

		if(window.confirm('本当に非表示にしますか？')){ // 確認ダイアログを表示

			return true; // 「OK」時は送信を実行

		}
		else{ // 「キャンセル」時の処理

			return false; // 送信を中止

		}

	}
</script>

</head>

<body>
<div id="page">

<jsp:include page="adminHeader.jsp"/>

<div id="contents">
<h1>商品情報一覧</h1>

<s:if test="#session.productInfoDtoList.size()>0">

<table style="table-layout: fixed;" class="horizontal-list-table" border="1">
<thead>
<tr>
<th style="width:180px;"><s:label value="非表示化"/></th>
<th><s:label value="商品名"/></th>
<th><s:label value="ふりがな"/></th>
<th><s:label value="商品画像"/></th>
<th><s:label value="商品画像2"/></th>
<th><s:label value="値段"/></th>
<th><s:label value="発売会社名"/></th>
<th><s:label value="発売年月日"/></th>
</tr>
</thead>
<tbody>
<s:iterator value="#session.productInfoDtoList">
<tr>
<td id="delete_btn"><s:form action="DeleteProductAction">
<s:if test='status==0'>
<s:hidden name="productId" value="%{productId}"/>
<input type ="submit" class="submit_btn" value="非表示にする" onclick="return alertFunction()"  />
</s:if>
<s:else>
<p style="text-align:center">非表示</p>
</s:else>
</s:form></td>
<s:if test='status==0'>
<td class="details"><s:property value="productName"/></td>
<td class="details"><s:property value="productNameKana"/></td>
<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'width="80px" height="80px"/></td>
<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName2"/>'width="80px" height="80px"/></td>
<td><s:property value="price"/>円</td>
<td class="details"><s:property value="releaseCompany"/></td>
<td><s:property value="releaseDate"/></td>
</s:if>
<s:else>
<td class="details" bgcolor="pink"><s:property value="productName"/></td>
<td class="details" bgcolor="pink"><s:property value="productNameKana"/></td>
<td bgcolor="pink"><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'width="80px" height="80px"/></td>
<td bgcolor="pink"><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName2"/>'width="80px" height="80px"/></td>
<td bgcolor="pink"><s:property value="price"/>円</td>
<td class="details" bgcolor="pink"><s:property value="releaseCompany"/></td>
<td bgcolor="pink"><s:property value="releaseDate"/></td>
</s:else>
</tr>

</s:iterator>
</tbody>

</table>

</s:if>

<div class="submit_btn_box">
<s:form action="AddProductAction">
<input type="submit" class="submit_btn" value="商品追加"/>
</s:form>
</div>
</div>

<s:else>
<div class="info">
商品情報はありません。
</div>
</s:else>
</div>
<s:include value="footer.jsp"/>
</body>

</html>