<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑角色信息</title>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
       // 返回
       function back(){
          window.location.href="searchRolesByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="addRoleForm" name="addRoleForm" action="<s:property value='action'/>" method="post">
     <table style="width:100%;">
        <thead>
           <th colspan="2">角色信息</th>
        </thead>
        <tbody>
           <tr>
              <td style="text-align:right;">角色名称</td>
              <td style="text-align:left;">
                <!-- 隐藏域 roleId -->
                <input type="hidden" id="roleVo.roleId" name="roleVo.roleId" value="<s:property value='roleVo.roleId'/>"/>
              	<input type="text" id="roleVo.roleName" name="roleVo.roleName" size=30 value="<s:property value='roleVo.roleName'/>">
              	<font size="+1" color="red">*</font>
              </td>
           </tr>
           <tr>
              <td style="text-align:right;">描述</td>
              <td style="text-align:left;">
                 <span style="white-space: nowrap;"> 
                      <textarea name="roleVo.description" rows="4" cols="75">${roleVo.description}</textarea>
				 </span>
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
