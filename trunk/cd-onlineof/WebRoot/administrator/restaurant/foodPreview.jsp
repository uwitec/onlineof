<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜信息预览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <div align="center">
   			<div align="center">${foodVo.name}(图)</div><br>
   			<div align="center"><img src="image?resId=${foodVo.foodId}&typeId=2" style="width:400px;height:250px;"/></div>
   			<div align="center">餐厅菜名称:${foodVo.name}</div>
   			<div align="center">菜价格￥:${foodVo.price}元/份</div>
   			<div align="center">菜简介:${foodVo.introduction}</div>
   			<div align="center">所属菜类别:${foodVo.food_kind_Name}</div>
   			<div align="center">所属餐厅:${foodVo.restaurantName}</div>
   		</div>
   		<div align="center"><input type="button" value="返回" onclick="window.history.back()"/></div>
  </body>
</html>
