<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "entity.shop" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	shop aShop = (shop)session.getAttribute("aShop");
%>
<div style = "text-align: right; font-family: consolas; font-size: 28px;">
	<a href = "empty_car.jsp">我的购物车</a>
</div>
<table align = "center" cellpadding = "20" cellspacing = "20">
	<tr>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>商品库存</td>
		<td>商品配置</td>
	</tr>
	<tr>
		<td><%=aShop.getShopId() %></td>
		<td><%=aShop.getShopName() %></td>
		<td><%=aShop.getShopPrice() %></td>
		<td><%=aShop.getShopNum() %></td>
		<td><%=aShop.getShopDetial() %></td>
	</tr>
	<tr>
		<td colspan = "2"></td>
		<td><a href = "add_car.jsp">加入购物车</a></td>
		<td><a href = "shops.jsp"> 查看更多商品</a></td>
	</tr>
</table>
</body>
</html>