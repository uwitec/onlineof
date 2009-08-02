<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑权限</title>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
       // 返回
       function back(){
          window.location.href="searchPrivilegesByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="editPrivilegeForm" name="editPrivilegeForm" action="<s:property value='action'/>" method="post">
     <table style="width:100%;">
        <thead>
           <tr><th colspan="2">权限信息</th></tr>
        </thead>
        <tbody>
           <tr>
             <td style="text-align:right;">权限名称</td>
             <td style="text-align:left;">
               <input type="text" id="privilegeVo.methodName" name="privilegeVo.privilegeName" value="<s:property value='privilegeVo.privilegeName'/>" size="30"/>
             </td>
           </tr>
           <tr>
             <td style="text-align:right;">类型</td>
             <td style="text-align:left;">
               <select id="privilegeVo.kind" name="privilegeVo.kind">
                 <s:if test="privilegeVo.kind == Model">
                   <option value="Model" selected>模块</option>
                   <option value="Operator">操作</option>
                 </s:if>
                 <s:else>
                   <option value="Model">模块</option>
                   <option value="Operator" selected>操作</option>
                 </s:else>
              </select>
             </td>
           </tr>
           <tr>
             <td style="text-align:right;"t>对应方法名</td>
             <td style="text-align:left;">
             	<input type="text" id="privilegeVo.methodName" name="privilegeVo.methodName" value="<s:property value='privilegeVo.methodName'/>"  size="30"/>
             </td>
           </tr>
           <tr>
             <td style="text-align:right;">请求URL</td>
             <td style="text-align:left;">
             	<input type="text" id="privilegeVo.url" name="privilegeVo.url" value="<s:property value='privilegeVo.url'/>"  size="30"/>
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
