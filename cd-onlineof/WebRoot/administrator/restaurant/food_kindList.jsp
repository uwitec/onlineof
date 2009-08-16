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

		<title>餐厅菜类别列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="administrator/css/table.css" rel="stylesheet"
			type="text/css" />
		<SCRIPT type="text/javascript" src="common/js/common.js"></SCRIPT>
		<script type="text/javascript">
			/*跳转到添加页面*/
			function addFoodKind(){
				window.location.href = "editFoodKindAction.do?food_kindVo.food_kind_Id=";
			}
			/*删除选定菜类别*/
			function delSelectedFoodKind(){
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
		<form action="getFoodKindPageAction.do" name="seachResKind"
			method="post">
			<div style="width: 100%; font-size: 10pt;">
				<span style="white-space: nowrap;"> 
				<s:if test="session.administrator">
				<span style="white-space: nowrap;">请选择餐厅/酒店</span>
				<SELECT name="restaurantId">
					<option value="">所有餐厅/酒店</option>
					<s:iterator value="restaurantVos">
						<option value="${restaurantId}">${name}</option>
					</s:iterator>
				</SELECT>
				</s:if>
				<span style="white-space: nowrap;">饮食类别名称</span> 
					 <input type="text" name="foodKindName"  /> 
					 <input type="submit" value="搜 索" />
					<input type="button" value="新增饮食类别" onclick="addFoodKind();" />
					<input type="button" value="删除选定饮食类别"
						onclick="delSelectedFoodKind();" /> </span>
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
							<span style="white-space: nowrap;">饮食类别名称</span>
						</th>
						<th>
							<span style="white-space: nowrap;">所属餐厅/酒店</span>
						</th>
						<th>
							<span style="white-space: nowrap;">饮食类别描述</span>
						</th>
						<th>饮食类型操作</th>
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
											value="${food_kind_Id}" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="name" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="restaurantName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="description" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"> <a
										href="deleteFoodKindAction.do?food_kindVo.food_kind_Id=${food_kind_Id}"
										class="button">删除</a> <a
										href="editFoodKindAction.do?food_kindVo.food_kind_Id=${food_kind_Id}"
										class="button">编辑</a>
										 <a href="getFoodPageAction.do?foodKindId=${food_kind_Id}">该类下所有饮食</a> </span>
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
					liststep="10" dispalytext="条记录" url="getFoodKindPageAction.do?foodKindName=${foodKindName}&restaurantId=${restaurantId}" />
			</div>
			<!-- 分页end -->
		</form>
	</body>
</html>
