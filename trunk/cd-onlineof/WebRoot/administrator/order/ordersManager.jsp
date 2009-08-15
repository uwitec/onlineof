<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>订单管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/common.css" />
		<link href="${pageContext.request.contextPath}/administrator/css/table.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/common.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/common/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			function hasChecked() {
				var cks = document.getElementsByName("checksItem");
				for (var i = 0; i < cks.length; i++){
					if (cks[i].checked) {
						return true;
					}
				}
				return false;
			}
			function chang() {
				var sele = document.getElementById("status");
				var cks = document.getElementsByName("checksItem");
				if (sele.value != "" && hasChecked()){
					var fo = document.getElementById("ordersForm");
					fo.action = "updateMany.do";
					fo.submit();
				}
			}
			function del() {
				var cks = document.getElementsByName("checksItem");
				if (cks.length > 0){
					var f = document.getElementById("ordersForm");
					f.action = "del.do";
					f.submit();
				}
			}
		</script>
	</head>
	<body
		style="margin-top: 0px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
		<form id="ordersForm" action="searchOrders.do" method="post">
			<input type="hidden" name="o" value="${o}">
			<div style="width: 100%; font-size: 10pt;">
				<span style="white-space: nowrap;">
				<span style="white-space: nowrap;">用户名</span>
					<input type="text" id="usersname" name="ordersVo.loginName" size="12"/>
					<s:if test="#session.session.usersVo.isSuper == 1">
						<span style="white-space: nowrap;">所属餐厅/酒店</span>
						<span style="white-space: nowrap;">
							<select id="restaurantId" name="ordersVo.restaurantName">
								<s:if test="restaurantVos == null || restaurantVos.size == 0">
									<option value="">
										暂无数据
									</option>
								</s:if>
								<s:else>
									<option value="">
										--请选择--
									</option>
									<s:iterator value="restaurantVos">
										<option value="<s:property value='name'/>">
											<s:property value="name" />
										</option>
									</s:iterator>
								</s:else>
							</select>
						</span>
					</s:if>&nbsp;
					<span style="white-space: nowrap;">
						订单状态
					</span>
					<span style="white-space: nowrap;">
						<select name="ordersVo.status">
							<option value="">--请选择--</option>
							<option value="待处理">待处理</option>
							<option value="配送中">配送中</option>
							<option value="完成">完成</option>
						</select>
					</span>&nbsp;
					<s:if test="o != 'tod'">
						<span style="white-space: nowrap;">
							订单时间段
						</span>
						<span style="white-space: nowrap;">
							<input type="text" name="ordersVo.ordersDate" size="12" onFocus="new WdatePicker(this,'%Y-%M-%D',false)" class="Wdate">
							至
							<input type="text" name="endTime" size="12" onFocus="new WdatePicker(this,'%Y-%M-%D',false)" class="Wdate">
						</span>
					</s:if>
					<span style="white-space: nowrap;">
						<input type="submit" value="查询"/>
					</span>
					<s:if test="o == 'tod'">
					<span style="white-space: nowrap;">
						<input type="button" value="新增订单" onclick="window.location = 'add.do'"/>
					</span>
					</s:if>
					<span style="white-space: nowrap;">
						<select id="status" name="status" onchange="javascript:chang();">
							<option value="">订单操作</option>
							<option value="配送中">确认订单</option>
							<option value="完成">完成订单</option>
						</select>
					</span>
					<span style="white-space: nowrap;">
						<input type="button" value="删除" onclick="javascript:del();"/>
					</span>
				</span>
			</div>
			<table style="width: 100%;">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkAll" name="checkAll"
								onclick="checkedAll()" />
							<span style="white-space: nowrap;">订单号</span>
						</th>
						<th>
							<span style="white-space: nowrap;">下单用户</span>
						</th>
						<th>
							<span style="white-space: nowrap;">订餐人</span>
						</th>
						<th>
							<span style="white-space: nowrap;">金额总计</span>
						</th>
						<th>
							<span style="white-space: nowrap;">下单时间</span>
						</th>
						<th>
							<span style="white-space: nowrap;">订单状态</span>
						</th>
						<s:if test="#session.session.usersVo.isSuper == 1">
							<th>
								<span style="white-space: nowrap;">所属酒店/餐厅</span>
							</th>
						</s:if>
					</tr>
				</thead>
				<tbody>
					<s:if test="pb.array.size != 0">
						<s:iterator value="pb.array">
							<tr>
								<td>
									<input type="checkbox" id="checksItem" name="checksItem"
										value="<s:property value='ordersId'/>"
										onclick="checkedJudge(this)" />
									<span style="white-space: nowrap;"><a href="getInfo.do?ordersVo.ordersId=${ordersId}"><s:property
											value="ordersCode" /></a></span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="loginName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="contactName" />&nbsp;<s:if test="contactGender == 0">(女士)</s:if>
										<s:else>(先生)</s:else> </span>

								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="totalPrice" />&nbsp;(元)</span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="ordersDate" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="status" /> </span>
								</td>
								<s:if test="#session.session.usersVo.isSuper == 1">
									<td>
										<span style="white-space: nowrap;"><s:property
												value="restaurantName" /> </span>
									</td>
								</s:if>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="8">
								<span style="white-space: nowrap;"><font
									style="color: red;">暂无数据</font> </span>
							</td>
						</tr>
					</s:else>
				</tbody>
			</table>
		</form>
		<!-- 分页start -->
		<s:if test="pb.array.size != 0">
			<div class="pagination" style="font-size: 10pt;">
				<page:pages1 pagesize="${pb.pagesize}"
					currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
					totalRow="${pb.totalRow}" liststep="10" dispalytext="笔订单"
					url="searchOrders.do?o=${o}&ordersVo.loginName=${ordersVo.loginName}&ordersVo.restaurantName=${ordersVo.restaurantName}&ordersVo.ordersDate=${ordersVo.ordersDate}&endTime=${endTime}&ordersVo.status=${ordersVo.status}" />
			</div>
		</s:if>
		<!-- 分页end -->
	</body>
</html>