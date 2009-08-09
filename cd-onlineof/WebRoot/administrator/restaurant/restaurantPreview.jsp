<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>餐厅信息预览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<div align="center">
   			<div align="center">${restaurantVo.name}(图)</div><br>
   			<div align="center"><img src="imgRestaurantAction.do?restaurantVo.restaurantId=${restaurantVo.restaurantId}" /></div>
   			<div align="center">餐厅名称:${restaurantVo.name}</div>
   			<div align="center">
   				<span>餐厅开门时间:${restaurantVo.openTime}</span>&nbsp;&nbsp;&nbsp;&nbsp;
   				<span>餐厅关门时间:${restaurantVo.closeTime}</span>
   			</div>
   			<div align="center">餐厅简介:${restaurantVo.introduction}</div>
   			<div align="center">餐厅联系电话:${restaurantVo.contactPhone}</div>
   			<div align="center">餐厅联系地址:${restaurantVo.address}</div>
   		</div>
  </body>
</html>
