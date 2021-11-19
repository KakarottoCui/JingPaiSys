<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 	<div class="pagination">
 		每页5条;共&nbsp;${count }&nbsp;条;共&nbsp;${maxPager }&nbsp;页;当前第&nbsp;${pagerNum }&nbsp;页&nbsp;
 		<a href="javascript:goPager(1)">首页</a>
 		<a href="javascript:goPager(${pagerNum }-1)">上一页</a>
 		<a href="javascript:goPager(${pagerNum }+1)">下一页 &gt; </a>
 		<a href="javascript:goPager(${maxPager });">尾页 &gt; </a>
 		<input type="text" style="width: 30px;" name="newPage" id="newPage"></input>
 		<input type="button" value="GO" onclick="goPager(-1)">
 	</div>
</body>
</html>