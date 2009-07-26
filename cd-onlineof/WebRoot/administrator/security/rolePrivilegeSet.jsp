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
	</script>
  </head>
  <body style="margin-top:1px;margin-bottom:0px;margin-left:0px;margin-right:0px;" onLoad="initRolePrivilegeTree()">
     <div id="rolePrivilegeTree" style="font-size:10pt; width:100%;height:100%;overflow:auto;"></div>
  </body>
</html>
