<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />

<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/createDestination.css">
<link rel="stylesheet" href="./css/createDestinationConfirm.css">





<title>宛先情報確認</title>
</head>
<body>
<div id="page2">
<jsp:include page="header.jsp" />
<div id="contents_sub">
<h1>宛先情報確認画面</h1>
<s:form action="CreateDestinationCompleteAction">
<table class="vertical-list-table" border="1">
<tr>
	<th scope="row" id="input_form"><s:label value="姓"/></th>
	<td><s:property value="familyName"/><s:hidden name="familyName" value="%{familyName}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="名"/></th>
	<td><s:property value="firstName"/><s:hidden name="firstName" value="%{firstName}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="姓ふりがな"/></th>
	<td><s:property value="familyNameKana"/><s:hidden name="familyNameKana" value="%{familyNameKana}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="名ふりがな"/></th>
	<td><s:property value="firstNameKana"/><s:hidden name="firstNameKana" value="%{firstNameKana}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="性別"/></th>
	<td><s:property value="sex"/><s:hidden name="sex" value="%{sex}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="住所"/></th>
	<td><s:property value="userAddress"/><s:hidden name="userAddress" value="%{userAddress}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="電話番号"/></th>
	<td><s:property value="telNumber"/><s:hidden name="telNumber" value="%{telNumber}"/></td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="メールアドレス"/></th>
	<td><s:property value="email"/><s:hidden name="email" value="%{email}"/></td>
</tr>


</table>

<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="宛先情報登録" class="submit_btn"/>
</div>
</div>
<s:token/>
</s:form>
</div>
</div>
<s:include value="footer.jsp" />
</body>
</html>