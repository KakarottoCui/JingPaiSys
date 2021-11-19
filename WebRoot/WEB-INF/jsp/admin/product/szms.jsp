<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>后台管理-晨曦拍卖网</title>
<link href="/sale/resources/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<link href="/sale/resources/js/My97DatePicker/skin/WdatePicker.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/sale/resources/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="/sale/resources/js/manage/main.js"></script>
<script type="text/javascript" src="/sale/resources/js/My97DatePicker/WdatePicker.js" defer="defer"></script>	
</head>
<body>

	<table width="100%" height="100%" border=0 cellpadding="0" cellSpacing=0 style="background:#EAEAEA;">
		<tr>
			<td height="80">
				<jsp:include page="../common/top.jsp" flush="true"/> 
			</td>
		</tr>
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" cellpadding="0" cellSpacing=0 border=0 borderColor="#ff0000">
					<tbody>
						<tr> 
							<td width="200" id="frmtitle" valign="top">
								<jsp:include page="../common/left.jsp" flush="true"/> 
							</td>
							<td bgcolor="#EAEAEA" onClick="switchSysBar()" style="height:100%;width:12px;text-align:center;cursor:pointer;">
								<span id="switchPoint" title="打开/关闭左边导航栏" style="color:#666;cursor:hand;font-family:Webdings;font-size:12px;">3</span>
							</td>
							<td valign="top">
								<div class="title"><h2>设置秒杀</h2></div>
								<div class="maincon">
								<form action="/sale/product/szms" method="post">
									<table class="formtable" width="100%">
										<tr>
											<td width="180px" align="right">秒杀产品：</td>
											<td colspan="3">
												<div class="stext">${product.name}</div>
											</td>
										</tr>
										<tr>
											<td width="180px" align="right">秒杀价格：</td>
											<td colspan="3">
												<div class="stext"><input type="text" name="price" value="" id="price" /></div>
											</td>
										</tr>
										<tr>
											<td width="180px" align="right">秒杀数量：</td>
											<td colspan="3">
												<div class="stext"><input type="text" name="count" value="" id="count" /></div>
											</td>
										</tr>
										<tr>
											<td width="180px" align="right">秒杀时间：</td>
											<td colspan="3">
												<div class="stext">
													<input class="Wdate" type="text" id="time" name="time" style="width: 150px;"
	                									onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>&nbsp;&nbsp;	 
												</div>
											</td>
										</tr>
										<tr>
											<td style="border:0;"></td>
											<td style="border:0;">
												<input type="hidden" value="${product.id}" name="id">
												<input type="submit" name="" value="提交" id="" class="btn-img" />
											</td>
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