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
	function goPager(pager){
		var maxPager= ${maxPager};
		if(pager==-1){
			pager = document.getElementById("newPage").value;
		}
		if(pager==""){
			alert("页面超出范围");
			return false;
		}
		if(pager==0){
			alert("当前为首页");
			return false;
		}
		if(pager>maxPager){
			alert("页面超出范围");
			return false;
		}
		window.location.href="/sale/product/promolist?pagerNum="+pager;
	}
	function del(id){
		if(confirm("确定删除？")){
			window.location.href="/sale/product/delete?id="+id;
		}
	}
	function update(id){
		window.location.href="/sale/product/toupdate?id="+id;
	}
	function add(){
		window.location.href="/sale/product/toadd";
	}
	function szjp(id){
		window.location.href="/sale/product/toszjp?id="+id;
	}
	function qxjp(id){
		window.location.href="/sale/product/qxjp?id="+id;
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
								<div class="title"><h2>竞拍商品列表</h2></div>
								<div class="maincon">
									<table class="tablelist" width="100%">
										<tr>
											<th>序号</th>
											<th>产品</th>
											<th>图片</th>
											<th>简介</th>
											<th>价格</th>
											<th>是否竞拍</th>
											<th>起拍价格</th>
											<th>竞拍结束时间</th>
											<th>操作</th>
										</tr>
								<c:choose>
									<c:when test="${list eq null}">
										<tr>
											<td colspan="6">暂无信息</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="product" items="${list}" varStatus="status">
											<tr>
												<td width="50px;">${product.id }</td>
												<td >${product.name }</td>
												<td width="120"><img src="/sale/${product.img}" width="110" height="121" border="0" /></td>
												<td >${product.content }</td>
												<td width="100px;">${product.price }</td>
												<td width="100px;"><c:if test="${product.sfjp ==0}">未竞拍</c:if><c:if test="${product.sfjp ==1}">已竞拍</c:if></td>
												<td width="100px;"><c:if test="${product.sfjp ==0}">无</c:if><c:if test="${product.sfjp ==1}">${product.qpprice }</c:if></td>
												<td width="100px;"><c:if test="${product.sfjp ==0}">无</c:if><c:if test="${product.sfjp ==1}">${product.jpdate }</c:if></td>
												<td width="150px;">
													<c:if test="${product.sfjp ==0}">
														<a style="color:#3366cc;" href="javascript:szjp(${product.id });">设置竞拍</a><span class="lr10"></span>
													</c:if>
													<c:if test="${product.sfjp ==1}">
														<a style="color:#3366cc;" href="javascript:qxjp(${product.id });">取消竞拍</a><span class="lr10"></span>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
										
									</table>
									<jsp:include page="../pager.jsp" flush="true"/> 
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