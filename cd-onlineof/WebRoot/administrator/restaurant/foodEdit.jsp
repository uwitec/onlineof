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

		<title>编辑菜信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="administrator/css/table.css">
		<script type="text/javascript" src="common/js/validate.js"></script>
		<script
			src="${pageContext.request.contextPath}/dwr/interface/LoadFoodKindDwrAction.js"></script>
		<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
		<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
		<script type="text/javascript">
		function getFoodKindByRestaurantId(){
			var restaurantId = DWRUtil.getValue("restaurantId");
			// alert("restaurantId="+restaurantId);
			var foodkindId = DWRUtil.getValue("fKindId");
			 // alert("foodkindId="+foodkindId);
			LoadFoodKindDwrAction.loadFoodKindByRestaurantId(restaurantId,function (foodKinds){
				DWRUtil.removeAllOptions("selKindId");
				DWRUtil.addOptions("selKindId",foodKinds,"food_kind_Id","name");
				DWRUtil.setValue("selKindId",foodkindId); //选定原有选项
			});
		}
	</script>
	</head>

	<body
		style="margin-top: 1px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px;"
		onload="getFoodKindByRestaurantId();">
		<form name="foodForm" action="savaFoodAction.do" method="post"
			onsubmit="return validate(this)" enctype="multipart/form-data">
			<table style="width: 100%;">
				<thead>
					<th colspan="4">
						编辑餐厅菜信息
					</th>
				</thead>
				<tbody>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅菜名称</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <!-- 隐藏菜ID --> <input
									type="hidden" name="foodVo.foodId"
									value="${foodVo.foodId}" /> <input type="hidden"
									name="foodKindId" value="${foodKindId}" /> <input type="text"
									name="foodVo.name" size="30" value="${foodVo.name}"
									required="string" /><font size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅菜价格</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <input type="text"
									name="foodVo.price" size="30" value="${foodVo.price}"
									required="string" /><font size="+1" color="red">*</font> </span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="white-space: nowrap;">是否招牌菜</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <input type="checkbox"
									name="foodVo.isSigns"
									<s:if test="foodVo.isSigns==1">checked</s:if> value="1" /> </span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="white-space: nowrap;">菜所属餐厅</span>
						</td>
						<td style="text-align: left;">
							<input type="hidden" id="fKindId"
								value="${foodVo.food_kindId}" />
							<span style="white-space: nowrap;"> <select
									id="restaurantId" name="foodVo.restaurantId"
									onchange="getFoodKindByRestaurantId();" style="width: 150px">
									<s:if test="restaurantVos!=null">
									<option value="">--请选择--</option>
									<s:iterator value="restaurantVos">
										<option value="${restaurantId}"
											<s:if test="foodVo.restaurantId == restaurantId">selected</s:if>>
											${name}
										</option>
									</s:iterator>
									</s:if>
									<s:else>
										<option value="">暂无数据</option>
									</s:else>
								</select> </span>
						</td>
						<td>
							<span style="white-space: nowrap;">请选择类别</span>
						</td>
						<td style="text-align: left;">
							<span style="white-space: nowrap;"><select
									style="width: 150px" id="selKindId" name="foodVo.food_kindId">
								</select>
							</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅菜描述</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <textarea
									name="foodVo.introduction" rows="4" cols="75">${foodVo.introduction}</textarea>
							</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<span style="white-space: nowrap;">餐厅菜图片</span>
						</td>
						<td style="text-align: left;" colspan="3">
							<span style="white-space: nowrap;"> <input type="file"
									name="foodImg" /><font size="+1" color="red">注意:只允许(*.jpeg,*.gif,*.png)格式图片上传</font>
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
