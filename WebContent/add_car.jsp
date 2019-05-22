<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "entity.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	shop aShop = (shop)session.getAttribute("aShop");
	Map<Integer,shopCar> car = (Map<Integer,shopCar>) session.getAttribute("car");
	if(car == null){
		car = new HashMap<>();
	}
	shopCar item = car.get(aShop.getShopId());
	if(item == null){
		item = new shopCar();
		item.setNum(1);
		item.setShops(aShop);
	}else{
		item.setNum(item.getNum()+1);
	}
	car.put(aShop.getShopId(), item);
	session.setAttribute("car", car);
	response.sendRedirect("empty_car.jsp");
%>
</body>
</html>