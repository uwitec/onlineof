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
    <title>权限设置</title>
    <link type="text/css" rel="stylesheet" href="administrator/css/dtree.css"/>
    <link href="administrator/css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script src="dwr/interface/LoadPrivilegeTreeAction.js"></script>
	<script src="administrator/js/dtree.js"></script>
	<script src="common/js/common.js"></script>
	<script language="javascript">
	    // 权限树
		var privilegeTree = new dTree('privilegeTree');
		//Node(id, pid, name, url, title, target, icon, iconOpen, open,inputName,inputValue,inputType,myOnClick)
		privilegeTree.inputType = "checkbox";
	    function initRolePrivilegeTree(){
	       LoadPrivilegeTreeAction.loadAllPrivilege(function(privilegeVos){
	            for(var i in privilegeVos){
					var p = privilegeVos[i];
					privilegeTree.add(p.privilegeId,p.parentId,p.privilegeName,'','','','','','','','','','');
				}
				$("rolePrivilegeTree").innerHTML=privilegeTree.toString();
	       });
	   }
	   
	   getPrivilegeByRoleId();
	   
	   //获取当前角色拥有的权限
	   function getPrivilegeByRoleId(){
	        LoadPrivilegeTreeAction.getPrivilegeByRoleId("${roleVo.roleId}",{callback:checkPrivilegeOfRole,errorHandler:function(msg,exception){alert(exception.message);}});
	   }
	   // 选中角色拥有的权限
	   function checkPrivilegeOfRole(privileges){
	        if(null != privileges && "" != privileges){
	            alert(privileges.length);
		        var allPrivileges = document.getElementsByName("inputName");
				//清空所有的CheckBox选择框
				for(var i=0; i<allPrivileges.length; i++){
					allPrivileges[i].checked = false;
				}
				for(var n=0; n<allPrivileges.length; n++){
					for(var k=0; k<privileges.length; k++){
						if(allPrivileges[n].value == privileges[k].privilegeId){
							allPrivileges[n].checked = true;
							break;
						}
					}
				}
			}
	   }
	    // 获取选择的权限
		function getRolePrivileges(roleId){
			var rolePrivileges = new Array();
			var allPrivilege = document.getElementsByName("inputName");
			for(var i=0; i<allPrivilege.length; i=i+1){
				if(allPrivilege[i].checked){
					rolePrivileges[rolePrivileges.length] = allPrivilege[i].value;
				}
			}
			return rolePrivileges;
		}
	   // 保存角色拥有权限
	   function saveRolePrivilege(roleId){
	       var rolePrivileges = getRolePrivileges(roleId);
	       var rolePrivilegeForm = document.getElementById("rolePrivilegeForm");
	       rolePrivilegeForm.action="saveRolePrivilege.do?rolePrivileges="+rolePrivileges+"&roleId=${roleVo.roleId}";
	       rolePrivilegeForm.submit();
	   }
	</script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;" onLoad="initRolePrivilegeTree()">
         <form id="rolePrivilegeForm" name="rolePrivilegeForm" action="" method="post">
             <table style="width:100%;">
                <thead>
                   <tr><th>设置角色权限 --> 角色:<s:property value='roleVo.roleName'/></th></tr>
                </thead>
                <tbody>
                   <tr>
                      <td style="text-align:left;">
                         <div id="rolePrivilegeTree" style="font-size:10pt;overflow:auto;width:100%;height:100%;"></div>
                      </td>
                   </tr>
                   <tr>
                      <td>
                        <input type="button" value="保存" onclick="saveRolePrivilege('${roleId}')"/>
                        <input type="button" value="取消" onclick="closeWindow()"/>
                      </td>
                   </tr>
                </tbody>
             </table>
         </form>
  </body>
</html>
