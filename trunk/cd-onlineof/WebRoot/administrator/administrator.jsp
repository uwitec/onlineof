<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<link href="administrator/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
     <table style="width:100%;height:100%;padding:0px;">
        <tr>
          <td style="width:85%;height:10%;background:#E6EAE9;" colspan="2">
            <embed src="administrator/image/towp.swf" style="width:100%;height:100%;RIGHT: 10px; "> </embed>
          </td>
        </tr> 
        <tr>
          <td style="width:15%;height:90%;">
            <div style="height:85%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:15%;width:99%;font-size:10pt;text-align:center;background: #E6EAE9;">技术支持:<br/>耗子,振哥,咚咚<br/>QQ:935760092</div>
          </td>
          <td style="width:85%;height:90%;">
            <table style="width:100%;font-size:10pt;border:1px solid #A9A9A9;height:5%;padding:0px;background: #E6EAE9;">
               <tr style="width:100%;height:100%;"><td style="width:100%;height:100%;"><span style="white-space: nowrap;width:100%;height:100%;background: #CAE8EA;padding:0px;"><b>您的位置:</b><span id="position"></span></span></td></tr>
            </table>
            <div style="width:100%;height:95%;background: #E6EAE9;">
               <iframe id="contentFrame" name="contentFrame" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/administrator/welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
