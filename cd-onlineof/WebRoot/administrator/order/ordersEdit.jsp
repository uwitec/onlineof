<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>订单详细信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/common/css/common.css" />
		<link
			href="${pageContext.request.contextPath}/administrator/css/table.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function status(id) {
				var sta = document.getElementById("status");
				window.location = "update.do?ordersVo.ordersId=" + id + "&ordersVo.status=" + sta.value;
			}
		</script>
	</head>
	<body
		style="margin-top: 1px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
		<table style="width: 100%">
			<tr>
				<td colspan="2" align="center">
					<font color="#FF0000"><b>订单号：</b>${ordersVo.ordersCode}</font>&nbsp;&nbsp;&nbsp;
					<b>下单用户：</b>${ordersVo.loginName}
					<input name="Submit4" type="button" class="input_bot" onclick="javascript:window.print();" value="打印">
				</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 25%">
					<strong>菜单：</strong>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="2" cellspacing="1">
						<tr>
							<td align="center">
								<strong>名称</strong>
							</td>
							<td align="center">
								<strong>数量</strong>
							</td>
							<td align="center">
								<strong>单价</strong>
							</td>
							<td align="center">
								<strong>类别</strong>
							</td>
						</tr>
						<s:iterator value="itemVoList">
							<tr>
								<td align="center">
									<a href="foodPreViewAction.do?foodVo.foodId=${foodId}"><s:property value="name" /></a>
								</td>
								<td align="center">
									<s:property value="num" />
								</td>
								<td align="center">
									<s:property value="price" />
								</td>
								<td align="center">
									<s:property value="kindName" />
								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>订餐人：</strong>
				</td>
				<td style="text-align: left;">
					<s:property value="ordersVo.contactName" />
					<s:if test="ordersVo.contactGender == 0">(女士)</s:if>
					<s:else>(先生)</s:else>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>送餐地址：</strong>
				</td>
				<td style="text-align: left;">
					<s:property value="ordersVo.requestAddress" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>配送费用：</strong>
				</td>
				<td style="text-align: left">
					${tip}(元)
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>金额总计：</strong>
				</td>
				<td style="text-align: left">
					<s:property value="ordersVo.totalPrice" />
					(元)
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>联系电话：</strong>
				</td>
				<td style="text-align: left">
					<s:property value="ordersVo.contactPhone" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>下单日期：</strong>
				</td>
				<td style="text-align: left">
					<s:property value="ordersVo.ordersDate" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<strong>订单状态：</strong>
				</td>
				<td style="text-align: left">
					<input type="hidden" value="${ordersVo.ordersId}">
					<input type="hidden" value="${o}">
					<select id="status" name="ordersVo.status" onchange="javascript:status('<s:property value="ordersVo.ordersId" />');">
					<s:if test="ordersVo.status == '待处理'">
						<option value="待处理" selected="selected">
							待处理
						</option>
						<option value="配送中">
							配送中
						</option>
						<option value="完成">
							完成
						</option>
					</s:if>
					<s:elseif test="ordersVo.status == '配送中'">
						<option value="待处理">
							待处理
						</option>
						<option value="配送中" selected="selected">
							配送中
						</option>
						<option value="完成">
							完成
						</option>
					</s:elseif>
					<s:elseif test="ordersVo.status == '完成'">
						<option value="待处理">
							待处理
						</option>
						<option value="配送中">
							配送中
						</option>
						<option value="完成" selected="selected">
							完成
						</option>
					</s:elseif>
					</select>
				</td>
			</tr>
			<s:if test="#session.session.usersVo.isSuper == 1">
				<tr>
					<td style="text-align: right;">
						<strong>所属餐厅/酒店：</strong>
					</td>
					<td style="text-align: left">
						<s:property value="ordersVo.restaurantName" />
					</td>
				</tr>
			</s:if>
			<tr>
				<td style="text-align: right;">
					<strong>备注：</strong>
				</td>
				<td style="text-align: left">
					<s:property value="ordersVo.remark" />
				</td>
			</tr>
		</table>
		<s:if test="#request.upd == true">
			<script type="text/javascript">alert("修改成功");</script>
		</s:if>
	</body>
</html>
