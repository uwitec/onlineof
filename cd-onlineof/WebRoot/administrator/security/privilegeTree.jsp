<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>选择一个权限</title>
    <link href="administrator/css/main.css" rel="stylesheet" type="text/css" />
    <script src="dwr/interface/LoadPrivilegeTreeAction.js"></script>
	<script src="dwr/engine.js"></script>
	<script src="dwr/util.js"></script>
	<script type="text/javascript" src="common/js/common.js"></script>
	<script language="javascript" src="administrator/js/tdTree.js"></script>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;text-align:center;">
     <table style="width:100%;">
        <thead><tr><th>选择一个上级权限</th></tr></thead>
        <tbody>
           <tr>
             <td>
                <div id="privilegeTreeDiv" style="text-align:left;width:100%;height:425px;overflow:auto;font-size:10pt;"></div>
             </td>
           </tr>
           <tr>
             <td style="text-align:center;">
               <input type="button" value="确定" onclick="getSelectParentPrivilege()"/>
     	       <input type="button" value="取消" onclick="closeWindow()"/> 
             </td>
           </tr>
        </tbody>
     </table>
     <script language="javascript">
	        var TreeDemo;
			function Config(Render,ShowRoot,Icons,DefaultIcon,DefaultOpenIcon,SplitIconPath){
			    this.Render = "privilegeTreeDiv";
				this.ShowRoot = false;
				this.Icons = ["${pageContext.request.contextPath}/administrator/image/tree/Column.png", "${pageContext.request.contextPath}/administrator/image/tree/ColumnOpen.png", "${pageContext.request.contextPath}/administrator/image/tree/File.png", "${pageContext.request.contextPath}/administrator/image/tree/FileOpen.png"];
				this.DefaultIcon = 0;
				this.DefaultOpenIcon = 1;
				this.SplitIconPath = "${pageContext.request.contextPath}/administrator/image/tree";
			 };
		     TreeDemo = new Tree(new Config());
		     
	        // 加载权限树
	        function loadPrivilegeTree(){
	           LoadPrivilegeTreeAction.getTopPrivilege({callback:loadTree,errorHandler:function(msg,exception){alert(exception.message);}});
	        };
	        // 回调函数初始化顶级树节点
	        function loadTree(topPrivileges){
	           if(topPrivileges.length > 0){
		        for(var i=0; i<topPrivileges.length; i++){
		           TreeDemo.AddNode({
		              Id:topPrivileges[i]["privilegeId"],
		              Text:topPrivileges[i]["privilegeName"],
		              ParentId:-1,
		              Asyn:topPrivileges[i]["hasChild"]==0?false:true,
		              Icon:topPrivileges[i]["hasChild"]==0?2:0,
		              IconOpen:topPrivileges[i]["hasChild"]==0?3:1,
		              Expand:function(Node){ 
					     LoadPrivilegeTreeAction.getChildPrivilege(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
					  }
		           });
		        }
		      }else{
		         TreeDemo.AddNode({
	              Id:'null',
	              Text:'暂无数据',
	              ParentId:-1,
	              Asyn:false,
	              Icon:2,
	              IconOpen:3
	           });
		      }
		    };
		    // 加载子权限节点
		    function loadChild(childPrivileges){
		       for(var i=0; i<childPrivileges.length; i++){
		           TreeDemo.AddNode({
		              Id:childPrivileges[i]["privilegeId"],
		              Text:childPrivileges[i]["privilegeName"],
		              ParentId:childPrivileges[i]["parentId"],
		              Asyn:childPrivileges[i]["hasChild"]==0?false:true,
		              Icon:childPrivileges[i]["hasChild"]==0?2:0,
		              IconOpen:childPrivileges[i]["hasChild"]==0?3:1,
		              Statu:childPrivileges[i]["url"],
		              Expand:function(Node){ 
					     LoadPrivilegeTreeAction.getChildPrivilege(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
					  },
					  Click:function(Node){
					  }
		           });
	          }
		    };
		    // 返回选择的父权限
		    function getSelectParentPrivilege(){
                if(TreeDemo.SelectedNode == undefined){
	               alert("请选择!");
	            }else{
	               window.opener.setSelectParentPrivilege(TreeDemo.SelectedNode.Id,TreeDemo.SelectedNode.Text);
	               window.close();
	            }
		    };
		    loadPrivilegeTree();
     </script>
  </body>
</html>
