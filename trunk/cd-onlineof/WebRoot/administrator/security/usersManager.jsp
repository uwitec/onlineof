<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统用户管理</title>
    <link type="text/css" rel="stylesheet" href="common/css/common.css"/>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="common/js/common.js"></script>
    <script language="javascript">
        // 根据名称(模糊查询)和所属餐厅查询用户
        function search(){
            var usersname = document.getElementById("usersname").value;
            var restaurantId = document.getElementById("restaurantId").value;
            document.getElementById("usersForm").action="searchUsersByPage.do?usersname="+usersname+"&restaurantId="+restaurantId;
            document.getElementById("usersForm").submit();
        }
        // 添加新用户
        function forwardAddNewUsers(){
            window.location.href="forwardAddUsers.do";
        }
        // 删除用户
        function deleteUsers(){
            var len = getAllCheckedValue();
            if(len > 0){
                var usersForm = document.getElementById("usersForm");
	            usersForm.action="deleteUsers.do";
	            usersForm.submit();
            }else{
                alert("请选择!");
            }
        }
    </script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="usersForm" name="usersForm" action="#" mthod="post">
      <div style="width:100%;font-size:10pt;">
      	     <span style="white-space: nowrap;">
      	      <span style="white-space: nowrap;">用户名</span>
      	      <input type="text" id="usersname" name="usersname"/>
      	      <span style="white-space: nowrap;">所属餐厅/酒店</span>
      	      <span style="white-space: nowrap;">
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
      	      <span style="white-space: nowrap;"><input type="button" value="删除" onclick="deleteUsers()"/></span>
      	      <span style="white-space: nowrap;"><input type="button" value="添加新用户" onclick="forwardAddNewUsers()"/></span>
      	     </span>
      </div>
      <table style="width:100%;">
         <thead>
           <tr>
               <th><input type="checkbox" id="checkAll" name="checkAll" onclick="checkedAll()"/></th>
	           <th><span style="white-space: nowrap;">用户名</span></th>
	           <th><span style="white-space: nowrap;">性别</span></th>
	           <th><span style="white-space: nowrap;">出生日期</span></th>
	           <th><span style="white-space: nowrap;">QQ</span></th>
	           <th><span style="white-space: nowrap;">E-mail</span></th>
	           <th><span style="white-space: nowrap;">联系电话</span></th>
	           <th><span style="white-space: nowrap;">手机</span></th>
	           <th><span style="white-space: nowrap;">所属餐厅/酒店</span></th>
	           <th><span style="white-space: nowrap;">所属角色</span></th>
	           <th><span style="white-space: nowrap;">操作</span></th>
           </tr>
         </thead>
         <tbody>
           <s:if test="pb.array.size != 0">
            <s:iterator value="pb.array">
	           <tr>
	             <td><input type="checkbox" id="checksItem" name="checksItem" value="<s:property value='usersId'/>"/></td>
	           	 <td><span style="white-space: nowrap;"><s:property value="usersname"/></span></td>
	             <td>
	               <span style="white-space: nowrap;"> 
	                <s:set name="genderStr" value="gender"/>
			        <s:if test="#genderStr == 1">男</s:if>
			        <s:elseif test="#genderStr == 0">女</s:elseif>
			       </span>
	             </td>
	             <td><span style="white-space: nowrap;"><s:property value="birthday"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="QQ"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="email"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="phone"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="movebile"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="restaurantName"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="roleName"/></span></td>
	             <td><a href="editUsres.do?usersId=<s:property value='usersId'/>">编辑</a></td>
	           </tr>
	        </s:iterator>
	       </s:if>
	       <s:else>
	          <tr>
	            <td colspan="11"><span style="white-space: nowrap;"><font style="color:red;">暂无数据</font></span></td> 
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
      </form>
  </body>
</html>
