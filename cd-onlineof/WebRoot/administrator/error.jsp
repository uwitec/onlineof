<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>出错页面</title>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
      <table style="width:100%;height:100%;">
         <tr>
           <td style="text-align:right;"><img src="administrator/image/error.gif"/></td>
           <td style="text-align:left;"><font style="font-size:13pt;color:red;">${errorMsg}</font></td>
         </tr>
      </table>
  </body>
</html>
