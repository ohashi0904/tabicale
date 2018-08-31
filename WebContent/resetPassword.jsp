<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/form.css">

<title>パスワード再設定</title>
</head>
<body>
<div id="page2">
<jsp:include page="header.jsp" />
<div id="contents_sub">
<h1>パスワード再設定画面</h1>

<s:form action="ResetPasswordConfirmAction">
	<table class="vertical-list-table">
		<tr>
			<th scope="row"><s:label value="ログインID"/></th>
			<s:if test="#session.savedLoginId==true">
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.saveId}' autocomplete="off"/></td>
			</s:if>
			<s:else>
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplete="off"/></td>
			</s:else>
		</tr>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.loginIdErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>
			<s:if test="!#session.adminPasswordErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.adminPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>

		<tr>
			<th scope="row"><s:label value="現在のパスワード"/></th>
			<td><s:password name="password" value="" placeholder="現在のパスワード" class="txt" /></td>
		</tr>
<s:if test="!#session.passwordErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.passwordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>
		<s:if test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.passwordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>
		<tr>
			<th scope="row"><s:label value="新しいパスワード"/></th>
			<td><s:password name="newPassword" value="" placeholder="新しいパスワード" class="txt" /></td>
		</tr>
		<tr>
			<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.newPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>
			<th scope="row"><s:label value="（再確認用）"/></th>
			<td><s:password name="reConfirmationPassword" value="" placeholder="新しいパスワード（再確認用）" class="txt" /></td>
		</tr>
		<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>
		<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
	<tr>
	<td colspan="2">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</td>
		</tr>
	</s:if>

		</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="パスワード再設定" class="submit_btn" />
</div>
</div>
</s:form>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>