<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


 <div id="showTimes"></div>
  <div id="test"></div>

<%
   long current_time=System.currentTimeMillis();
   long end_time=1398686400000l;
   long time=end_time-current_time;
  %>
 <script>
    var second = <%= time / 1000%>; // 剩余秒数
    var toDays = function(){
    	document.getElementById("test").innerHTML = second;
	    var s = second % 60; // 秒
	    var mi = (second - s) / 60 % 60; // 分钟
	    var h =  ((second - s) / 60 - mi ) / 60 % 24; // 小时
	    var d =  (((second - s) / 60 - mi ) / 60 - h ) / 24 // 天
	    if(second<=0){
	    	return "开抢";
	    }else{
	    	return "剩余：" + d + "天" + h + "小时" + mi + "分钟" + s + "秒";
	    }
    }
     //然后写一个定时器
    window.setInterval(function(){
        second --;
  		document.getElementById("showTimes").innerHTML = toDays ();
    }, 1000);
 </script>
