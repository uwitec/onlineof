<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>多滋味管理系统</title>
<base href="<%=basePath%>">
<link href="administrator/css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
.xmenu td{font-size:12px;font-family:verdana,arial;color:#F09029;border:1px solid #ffffff;background:#ffffff;filter:blendtrans(duration=0.5);cursor:hand;text-align:center;}
.bj1 {
	background-image: url(administrator/image/login/login/cdsy_47.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
}
.bj2 {
	background-image: url(administrator/image/login/cdsy_49.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	font-size: 14px;
	font-weight: bold;
	color: #000000;
}
.xw1 {
	font-size: 14px;
	font-weight: bold;
	color: #ff0000;
}
.xw2 {
	font-size: 14px;
	font-weight: normal;
	color: #000000;
}
.dg1 {
	font-size: 14px;
	font-weight: bold;
	color: #d19406;
}
.dg2 {
	font-size: 12px;
	font-weight: normal;
	color: #000000;
}
body {
	background-image: url();
	background-color: #f9f9f9;
}
.bj3 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	font-size: 14px;
	font-weight: bold;
	color: #FD6001;
	background-image: url(administrator/image/login/cdsy_163.jpg);
	background-repeat: repeat-x;
}
.bj4 {
	font-size: 14px;
	font-weight: bold;
	color: #000000;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: none;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	border-bottom-color: #EACEA7;
	background-image: url(administrator/image/login/cdsy_165.jpg);
	background-repeat: repeat-x;
}
.bj5 {
	font-size: 12px;
	font-weight: bold;
	color: #FF5C01;
	background-image: url(administrator/image/login/cdsy_220.jpg);
	background-repeat: repeat-x;
	border-top-width: 1px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	border-left-color: #EACEA7;
}
.bj6 {
	font-size: 12px;
	color: #000000;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #EACEA7;
}
.zt1 {
	font-size: 12px;
	color: #0063C8;
	border-bottom:1px solid #D4D6D5;
}
.zt2 {
	font-size: 12px;
	color: #000000;
	border-bottom:1px solid #D4D6D5;
}
-->
</style>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/interface/usersManagerDwrAction.js"></script>
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

<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
<table width="80%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td height="117">&nbsp;</td>
  </tr>
  <tr>
    <td height="235" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38" height="48" background="administrator/image/login/ht01.jpg">&nbsp;</td>
        <td width="373" background="administrator/image/login/ht02.jpg">&nbsp;</td>
        <td width="248" background="administrator/image/login/ht03.jpg">&nbsp;</td>
        <td width="343" background="administrator/image/login/ht04.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td height="130" colspan="4"><table width="100%" height="130" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="79" background="administrator/image/login/ht05.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht06.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht07.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht08.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht09.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht10.jpg">&nbsp;</td>
            <td width="79" background="administrator/image/login/ht11.jpg">&nbsp;</td>
            <td width="51" background="administrator/image/login/ht12.jpg">&nbsp;</td>
            <td width="242" background="administrator/image/login/ht12.jpg">
			   <form action="login.do" id="loginForm" name="loginForm" method="post">
				   <table style="width:100%;height:100%;">
					  <tr>
						<td align="right"><span style="white-space: nowrap;">用户名:</span></td>
						<td align="left"><input type="text" id="usersname" name="usersname" value="administrator" size="20"/></td>
					  </tr>
					  <tr>
						<td align="right"><span style="white-space: nowrap;">密码:</span></td>
						<td align="left"><input type="password" id="password" name="password" value="onlineof" size="22"/></td>
					  </tr>
					  <tr>
						<td colspan="2">
						   <input type="button" value="登陆" onclick="login()"/>
						</td>
					  </tr>
				   </table>
				</form>
			</td>
            <td width="156" background="administrator/image/login/ht12.jpg">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="57" colspan="4" valign="top"><table width="100%" height="57" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="79" background="administrator/image/login/ht13.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht14.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht15.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht16.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht17.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht18.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht19.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht20.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht21.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht22.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht23.jpg" >&nbsp;</td>
            <td width="79" background="administrator/image/login/ht24.jpg" >&nbsp;</td>
            <td width="54" background="administrator/image/login/ht25.jpg" >&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
