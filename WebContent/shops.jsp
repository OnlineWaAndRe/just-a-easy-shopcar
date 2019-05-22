<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.*,java.util.List, entity.shop" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>no one</title>
</head>
<body>
<div style = "text-align: right; font-family: consolas; font-size: 28px;">
	<a href = "empty_car.jsp">我的购物车</a>
</div>
	<%
		shopService ss = new shopService();
		List<shop> listShop = ss.getAllShop();
	%>
	<table align = "center" width = "100%">
		<tr>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>商品库存</th>
			<th>商品描述</th>
		</tr>
		<%
			for(shop s : listShop){
		%>
		<tr align = "center">
			<td><a href="temp_shop.jsp?shopId=<%=s.getShopId()%>"><%=s.getShopName() %></a></td>
			<td><%=s.getShopPrice() %></td>
			<td><%=s.getShopNum() %></td>
			<td><%=s.getShopDetial()%></td>
			<td></td>
		</tr>
		<%} %>
	</table>
	<div style = "text-align: center; font-family: consolas; font-size: 28px;">
		<a href = "shops.jsp">再看看</a>
	</div>
</body>
</html>