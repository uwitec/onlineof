<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<style type="text/css">
       .table {
			border-collapse: collapse;
			padding: 5px;
			border-color: gray;
		}
		
		.table th {
			background-color: #E4E4E4;
			text-align: center;
			padding: 5px;
			font-size: 12px;
			border-color: gray;
		}
		
		.table td {
			text-align: center;
			padding: 5px;
			font-family: "arial";
			font-size: 12px;
			border-color: gray;
			border-style: solid;
			border-width: 1px 0px 1px 1px;
		}
    </style>
</head>
<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
     <table style="width:100%;height:100%;">
        <tr>
          <td style="width:85%;height:10%;background-color:#A9A9A9;" colspan="2">
          </td>
        </tr> 
        <tr>
          <td style="width:15%;height:90%;">
            <div style="height:75%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:25%;width:99%;background-color:#A9A9A9;font-size:10pt;text-align:center;">技术支持:<br/>耗子,振哥,咚咚<br/>QQ:935760092</div>
          </td>
          <td style="width:85%;height:90%;">
            <table style="width:100%;font-size:10pt;border:1px solid #A9A9A9;height:5%;">
               <tr><td><span style="white-space: nowrap;"><b>您的位置:</b><span id="position"></span></span></td></tr>
            </table>
            <div style="width:100%;height:95%;">
               <iframe id="contentFrame" name="contentFrame" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/administrator/welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
