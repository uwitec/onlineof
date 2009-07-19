<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="../common/css/table.css"/>
</head>
<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
     <table style="width:100%;height:100%;">
        <tr>
          <td style="width:15%;height:99%;">
            <div style="height:7%;width:99%;"><img src="image/logo.jpg" style="width:100%;height:99%;"></div>
            <div style="height:75%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:18%;width:99%;background-color:#A9A9A9;font-size:10pt;text-align:center;">技术支持:谈冬、张振<br/>QQ:935760092</div>
          </td>
          <td style="width:85%;height:100%;">
            <div style="width:100%;height:7%;border:1px solid #A9A9A9; bottom:2px;margin:0 0 2 0px;"></div>
            <div style="width:100%;height:92%;border:1px solid #A9A9A9;">
               <iframe id="contentFrame" name="contentFrame" style="width:100%;height:100%;" frameborder="0" src="welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
