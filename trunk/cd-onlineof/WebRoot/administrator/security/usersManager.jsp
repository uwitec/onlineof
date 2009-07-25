<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统用户管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/common.css"/>
    <script language="javascript">
        // 根据名称(模糊查询)和所属餐厅查询用户
        function search(){
            var usersname = document.getElementById("usersname").value;
            var restaurantId = document.getElementById("restaurantId").value;
            alert("用户名: " + usersname + "餐厅: "+restaurantId);
            window.location.href="searchUsersByPage.do?usersname="+usersname+"&restaurantId="+restaurantId;
        }
        // 添加新用户
        function forwardAddNewUsers(){
            window.location.href="forwardAddUsers.do";
        }
        function getSelectRestaurant(){
        
        }
    </script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
      <table style="width:100%;font-size:10pt;">
      	<tr>
      	   <td style="width:100%;">
      	     <span style="white-space: nowrap;">
      	      <span style="white-space: nowrap;">用户名</span>
      	      <input type="text" id="usersname" name="usersname">
      	      <span style="white-space: nowrap;">所属餐厅/酒店</span>
      	      <span style="white-space: nowrap;">
      	      <!--  两种方式任选一种
      	      <s:select list="restaurantVos" name="restaurant" listKey="restaurantId" listValue="name" headerKey="" headerValue="--请选择--" theme="simple" onchange="javascript:getSelectRestaurant();" /> 
      	      -->
      	      <select id="restaurantId" name="restaurantId">
      	        <s:set name="restaurantData" value="restaurantVos"/>
      	        <s:if test="#restaurantData == null">
      	           <option value="">暂无数据</option>
      	        </s:if>
      	        <s:else>
      	            <option value="">--请选择--</option>
	      	        <s:iterator value="restaurantVos">
	      	      	   <option value="<s:property value='restaurantId'/>"><s:property value="name"/></option>
	      	      	</s:iterator>
      	      	</s:else>
      	      </select>
      	      </span>
      	      <span style="white-space: nowrap;"><input type="button" value="查询" onclick="search()"/></span>
      	      <span style="white-space: nowrap;"><input type="button" value="添加新用户" onclick="forwardAddNewUsers()"/></span>
      	     </span>
      	   </td>
      	</tr>
      </table>
      <table class="table" style="width:100%;">
         <thead>
           <tr>
	           <th><span style="white-space: nowrap;">用户名</span></th>
	           <th><span style="white-space: nowrap;">密码</span></th>
	           <th><span style="white-space: nowrap;">性别</span></th>
	           <th><span style="white-space: nowrap;">出生日期</span></th>
	           <th><span style="white-space: nowrap;">所属餐厅/酒店</span></th>
	           <th><span style="white-space: nowrap;">操作</span></th>
           </tr>
         </thead>
         <tbody>
           <s:set name="data" value="pb.array"/>
           <s:if test="#data != null">
            <s:iterator value="pb.array">
	           <tr>
	           	 <td><span style="white-space: nowrap;"><s:property value="usersname"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="password"/></span></td>
	             <td>
	               <span style="white-space: nowrap;"> 
	                <s:set name="genderStr" value="gender"/>
			        <s:if test="#genderStr == 1">男</s:if>
			        <s:elseif test="#genderStr == 0">女</s:elseif>
			       </span>
	             </td>
	             <td><span style="white-space: nowrap;"><s:property value="birthday"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="restaurantName"/></span></td>
	             <td>
	                <span style="white-space: nowrap;">
		                <s:a href="#">删除</s:a>
		                <s:a href="#">编辑</s:a>
	                </span>
	             </td>
	           </tr>
	        </s:iterator>
	       </s:if>
	       <s:else>
	          <tr>
	            <td colspan="6"><span style="white-space: nowrap;"><font style="color:red;">暂无数据</font></span></td> 
	          </tr>
	       </s:else> 
         </tbody>
      </table>
      <!-- 分页start -->
	<div class="pagination" style="font-size:10pt;">
		<page:pages1 pagesize="${pb.pagesize}"
			currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
			totalRow="${pb.totalRow}" liststep="10" dispalytext="个用户"
			url="searchUsersByPage.do" />
	</div>
	<!-- 分页end -->
  </body>
</html>
