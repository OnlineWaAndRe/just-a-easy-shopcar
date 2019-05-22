<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.util.*, entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Please save the poor children of Uganda.</title>
</head>
<body>
	<p>Please save the poor children of Uganda.</p>
	<table align = "center" width = "100%" border = "1px">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品单价</td>
			<td>购买数量</td>
			<td>商品小计</td>
		</tr>
		<%
			Map<Integer,shopCar> car = (Map<Integer,shopCar>) session.getAttribute("car");
			double count = 0;
			for(Map.Entry<Integer,shopCar> entry : car.entrySet()){
				double price = entry.getValue().getNum() * entry.getValue().getShops().getShopPrice();
				count += price;
		%>
		<tr>
			<td><%=entry.getValue().getShops().getShopId() %></td>
			<td><%=entry.getValue().getShops().getShopNum() %></td>
			<td><%=entry.getValue().getShops().getShopPrice() %></td>
			<td><%=entry.getValue().getNum() %></td>
			<td><%=price%></td>
		</tr>
		<%} %>
		<tr>
			<td colspan = "4" align = "center">商品总价</td>
			<td> <%=count %></td>
		</tr>
		
	</table>
</body>
</html>