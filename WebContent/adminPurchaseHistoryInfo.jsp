<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/adminList.css">
<title>管理者購入履歴情報一覧画面</title>

<!-- URLの直打対策 -->
<script type="text/JavaScript" src="./js/transitionControl.js"></script>

</head>
<body>
<div id="page">
<jsp:include page="adminHeader.jsp" />
<h1>購入履歴情報一覧</h1>
<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
		<table border="1" class="admin_list">
			<thead>
				<tr>
					<th><s:label value="id"/></th>
					<th><s:label value="user_id"/></th>
					<th><s:label value="product_id"/></th>
					<th><s:label value="product_count"/></th>
					<th><s:label value="price"/></th>
					<th><s:label value="destinationId"/></th>
					<th><s:label value="regist_date"/></th>
					<th><s:label value="update_date"/></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.purchaseHistoryInfoDtoList">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="userId"/></td>
						<td><s:property value="productId"/></td>
						<td><s:property value="productCount"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="destinationId"/></td>
						<td><s:property value="registDate"/></td>
						<td><s:property value="updateDate"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
</s:if>
<s:else>
	<div>
		<h1>購入履歴情報はありません</h1>
	</div>
</s:else>
</div>
<s:include value="footer.jsp"/>
</body>
</html>