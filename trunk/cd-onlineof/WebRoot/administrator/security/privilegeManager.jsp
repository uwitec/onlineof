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
    <title>权限管理</title>
    <link type="text/css" rel="stylesheet" href="common/css/common.css"/>
    <script type="text/javascript" src="common/js/common.js"></script>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
       // 删除权限
        function deletePrivilege(){
            var len = getAllCheckedValue();
            if(len > 0){
                var privilegeForm = document.getElementById("privilegeForm");
	            privilegeForm.action="deletePrivilege.do";
	            privilegeForm.submit();
            }else{
                alert("请选择!");
            }
        }
        // 查询
        function search(){
            var privilegeName = document.getElementById("privilegeName").value;
            window.location.href="searchPrivilegesByPage.do?privilegeName="+privilegeName;
        }
        // 跳转到添加新权限页面
        function forwardAddNewPrivilege(){
            window.location.href="forwardAddNewPrivilege.do";
        }
    </script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="privilegeForm" name="privilegeForm" action="#" mthod="post">
     <div style="width:100%;font-size:10pt;">
   	     <span style="white-space: nowrap;">
   	      <span style="white-space: nowrap;">权限名</span>
   	      <input type="text" id="privilegeName" name="privilegeName"/>
   	      <span style="white-space: nowrap;"><input type="button" value="查询" onclick="search()"/></span>
   	      <span style="white-space: nowrap;"><input type="button" value="删除" onclick="deletePrivilege()"/></span>
   	      <span style="white-space: nowrap;"><input type="button" value="添加新权限" onclick="forwardAddNewPrivilege()"/></span>
   	     </span>
     </div>
     <table style="width:100%;">
         <thead>
           <tr>
               <th><input type="checkbox" id="checkAll" name="checkAll" onclick="checkedAll()"/></th>
	           <th><span style="white-space: nowrap;">权限名</span></th>
	           <th><span style="white-space: nowrap;">类型</span></th>
	           <th><span style="white-space: nowrap;">对应的方法名</span></th>
	           <th><span style="white-space: nowrap;">URL</span></th>
	           <th><span style="white-space: nowrap;">操作</span></th>
           </tr>
         </thead>
         <tbody id="tb">
           <s:if test="pb.array.size > 0">
            <s:iterator value="pb.array">
	           <tr>
	             <td><input type="checkbox" id="checksItem" name="checksItem" value="<s:property value='privilegeId'/>"/></td>
	             <td><span style="white-space: nowrap;"><s:property value="privilegeName"/></span></td>
	           	 <td><span style="white-space: nowrap;"><s:property value="kind"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="methodName"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="url"/></span></td>
	             <td><span style="white-space: nowrap;"><a href="editPrivilege.do?privilegeId=<s:property value='privilegeId'/>">编辑</a></span></td>
	           </tr>
	        </s:iterator>
	       </s:if>
	       <s:else>
	          <tr>
	            <td colspan="5"><span style="white-space: nowrap;"><font style="color:red;">暂无数据</font></span></td> 
	          </tr>
	       </s:else> 
         </tbody>
      </table>
     </form>
     <!-- 分页start -->
		<div class="pagination" style="font-size:10pt;">
			<page:pages1 pagesize="${pb.pagesize}"
				currentPage="${pb.currentPage}" totalPage="${pb.totalPage}"
				totalRow="${pb.totalRow}" liststep="10" dispalytext="个权限"
				url="searchPrivilegesByPage.do" />
		</div>
	<!-- 分页end -->
  </body>
</html>
