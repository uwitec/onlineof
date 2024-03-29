<%@ page language="java" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/dwr/interface/LoadPrivilegeTreeAction.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/administrator/js/tdTree.js"></script>
<html>
<head><title></title></head>
<body>
<div style="width:100%;float:left;font-size:10pt;text-align:left;overflow:auto; height: 470px;"
	id="navigationTreeDiv" name="navigationTreeDiv">
</div>
</body>
</html>
<script language="javascript">
    var TreeDemo;
	function Config(Render,ShowRoot,Icons,DefaultIcon,DefaultOpenIcon,SplitIconPath){
	    this.Render = "navigationTreeDiv";
		this.ShowRoot = false;
		this.Icons = ["${pageContext.request.contextPath}/administrator/image/tree/Column.png", "${pageContext.request.contextPath}/administrator/image/tree/ColumnOpen.png", "${pageContext.request.contextPath}/administrator/image/tree/File.png", "${pageContext.request.contextPath}/administrator/image/tree/FileOpen.png"];
		this.DefaultIcon = 0;
		this.DefaultOpenIcon = 1;
		this.SplitIconPath = "${pageContext.request.contextPath}/administrator/image/tree";
	 }
     TreeDemo = new Tree(new Config());
     function load(){
     	LoadPrivilegeTreeAction.loadPrivilegeTree({callback:loadTree,errorHandler:function(msg,exception){alert(exception.message);}});
     }
     /*加载树*/
     function loadTree(topPrvileges){
      if(topPrvileges.length > 0){
        for(var i=0; i<topPrvileges.length; i++){
           TreeDemo.AddNode({
              Id:topPrvileges[i]["privilegeId"],
              Text:topPrvileges[i]["privilegeName"],
              ParentId:-1,
              Asyn:topPrvileges[i]["hasModelChild"]==0?false:true,
              Icon:topPrvileges[i]["hasModelChild"]==0?2:0,
              IconOpen:topPrvileges[i]["hasModelChild"]==0?3:1,
              Expand:function(Node){ 
			     LoadPrivilegeTreeAction.loadChildModelPrivilegeTree(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
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
     }
     /*加载子节点*/
     function loadChild(childPrivileges){
        for(var i=0; i<childPrivileges.length; i++){
           TreeDemo.AddNode({
              Id:childPrivileges[i]["privilegeId"],
              Text:childPrivileges[i]["privilegeName"],
              ParentId:childPrivileges[i]["parentId"],
              Asyn:childPrivileges[i]["hasModelChild"]==0?false:true,
              Icon:childPrivileges[i]["hasModelChild"]==0?2:0,
              IconOpen:childPrivileges[i]["hasModelChild"]==0?3:1,
              Statu:childPrivileges[i]["url"],
              Expand:function(Node){ 
			     LoadPrivilegeTreeAction.loadChildModelPrivilegeTree(Node.Id,{callback:loadChild,errorHandler:function(msg,exception){alert(exception.message);}});
			  },
			  Click:function(Node){
			     doAjaxSend(Node.Statu);
			     setPosition(Node.Id);
			  }
           });
        }
        function doAjaxSend(url){
           document.getElementById("contentFrame").contentWindow.location=url;
        }
     }
     // 设置导航位置
     function setPosition(id){
        var position = document.getElementById("position");
        var clickNode = TreeDemo.FindNode(id);
        if(clickNode.ParentId != -1){
           var parentNode = TreeDemo.FindNode(clickNode.ParentId);
           position.innerHTML=parentNode.Text + " >> " +clickNode.Text;
        }
     }
     load();
</script>