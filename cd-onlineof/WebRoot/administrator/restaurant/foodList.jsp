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

		<title>菜信息列表</title>

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
			function addFood(){
				var foodKindId = document.getElementsByName("foodKindId")[0].value;
				window.location.href = "editFoodAction.do?foodKindId="+foodKindId+"&foodVo.foodId=";
			}
			/*删除选定菜类别*/
			function delSelectedFood(){
				var cks = document.getElementsByName("checksItem");
				var tempCkValues = new Array();
				for(var i=0;i<cks.length;i=i+1){
					if(cks[i].checked){
						tempCkValues.push(cks[i].value);
					}
				}
				if(tempCkValues!=null&&tempCkValues.length>0){
					window.location.href="deleteFoodAction.do?checksItem="+tempCkValues;
				}else{
					alert("请选择要删除的菜!");
				}
			}
		</script>
	</head>

	<body>
		<form action="getFoodPageAction.do" name="seachResKind" method="post">
			<div style="width: 100%; font-size: 10pt;">
				<span style="white-space: nowrap;"> <span
					style="white-space: nowrap;">请选择餐厅</span> <!-- 隐藏传递过来的fookKindId -->
					<input type="hidden" name="foodKindId" value="${foodKindId}" /> 
					<SELECT name="restaurantId">
						<option value="">
							所有餐厅
						</option>
						<s:if test="null!=restaurantVos&&restaurantVos.size>0">
							<s:iterator value="restaurantVos">
								<option value="${restaurantId}">${name}</option>
							</s:iterator>
						</s:if>
						<s:else>
							<option value="">暂无餐厅/酒店数据</option>
						</s:else>
					</SELECT> <span style="white-space: nowrap;">餐厅菜名称</span> <input type="text"
						name="foodName" /> <input type="submit" value="搜 索" /> <input
						type="button" value="新增菜信息" onclick="addFood();" /> <input
						type="button" value="删除选定菜信息" onclick="delSelectedFood();" /> </span>
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
							<span style="white-space: nowrap;">餐厅菜名称</span>
						</th>
						<th>
							<span style="white-space: nowrap;">所属餐厅</span>
						</th>
						<th>
							<span style="white-space: nowrap;">所属类别</span>
						</th>
						<th>
							<span style="white-space: nowrap;">价格(元/份)</span>
						</th>
						<th>
							<span style="white-space: nowrap;">是否是招牌菜</span>
						</th>
						<th>
							<span style="white-space: nowrap;">菜简介</span>
						</th>
						<th>
							餐厅菜信息操作
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
											value="${foodId}" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><a
										href="foodPreViewAction.do?foodVo.foodId=${foodId}">${name}</a>
									</span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="restaurantName" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="food_kind_Name" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="price" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;">${isSigns==1?"是":"否"}</span>
								</td>
								<td>
									<span style="white-space: nowrap;"><s:property
											value="introduction" /> </span>
								</td>
								<td>
									<span style="white-space: nowrap;"> <a
										href="deleteFoodAction.do?foodVo.foodId=${foodId}&foodKindId=${foodKindId}"
										class="button">删除</a> <a
										href="editFoodAction.do?foodVo.foodId=${foodId}&foodKindId=${foodKindId}"
										class="button">编辑</a> </span>
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
					url="getFoodPageAction.do?restaurantId=${restaurantId}&foodKindId=${foodKindId}&foodName=${foodName}" />
			</div>
			<!-- 分页end -->
		</form>
	</body>
</html>
