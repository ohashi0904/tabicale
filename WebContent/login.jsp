<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/form.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.1.0.min.js"></script>

<title>ログイン</title>
<script>
	function goLoginAction() {
		document.getElementById("form").action = "LoginAction";
	}
	function goCreateUserAction() {
		document.getElementById("form").action = "CreateUserAction";
	}
	function goResetPasswordAction() {
		document.getElementById("form").action = "ResetPasswordAction";
	}
	function reloadCheck() {
		if (window.name != "xyz") {
			alert("リロードしました");
			location.reload();
			window.name = "xyz";
		}
	}
</script>
</head>
<body>
	<div id="page2">
		<jsp:include page="header.jsp" />

		<div id="contents_sub">
			<h1>ログイン画面</h1>
			<s:form id="form" action="LoginAction">
				<s:hidden name="settlementFlag" value="%{settlementFlag}" />


				<!--
	SAVED:<s:property value="%{#session.savedLoginId}"/>
	LOGINID:<s:property value="%{#session.loginId}"/>
-->

				<table class="vertical-list-table">
					<tr>
						<th scope="row"><s:label value="ログインID:" /></th>
						<s:if test="#session.savedLoginId==true">
							<td><s:textfield name="loginId" class="txt"
									placeholder="ログインID" value='%{#session.saveId}'
									autocomplete="off" /></td>
						</s:if>
						<s:else>
							<td><s:textfield name="loginId" class="txt"
									placeholder="ログインID" autocomplete="off" /></td>
						</s:else>
					</tr>

					<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
						<tr>
							<td colspan="2">
								<div class="error">
									<div class="error-message">
										<s:iterator value="#session.loginIdErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</td>
						</tr>
					</s:if>

					<tr>
						<th scope="row"><s:label value="パスワード:" /></th>
						<td><s:password name="password" class="txt"
								value="" placeholder="パスワード" autocomplete="off" /></td>
					</tr>

					<s:if test="!#session.passwordErrorMessageList.isEmpty()">
						<tr>
							<td colspan="2">
								<div class="error">
									<div class="error-message">
										<s:iterator value="#session.passwordErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</td>
						</tr>
					</s:if>

					<s:elseif
						test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
						<tr>
							<td colspan="2">
								<div class="error">
									<div class="error-message">
										<s:iterator value="#session.passwordIncorrectErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</td>
						</tr>
					</s:elseif>

				</table>

				<div class="box">
					<s:if test="#session.savedLoginId==true">
						<s:checkbox name="savedLoginId" checked="checked" />
					</s:if>
					<s:else>
						<s:checkbox name="savedLoginId" />
					</s:else>
					<s:label value="ログインID保存" />
					<br>
				</div>

				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="ログイン" class="submit_btn"
							onclick="goLoginAction();" />
					</div>
				</div>
			</s:form>
			<br>
			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:form action="CreateUserAction">
						<s:submit value="新規ユーザー登録" class="submit_btn" />
					</s:form>
				</div>
			</div>

			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:form action="ResetPasswordAction">
						<s:submit value="パスワード再設定" class="submit_btn" />
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>