<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>登録完了画面</title>
</head>
<body>
<div id="page2">
<jsp:include page="header.jsp" />
<div id="contents_sub">
<h1>登録完了画面</h1>
<div class="success">
ユーザー登録が完了しました。
</div>
</div>
</div>
<%-- <s:submit value="ログアウト" class="submit_btn" onclick="goLogoutAction();"/> --%>

		<%-- <div>
				<p><a href='<s:url action="HomeAction"/>'>ホームへ</a></p>
			</div> --%>
<s:include value="footer.jsp"/>

</body>
</html>