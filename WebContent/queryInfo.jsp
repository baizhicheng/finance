<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看个人信息</title>
</head>
<body>
<h1 align="center">查看个人信息</h1>
  <form action="QueryInfoServlet" method="post">
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
			<td style=" width:600px;">&nbsp;&nbsp;${ui.address}</td>
		</tr>
		<tr>
			<td bgcolor="#e1e1e1" style=" width:200px;height:50px" align="center">手&nbsp;&nbsp;机&nbsp;&nbsp;号&nbsp;&nbsp;码</td>
			<td style=" width:600px;">&nbsp;&nbsp;${ui.phone}</td>
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
  </form>
</body>
</html>