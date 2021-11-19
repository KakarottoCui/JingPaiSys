<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>晨曦拍卖网-秒杀专区</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>
<script type="text/javascript">
  window.onload=function(){
	    var sa_bars= document.getElementsByName('sa_bar');
	    for(var i=0;i<sa_bars.length;i++){
	    	 if(i==2){
	    		 document.getElementsByName('sa_bar')[2].className='active';  
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
    <!--PRODUCT DETAIL STARTS-->
    <div id="product_detail"> 
      <!--Product Left Starts-->
      <div class="product_leftcol"> <img src="/sale/${product.img}" style="width: 363px;height: 413px;" /> <span class="pr_info"></span>
      </div>
      <!--Product Left Ends--> 
      <!--Product Right Starts-->
      <div class="product_rightcol"> 
        <h1>${product.name}</h1>
        <p class="short_dc" /> ${product.content}
        
        <div class="pr_price"> <big>￥${product.msprice}</big> <small>￥${product.price}</small> </div>
        <div class="add_to_buttons">
        <c:if test="${product.mscount>0}">
          秒杀时间：${product.msdate}开始
          <button id="addcart" style="display: none" onclick="addCart('${product.id }','${product.msprice }');" class="add_cart">加    入    购    物    车  </button>
        </c:if>
        <c:if test="${product.mscount==0}">
        	此次秒杀已结束
        </c:if>
        </div>
        <div class="add_to_buttons" id="showTimes"></div>
		 <script>
		    var second = ${time}; // 剩余秒数
		    var toDays = function(){
			    var s = second % 60; // 秒
			    var mi = (second - s) / 60 % 60; // 分钟
			    var h =  ((second - s) / 60 - mi ) / 60 % 24; // 小时
			    var d =  (((second - s) / 60 - mi ) / 60 - h ) / 24 // 天
			    if(second<=0){
			    	document.getElementById("addcart").style.display = "block";
			    	document.getElementById("showTimes").style.display = "none";
			    }else{
			    	return "开始倒计时：" + d + "天" + h + "小时" + mi + "分钟" + s + "秒";
			    }
		    }
		     //然后写一个定时器
		    window.setInterval(function(){
		        second --;
		  		document.getElementById("showTimes").innerHTML = toDays ();
		    }, 1000);
		 </script>
      </div>
    <!--Product Right Ends--> 
  </div>
  <!--PRODUCT DETAIL ENDS--> 
  <!--Product List Starts-->
  <div class="products_list products_slider">
    <h2 class="sub_title">您可能还喜欢</h2>
    <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
      <c:forEach var="cxproduct" items="${cxlist}" varStatus="status">
          <li> <a href="javascript:cxdetail(${cxproduct.id });" class="product_image"><img src="/sale/${cxproduct.img}" style="width: 216px;height: 245px;"/></a>
              <div class="product_info">
                  <h3><a href="javascript:cxdetail(${cxproduct.id });">${cxproduct.name }</a></h3>
                  <small>${cxproduct.content }</small> </div>
              <div class="price_info"> <a href="javascript:addCart('${cxproduct.id }','${cxproduct.newprice }');">+ 加入收藏</a>
                  <button class="price_add" onclick="addCart('${cxproduct.id }','${cxproduct.newprice }');" title="" type="button"><span class="pr_price">¥${cxproduct.price }</span><span class="pr_add">加入购物车</span></button>
              </div>
          </li>
      </c:forEach>
    </ul>
  </div>
  <!--Product List Ends--> 
  </section>
  <!--Mid Section Ends--> 
</div>
	<jsp:include page="common/buttom.jsp" flush="true"/> 
</div>
</body>
</html>
