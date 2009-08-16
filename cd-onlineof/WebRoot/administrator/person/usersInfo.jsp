<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户个人信息</title>
    <link type="text/css" rel="stylesheet" href="administrator/css/table.css"/>
    <link type="text/css" rel="stylesheet" href="administrator/css/common.css"/>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="usersInfoForm" name="usersInfoForm" action="updateUsersInfo.do" method="post">
       <table style="width:100%;">
          <thead>
             <th colspan="2">个人资料</th>
          </thead>
          <tbody>
             <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">用户名</span></td>
	           <td style="text-align:left;">
	              <span style="white-space: nowrap;">
	                <!-- 隐藏域用户ID -->
	                <input type="hidden" id="usersVo.usersId" name="usersVo.usersId" value="<s:property value='usersVo.usersId'/>"/>
	           		<input type="text" id="usersVo.usersname" name="usersVo.usersname" size="30" value="<s:property value='usersVo.usersname'/>"/>
	           		<font size="+1" color="red">*</font>
	           	  </span>
	           </td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">性别</span></td>
	           <td style="text-align:left;">
	              <select id="usersVo.gender" name="usersVo.gender">
	                 <s:if test="usersVo.gender == 1">
	                   <option value="1" selected="selected">男</option>
	                   <option value="0">女</option>
	                 </s:if>
	                 <s:else>
	                   <option value="1">男</option>
	                   <option value="0" selected="selected">女</option>
	                 </s:else>
	              </select>
	           </td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">出生日期</span></td>
	           <td style="text-align:left;"><input type="text" id="usersVo.birthdayStr" name="usersVo.birthdayStr" size="30" onFocus="new WdatePicker(this,'%Y-%M-%D',false)" class="Wdate" value="<s:property value='usersVo.birthday'/>"></td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">QQ</span></td>
	           <td style="text-align:left;"><input type="text" id="usersVo.QQ" name="usersVo.QQ" size="30" value="<s:property value='usersVo.QQ'/>"></td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">E-mail</span></td>
	           <td style="text-align:left;"><input type="text" id="usersVo.email" name="usersVo.email" size="30" value="<s:property value='usersVo.email'/>"></td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">联系电话</span></td>
	           <td style="text-align:left;"><input type="text" id="usersVo.phone" name="usersVo.phone" size="30" value="<s:property value='usersVo.phone'/>"></td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">手机</span></td>
	           <td style="text-align:left;">
	           	 <input type="text" id="usersVo.movebile" name="usersVo.movebile" size="30" value="<s:property value='usersVo.movebile'/>" />
	           </td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">所属餐厅</span></td>
	           <td style="text-align:left;">
	             <input type="hidden" name="usersVo.restaurantId" value="<s:property value='usersVo.restaurantId'/>"/>
	             <input type="text" name="usersVo.restaurantName" value="<s:property value='usersVo.restaurantName'/>" readonly="readonly" class="inputNull"/>
	           </td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">所属角色</span></td>
	           <td style="text-align:left;">
	             <input type="hidden" name="usersVo.roleId" value="<s:property value='usersVo.roleId'/>"/>
	             <input type="text" name="usersVo.roleName" value="<s:property value='usersVo.roleName'/>" readonly="readonly" class="inputNull"/>
	           </td>
	         </tr>
	         <tr>
	           <td align="center" colspan="2">
	              <input type="submit" value="保存">
	              <input type="reset" value="重置">
	           </td>
	         </tr> 
          </tbody>
       </table>
    </form>
  </body>
</html>
