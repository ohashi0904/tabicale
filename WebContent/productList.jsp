<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/productList.css">
<title>商品一覧</title>
</head>
<body>
	<div id="page">
		<jsp:include page="header.jsp" />
		<div id="contents">
			<h1>商品一覧画面</h1>
			<s:if test="productInfoDtoList==null">
				<div class="title">検索結果がありません。</div>
			</s:if>
			<s:else>
				<div id="product-list">
					<s:iterator value="#session.productInfoDtoList">
						<div class="product-list-box">
							<ul>
								<li><a
									href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/></s:url>'>
										<img
										src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
										class="item-image-box-200" alt="" />
								</a>
									<div class="product-list-tag">
										<s:property value="productName" />
										<br>
									</div>
									<div class="product-list-tag">
										<s:property value="productNameKana" />
										<br>
									</div>
									<div class="product-list-tag">
										<s:property value="price" />
										円<br>
									</div></li>
							</ul>
						</div>
					</s:iterator>
				</div>
				<div id="pageNumber">
					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test="#session.currentPageNo == #pageNo.count">
							<a class="pageNo"> <s:property value="%{#pageNo.count}" />
							</a>
						</s:if>
						<s:else>
							<a class="pageNo"
								href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/><s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/></s:url>"><s:property
									value="%{#pageNo.count}" /></a>
									</>
						</s:else>
					</s:iterator>

				</div>
			</s:else>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>