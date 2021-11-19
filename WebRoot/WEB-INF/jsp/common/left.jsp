<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>left</title>
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
   	  <ul class="category departments">
          <li class="header">正在促销</li>
      <c:forEach var="cxproduct" items="${cxlist}" varStatus="status">
          <li><a href="javascript:cxdetail(${cxproduct.id });">${cxproduct.name }</a></li>
      </c:forEach>
      </ul>
      <ul class="category collection">
          <li class="header">新品上市</li>
      <c:forEach var="newproduct" items="${newlist}" varStatus="status">
          <li><a href="javascript:detail(${newproduct.id });">${newproduct.name}</a></li>
      </c:forEach>
      </ul>
  </body>
</html>
