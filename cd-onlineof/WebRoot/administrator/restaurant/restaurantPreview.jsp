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
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
        // 返回
        function back(){
            window.location.href="getRestaurantPageAction.do";
        }
    </script>
  </head>
  
  <body>
   		<div align="center">
   			<div align="center">${restaurantVo.name}(图)</div><br>
   			<div align="center"><img src="imgRestaurantAction.do?restaurantVo.restaurantId=${restaurantVo.restaurantId}" style="width:400px;height:250px;"/></div>
   			<div align="center">餐厅名称:${restaurantVo.name}</div>
   			<div align="center">
   				<span>餐厅开门时间:${restaurantVo.openTime}</span>&nbsp;&nbsp;&nbsp;&nbsp;
   				<span>餐厅关门时间:${restaurantVo.closeTime}</span>
   			</div>
   			<div align="center">餐厅简介:${restaurantVo.introduction}</div>
   			<div align="center">餐厅联系电话:${restaurantVo.contactPhone}</div>
   			<div align="center">餐厅联系地址:${restaurantVo.address}</div>
   		</div>
   		<div align="center"><input type="button" value="返回" onclick="back()"/></div>
  </body>
</html>
