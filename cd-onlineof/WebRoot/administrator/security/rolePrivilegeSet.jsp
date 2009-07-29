<%@ page language="java" pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script src="dwr/interface/LoadPrivilegeTreeAction.js"></script>
	<script src="administrator/js/dtree.js"></script>
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
	        LoadPrivilegeTreeAction.getPrivilegeByRoleId("${roleId}",{callback:checkPrivilegeOfRole,errorHandler:function(msg,exception){alert(exception.message);}});
	   }
	   // 选中角色拥有的权限
	   function checkPrivilegeOfRole(privileges){
	        if(privileges.length > 0){
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
	   
	</script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;" onLoad="initRolePrivilegeTree()">
     <div id="rolePrivilegeTree" style="font-size:10pt; width:100%;height:100%;overflow:auto;"></div>
  </body>
</html>
