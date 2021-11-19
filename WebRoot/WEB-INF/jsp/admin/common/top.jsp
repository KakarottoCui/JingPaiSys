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
    
    <title>index</title>
    <script type="text/javascript">
    	function logout(){
			if(confirm('确认退出？')){
				window.location.href = '/sale/user/adminlogout';
			}
		}
    </script>
  </head>
  
  <body>
    <img src="/sale/resources/images/manage/logo.jpg" width="477" height="52" alt="晨曦拍卖网-后台管理" class="logo" />
	<div class="user">当前用户：<%=user.getUsername() %>(<a href="javascript:logout();">退出登录</a>)</div>
  </body>
</html>
