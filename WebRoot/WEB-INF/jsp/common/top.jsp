<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.itbaizhan.bean.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>top-top</title>
	<script type="text/javascript">
		var user = '<%=user%>';
		function cart(){
			if(user=='null'){
				alert("请先登录");
				return false;
			}else{
				//TODO
				window.location.href = '/sale/index/toCart';
			}
		}
		function order(){
			if(user=='null'){
				alert("请先登录");
				return false;
			}else{
				//TODO
				window.location.href = '/sale/order/toOrderList';
			}
		}
		function addCart(id,price){
			if(user=='null'){
				alert("请先登录");
				return false;
			}else{
				window.location.href = '/sale/order/add?id='+id+'&price='+price;
			}
			
		}
		function addprice(id){
			if(user=='null'){
				alert("请先登录");
				return false;
			}else{
				var addprice = document.getElementById("addprice").value;
				window.location.href="/sale/order/addprice?addprice="+addprice+"&id="+id;
			}
		}
		
		
	</script>
  </head>
  <body>
    <div class="header_container">
        <!--Header Starts-->
        <header>
            <div class="top_bar clear">
		       <!--Top Links Starts-->
		       <ul class="top_links">
		           <li><a href="javascript:cart();">我的购物车</a></li>
		           <li><a href="javascript:order();">我的订单</a></li>
		       <%if(user!=null){ %>
		       	   <li><a href="javascript:;">欢迎您，${user.username }</a></li>
		       	   <li><a href="/sale/user/tochangePsd">修改密码</a></li>
		       	   <li class="highlight"><a href="/sale/user/logout" >退出</a></li>
		       <%}else{ %>
		       	   <li><a href="/sale/user/tologin">登录</a></li>
		           <li class="highlight"><a href="/sale/user/tologin">注册</a></li>
		       <%} %>
		           
		       </ul>
		       <!--Top Links Ends-->
		   </div>
		   <!--Logo Starts-->
		   <h1 class="logo"> <a href="/sale/index/toIndex"><img src="/sale/resources/images/logo.png" /></a> </h1>
		   <!--Logo Ends-->
        </header>
        <!--Header Ends-->
    </div>
    <div class="navigation_container">
        <!--Navigation Starts-->
        <nav>
            <ul class="primary_nav">
                <li name="sa_bar"  class="active"><a href="/sale/index/toIndex">首页</a></li>
                <li name="sa_bar"><a href="/sale/index/toPromotions">促销</a></li>
                <li name="sa_bar"><a href="/sale/index/toSpike">秒杀</a></li>
                <li name="sa_bar"><a href="/sale/index/toAuction">竞拍</a></li>
                <li name="sa_bar"><a href="/sale/index/toMessage">留言</a></li>
            </ul>
            <div class="minicart"> 
            	<%if(user!=null){ %>
            	<a href="javascript:cart();" class="minicart_link"></a>
            	<!-- 
                <div class="cart_drop"> <span class="darw"></span>
                    <ul>
                    
                        <li><img src="/sale/resources/images/mini_c_item1.png" /><a href="#">商品名称</a> <span class="price">¥49.90</span></li>
                        <li><img src="/sale/resources/images/mini_c_item2.png" /><a href="#">商品名称</a> <span class="price">¥12.90</span></li>
                        <div class="cart_bottom">
                            <div class="subtotal_menu"><small>总价:</small><big>¥69.20</big></div>
                            <a href="javascript:cart();">去付款</a></div>
                    </ul>
                </div>
                 -->
               <%}else{ %>
               	<a href="/sale/user/tologin"> <span class="item"></span> <span class="price"><b>登录之后才能查看购物车</b></span> </a>
               <%} %>
            </div>
        </nav>
        <!--Navigation Ends-->
    </div>
  </body>
</html>
