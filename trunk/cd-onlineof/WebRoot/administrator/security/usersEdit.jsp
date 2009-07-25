<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>编辑用户信息</title>
    <style rel="stylesheet" type="text/css">
       .table{
       		border-collapse: collapse;
			padding: 5px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 1px 1px 1px;
       	}
       .table thead th{
       		background-color:#E4E4E4;
       		text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
       	}
       .table tbody td{
			padding: 5px;
			font-family: "arial";
			font-size: 12px;
       }
       .table tfoot td{
       		text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 0px 1px;
       	}
    </style>
    <script language="javascript" src="${pageContext.request.contextPath}/common/js/My97DatePicker/WdatePicker.js"></script>
    <script language="">
       // 返回
       function back(){
          window.location.href="searchUsersByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="editForm" name="editForm" action="editUsers.do" method="post">
       <table class="table" style="width:100%;">
          <thead>
             <th colspan="2">编辑用户信息</th>
          </thead>
          <tbody>
             <tr>
	           <td align="right"><span style="white-space: nowrap;">用户名</span></td>
	           <td>
	              <span style="white-space: nowrap;">
	                <!-- 隐藏域用户ID -->
	                <input type="hidden" value="<s:property value='usersVo.usersId'/>"/>
	           		<input type="text" id="usersVo.usersname" name="usersVo.usersname" size=30 value="<s:property value='usersVo.usersname'/>"/>
	           	  </span>
	           </td>
	         </tr>
	         <tr>
	           <td align="right"><span style="white-space: nowrap;">性别</span></td>
	           <td>
	              <select id="usersVo.gender" name="usersVo.gender">
	                 <s:if test="usersVo.gender == 1">
	                   <option value="1" selected>男</option>
	                   <option value="0">女</option>
	                 </s:if>
	                 <s:else>
	                   <option value="1">男</option>
	                   <option value="0" selected>女</option>
	                 </s:else>
	              </select>
	           </td>
	         </tr>
	         <tr>
	           <td align="right"><span style="white-space: nowrap;">出生日期</span></td>
	           <td><input type="text" id="usersVo.birthdayStr" name="usersVo.birthdayStr" size=30 onFocus="new WdatePicker(this,'%Y%M%D',false)" class="Wdate" value="<s:property value='usersVo.birthday'/>"></td>
	         </tr>
	         <tr>
	           <td align="right"><span style="white-space: nowrap;">所属餐厅</span></td>
	           <td>
	             <select id="usersVo.restaurantId" name="usersVo.restaurantId">
	      	        <s:if test="restaurantVos.size == 0">
	      	           <option>暂无数据</option>
	      	        </s:if>
	      	        <s:else>
	      	            <option value="">--请选择--</option>
		      	        <s:iterator value="restaurantVos">
		      	           <s:if test="restaurantId == usersVo.restaurantId">
		      	              <option value="<s:property value='restaurantId'/>" selected><s:property value="name"/></option>
		      	           </s:if>
		      	           <s:else>
		      	              <option value="<s:property value='restaurantId'/>"><s:property value="name"/></option>
		      	           </s:else>
		      	      	</s:iterator>
	      	      	</s:else>
	      	      </select>
	           </td>
	         </tr>
	         <tr>
	           <td align="right"><span style="white-space: nowrap;">角色分配</span></td>
	           <td>
      	         <s:if test="roleVos.size == 0">
      	           <span style="white-space: nowrap;">暂无数据</span>
      	         </s:if>
      	         <s:else>
      	           <s:checkboxlist theme="simple" list="roleVos" listKey="roleName" listValue="roleId" name="ownerRoles"/>
                 </s:else>
	           </td>
	         </tr>
          </tbody>
          <tfoot>
             <tr>
	           <td align="center" colspan="2">
	              <input type="button" value="保存" onclick="updateUsers()">
	              <input type="reset" value="重置">
	              <input type="button" value="返回" onclick="back()">
	           </td>
	         </tr> 
          </tfoot>
       </table>
    </form>
  </body>
</html>
