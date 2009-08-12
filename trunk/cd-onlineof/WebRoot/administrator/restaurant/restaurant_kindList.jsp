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
		<link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
		<SCRIPT type="text/javascript" src="common/js/common.js"></SCRIPT>
		<script type="text/javascript">
			//添加餐厅分类信息
			function addRestaurantKind(){
				window.location.href="editRestaurantKindAction.do?restaurant_kindVo.restaurant_kind_Id=";
			}
			//删除选中的餐厅分类
			function delSelectedRestaurantKind(){
				var cks = document.getElementsByName("checksItem");
				var tempCkValues = new Array();
				for(var i=0;i<cks.length;i=i+1){
					if(cks[i].checked){
						tempCkValues.push(cks[i].value);
					}
				}
				if(tempCkValues!=null&&tempCkValues.length>0){
					window.location.href="delRestaurantKindAction.do?checksItem="+tempCkValues;
				}else{
					alert("请选择要删除的分类!");
				}
			}
		</script>
	</head>

	<body>
		<form action="restaurantKindPageAction.do" name="seachResKind" method="post">
			<div style="width: 100%; font-size: 10pt;">
				<span style="white-space: nowrap;"> <span
					style="white-space: nowrap;">餐厅分类名称</span> <input type="text"
						name="kindName" /> <input type="submit" value="搜 索" /> <input
						type="button" value="新增餐厅分类" onclick="addRestaurantKind();" /> <input
						type="button" value="删除选定分类" onclick="" /> </span>
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
							<span style="white-space: nowrap;">餐厅分类名称</span>
						</th>
						<th>
							<span style="white-space: nowrap;">餐厅分类描述</span>
						</th>
						<th>
							<span style="white-space: nowrap;">创建时间</span>
						</th>
						<th>
							<span style="white-space: nowrap;">操作</span>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:set name="data" value="pageBean.array" />
					<s:if test="#data!=null&&#data.size!=0">
						<s:iterator value="pageBean.array">
							<tr>
								<td>
									<span style="white-space: nowrap;"><input
											type="checkbox" id="checksItem" name="checksItem"
											value="${restaurant_kind_Id}" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="name" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="description" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="createTime" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"> <a
											href="delRestaurantKindAction.do?restaurant_kindVo.restaurant_kind_Id=${restaurant_kind_Id}"
											cssClass="button">删除</a> <a
										href="editRestaurantKindAction.do?restaurant_kindVo.restaurant_kind_Id=${restaurant_kind_Id}"
										class="button">编辑</a> </span>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="6">
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
					liststep="10" dispalytext="条记录" url="restaurantKindPageAction.do?kindName=${kindName}" />
			</div>
			<!-- 分页end -->
		</form>
	</body>
</html>
