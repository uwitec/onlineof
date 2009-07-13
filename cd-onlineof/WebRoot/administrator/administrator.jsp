<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>项目</title>
<link href="css/globe.css" rel="stylesheet" type="text/css">
<script id="systemframe" language="jscript" src="js/systemframe.js"></script>
<script language="javascript">
  function doLogoutSystem() {
      alert("设置指向自己的LogoutServlet!");
      window.location.href = "";
  }


  function doExitSystem() {
     window.close();
  }
</script>
</head>
<body onLoad="initial();">
<table class="MainTable" cellpadding="0" cellspacing="0">
	<tr style="height:7%;" class="TitleTR">
	  <td>
		<table style="width:100%;height:100%;tabley-layout:fixed;" cellpadding="0" cellspacing="0">
			<tr>
			   <td style="width:10%">
			      <!-- 插入图标信息 -->
			      &nbsp;
			   </td>
			   <td style="width:30%"  align="right">
			      <!-- 插入登陆用户信息 -->
				  <span class="infoLab">你好! 登陆时间</span>
			   </td>
			   <td style="width:20%"><span id="timetable" class="infoLab"></span></td>
			   <td style="width:40%;padding:0px 10px 0px 0px;" align="right">
			      <span class="helpBtn" onClick="doLogoutSystem()">注销</span><span class="helpBtn">&nbsp;|&nbsp;</span><span onClick="doExitSystem()" class="helpBtn">退出</span><span class="helpBtn">&nbsp;|&nbsp;</span><span class="helpBtn">帮助</span>
			   </td>
			</tr>
		</table>
	  </td>
    </tr>
	<tr style="height:35px;" class="NavigateTR">
	  <td>
		 <table style="width:100%;height:30px;table-layout:fixed;" cellpadding="0" cellspacing="0">
			<tr>
			   <td style="width:20px">&nbsp;
			      
			   </td>
			   <td style="width:100%;">
			      <div id="NavigateContainer" class="NavigateContainer" onMouseDown="doNavigateMouseDown()" defaultIndex=0>
					 <div class="NavItem" submenu="systemMenu">系统管理</div>
					 <div class="NavSpace">|</div>
					 <div class="NavItem" submenu="customMenu">客户管理</div>
					 <div class="NavSpace">|</div>
					 <div class="NavItem" submenu="customMenu">产品管理</div>
				 </div>
			   </td>
			</tr>
		  </table>
	  </td>
    </tr>
	<tr style="height:90%">
	    <td>
           <table class="MainBodyTable" cellpadding="0" cellspacing="0">
		      <tr>
			     <td class="MenuTD">
				   <div id="systemMenu" class="MenuContainer" onMouseDown="doMenuMouseDown()" onMouseOver="doMenuMouseOver()" onMouseOut="doMenuMouseOut()" >
					   <div class="SubMenuItem"><img src="common/image/open.gif"></img><span>用户管理</span></div>
					   <div class="MenuItemContainer">
						   <div class="MenuItem" url="listTable.html"><span>用户管理</span></div>
						   <div class="MenuItem" url=""><span>用户管理</span></div>
					   </div>
					   <div class="SubMenuItem"><img src="common/image/open.gif"></img><span>权限管理</span></div>
					   <div class="MenuItemContainer">
						   <div class="MenuItem" url=""><span>角色管理</span></div>
						   <div class="MenuItem" url=""><span>角色管理</span></div>
					   </div>
				   </div>	
				   <div id="customMenu" class="MenuContainer" onMouseDown="doMenuMouseDown()" onMouseOver="doMenuMouseOver()" onMouseOut="doMenuMouseOut()" >
					   <div class="SubMenuItem"><img src="common/image/open.gif"></img><span>客户管理</span></div>
					   <div class="MenuItemContainer">
						   <div class="MenuItem" url="http://www.yahoo.com"><span>我的客户</span></div>
						   <div class="MenuItem" url=""><span>我的客户</span></div>
					   </div>
					   <div class="SubMenuItem"><img src="common/image/open.gif"></img><span>我的客户</span></div>
					   <div class="MenuItemContainer">
						   <div class="MenuItem" url=""><span>我的客户</span></div>
						   <div class="MenuItem" url=""><span>我的客户</span></div>
					   </div>
				   </div>					   
				 </td>
			     <td class="FrameTD">
				     <iframe id="ContentFrame" src="#" frameborder=0 scrolling=yes style="width:100%;height:100%"></iframe>			    
			     </td>
			  </tr>
		   </table>		
		</td>
    </tr>
</table>
</body>
</html>
