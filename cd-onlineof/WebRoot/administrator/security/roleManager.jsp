<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>角色管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/common/js/common.js"></script>
    <script language="javascript">
       // 删除角色
        function deleteRole(){
            var len = getAllCheckedValue();
            if(len > 0){
                var roleForm = document.getElementById("roleForm");
	            roleForm.action="deleteRole.do";
	            roleForm.submit();
            }else{
                alert("请选择!");
            }
        }
        // 跳转到添加新角色页面
        function forwardAddNewRole(){
            window.location.href="forwardAddNewRole.do";
        }
    </script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
     <form id="roleForm" name="roleForm" action="searchRolesByPage.do" mthod="post">
      <div style="width:100%;font-size:10pt;">
      	     <span style="white-space: nowrap;">
      	      <span style="white-space: nowrap;">角色名</span>
      	      <input type="text" id="roleName" name="roleName"/>
      	      <span style="white-space: nowrap;"><input type="submit" value="查询"/></span>
      	      <span style="white-space: nowrap;"><input type="button" value="删除" onclick="deleteRole()"/></span>
      	      <span style="white-space: nowrap;"><input type="button" value="添加新角色" onclick="forwardAddNewRole()"/></span>
      	     </span>
      </div>
      <table class="table" style="width:100%;">
         <thead>
           <tr>
               <th><input type="checkbox" id="checkAll" name="checkAll" onclick="checkedAll()"/></th>
	           <th><span style="white-space: nowrap;">角色名</span></th>
	           <th><span style="white-space: nowrap;">描述</span></th>
	           <th><span style="white-space: nowrap;">操作</span></th>
           </tr>
         </thead>
         <tbody>
           <s:if test="pb.array.size > 0">
            <s:iterator value="pb.array">
	           <tr>
	             <td><input type="checkbox" id="checksItem" name="checksItem" value="<s:property value='roleId'/>"/></td>
	           	 <td><span style="white-space: nowrap;"><s:property value="roleName"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="description"/></span></td>
	             <td><a href="editRole.do?roleId=<s:property value='roleId'/>">编辑</a>/<a href="#">权限设置</a></td>
	           </tr>
	        </s:iterator>
	       </s:if>
	       <s:else>
	          <tr>
	            <td colspan="7"><span style="white-space: nowrap;"><font style="color:red;">暂无数据</font></span></td> 
	          </tr>
	       </s:else> 
         </tbody>
      </table>
      </form>
      <!-- 分页start -->
	<div class="pagination" style="font-size:10pt;">
		<page:pages1 pagesize="${pb.pagesize}"
			currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
			totalRow="${pb.totalRow}" liststep="10" dispalytext="个角色"
			url="searchUsersByPage.do" />
	</div>
	<!-- 分页end -->
  </body>
</html>
