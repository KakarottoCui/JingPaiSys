<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>晨曦拍卖网-购物车</title>
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
	function setValue(id){
		var count = document.getElementById("count"+id).value;
		window.location.href="/sale/order/changeCount?id="+id+"&count="+count;
	}
	function deleteorder(id){
		window.location.href="/sale/order/deleteorder?id="+id;
	}
	function toIndex(){
		window.location.href="/sale/index/toIndex";
	}
	function checkout(price){
		window.location.href="/sale/order/tocheckout?price="+price;
	}
</script>
</head>

<body>
<div class="wrapper">
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
  <jsp:include page="common/top.jsp" flush="true"/> 
  <div class="section_container"> 
    <!--Mid Section Starts-->
    <section> 
      <!--CART STARTS-->
      <div id="shopping_cart" class="full_page">
        <h1>已购清单</h1>
<c:choose>
	<c:when test="${count==0}">
        <div class="message success">您还没有购买任何产品.</div>
    </c:when>
	<c:otherwise>
		<div class="action_buttonbar">
        <div class="cart_table">
          <table class="data-table cart-table" id="shopping-cart-table" cellpadding="0" cellspacing="0">
            <tr>
              <th colspan="2">产品</th>
              <th class="align_center" width="6%"></th>
              <th class="align_center" width="12%">单价</th>
              <th class="align_center" width="10%">数量</th>
              <th class="align_center" width="12%">总价</th>
              <th class="align_center" width="6%"></th>
            </tr>
        <c:forEach var="order" items="${list}" varStatus="status">
	         <tr>
	           <td width="10%"><img src="/sale/${order.product.img}" /></td>
	           <td class="align_left" width="44%"><a class="pr_name" href="#">${order.product.name}</a><span class="pr_info">${order.product.content}</span></td>
	           <td class="align_center"><a href="#" class="edit"></a></td>
	           <td class="align_center vline">￥<span class="price" id="price${order.id}">${order.singleprice}</span></td>
	           <td class="align_center vline"><span class="price" >${order.count }</span></td>
	           <td class="align_center vline">￥<span class="price" id="dsumpirce${order.id}">${order.price}</span></td>
	           <td class="align_center vline"></td>
	         </tr>
        </c:forEach>
          </table>
        </div>
        <div class="action_buttonbar">
          <button type="button" title="" onclick="toIndex();" class="continue">返回首页</button>
          <!-- 
          <button type="button" onclick="checkout('${sumprice}');" title="" class="checkout">结算</button> -->
        </div>
	</c:otherwise>
</c:choose>
      </div>
      <!--CART ENDS--> 
      
    </section>
    <!--Mid Section Ends--> 
  </div>
  <jsp:include page="common/buttom.jsp" flush="true"/> 
</div>
</body>
</html>