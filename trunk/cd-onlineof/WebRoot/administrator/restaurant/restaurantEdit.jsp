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

		<title>My JSP 'restaurantEdit.jsp' starting page</title>

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
		<form name="restaurantKindForm" action="savaRestaurantAction.do"
			method="post" onsubmit="return validate(this)"
			enctype="multipart/form-data">
			<table style="width: 100%;">
				<thead>
					<th colspan="4">
						编辑餐厅信息
					</th>
				</thead>
				<tbody>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅名称</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span style="white-space: nowrap;"> <!-- 隐藏域餐厅分类ID --> <input
									type="hidden" name="restaurantVo.restaurantId" value="${restaurantVo.restaurantId}" /> <input
									type="text" name="restaurantVo.name" size=30
									value="${restaurantVo.name}" required="string" /><font
								size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅地址</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span><input type="text" name="restaurantVo.address"
									size=30 value="${restaurantVo.address}" required="string" /> <font
								size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅开门时间</span>
						</td>
						<td style="text-align: left;">
							<span><input type="text" name="restaurantVo.openTime"
									size=30 value="${restaurantVo.openTime}" required="string" />
								<font size="+1" color="red">*</font> </span>
						</td>
						<td align="right">
							<span style="white-space: nowrap;">餐厅关门时间</span>
						</td>
						<td style="text-align: left;">
							<span><input type="text" name="restaurantVo.closeTime"
									size=30 value="${restaurantVo.closeTime}" required="string" />
								<font size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅创建人</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span><input type="text" name="restaurantVo.createName"
									size=30 value="${restaurantVo.createName}" required="string" />
								<font size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅分类名称${restaurantVo.resKindId}</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <select
									name="restaurantVo.resKindId">
									<!-- 绑定Action里面的数组 -->
									<s:if test="restaurant_kindVos!=null">
									<option value="">--请选择--</option>
									<s:iterator value="restaurant_kindVos">
										<option value="${restaurant_kind_Id}"
											<s:if test="restaurantVo.resKindId==restaurant_kind_Id">selected</s:if>>
											${name}
										</option>
									</s:iterator>
									</s:if>
									<s:else>
										<option value="">暂无数据</option>										
									</s:else>
								</select> </span>
						</td>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人QQ</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="text"
									name="restaurantVo.QQ" size="30" value="${restaurantVo.QQ}"
									required="string" /> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <input type="text"
									name="restaurantVo.contactName" size=30
									value="${restaurantVo.contactName}" required="string" /> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人电话</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="text"
									name="restaurantVo.contactPhone" size=30
									value="${restaurantVo.contactPhone}" /> </span>
						</td>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人手机</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="text"
									name="restaurantVo.mobilePhone" size=30
									value="${restaurantVo.mobilePhone}" /> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人邮箱</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="text"
									name="restaurantVo.email" size=30 value="${restaurantVo.email}"
									required="email" /> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅联系人性别</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="radio"
									name="restaurantVo.contactGender"
									<s:if test="restaurantVo.contactGender==1">checked</s:if>
									value="1" />男 <input type="radio"
									name="restaurantVo.contactGender"
									<s:if test="restaurantVo.contactGender==0">checked</s:if>
									value="0" />女 </span>
						</td>
						<td align="right">
							<span style="white-space: nowrap;">餐厅状态</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="checkbox"
									name="restaurantVo.status"
									<s:if test="restaurantVo.status==1">checked</s:if> value="1">
							</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅简介</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span style="white-space: nowrap;"> <textarea
									name="restaurantVo.introduction" rows="4" cols="75">${restaurantVo.introduction}</textarea>
							</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅图片</span>
						</td>
						<td colspan="3" style="text-align: left;">
							<span style="white-space: nowrap;"> <input type="file"
									name="resFile"><font size="+1" color="red">注意:只允许(*.jpeg,*.gif,*.png)格式图片上传</font>
							</span>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td align="center" colspan="4">
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
