<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>晨曦拍卖网-竞拍专区</title>
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
<script type="text/javascript">

</script>
</head>

<body>
<script type="text/javascript">
  window.onload=function(){
	    var sa_bars= document.getElementsByName('sa_bar');
	    for(var i=0;i<sa_bars.length;i++){
	    	 if(i==3){
	    		 document.getElementsByName('sa_bar')[3].className='active';  
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
        
        <div class="pr_price"> <big>价格：￥${product.jpprice}</big> <small></small> </div>
        <div class="pr_price" id="adddiv"> 
        	<small>加价：<input type="text" id="addprice" name="addprice"/></small> 
        	<button class="button brown_btn" onclick="addprice(${product.id});" type="button">确定</button>
        	<small></small> 
        </div>
        <div class="add_to_buttons">
        	商品将在竞拍结束后自动加入出价最高者的购物车内！</br>
        	竞拍结束时间：${product.jpdate}
          <button style="display: none;" onclick="addCart('${product.id }','${product.jpprice }');" class="add_cart">加    入    购    物    车  </button>
        </div>
         <div id="showTimes"></div>
		
	
		 <script>
		    var second = ${time}; // 剩余秒数
		    var toDays = function(){
			    var s = second % 60; // 秒
			    var mi = (second - s) / 60 % 60; // 分钟
			    var h =  ((second - s) / 60 - mi ) / 60 % 24; // 小时
			    var d =  (((second - s) / 60 - mi ) / 60 - h ) / 24 // 天
			    if(second<=0){
			    	document.getElementById("adddiv").style.display = "none";
			    	setVisible();
			    	return "竞拍已结束";
			    }else{
			    	return "竞拍剩余时间：" + d + "天" + h + "小时" + mi + "分钟" + s + "秒";
			    }
		    }
		     //然后写一个定时器
		    window.setInterval(function(){
		        second --;
		  		document.getElementById("showTimes").innerHTML = toDays ();
		    }, 1000);
		    function setVisible(){
		    	if(second==0){
		    		window.location.href = "/sale/order/setVisible?id="+${product.id};
		    	}
		    }
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
              <div class="price_info"> <a href="javascript:addCart('${cxproduct.id }','${cxproduct.price }');">+ 加入收藏</a>
                  <button class="price_add" title="" type="button"><span class="pr_price">¥${cxproduct.price }</span><span class="pr_add">加入购物车</span></button>
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
