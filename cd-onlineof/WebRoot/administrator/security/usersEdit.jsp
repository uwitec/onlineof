<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>编辑用户信息</title>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="${pageContext.request.contextPath}/common/js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript">
       // 返回
       function back(){
          window.location.href="searchUsersByPage.do";
       }
    </script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form id="editForm" name="editForm" action="updateUsers.do" method="post">
       <table style="width:100%;">
          <thead>
             <th colspan="2">编辑用户信息</th>
          </thead>
          <tbody>
             <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">用户名</span></td>
	           <td style="text-align:left;">
	              <span style="white-space: nowrap;">
	                <!-- 隐藏域用户ID -->
	                <input type="hidden" value="<s:property value='usersVo.usersId'/>"/>
	           		<input type="text" id="usersVo.usersname" name="usersVo.usersname" size=30 value="<s:property value='usersVo.usersname'/>"/>
	           	  </span>
	           </td>
	         </tr>
	         <tr>
	           <td style="text-align:right;"><span style="white-space: nowrap;">性别</span></td>
	           <td style="text-align:left;">
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
	           <td style="text-align:right;"><span style="white-space: nowrap;">出生日期</span></td>
	           <td style="text-align:left;"><input type="text" id="usersVo.birthdayStr" name="usersVo.birthdayStr" size=30 onFocus="new WdatePicker(this,'%Y%M%D',false)" class="Wdate" value="<s:property value='usersVo.birthday'/>"></td>
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
	           <td style="text-align:right;"><span style="white-space: nowrap;">所属角色</span></td>
	           <td style="text-align:left;">
      	         <select id="usersVo.roleId" name="usersVo.roleId">
	      	        <s:if test="roleVos.size == 0">
	      	           <option>暂无数据</option>
	      	        </s:if>
	      	        <s:else>
	      	            <option value="">--请选择--</option>
		      	        <s:iterator value="roleVos">
		      	           <s:if test="roleId == usersVo.roleId">
		      	              <option value="<s:property value='roleId'/>" selected><s:property value="roleName"/></option>
		      	           </s:if>
		      	           <s:else>
		      	              <option value="<s:property value='roleId'/>"><s:property value="roleName"/></option>
		      	           </s:else>
		      	      	</s:iterator>
	      	      	</s:else>
	      	      </select>
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
