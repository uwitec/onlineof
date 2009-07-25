<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑用户</title>
    <style rel="stylesheet" type="text/css">
       .infoTable{
       		border-collapse: collapse;
			padding: 5px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 1px 1px 1px;
       	}
       .infoTable thead th{
       		background-color:#E4E4E4;
       		text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
       	}
       .infoTable tbody td{
			padding: 5px;
			font-family: "arial";
			font-size: 12px;
       }
    </style>
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
                   var roles = getAllCheckedValue();
                   var addUsersForm = document.getElementById("addUsersForm");
                   addUsersForm.action = "addUsers.do?roles="+roles;
                   addUsersForm.submit();
                   // window.location.href="addUsers.do?roles="+roles;
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
    <table class="infoTable" style="width:100%;">
      <thead>
         <th colspan="2"><span style="white-space: nowrap;">添加系统用户</span></th>
      </thead>
      <tbody>
         <tr>
           <td align="right"><span style="white-space: nowrap;">用户名</span></td>
           <td>
              <span style="white-space: nowrap;">
           		<input type="text" id="usersVo.usersname" name="usersVo.usersname" size=30>
           		<input type="button" value="检测用户" onclick="checkUsers()">
           		<span id="checkUsers"></span>
           	  </span>
           </td>
         </tr>
         <tr>
           <td align="right"><span style="white-space: nowrap;">密码</span></td>
           <td><input type="password" id="usersVo.password" name="usersVo.password" size=30></td>
         </tr>
         <tr>
           <td align="right"><span style="white-space: nowrap;">确认密码</span></td>
           <td><input type="password" id="surePassword" name="surePassword" size=30></td>
         </tr>
         <tr>
           <td align="right"><span style="white-space: nowrap;">性别</span></td>
           <td>
              <select id="usersVo.gender" name="usersVo.gender">
                 <option value="1">男</option>
                 <option value="0">女</option>
              </select>
           </td>
         </tr>
         <tr>
           <td align="right"><span style="white-space: nowrap;">出生日期</span></td>
           <td><input type="text" id="usersVo.birthdayStr" name="usersVo.birthdayStr" size=30 onFocus="new WdatePicker(this,'%Y%M%D',false)" class="Wdate"></td>
         </tr>
         <tr>
           <td align="right"><span style="white-space: nowrap;">所属餐厅</span></td>
           <td>
             <select id="usersVo.restaurantId" name="usersVo.restaurantId">
      	        <s:set name="restaurantData" value="restaurantVos"/>
      	        <s:if test="#restaurantData == null">
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
           <td align="right"><span style="white-space: nowrap;">角色分配</span></td>
           <td>
              <s:iterator value="roleVos">
                 <s:set name="roleData" value="roleVos"/>
      	         <s:if test="#roleData == null">
      	           <span style="white-space: nowrap;">暂无数据</span>
      	         </s:if>
      	         <s:else>
                   <input type="checkbox" id="checks" name="checks" value="<s:property value='roleId'/>"/><s:property value="roleName"/>
                 </s:else>
              </s:iterator>
           </td>
         </tr>
      </tbody>
      <tfoot>
         <tr>
           <td align="center" colspan="2">
              <input type="button" value="保存" onclick="saveUsers()">
              <input type="reset" value="重置">
              <input type="button" value="返回" onclick="back()">
           </td>
         </tr>
      </tfoot>
    </table>
   </form>
  </body>
</html>
