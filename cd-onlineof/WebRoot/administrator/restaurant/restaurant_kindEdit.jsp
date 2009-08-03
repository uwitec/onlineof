<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>餐厅分类信息管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="common/css/common.css">
		<script type="text/javascript" src="common/js/validate.js"></script>

	</head>

	<body
		style="margin-top: 1px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
		<form name="restaurantKindForm" action="savaRestaurantKindAction.do"
			method="post" onsubmit="return validate(this)">
			<table class="table" style="width: 100%;">
				<thead>
					<th colspan="2"> 
						编辑餐厅分类信息 
					</th>
				</thead>
				<tbody>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅分类名称</span>
						</td>
						<td>
							<span style="white-space: nowrap;"> <!-- 隐藏域餐厅ID -->
							<input type="hidden" value="<s:property value='restaurant_kindVo.restaurant_kind_Id'/>" />
								<input type="text" name="restaurant_kindVo.name" size=30
									value="<s:property value='restaurant_kindVo.name'/>" required="string"/><font size="+1" color="red">*</font></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅分类说明</span>
						</td>
						<td>
							<span style="white-space: nowrap;">
							 <textarea name="restaurant_kindVo.description" rows="4" cols="75">${restaurant_kindVo.description}</textarea> 
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
