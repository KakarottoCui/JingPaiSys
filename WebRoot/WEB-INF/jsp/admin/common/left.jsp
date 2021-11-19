<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'left.jsp' starting page</title>
    <script type="text/javascript">
    	function changePsd(){
    		window.location.href = "/sale/user/toAdminChangePsd"
    	}
    	function message(){
    		window.location.href = "/sale/message/list"
    	}
    	function product(){
    		window.location.href = "/sale/product/list"
    	}
    	function spike(){
    		window.location.href = "/sale/product/spikelist"
    	}
    	function promo(){
    		window.location.href = "/sale/product/promolist"
    	}
    	function order(){
    		window.location.href = "/sale/order/htlist"
    	}
    </script>
  </head>
  
  <body>
    <dl class="sort">
		<dt class="current">修改密码</dt>
		<dd><a href="javascript:changePsd();">修改密码</a></dd>
	</dl>
	<dl class="sort">
		<dt class="current">商品管理</dt>
		<dd>
			<a href="javascript:product();">商品管理</a>
			<a href="javascript:spike();">秒杀商品</a>
			<a href="javascript:promo();">竞拍商品</a>
		</dd>
	</dl>
	<dl class="sort">
		<dt class="current">订单管理</dt>
		<dd>
			<a href="javascript:order();">订单</a>
		</dd>
	</dl>
	<dl class="sort">
		<dt class="current">留言管理</dt>
		<dd>
			<a href="javascript:message();">留言管理</a>
		</dd>
	</dl>
  </body>
</html>
