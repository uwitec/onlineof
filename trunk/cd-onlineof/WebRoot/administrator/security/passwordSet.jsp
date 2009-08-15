<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>密码设置</title>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script src="dwr/interface/usersManagerDwrAction.js"></script>
	<script src="dwr/engine.js"></script>
	<script src="dwr/util.js"></script>
    <script language="javascript">
       // 保存
       function clickSaveBtn(){
           var oldPassword = document.getElementById("oldPassword").value;
           var newPassword = document.getElementById("newPassword").value;
           var sureNewPassword = document.getElementById("sureNewPassword").value;
           if(oldPassword == "" || newPassword == "" || sureNewPassword == ""){
               alert("密码不能为空!");
           }else{
               if(newPassword != sureNewPassword){
	              alert("确认密码不匹配!");
	           }else{
	              usersManagerDwrAction.resetUsersPassword('${session.usersId}', oldPassword, newPassword,{callback:returnReset,errorHandler:function(msg,exception){alert(exception.message);}});
	              function returnReset(bool){
	                 if(bool){
	                    alert("重置成功!");
	                 }
	              }
	           }
           }
       }
    </script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="passwordSetForm" name="passwordSetForm" action="" method="post">
     <table style="width:100%;">
       <thead>
          <tr><th colspan="2">重置密码</th></tr>
       </thead>
       <tbody>
          <tr>
            <td style="text-align:right;">原始密码</td>
            <td style="text-align:left;">
            	<input type="password" id="oldPassword" size="30"/>
            	<font size="+1" color="red">*</font>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">输入新密码</td>
            <td style="text-align:left;">
            	<input type="password" id="newPassword" size="30"/>
                <font size="+1" color="red">*</font>	
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">确认新密码</td>
            <td style="text-align:left;">
            	<input type="password" id="sureNewPassword" size="30"/>
                <font size="+1" color="red">*</font>
            </td>
          </tr>
          <tr>
            <td colspan="2">
               <input type="button" value="保存" onclick="clickSaveBtn()"/>
               <input type="reset" value="重置"/>
            </td>
          </tr>
       </tbody>
     </table>
    </form>
  </body>
</html>
