<%@ page language="java" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/dwr/interface/LoadPrivilegeTreeAction.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script language="javascript" src="js/tdTree.js"></script>
<html>
<head><title></title></head>
<body onload="load()">
<div style="width:100%;float:left; text-align:left;overflow:auto; height: 420px;"
	id="navigationTreeDiv" name="navigationTreeDiv">
</div>
</body>
</html>
<script language="javascript">
    var TreeDemo;
	function Config(Render,ShowRoot,Icons,DefaultIcon,DefaultOpenIcon,SplitIconPath){
	    this.Render = "navigationTreeDiv";
		this.ShowRoot = false;
		this.Icons = ["image/tree/Column.png", "image/tree/ColumnOpen.png", "image/tree/File.png", "image/tree/FileOpen.png"];
		this.DefaultIcon = 0;
		this.DefaultOpenIcon = 1;
		this.SplitIconPath = "image/tree";
	 }
     TreeDemo = new Tree(new Config());
     function load(){
     	LoadPrivilegeTreeAction.loadPrivilegeTree({callback:loadTree,errorHandler:function(msg,exception){alert(exception.message);}});
     }
     // 初始化模块权限树(加载顶级模块)
     function loadTree(topPrvileges){
        for(var i=0; i<topPrvileges.length; i++){
           TreeDemo.AddNode({
              Id:topPrvileges[i]["privilegeId"],
              Text:topPrvileges[i]["privilegeName"],
              ParentId:-1,
              Asyn:topPrvileges[i]["hasChild"]==0?false:true,
              Icon:topPrvileges[i]["hasChild"]==0?2:0,
              IconOpen:topPrvileges[i]["hasChild"]==0?3:1,
              Expand:function(Node){ 
			     LoadPrivilegeTreeAction.loadChildModelPrivilegeTree(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
			  }
           });
        }
     }
     // 回调函数加载子模块权限
     function loadChild(childPrivileges){
        alert(childPrivileges.length);
        for(var i=0; i<childPrivileges.length; i++){
           TreeDemo.AddNode({
              Id:childPrivileges[i]["privilegeId"],
              Text:childPrivileges[i]["privilegeName"],
              ParentId:childPrivileges[i]["parentId"],
              Asyn:childPrivileges[i]["hasChild"]==0?false:true,
              Icon:childPrivileges[i]["hasChild"]==0?2:0,
              IconOpen:childPrivileges[i]["hasChild"]==0?3:1,
              Expand:function(Node){ 
			     LoadPrivilegeTreeAction.loadChildModelPrivilegeTree(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
			  }
           });
        }
     }
</script>