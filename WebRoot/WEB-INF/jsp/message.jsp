<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>晨曦拍卖网-留言板</title>
<!--CSS-->
<link rel="stylesheet" href="/sale/resources/css/styles.css" />
<!--Google Webfont -->
<link href='http://fonts.googleapis.com/css?family=Istok+Web' rel='stylesheet' type='text/css' />
<!--Javascript-->
<script type="text/javascript" src="/sale/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.easing.js"></script>
<script type="text/javascript" src="/sale/resources/js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="/sale/resources/js/form_elements.js"></script>
<script type="text/javascript" src="/sale/resources/js/custom.js"></script>
<!--[if lt IE 9]>
    <script src="js/html5.js"></script>
<![endif]-->
<!-- mobile setting -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<script type="text/javascript">
  window.onload=function(){
	    var sa_bars= document.getElementsByName('sa_bar');
	    for(var i=0;i<sa_bars.length;i++){
	    	 if(i==4){
	    		 document.getElementsByName('sa_bar')[4].className='active';  
	    	 }else{
	    		 document.getElementsByName('sa_bar')[i].className=''; 
	    	 }
	    } 
  }
</script>
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<div class="wrapper">
    <jsp:include page="common/top.jsp" flush="true"/> 
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <div class="full_page">
                <h1>留言板</h1>
				<div class="col_left_main contact_page">
                	<!--Contact Starts-->
                        <address>
                            <b>联系地址</b><br />
                                                        北京市海淀区531号<br />
                                                        奥运大厦<br />
                            010-01111111<br />
                        </address>
                    
                    <!--Block Ends-->
        <!--Form Starts-->
        <div class="block">
            <form id="contact-us" action="/sale/message/add" method="post" />
                <h3>留言</h3>
                <ul id="contact_form">
                    <li>
                        <input type="text" name="name" id="name" value="" class="txt requiredField" placeholder="姓名:" />
                                            </li>
                    <li>
                        <input type="text" name="email" id="email" value="" class="txt requiredField email" placeholder="邮箱:" />
                                            </li>
                    <li>
                        <textarea name="message" id="message"  class="txtarea requiredField" style="height: 50px;" placeholder="留言:"></textarea>
                                            </li>
                    <li>
                        <button name="submit" type="submit" class="subbutton brown_btn">确定</button>
                        <input type="hidden" name="submitted" id="submitted" value="true" />
                    </li>
                </ul>
            </form>
        </div>
        <!--Form Ends-->
                      
                    <!--Contact Ends-->
                </div>
                <div class="col_right">
                    <div class="block-progress">
                        <div class="block-title">客户服务</div>
                            <ul>
                                <li>F.A.Q</li>
                                <li>安全支付</li>
                                <li>订单查询</li>
                                <li>舒心购物</li>
                                <li>退货政策</li>
                            </ul>
                    </div>
                    <div class="right_promo">
                    <img src="/sale/resources/images/side_promo_banner.jpg" />
                    </div>
                </div>
            </div>
        </section>
        <!--Mid Section Ends-->
    </div>
    <jsp:include page="common/buttom.jsp" flush="true"/> 
</div>

</body>
</html>
