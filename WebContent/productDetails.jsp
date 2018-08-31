<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/productDetails.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
<script>
document.getElementById("ex_out").addEventListener("mouseover", function(){
	document.getElementById("ex_menu").style.display = 'block';
}, false);

document.getElementById("ex_out").addEventListener("mouseout", function(){
	document.getElementById("ex_menu").style.display = 'none';
}, false);
</script>
<title>商品詳細</title>
</head>
<body>
<div id="page">
<div><jsp:include page="header.jsp" /></div>
<div id= "contents">
<h1>商品詳細画面</h1>
     <div><s:form action= "AddCartAction">
     <div class="box1">
         <div class= "2column-container">
            <div class = "left">
                <div class="gazo1">
                	<a href='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' data-lightbox="sample" data-title="かれんだー">
                		<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' class= "image_main1"/>
                	</a>
                </div>
                <div class="gazo2">
                	<a href='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName2}"/>' data-lightbox="sample" data-title="かれんだー">
                		<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName2}"/>' class= "image_main2"/>
                	</a>
               </div>
            </div>
            <div class="right">

                <table style="table-layout: fixed;" class="vertical-list-table">
                     <tr>
                           <th scope= "row"><s:label value="商品名"/></th>
                           <td><div class="productdetails"><s:property value="%{#session.productName}"/></div></td>
                     </tr>
                     <tr>
                          <th scope="row"><s:label value="商品名かな"/></th>
                          <td><div class="productdetails"><s:property value="%{#session.productNameKana}"/></div></td>
                     </tr>
                     <tr>
                          <th scope="row"><s:label value= "値段"/></th>
                          <td><s:property value= "%{#session.price}"/>円</td>
                     </tr>
                     <tr>
                          <th scope="row"><s:label value= "購入個数"/></th>
                          <td><s:select name="productCount" list= "%{#session.productCountList}"/>個</td>
                     </tr>
                     <tr>
                          <th scope= "row"><s:label value= "発売会社名"/></th>
                          <td><div class="productdetails"><s:property value= "%{#session.releaseCompany}"/></div></td>
                     </tr>
                     <tr>
                          <th scope="row"><s:label value="発売年月日"/></th>
                          <td><s:property value="%{#session.releaseDate}"/></td>
                     </tr>
                     <tr>
                          <th scope="row"><s:label value="商品詳細"/></th>
                          <td><div class="productdetails"><s:property value="%{#session.productDescription}"/></div></td>
                     </tr>

                 </table>

            </div>

       </div>

     <s:hidden name="productId" value="%{#session.productId}"/>
     <s:hidden name="productName" value="%{#session.productName}"/>
     <s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
     <s:hidden name="imageFilePath" value="%{#session.imageFIlePath}"/>
     <s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
     <s:hidden name="price" value="%{#session.price}"/>
     <s:hidden name="releaseCompany" value="%{#session.releaseCompany}"/>
     <s:hidden name="releaseDate" value="%{#session.releaseDate}"/>
     <s:hidden name="productDescription" vslue="%{#session.productDescription}"/>
     <s:hidden name="checkRandomId" vslue="checkRandomId"/>
     <s:token />
     </div>
     <div class="submit_btn_box">
     <s:submit value="カートに追加" class="submit_btn"/>
     </div>

     </s:form></div>

     <div class="box2">
<!--      <div class="product-details-recomment-box"> -->
     <s:if test="#session.productInfoDtoList.size()!=0">
     <s:iterator value="#session.productInfoDtoList">

           <div class="recommend-box">
           <div>
           <a href='<s:url action="ProductDetailsAction">
           <s:param name="productId" value="%{productId}"/>
           </s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-100"/></a>
           </div>
           <div class="sub">
           <s:property value="productName"/></div>
           </div>


     </s:iterator>
     </s:if>
     <s:else>
     <div class="no-item">関連商品はありません</div>
     </s:else>

<!--      </div> -->
     </div>

</div>
</div>
<s:include value="footer.jsp"/>

</body>
</html>