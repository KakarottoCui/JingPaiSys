<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>欢迎光临</title>
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
	function detail(id){
		window.location.href = "/sale/index/toDetail?id="+id;
	}
	function cxdetail(id){
		window.location.href = "/sale/index/tocxDetail?id="+id;
	}
</script>
</head>
<body>
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<div class="wrapper">
    <jsp:include page="common/top.jsp" flush="true"/> 
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">新品上市</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                <c:forEach var="newproduct" items="${newlist}" varStatus="status">
                    <li> <a href="javascript:detail(${newproduct.id });" class="product_image"><img src="/sale/${newproduct.img}" style="width: 216px;height: 245px;"/></a>
                        <div class="product_info">
                            <h3><a href="javascript:detail(${newproduct.id });">${newproduct.name }</a></h3>
                            <small>${newproduct.content }</small> </div>
                        <div class="price_info"> <a href="javascript:addCart('${newproduct.id }','${newproduct.price }');">+ 加入收藏</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">¥${newproduct.price }</span><span class="pr_add" onclick="addCart('${newproduct.id }','${newproduct.price }');">加入购物车</span></button>
                        </div>
                    </li>
                </c:forEach>
                </ul>
            </div>
            <!--Product List Ends-->
            <!--Product List Starts-->
            <div class="products_list products_slider">
                <h2 class="sub_title">促销</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                    <c:forEach var="cxproduct" items="${cxlist}" varStatus="status">
                    <li> <a href="javascript:cxdetail(${cxproduct.id });" class="product_image"><img src="/sale/${cxproduct.img}" style="width: 216px;height: 245px;"/></a>
                        <div class="product_info">
                            <h3><a href="javascript:cxdetail(${cxproduct.id });">${cxproduct.name }</a></h3>
                            <small>${cxproduct.content }</small> </div>
                        <div class="price_info"> <a href="javascript:addCart('${cxproduct.id }','${cxproduct.newprice }');">+ 加入收藏</a>
                            <button class="price_add" title="" type="button"><span class="pr_price">¥${cxproduct.newprice }</span><span class="pr_add" onclick="addCart('${cxproduct.id }','${cxproduct.newprice }');">加入购物车</span></button>
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