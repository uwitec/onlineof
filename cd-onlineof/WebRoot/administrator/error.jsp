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
    <style type="text/css">
        body {
			font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
			color: #4f6b72;
			background: #E6EAE9;
		}
    </style>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <table style="width:100%;height:100%;">
      <tr>
        <td style="text-align:center;">
          <div style="width:500px;height:240px;border:8px solid #A9A9A9;">
	        <div style="width:100%;height:100%;border:2px solid #FFFFFF;background:#FFFFFF;">
		      <div align="left" style="width:100%;height:50%;">
		           <img src="administrator/image/infod.gif"/>
		           <strong style="font-size:13pt;color:red;">操作错误!</strong>
		      </div>
		      <div align="center" style="width:100%;height:50%;">
		         <table style="width:100%;">
		            <tr>
		              <td style="text-align:right;"><strong style="font-size:13pt;">错误编号:</strong></td>
		              <td style="text-align:left;"><font style="font-size:13pt;color:red;">${errorCode}</font></td>
		            </tr>
		            <tr>
		              <td style="text-align:right;"><strong style="font-size:13pt;">错误信息:</strong></td>
		              <td style="text-align:left;"><font style="font-size:13pt;color:red;">${errorMsg}</font></td>
		            </tr>
		         </table>
		      </div>
		     </div> 
	     </div> 
        </td>
      </tr>
    </table>
  </body>
</html>
