<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="common/css/table.css"/>
    <link rel="stylesheet" href="common/css/body.css"/>
  </head>
  <body id="body">
      <!-- 页头 -->
	  <div><jsp:include page="common/jsp/header.jsp"></jsp:include></div>
	  
	  <!-- 内容 -->
	  <div style="border:1px solid #A9A9A9;width:1140;height:1500">
	     <iframe src="common/jsp/mainFrame.jsp" id="contentFrame" name="contentFrame" style="width:100%;height:100%;" scrolling="no" frameborder="0">
	     	
	     </iframe> 
	  </div>

	  <!-- 页尾 -->
	  <div><jsp:include page="common/jsp/footer.jsp"></jsp:include></div>
  </body>
</html>
