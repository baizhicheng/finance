<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/finance/js/jquery.js"></script>
<script type="text/javascript" src="/finance/js/jquery.cookie.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		if ($.cookie("rmbUser") == "true") {
			$("#rmbUser").attr("checked", true);
			$("#uname").val($.cookie("userName"));
			$("#psd").val($.cookie("passWord"));
		}
	});
	//保存用户信息 
	function saveUserInfo() {
		if ($("#rmbUser").attr("checked") == true) {
			var userName = $("#uname").val();
			var passWord = $("#psd").val();
			$.cookie("rmbUser", "true", {
				expires : 7
			}); // 存储一个带7天期限的 cookie 
			$.cookie("userName", userName, {
				expires : 7
			}); // 存储一个带7天期限的 cookie 
			$.cookie("passWord", passWord, {
				expires : 7
			}); // 存储一个带7天期限的 cookie 
		} else {
			$.cookie("rmbUser", "false", {
				expires : -1
			});
			$.cookie("userName", '', {
				expires : -1
			});
			$.cookie("passWord", '', {
				expires : -1
			});
		}
	}
</script>
<body>
<div class="logo">
    <img src="/finance/images/title.png"/>
    </div>
<div id="content">
    <div class="login-header" align="center">
        <font color="#000000" size=5>登录</font>
    </div>
<form action="LoginServlet" method="post">
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="text" id="uname" name="uname" value="${uname}" placeholder="请输入用户名">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" id="psd" name="psd" placeholder="请输入密码">
        </div>
  <div class="abc"><font color="#000000" size="4">验证码：<input type="text" name="vericode" size="3" /><span><img src="VerifyCodeServlet" title="看不清，点击换一张"onClick="this.src=this.src+'?'" ></span></div>
    <div class="login-button-box">
      <input type="submit" value="登录" id="log_Commit" onclick="saveUserInfo()"  />
  </div>
     <div class="remember-box">
        <label>
            <input type="checkbox" checked="true"  id="rmbUser" class="checkbox" >记住密码
        </label>
    </div>
    <div id="msg">
    <span style="color:red;font-weight: bold;" >${msg}</span>
    </div>
</form>
</div>

</body>
</html>