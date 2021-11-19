<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>晨曦拍卖网-促销专场</title>
<!--CSS-->
<link rel="stylesheet" href="/sale/resources/css/styles.css" />
<!--Google Webfont -->
<link href='http://fonts.googleapis.com/css?family=Istok+Web' rel='stylesheet' type='text/css' />
<!--Javascript-->
<script type="text/javascript" src="/sale/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.easing.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="/sale/resources/js/form_elements.js"></script>
<script type="text/javascript" src="/sale/resources/js/custom.js"></script>
<!--[if lt IE 9]>
    <script src="js/html5.js"></script>
<![endif]-->
<!-- mobile setting -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<script type="text/javascript">
  window.onload=function(){
	    var sa_bars= document.getElementsByName('sa_bar');
	    for(var i=0;i<sa_bars.length;i++){
	    	 if(i==1){
	    		 document.getElementsByName('sa_bar')[1].className='active';  
	    	 }else{
	    		 document.getElementsByName('sa_bar')[i].className=''; 
	    	 }
	    } 
  }
</script>
<div class="wrapper">
    <jsp:include page="common/top.jsp" flush="true"/> 
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <!--SIDE NAV STARTS-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1>促销</h1>
                    <jsp:include page="common/left.jsp" flush="true"/> 
                </div>
            </div>
            <!--SIDE NAV ENDS-->
            <!--MAIN CONTENT STARTS-->
            <div id="main_content">
                <div class="category_banner"> <img src="/sale/resources/images/promo_cat_banner.jpg" /> </div>
                <ul class="breadcrumb">
                    <li><a href="/sale/index/toIndex">首页</a></li>
                    <li class="active"><a href="javascript:;">促销</a></li>
                </ul>
                <!--Product List Starts-->
                <div class="products_list products_slider">
                    <ul>
                    <c:forEach var="cxproduct" items="${cxlist}" varStatus="status">
                        <li> <a href="javascript:cxdetail(${cxproduct.id });" class="product_image"><img src="/sale/${cxproduct.img}" style="width: 216px;height: 245px;"/></a>
			              <div class="product_info">
			                  <h3><a href="javascript:cxdetail(${cxproduct.id });">${cxproduct.name }</a></h3>
			                  <small>${cxproduct.content }</small> </div>
			             
			              <div class="price_info"> <a href="javascript:addCart('${cxproduct.id }','${cxproduct.newprice }');">+ 加入收藏</a>
			                  <button class="price_add" onclick="addCart('${cxproduct.id }','${cxproduct.newprice }');" title="" type="button"><span class="pr_price">¥${cxproduct.newprice }</span><span class="pr_add">加入购物车</span></button>
			              </div>
			            </li>
                    </c:forEach>
                    </ul>
                </div>
                <!--Product List Ends-->
            </div>
            <!--MAIN CONTENT ENDS-->
        </section>
        <!--Mid Section Ends-->
    </div>
    <jsp:include page="common/buttom.jsp" flush="true"/> 
</div>

</body>
</html>
