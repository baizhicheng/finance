<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人密码</title>
<script type="text/javascript" src="/finance/js/jquery.js"></script>
<script type="text/javascript" src="/finance/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function() {
		var validate = $("#myform").validate({
			rules : {
				oldpsd : {
					required: true,
				},
				newpsd : {
					required: true,
	                minlength: 6,
	                maxlength: 20
				},
				confirm : {
					required: true,
					equalTo : "#newpsd"
				}
			},
			messages : {
				oldpsd : {
					required: "当前密码不能为空",
				},
				newpsd : {
					required: "新的密码不能为空",
	                minlength: "密码长度不能少于6个字符",
	                maxlength: "密码长度不能超过20个字符"
				},
				confirm : {
					required: "确认密码不能为空",
	                equalTo: "确认密码和密码不一致"
				}
			}
		});
	});
</script>
</head>
<body>
	<h1 align="center">修改个人密码</h1>
	<form action="UpdatePsdServlet" method="post" id="myform">
			<table align="center" border="1" cellspacing="0"
				bordercolor="#000000">
				<tr>
					<td bgcolor="#e1e1e1" style="width: 200px; height: 50px"
						align="center">当&nbsp;&nbsp;前&nbsp;&nbsp;密&nbsp;&nbsp;码</td>
					<td style="width: 600px;">&nbsp;&nbsp; <input type="password"
						id="oldpsd" name="oldpsd" style="height: 25px;" /><font style="color: red;">*</font>
					</td>
				</tr>
				<tr>
					<td bgcolor="#e1e1e1" style="width: 200px; height: 50px"
						align="center">新&nbsp;&nbsp;的&nbsp;&nbsp;密&nbsp;&nbsp;码</td>
					<td style="width: 600px;">&nbsp;&nbsp; <input type="password"
						id="newpsd" name="newpsd" style="height: 25px;" /><font
						style="color: red;">*</font>
					</td>
				</tr>
				<tr>
					<td bgcolor="#e1e1e1" style="width: 200px; height: 50px"
						align="center">确&nbsp;&nbsp;认&nbsp;&nbsp;密&nbsp;&nbsp;码</td>
					<td style="width: 600px;">&nbsp;&nbsp; <input type="password"
						id="confirm" name="confirm" style="height: 25px;" /><font
						style="color: red;">*</font>
					</td>
				</tr>
			</table >
			<table align="center">
				<tr>
					<td align="right"style="width: 400px;">${msg}</td>
					<td align="right"style="width: 400px;"><input type="submit"
						value="提交" style="width: 100px;" /></td>
				</tr>
			</table>
	</form>
</body>
</html>