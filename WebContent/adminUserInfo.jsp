<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/adminList.css">
<title>管理者ユーザー情報一覧画面</title>

<!-- URLの直打対策 -->
<script type="text/JavaScript" src="./js/transitionControl.js"></script>

</head>
<body>
<div id="page">
<jsp:include page="adminHeader.jsp" />
<h1>ユーザー情報一覧</h1>
<s:if test="#session.userInfoDtoList.size()>0">
		<table border="1" class="admin_list">
			<thead>
				<tr>
					<th><s:label value="id"/></th>
					<th><s:label value="user_id"/></th>
					<th><s:label value="password"/></th>
					<th><s:label value="family_name"/></th>
					<th><s:label value="first_name"/></th>
					<th><s:label value="family_name_kana"/></th>
					<th><s:label value="first_name_kana"/></th>
					<th><s:label value="sex"/></th>
					<th><s:label value="email"/></th>
					<th><s:label value="status"/></th>
					<th><s:label value="logined"/></th>
					<th><s:label value="regist_date"/></th>
					<th><s:label value="update_date"/></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.userInfoDtoList">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="userId"/></td>
						<td><s:property value="password"/></td>
						<td><s:property value="familyName"/></td>
						<td><s:property value="firstName"/></td>
						<td><s:property value="familyNameKana"/></td>
						<td><s:property value="firstNameKana"/></td>
						<td><s:property value="sex"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="status"/></td>
						<td><s:property value="logined"/></td>
						<td><s:property value="registDate"/></td>
						<td><s:property value="updateDate"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
</s:if>
<s:else>
	<div>
		<h1>ユーザー情報はありません</h1>
	</div>
</s:else>
</div>
<s:include value="footer.jsp"/>
</body>
</html>