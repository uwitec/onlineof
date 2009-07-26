<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
		<link rel="stylesheet" type="text/css" href="common/css/common.css">

	</head>

	<body>
		
		<table class="table" style="width: 100%;">
			<thead>
				<tr>
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
				<s:set name="data" value="pb.array" />
				<s:if test="#data != null">
					<s:iterator value="pb.array">
						<tr>
							<td>
								<span style="white-space: nowrap;"><s:property
										value="restaurantTypeName" />
								</span>
							</td>
							<td>
								<span style="white-space: nowrap;"><s:property
										value="description" />
								</span>
							</td>
							<td>
								<span style="white-space: nowrap;"><s:property
										value="createTime" />
								</span>
							</td>
							<td>
								<span style="white-space: nowrap;"> <s:a href="#">删除</s:a>
									<s:a href="#">编辑</s:a> </span>
							</td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr>
						<td colspan="6">
							<span style="white-space: nowrap;"><font
								style="color: red;">暂无数据</font>
							</span>
						</td>
					</tr>
				</s:else>
			</tbody>
		</table>
		<!-- 分页start -->
		<div class="pagination">
			<page:pages1 pagesize="${pb.pagesize}"
				currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
				totalRow="${pb.totalRow}" liststep="10" dispalytext="条记录"
				url="getRestaurantKindPage.do" />
		</div>
		<!-- 分页end -->
	</body>
</html>
