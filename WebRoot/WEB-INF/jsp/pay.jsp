<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

<title>欢迎光临</title>
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
<script type="text/javascript">
	function pay(){
		document.getElementById("login-form").submit();
	}
	function login(){
		window.location.href = '/sale/user/tologin';
	}
</script>
<!--[if lt IE 9]>
    <script src="js/html5.js"></script>
<![endif]-->
<!-- mobile setting -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<c:if test="${msg!=null}">
	<c:if test="${msg=='success'}">
		<script>
			alert("注册成功");
		</script>
	</c:if>
	<c:if test="${msg=='error'}">
		<script>
			alert("注册失败，请重新操作");
		</script>
	</c:if>
</c:if>
<div class="wrapper">
    <jsp:include page="common/top.jsp" flush="true"/> 
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <div class="full_page">
                <h1>支付</h1>
                <!--CHECKOUT STEPS STARTS-->
                <div class="checkout_steps">
                    <ol id="checkoutSteps">
                        <li class="section allow active" id="opc-login">
                            <div class="step-title"> <span class="number"></span>
                                <h2>支付</h2>
                            </div>
                            <div id="checkout-step-login">
                                <div class="col2-set">
                                    <div class="col-2">
                                        <h3>支付</h3>
                                        <form method="post" action="/sale/order/pay" id="login-form" />
                                            <fieldset>
                                                <ul class="form-list">
                                                    <li>
                                                        <label class="required" for="login-password"><em>*</em>快递公司</label>
                                                        <div class="input-box">
                                                            	<input type="radio" name="bank" value="中国农业银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/nongye.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;
                                                            	<input type="radio" name="bank" value="中国工商银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/gongshang.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;
                                                            	<input type="radio" name="bank" value="中国建设银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/jianshe.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;
                                                            	<input type="radio" name="bank" value="招商银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/zhaoshang.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            	<input type="radio" name="bank" value="交通银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/jiaotong.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;
                                                            	<input type="radio" name="bank" value="中国银行" class="input-text" style="width: 10px;"/><img alt="" src="/sale/resources/images/zhongguo.png" style="width: 130px;height: 35px;">|&nbsp;&nbsp;
                                                        </div>
                                                    </li>
                                                </ul>
                                                <br />
                                                <br />
                                            </fieldset>
                                        </form>
                                    </div>
                                </div>
                                <div class="col2-set">
                                    <div class="col-1">
                                    </div>
                                    <div class="col-2">
                                        <div class="buttons-set"> <a class="fl_right" href="#"></a>
                                            <button class="button brown_btn" onclick="pay();" type="button">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ol>
                </div>
                <!--CHECKOUT STEPS ENDS-->
                <div class="col_right">
                    <div class="block-progress">
                        <div class="block-title">结账流程</div>
                            <ul>
                                <li>>提交订单</li>
                                <li>>填写地址</li>
                                <li>>付款</li>
                                <li>>等待收货</li>
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