<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
<link href="/finance/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/finance/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//初始化div，并注册事件
		var initDiv = function() {
			$(".menufont a").css("color", "black");
			$(".menufont a").mouseover(function() {
				$(this).css("color", "blue");
			}).mouseout(function() {
				$(this).css("color", "black");
			});
		};
		initDiv();
		$(".menufont a").click(function() {
			initDiv();
			//当前被点击的div改变颜色
			$(this).css("color", "red");
			//取消当前div的mouseout和mouseover事件
			$(this).unbind("mouseout");
			$(this).unbind("mouseover");
		});
	});

	$(document).ready(function() {
		$(".menufont a").click(function() {
			$(".menufont a").removeClass("current");
			
			$(this).addClass("current");
			$("#title2 div").hide();
			var name1 = $(this).attr("id");
			$("#" + name1 + "_con").show();
			
			$("#title3 div").hide();
			var name2 = $(this).attr("id");
			$("#" + name2 + "_where").show();
		});
	});
</script>
</head>

<body>
	<div id="containt">
		<div id="top">
			<div id="top_left">
				<img src="/finance/images/logo1.png" />
			</div>
			<div id="top_right">
				<img src="/finance/images/logo2.png" />
			</div>
			<div class="title2">
				<font style="color: white;">欢迎您：${uname}</font>
			</div>
		</div>
		<div id="title">
			<div id="title_left">
				<div id="title1">&nbsp;新&nbsp;&nbsp;&nbsp;闻</div>
			</div>
			<div id="title_right">
				<div id="title2">
					<div id="menu1_con">查看交易记录</div>
					<div id="menu2_con" style="display: none;">存款</div>
					<div id="menu3_con" style="display: none;">取款</div>
					<div id="menu4_con" style="display: none;">转账</div>
					<div id="menu5_con" style="display: none;">查看个人信息</div>
					<div id="menu6_con" style="display: none;">修改个人信息</div>
					<div id="menu7_con" style="display: none;">修改个人密码</div>
					<div id="menu8_con" style="display: none;">注销</div>
				</div>
				<div id="title3">
					<div id="menu1_where">当前位置：用户操作>查看交易记录</div>
					<div id="menu2_where" style="display: none;">当前位置：用户操作>存款</div>
					<div id="menu3_where" style="display: none;">当前位置：用户操作>取款</div>
					<div id="menu4_where" style="display: none;">当前位置：用户操作>转账</div>
					<div id="menu5_where" style="display: none;">当前位置：用户操作>查看个人信息</div>
					<div id="menu6_where" style="display: none;">当前位置：用户操作>修改个人信息</div>
					<div id="menu7_where" style="display: none;">当前位置：用户操作>修改个人密码</div>
					<div id="menu8_where" style="display: none;">当前位置：用户操作>注销</div>
				</div>
			</div>
		</div>
	
		<div id="news">
			<div class="title_left">
			     <div class="news">
			        <iframe name="newsbrief" id="newsbrief" src="newsbrief.jsp" frameborder="0" scrolling="auto" width="100%" height="100%"> 
				</iframe>
		         </div>
				<div class="title1">&nbsp;菜&nbsp;&nbsp;&nbsp;单</div>
			</div>
		</div>
        
		<div id="content">
			<div id="content_left">
				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="QueryRecordServlet" target="main" id="menu1"
							class="current">查看交易记录></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="deposit.jsp" target="main" id="menu2">
							存&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="withdraw.jsp" target="main" id="menu3">
							取&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="transfer.jsp" target="main" id="menu4">
							转&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="QueryInfoServlet" target="main" id="menu5">查看个人信息></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="UpdateInfoServlet" target="main" id="menu6">修改个人信息></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="updatePsd.jsp" target="main" id="menu7">修改个人密码></a>
					</div>
				</div>

				<div class="menu">
					<div class="menuimg">
						<img src="/finance/images/01.png" />
					</div>
					<div class="menufont">
						<a href="LoginoutServlet" target="main" id="menu8">
							注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销></a>
					</div>
				</div>

			</div>
			<div id="content_right">
				<iframe name="main" id="rightMain" src="welcome.jsp" frameborder="0"
					scrolling="auto" width="100%" height="100%"> 
				</iframe>
			</div>
		</div>
		<div id="bottom">
			<div id="bottom_center">版权所有 @ 2000-2016 中软国际公司</div>
		</div>
	</div>
</body>
</html>