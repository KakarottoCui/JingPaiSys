<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>后台管理-晨曦拍卖网</title>
<link href="/sale/resources/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="/sale/resources/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="/sale/resources/js/manage/main.js"></script>
</head>
<body>

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
								欢迎登录后台管理								
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>