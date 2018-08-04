<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<script type="text/javascript" src="/finance/js/jquery.js"></script>
<script type="text/javascript" src="/finance/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function() {
		// 手机号码验证 
		jQuery.validator.addMethod("isPhone", function(value, element) {
          var length = value.length;
          var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
          return this.optional(element) || (length == 11 && mobile.test(value));
         }, "请填写正确的手机号码");
		
		var validate = $("#myform").validate({
			rules : {
				  address:{
					  required:true,
				  },
				  phone:{ 
					  required:true, 
					  isPhone:true 
				}
			},
			messages : {
				  address:{
					  required:"地址不能为空",
				  },
				  phone:{ 
					  required: "请输入您的联系电话", 
					  isPhone: "请输入一个有效的联系电话" 
				}
			}
		});
	});
</script>
</head>
<body>
<h1 align="center">修改个人信息</h1>
<form action="UpdateInfoServlet" method="post" id="myform">
<table align="center" border="1" cellspacing="0" bordercolor="#000000">
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.account}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.uname}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">出&nbsp;&nbsp;生&nbsp;&nbsp;日&nbsp;&nbsp;期</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.birth}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.sex}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">家&nbsp;&nbsp;庭&nbsp;&nbsp;住&nbsp;&nbsp;址</td>
			<td style=" width:600px;">&nbsp;&nbsp;
			<input type="text" id="address" name="address" value="${ui.address}"  style=" width:300px;height:25px;"/><font style="color:red;">*</font></td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">手&nbsp;&nbsp;机&nbsp;&nbsp;号&nbsp;&nbsp;码</td>
			<td style=" width:600px;">&nbsp;&nbsp;
			<input type="text" id="phone" name="phone" value="${ui.phone}" style=" width:300px;height:25px;"/><font style="color:red;">*</font></td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">身&nbsp;&nbsp;份&nbsp;&nbsp;证&nbsp;&nbsp;号</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.idcard}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">账&nbsp;&nbsp;户&nbsp;&nbsp;余&nbsp;&nbsp;额</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.balance}</td>
		</tr>
	</table>
	<table align="center">
	   <tr>
	    <td align="right"style="width: 400px;">${msg}</td>
		<td align="right"style="width: 400px;"><input type="submit"value="提交" style="width: 100px;" /></td>
	   </tr>
	</table>
	<input type="hidden" value="${ui.id}" name="id"/>
</form>
</body>
</html>