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
	function toregister(){
		window.location.href = '/sale/user/toregister';
	}
	function login(){
		document.getElementById("login-form").submit();
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
	<c:if test="${msg=='error'}">
		<script>
			alert("账号或密码错误");
		</script>
	</c:if>
</c:if>
<div class="wrapper">
    <jsp:include page="common/top.jsp" flush="true"/>
    <div class="section_container">
        <!--Mid Section Starts-->
        <section>
            <div class="full_page">
                <h1>登录与注册</h1>
                <!--CHECKOUT STEPS STARTS-->
                <div class="checkout_steps">
                    <ol id="checkoutSteps">
                        <li class="section allow active" id="opc-login">
                            <div class="step-title"> <span class="number">1</span>
                                <h2>登录</h2>
                            </div>
                            <div id="checkout-step-login">
                                <div class="col2-set">
                                    <div class="col-1">
                                        <h3>登录或注册</h3>
                                        <p></p>
                                        <ul class="form-list">
                                        </ul>
                                        <h4>快速注册!</h4>
                                        <p>为了以后的方便请注册新用户:</p>
                                        <ul class="ul">
                                            <li>快速注册</li>
                                            <li>轻松查看您的购物车和订单</li>
                                        </ul>
                                    </div>
                                    <div class="col-2">
                                        <h3>登录</h3>
                                        <form method="post" action="/sale/user/login" id="login-form" />
                                            <fieldset>
                                                <h4>已经注册?</h4>
                                                <p>请在下面登录:</p>
                                                <ul class="form-list">
                                                    <li>
                                                        <label class="required" for="login-email"><em>*</em>用户名</label>
                                                        <div class="input-box">
                                                            <input type="text" name="username" value="" class="input-text" />
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <label class="required" for="login-password"><em>*</em>密码</label>
                                                        <div class="input-box">
                                                            <input type="password" name="password" class="input-text" />
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
                                        <div class="buttons-set">
                                            <button class="button brown_btn" onclick="toregister();" type="button">继续</button>
                                        </div>
                                        <div class="buttons-set">
                                            <a href="/sale/user/adminlogin">管理员登录</a>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="buttons-set"> <a class="fl_right" href="#"></a>
                                            <button class="button brown_btn" onclick="login();" type="button">登录</button>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="step-title"> <span class="number">2</span>
                                <h2>提交订单</h2>
                            </div>
                        </li>
                        <li>
                            <div class="step-title"> <span class="number">3</span>
                                <h2>填写地址</h2>
                            </div>
                        </li>
                        <li>
                            <div class="step-title"> <span class="number">4</span>
                                <h2>付款</h2>
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
