<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link rel="stylesheet" href="./css/tabicale.css">
<link rel="stylesheet" href="./css/home.css">

<title>ホーム</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <script>

  jQuery(function($){
	    $(document).ready(function(){
	      $('.slider').bxSlider({
	    	  auto:true,
	    	  mode:'fade',
	    	  speed:1000,
	    	  pause: 3000,
	    	  controls: false,
	    	  pager: false
	      });
	    });
	  });

  </script>


</head>
<body>

<div id="home_menu" style=z-index:1000;>
<jsp:include page="header.jsp" />
</div>

<div class="slider">

        <div><img src="images/slideshow_01.jpg"></div>
        <div><img src="images/slideshow_02.jpg"></div>
        <div><img src="images/slideshow_03.jpg"></div>
        <div><img src="images/slideshow_04.jpg"></div>
        <div><img src="images/slideshow_05.jpg"></div>
        <div><img src="images/slideshow_06.jpg"></div>

    </div>

    <div id="contents_home">

    <div class="chuo_yose">

	<h1>世界をめくろう。</h1><br>

	<p>旅好きな僕たちが作りたいのは</p>
	<p>見ているだけで旅に出たくなるモノ。</p><br>
    <p>何気ない日常にも世界を感じさせるモノ。</p><br>
	<p>それは世界の"カレンダー"</p>


	<p>そして、人と人が繋がる</p>
	<p>グローバルな時代だからこそ、</p>
	<p>僕たちは、みんなで世界を感じられるモノを</p>
	<p>作りたい。</p><br>

	<h1>TABICALE</h1><br>


    <p>それは、カレンダーをめくると世界をめぐる</p><br>
	<p>旅のカレンダーブランド</p><br>

	</div>
    </div>
<s:include value="footer.jsp" />
</body>
</html>