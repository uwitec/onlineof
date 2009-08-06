<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>权限管理</title>
    <script type="text/javascript" src="common/js/common.js"></script>
    <script src="${pageContext.request.contextPath}/dwr/interface/LoadPrivilegeTreeAction.js"></script>
	<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
	<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
	<script language="javascript" src="administrator/js/tdTree.js"></script>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css"></link>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <table style="width:100%;height:100%;">
       <tr>
          <td style="width:15%;">
            <div id="privilegeTreeDiv" style="text-align:left;width:100%;height:100%;overflow:auto;"></div>
          </td>
          <td style="width:80%;">
             <iframe id="privilegeFrame" src="administrator/security/privilegeEdit.jsp" style="width:100%;height:100%;" frameborder="0"></iframe>
          </td>
       </tr>
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
		 }
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
				  },
				  Click:function(Node){
				    clickPrivilegeNode(Node.Id);
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
				    clickPrivilegeNode(Node.Id);
				  }
	           });
          }
	    }
	    // 点击权限节点
	    function clickPrivilegeNode(id){
	        document.getElementById("privilegeFrame").contentWindow.location="editPrivilege.do?privilegeId="+id;
	    }
	    // 添加权限之后  新建节点
	    function addPrivilegeNode(id,text,parentId){
	        TreeDemo.AddNode({
		       Text:text,
		       Id:id,
		       ParentId:parentId,
		       Asyn:false,
		       Icon:2,
		       IconOpen:3,
		       Statu:true,
		       Click:function(Node){
	              clickPrivilegeNode(Node.Id);
	           },
	           ExpandBefor:function(Node){
                  blocTreeAction.getChildBlocTree(Node.Id,{callback:loadChild,errorHandler:function(msg,e){alert(e.message);}});
               }
		   });
		   var parent = TreeDemo.SelectedNode;
		   TreeDemo.ExpandNode(parent,false);
		   TreeDemo.FindNode(id).SetSelect(true);
		   clickPrivilegeNode(id);
	    }
	    // 修改权限之后  修改节点
	    function updatePrivilegeNode(id,text){
	       var privilegeNode = TreeDemo.FindNode(id);
	       privilegeNode.SetText(text);
	    }
	    // 删除权限之后  删除节点
	    function deletePrivilegeNode(id){
	       TreeDemo.RemoveNode(TreeDemo.FindNode(id)); 
	    }
	    loadPrivilegeTree();
    </script>
  </body>
</html>
