<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账</title>
<script type="text/javascript" src="/finance/js/jquery.js"></script>
<script type="text/javascript" src="/finance/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function() {
		 //自定义validate验证输入的数字小数点位数不能大于两位
        jQuery.validator.addMethod("minNumber",function(value, element){
            var returnVal = true;
            inputZ=value;
            var ArrMen= inputZ.split(".");    //截取字符串
            if(ArrMen.length==2){
                if(ArrMen[1].length>2){    //判断小数点后面的字符串长度
                    returnVal = false;
                    return false;
                }
            }
            return returnVal;
        },"小数点后最多为两位");         //验证错误信息

		var validate = $("#myform").validate({
			rules : {
				account:{
					required: true,
					number: true,
					minlength: 18,
	                maxlength: 20
				},
				money: {
                    required: true,    //要求输入不能为空
                    number: true,     //输入必须是数字
                    min: 0.01,          //输入的数字最小值为0.01，不能为0或者负数
                    minNumber: $("#money").val()    //调用自定义验证
                }
			},
			messages : {
				account:{
					required: "对方账户不能为空",
					number: "对方账户必须是数字",
					minlength: "对方账户长度不能少于18个字符",
	                maxlength: "对方账户长度不能超过20个字符"
				},
				money: {
                    required: "转账金额不能为空",
                    number: "转账金额必须是数字",
                    min: "转账金额最小为0.01",
                    minNumber: "转账金额最多小数点后两位"
                }

			}
		});
	});
</script>
</head>
<body>
<h1 align="center">转&nbsp;&nbsp;账</h1>
<form action="TransferServlet" method="post" id="myform">
<table align="center" border="1" cellspacing="0" bordercolor="#000000">
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">转&nbsp;&nbsp;账&nbsp;&nbsp;时&nbsp;&nbsp;间</td>
			<td style=" width:600px;">&nbsp;&nbsp;
			<input type="text" name="time" value="<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>" style=" height:25px;"/>
			</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">对&nbsp;&nbsp;方&nbsp;&nbsp;账&nbsp;&nbsp;户</td>
			<td style=" width:600px;">&nbsp;&nbsp;
			<input type="text" id="account" name="account" style=" height:25px;"/><font style="color:red;">*</font></td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">转&nbsp;&nbsp;账&nbsp;&nbsp;金&nbsp;&nbsp;额</td>
			<td style=" width:600px;">&nbsp;&nbsp;
			<input type="text" id="money" name="money" style=" height:25px;"/><font style="color:red;">*</font>
			</td>
		</tr>
	</table>
	<table>
	   <tr>
	    <td align="right"style="width: 400px;">${msg}</td>
		<td align="right"style="width: 400px;"><input type="submit"value="提交" style="width: 100px;" /></td>
	   </tr>
	</table>
</form>
</body>
</html>