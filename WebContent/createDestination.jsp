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

<title>宛先情報入力</title>
</head>
<body>
<div id="page2">
<jsp:include page="header.jsp"/>


<div id="contents_sub">
<h1>宛先情報入力画面</h1>

<s:form action="CreateDestinationConfirmAction">
<table class="vertical-list-table">


<tr>
	<th scope="row" id="input_form"><s:label value="姓" /></th>
		<td><s:textfield name="familyName" class="txt" placeholder="姓" />
		</td>
</tr>


<tr>
	<td colspan="2">
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
<tr>


<tr>
	<th scope="row" id="input_form"><s:label value="名"/></th>
		<td><s:textfield name="firstName" class="txt" placeholder="名" />
		</td>
</tr>


<tr>
	<td colspan="2">
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>


<tr>
	<th scope="row" id="input_form"><s:label value="姓かな"/></th>
		<td><s:textfield name="familyNameKana" class="txt" placeholder="姓かな"/>
		</td>
</tr>


<tr>
	<td colspan="2">
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property/><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="名かな"/></th>
		<td><s:textfield name="firstNameKana" class="txt" placeholder="名かな"/>
		</td>
</tr>

<tr>
	<td colspan="2">
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>


<tr>

	<th scope="row" id="input_form"><s:label value="性別"/></th>
			<td><s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/>


</tr>


<tr>
	<th scope="row" id="input_form"><s:label value="住所"/></th>
		<td><s:textfield name="userAddress" class="txt" placeholder="住所"/>
		</td>
</tr>


<tr>
	<td colspan="2">
			<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="電話番号"/></th>
		<td><s:textfield name="telNumber" class="txt" placeholder="電話番号"/>
		</td>
</tr>


<tr>
	<td colspan="2">
			<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>

<tr>
	<th scope="row" id="input_form"><s:label value="メールアドレス"/></th>
		<td><s:textfield name="email" class="txt" placeholder="メールアドレス"/>
		</td>
</tr>

<tr>
	<td colspan="2">
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
	</td>
</tr>

</table>

<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="宛先情報確認" class="submit_btn" />
</div>
</div>
</s:form>
</div>

</div>
<s:include value="footer.jsp"/>
</body>
</html>