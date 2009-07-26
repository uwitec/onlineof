<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑角色信息</title>
    <style rel="stylesheet" type="text/css">
       .table{
       		border-collapse: collapse;
			padding: 5px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 1px 1px 1px;
       	}
       .table thead th{
       		background-color:#E4E4E4;
       		text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
       	}
       .table tbody td{
			padding: 5px;
			font-family: "arial";
			font-size: 12px;
       }
       .table tfoot td{
       		text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
       	}
    </style>
    <script language="javascript">
       // 返回
       function back(){
          window.location.href="searchRolesByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="addRoleForm" name="addRoleForm" action="<s:property value='action'/>" method="post">
     <table class="table" style="width:100%;">
        <thead>
           <th colspan="2">角色信息</th>
        </thead>
        <tbody>
           <tr>
              <td align="right">角色名称</td>
              <td>
                <!-- 隐藏域 roleId -->
                <input type="hidden" id="roleVo.roleId" name="roleVo.roleId" value="<s:property value='roleVo.roleId'/>"/>
              	<input type="text" id="roleVo.roleName" name="roleVo.roleName" size=30 value="<s:property value='roleVo.roleName'/>">
              </td>
           </tr>
           <tr>
              <td align="right">描述</td>
              <td>
                 <textarea rows="4" cols="24" id="roleVo.description" name="roleVo.description" value="<s:property value='roleVo.description'/>">
                    ${roleVo.description}
                 </textarea>
              </td>
           </tr>
           <tr>
           <td align="center" colspan="2">
              <input type="submit" value="保存">
              <input type="reset" value="重置">
              <input type="button" value="返回" onclick="back()">
           </td>
         </tr>
        </tbody>
     </table>
     </form>
  </body>
</html>
