<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑餐厅菜类别信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
			href="administrator/css/table.css">
	<script type="text/javascript" src="common/js/validate.js"></script>

  </head>
  
<body
		style="margin-top: 1px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
		<form name="restaurantKindForm" action="savaFoodKindAction.do"
			method="post" onsubmit="return validate(this)">
			<table style="width: 100%;">
				<thead>
					<th colspan="4">
						编辑餐厅分类信息
					</th>
				</thead>
				<tbody>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅菜类别名称</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <!-- 隐藏菜类别ID --> <input
									type="hidden"
									value="${food_kindVo.food_kind_Id}" />
								<input type="text" name="food_kindVo.name" size=30
									value="${food_kindVo.name }"
									required="string" /><font size="+1" color="red">*</font>
							</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">菜类别所属餐厅</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> 
								<select name="food_kindVo.restaurantId">
									<s:iterator value="restaurantVos">
										<option value="${restaurantId}" <s:if test="food_kindVo.restaurantId == restaurantId">selected</s:if> >${name}</option>
									</s:iterator>
								</select>
							</span>
						</td>
					</tr>
				<tr>
					<td align="right">
						<span style="white-space: nowrap;">餐厅菜类别描述</span>
					</td>
					<td style="text-align: left;">
						<span style="white-space: nowrap;"> <textarea
								name="food_kindVo.description" rows="4" cols="75">${food_kindVo.description}</textarea>
						</span>
					</td>
				</tr>
				</tbody>
				<tfoot>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" value="保存">
							<input type="reset" value="重置">
							<input type="button" value="返回" onclick="window.history.back()">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
