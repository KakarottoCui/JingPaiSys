<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>晨曦拍卖网后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="/sale/resources/admin/Styles/base.css" />
    <link rel="stylesheet" type="text/css" href="/sale/resources/admin/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/sale/resources/admin/Styles/bootstrap.min.css" />
    <script type="text/javascript" src="/sale/resources/admin/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/sale/resources/admin/Scripts/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="/sale/resources/admin/Scripts/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/sale/resources/admin/Styles/login.css" />
    <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 0.7, dir: 'right', depth: 10 });
            $('.login').click(function () {
                if ($('#uid').val() == "" || $('#pwd').val() == "" || $('#code').val() == "") { $('.tip').html('�û�������벻��Ϊ�գ�') }
                else {
                    location.href = 'index.html';
                }
            })
        })
    </script>
</head>
<body>
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>
	<form action="/sale/user/adminlogin" method="post">
    <div class="row-fluid">
        <h1>晨曦拍卖网后台管理系统</h1>
        <p>
            <label>用户名：<input type="text" name="username" id="username" /></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password" /></label>
        </p>
        <p class="tip">&nbsp;</p>
        <hr />
        <input type="submit" value=" 登录 " class="btn btn-primary btn-large login" />
        &nbsp;&nbsp;&nbsp;<input type="button" value=" 重置 " class="btn btn-large" />
    </div>
    </form>
</body>
</html>
