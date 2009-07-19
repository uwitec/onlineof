<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title></title>
    <script language="javascript">
        function login(){
            var form = document.getElementById("loginForm");
            var usersname = document.getElementById("usersname");
            var password = document.getElementById("password");
            if(null == usersname || "" == usersname){
               alert("用户名不能为空!");
            }else{
               if(null == password || "" == password){
                  alert("密码不能为空!");
               }else{
                  form.submit();
               }
            }
        }
    </script>
  </head>  
<body style="background-color:#F5F5F5;border-bottom:0px; border-top:0px; border-left:0px; border-right:0px;"> 
    <form action="login.do" id="loginForm" name="loginForm" method="post">
       <table>
          <tr>
            <td align="right">用户名:</td>
            <td><input type="text" id="usersname" name="usersname"/></td>
          </tr>
          <tr>
            <td align="right">密码:</td>
            <td><input type="password" id="password" name="password"/></td>
          </tr>
          <tr>
            <td colspan="2">
               <input type="button" id="submitBtn" value="登陆" onclick="login()"/>
            </td>
          </tr>
       </table>
    </form>
</body>  
</html>  
