<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cn.itbaizhan.bean.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute("user");
%>
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>后台管理-晨曦拍卖网</title>
<link href="/sale/resources/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="/sale/resources/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="/sale/resources/js/manage/main.js"></script>
<script type="text/javascript">
	var psd = '<%=user.getPassword()%>'
	function check(){
		var oldpsd = document.getElementById("oldpsd").value;
		var newpsd = document.getElementById("newpsd").value;
		var cpsd = document.getElementById("cpsd").value;
		
		if(!checkPsd(oldpsd)){
			alert("原密码错误");
			return false;
		}
		if(newpsd.length==0||cpsd.length==0){
			alert("新密码和重复新密码都不能为空！");
			return false;
		}
		if(newpsd!=cpsd){
			alert("两次密码输入不一致");
			return false;
		}
	}
    // 密码框失去焦点后验证密码是否正确
    function checkPsd(pwd){
    	 if(pwd!=psd){
    		document.getElementById('msg').innerHTML="原密码输入错误，请重新输入!"; 
    		return false;
    	 }
    	 document.getElementById('msg').innerHTML="";
    	 return true;
    }
</script>
</head>
<body>
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
	<table width="100%" height="100%" border=0 cellpadding="0" cellSpacing=0 style="background:#EAEAEA;">
		<tr>
			<td height="80">
				<jsp:include page="common/top.jsp" flush="true"/> 
			</td>
		</tr>
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" cellpadding="0" cellSpacing=0 border=0 borderColor="#ff0000">
					<tbody>
						<tr> 
							<td width="200" id="frmtitle" valign="top">
								<jsp:include page="common/left.jsp" flush="true"/> 
							</td>
							<td bgcolor="#EAEAEA" onClick="switchSysBar()" style="height:100%;width:12px;text-align:center;cursor:pointer;">
								<span id="switchPoint" title="打开/关闭左边导航栏" style="color:#666;cursor:hand;font-family:Webdings;font-size:12px;">3</span>
							</td>
							<td valign="top">
								<div class="title"><h2>修改密码</h2></div>
								<div class="maincon">
								<form action="/sale/user/adminChangePsd" method="post" onsubmit="return check();">
									<table class="formtable" width="100%">
										<tr>
											<td width="180px" align="right">原密码：</td>
											<td colspan="3">
												<div class="stext"><input type="password" name="oldpsd" value="" id="oldpsd"  onblur="checkPsd(this.value)" />
												  <span id="msg" style="color:red"></span>
												</div>
											</td>
										</tr>
										<tr>
											<td width="180px" align="right">新密码：</td>
											<td colspan="3">
												<div class="stext"><input type="password" name="newpsd" value="" id="newpsd" /></div>
											</td>
										</tr>
										<tr>
											<td width="180px" align="right">重复新密码：</td>
											<td width="210px" colspan="3">
												<div class="stext"><input type="password" name="cpsd" value="" id="cpsd"  /></div>
											</td>
										</tr>
										<tr>
											<td style="border:0;"></td>
											<td style="border:0;">
											<input type="submit" name="" value="确定" id="" class="btn-img" /></td>
										</tr>
									</table>
								</form>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>