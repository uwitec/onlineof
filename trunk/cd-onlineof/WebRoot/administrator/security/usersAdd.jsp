<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新建用户</title>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/dwr/interface/usersManagerDwrAction.js"></script>
    <script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
    <script src="${pageContext.request.contextPath}/dwr/util.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/common/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/common/js/common.js"></script>
    <script language="javascript">
       function checkUsers(){
          var usersname = document.getElementById("usersVo.usersname").value;
          if(null == usersname || "" == usersname){
             alert("请输入用户名!");
          }else{
          	 usersManagerDwrAction.checkUsers(usersname,callCheck);
          }
       }
       function callCheck(bool){
          var element = document.getElementById("checkUsers");
          if(bool){
              //alert("合法用户名!");
              element.innerHTML="<font style='color:green;'><b>合法用户名!</b></font>";
          }else{
              //alert("此用户已存在!");
              element.innerHTML="<font style='color:red;'><b>此用户已存在!</b></font>";
              document.getElementById("usersVo.usersname").value = "";
          }
       }
       // 添加用户
       function saveUsers(){
          var usersname = document.getElementById("usersVo.usersname").value;
          var password = document.getElementById("usersVo.password").value;
          var surePassword = document.getElementById("surePassword").value;
          if(usersname != ""){
             if(password != ""){
                if(password == surePassword){
                   var addUsersForm = document.getElementById("addUsersForm");
                   addUsersForm.action = "addUsers.do";
                   addUsersForm.submit();
                }else{
                   alert("密码不匹配!");
                }
             }else{
                alert("密码不能为空!");
             }
          }else{
             alert("用户名不能为空!");
          }
       }
       // 返回
       function back(){
          window.location.href="searchUsersByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="addUsersForm" name="addUsersForm" action="addUsers.do" method="post">
    <table class="table" style="width:100%;">
      <thead>
         <th colspan="2"><span style="white-space: nowrap;">添加系统用户</span></th>
      </thead>
      <tbody>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">用户名</span></td>
           <td style="text-align:left;">
              <span style="white-space: nowrap;">
           		<input type="text" id="usersVo.usersname" name="usersVo.usersname" size=30/>
           		<input type="button" value="检测用户" onclick="checkUsers()">
           		<span id="checkUsers"></span>
           	  </span>
           </td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">密码</span></td>
           <td style="text-align:left;"><input type="password" id="usersVo.password" name="usersVo.password" size=30></td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">确认密码</span></td>
           <td style="text-align:left;"><input type="password" id="surePassword" name="surePassword" size=30></td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">性别</span></td>
           <td style="text-align:left;">
              <select id="usersVo.gender" name="usersVo.gender">
                 <option value="1">男</option>
                 <option value="0">女</option>
              </select>
           </td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">出生日期</span></td>
           <td style="text-align:left;"><input type="text" id="usersVo.birthdayStr" name="usersVo.birthdayStr" size=30 onFocus="new WdatePicker(this,'%Y%M%D',false)" class="Wdate"></td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">所属餐厅</span></td>
           <td style="text-align:left;">
             <select id="usersVo.restaurantId" name="usersVo.restaurantId">
      	        <s:if test="restaurantVos.size == 0">
      	           <option>暂无数据</option>
      	        </s:if>
      	        <s:else>
      	            <option value="">--请选择--</option>
	      	        <s:iterator value="restaurantVos">
	      	      	   <option value="<s:property value='restaurantId'/>"><s:property value="name"/></option>
	      	      	</s:iterator>
      	      	</s:else>
      	      </select>
           </td>
         </tr>
         <tr>
           <td style="text-align:right;"><span style="white-space: nowrap;">所属角色</span></td>
           <td style="text-align:left;">
              <select id="usersVo.roleId" name="usersVo.roleId">
      	        <s:if test="roleVos.size > 0">
      	            <option value="">--请选择--</option>
	      	        <s:iterator value="roleVos">
	      	      	   <option value="<s:property value='roleId'/>"><s:property value="roleName"/></option>
	      	      	</s:iterator>
      	        </s:if>
      	        <s:else>
      	           <option>暂无数据</option>
      	      	</s:else>
      	      </select>
           </td>
         </tr>
         <tr>
           <td align="center" colspan="2">
              <input type="button" value="保存" onclick="saveUsers()">
              <input type="reset" value="重置">
              <input type="button" value="返回" onclick="back()">
           </td>
         </tr>
      </tbody>
    </table>
   </form>
  </body>
</html>
