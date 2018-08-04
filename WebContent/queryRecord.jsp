<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.finance.model.TradeInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看交易记录</title>
</head>
<body>
<h1 align="center">交易记录</h1>
<table align="center" border="1" cellspacing="0" bordercolor="#000000">
        <%! int curPage,maxPage; %>
        <% curPage =Integer.parseInt(request.getAttribute("curPage").toString()); %> <!--取得当前页-->
        <% maxPage =Integer.parseInt((String)request.getAttribute("maxPage").toString()); %> <!--取得总页数-->
		<tr>
			<td bgcolor="#e1e1e1" style=" width:100px;" align="center">序号</td>
			<td bgcolor="#e1e1e1" style=" width:300px;" align="center">对方账户</td>
			<td bgcolor="#e1e1e1" style=" width:100px;" align="center">交易金额</td>
			<td bgcolor="#e1e1e1" style=" width:100px;" align="center">交易类型</td>
			<td bgcolor="#e1e1e1" style=" width:300px;" align="center">交易日期</td>
		</tr>
		<% 
            List<TradeInfo> list = (List<TradeInfo>) request.getAttribute("list");
            if (request.getAttribute("list") == null){
        	out.print("没有数据！");
        }else {
        	for (TradeInfo tr : list) {
        %>
		<tr>
			<td align="center"><%= tr.getId() %></td>
			<td align="center"><%= tr.getAccount() %></td>
			<td align="center"><%= tr.getMoney() %></td>
			<td align="center"><%= tr.getTradetype() %></td>
			<td align="center"><%= tr.getTradetime() %></td>
		</tr>
		<%
                }
            }
        %>
	</table>
<form name="form1" action="QueryRecordServlet" method="get">
	<table align="center">
	<tr>
	<td>
             第<%= curPage %>页&nbsp; 共<%= maxPage %>页  
    <%if (curPage > 1){
    %>
    <a href="QueryRecordServlet?page=1">首页</a>
    <a href="QueryRecordServlet?page=<%=curPage - 1%>">上一页</a>
    <%
    }else {
    %>
            首页 上一页
    <%
        }%>
    <%if (curPage < maxPage){
    %>  
    <a href="QueryRecordServlet?page=<%=curPage + 1%>">下一页</a>
    <a href="QueryRecordServlet?page=<%=maxPage %>">尾页</a>
    <%
    }else {
    %>
            下一页 尾页
    <%
        }%>
              转至第 <select name="page" onchange="document.form1.submit()">
            <%for ( int i = 1; i <= maxPage; i++){
                if (i == curPage){
            %>
            <!--当前页页码默认选中-->
            <option selected value="<%= i%>"><%= i %></option>
            <%
            }else {
            %>
            <option value="<%= i %>"><%= i %></option>
            <%
                    }
                }%>
        </select>页
</td>
</tr>
</table>
</form>

</body>
</html>