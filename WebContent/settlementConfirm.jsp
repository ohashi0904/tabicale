<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/settlementConfirm.css">
<title>決済確認</title>
<script>
	history.forward();
</script>
</head>
<body>
	<div id="page">
		<jsp:include page="header.jsp" />
		<div id="contents">
			<h1>決済確認画面</h1>
			<s:if test="#session.destinationInfoDtoList != null">
				<div class="info">送り先情報を選択してください。</div>
				<s:form id="form" action="SettlementCompleteAction">
					<table style="table-layout: fixed;">
						<thead>
							<tr>
								<th class="radio"><s:label value="#" /></th>
								<th class="name"><s:label value="名前" /></th>
								<th class="kana"><s:label value="ふりがな" /></th>
								<th class="address"><s:label value="住所" /></th>
								<th class="tel"><s:label value="電話番号" /></th>
								<th class="mail"><s:label value="メールアドレス" /></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.destinationInfoDtoList" status="st">
								<tr>
									<td class="#"><s:if test="#st.index == 0">
											<input type="radio" name="id" checked="checked"
												value="<s:property value='id'/>" />
										</s:if> <s:else>
											<input type="radio" name="id"
												value="<s:property value='id'/>" />
										</s:else></td>
									<td class="name"><s:property value="familyName" /><span>
									</span>
									<s:property value="firstName" /></td>
									<td class="kana"><s:property value="familyNameKana" /><span>
									</span>
									<s:property value="firstNameKana" /></td>
									<td class="address"><s:property value="userAddress" /></td>
									<td class="tel"><s:property value="telNumber" /></td>
									<td class="mail"><s:property value="email" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="submit_btn_box">
						<div id="contents-btn-set">
							<s:submit value="決済" class="submit_btn" />
						</div>
					</div>
					<s:token />
				</s:form>
			</s:if>
			<s:else>
				<div class="info">送り先情報を登録してください。</div>
			</s:else>

			<div class="submit_btn_box">
				<div id="contents-btn-set">
					<s:form action="CreateDestinationAction">
						<s:submit value="新規登録" class="submit_btn" />
					</s:form>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>