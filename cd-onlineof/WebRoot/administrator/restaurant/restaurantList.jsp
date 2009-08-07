<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
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

		<title>餐厅分类信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="administrator/css/table.css" rel="stylesheet"
			type="text/css" />
		<SCRIPT type="text/javascript" src="common/js/common.js"></SCRIPT>
		<script type="text/javascript">
			//添加餐厅信息
			function addRestaurantKind(){
				window.location.href="editRestaurantAction.do?restaurantVo.restaurantId=";
			}
			//删除选中的餐厅
			function delSelectedRestaurantKind(){
				if(window.confirm("您确定要删除吗?")){
					var cks = document.getElementsByName("checksItem");
					var tempCkValues = new Array();
					for(var i=0;i<cks.length;i=i+1){
						if(cks[i].checked){
							tempCkValues.push(cks[i].value);
						}
					}
					if(tempCkValues!=null&&tempCkValues.length>0){
						window.location.href="deleteRestaurantAction.do?checksItem="+tempCkValues;
					}else{
						alert("请选择要删除的分类!");
					}
				}
			}
		</script>
	</head>

	<body>
		<form action="getRestaurantPageAction.do" name="seachResKind"
			method="post">
			<div style="width: 100%; font-size: 10pt;">
				<span style="white-space: nowrap;"> <span
					style="white-space: nowrap;">餐厅分类名称</span> <select name="kindId">
						<option value="">
							所有类型
						</option>
						<s:iterator value="restaurant_kindVos">
							<option value="${restaurant_kind_Id}"
								<s:if test="kindId == restaurant_kind_Id">selected</s:if>>
								${name}
							</option>
						</s:iterator>
					</select> 餐厅名称:<input type="text" name="restaurantName"
						value="${restaurantName}" /> <input type="submit" value="搜 索" />
					<input type="button" value="新增餐厅" onclick="addRestaurantKind();" />
					<input type="button" value="删除选定餐厅"
						onclick="delSelectedRestaurantKind();" /> </span>
			</div>
			<table class="table" style="width: 100%;">
				<thead>
					<tr>
						<th>
							<span style="white-space: nowrap;"><input type="checkbox"
									name="ids" id="checkAll" name="checkAll" onclick="checkedAll()" />
							</span>
						</th>
						<th>
							<span style="white-space: nowrap;">餐厅名称</span>
						</th>
						<th>
							<span style="white-space: nowrap;">创建者</span>
						</th>
						<th>
							<span style="white-space: nowrap;">餐厅分类名称</span>
						</th>
						<th>
							<span style="white-space: nowrap;">餐厅联系人</span>
						</th>
						<th>
							<span style="white-space: nowrap;">联系人手机</span>
						</th>
						<th>
							<span style="white-space: nowrap;">联系人邮箱</span>
						</th>
						<th>
							<span style="white-space: nowrap;">操作</span>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:set name="data" value="pageBean.array" />
					<s:if test="#data != null">
						<s:iterator value="pageBean.array">
							<tr>
								<td>
									<span style="white-space: nowrap;"><input
											type="checkbox" id="checksItem" name="checksItem"
											value="${restaurantId}" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="name" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="createName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="resKindName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="contactName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="mobilePhone" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="email" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"> <a
										href="deleteRestaurantAction.do?restaurantVo.restaurantId=${restaurantId}"
										class="button">删除</a> <a
										href="editRestaurantAction.do?restaurantVo.restaurantId=${restaurantId}"
										class="button">编辑</a> <a
										href="getFoodKindByRestaurantIdAction.do?restaurantId=${restaurantId}">设置餐厅菜分类</a>
									</span>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="12">
								<span style="white-space: nowrap;"><font
									style="color: red;">暂无数据</font> </span>
							</td>
						</tr>
					</s:else>
				</tbody>
			</table>
			<!-- 分页start -->
			<div class="pagination">
				<page:pages1 pagesize="${pageBean.pagesize}"
					currentPage="${pageBean.currentPage}"
					totalPage="${pageBean.totalPage}" totalRow="${pageBean.totalRow}"
					liststep="10" dispalytext="条记录"
					url="getRestaurantPageAction.do?kindName=${kindName}" />
			</div>
			<!-- 分页end -->
		</form>
	</body>
</html>
