<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统用户管理</title>
    <link ref="stylesheet" type="text/css" href="css/common.css"></link> 
    <style type="text/css">
       .table {
			border-collapse: collapse;
			padding: 5px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 1px 1px 1px;
		}
		
		.table th {
			background-color: #E4E4E4;
			text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
		}
		
		.table td {
			text-align: center;
			padding: 5px;
			font-family: "arial";
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 1px 1px;
		}
		/*分页样式*/
		.pagination { padding: 5px 0; clear: both; float: right; overflow: hidden;font-size:10pt;}
   		.pagination span { display: block; float: left;}
  		.pagination .number { margin-left: 7px; display: inline;}
  		.pagination .number a { display: block; padding: 0 5px; color: #28558c;}
  		.pagination .number.current { border: 1px solid #ff7200; background: #ff9c00;}
  		.pagination .number.current a { color: #fff;}
    </style>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
      <table style="width:100%;font-size:10pt;">
      	<tr>
      	   <td style="width:60%;font-size:13px;color:#4f89ad; display:inline;">
      	      <strong><img src="image/point.jpg"/>系统用户列表</strong>
      	   </td>
      	   <td style="width:40%;">
      	      用户名<input type="text" id="usersname" name="usersname">
      	     <input type="button" value="查询"/>
      	     <input type="button" value="添加新用户"/>
      	   </td>
      	</tr>
      </table>
      <table class="table" style="width:100%;">
         <thead>
           <tr>
	           <th>用户名</th>
	           <th>密码</th>
	           <th>性别</th>
	           <th>出生日期</th>
	           <th>所属餐厅/酒店</th>
	           <th>操作</th>
           </tr>
         </thead>
         <tbody>
            <s:iterator value="pb.array">
	           <tr>
	           	 <td><s:property value="usersname"/></td>
	             <td><s:property value="password"/></td>
	             <td>
	                <s:set name="genderStr" value="gender"/>
			        <s:if test="#genderStr == 1">男</s:if>
			        <s:elseif test="#genderStr == 0">女</s:elseif>
	             </td>
	             <td><s:property value="birthday"/></td>
	             <td><s:property value="restaurantName"/></td>
	             <td>
	                <s:a href="#">删除</s:a>
	                <s:a href="#">修改</s:a>
	             </td>
	           </tr>
	        </s:iterator>
         </tbody>
      </table>
      <!-- 分页start -->
	<div class="pagination">
		<page:pages1 pagesize="${pb.pagesize}"
			currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
			totalRow="${pb.totalRow}" liststep="10" dispalytext="个用户"
			url="usersManager.do" />
	</div>
	<!-- 分页end -->
  </body>
</html>
