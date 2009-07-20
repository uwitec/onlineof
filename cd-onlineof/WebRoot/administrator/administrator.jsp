<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/table.css"/>
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
          <td style="width:15%;height:8%;"><img src="image/logo.jpg" style="width:100%;height:99%;"></td>
          <td style="width:85%;height:8%;">
            <table style="width:100%;height:100%%;top:2px;" class="table">
              <thead>
              	<tr>
              		<th style="text-align:left;width:80%;">常德市一点味餐厅     2009年07月19日星期日</th>
              		<th style="width:20%;"><a href="#"><strong>退出系统</strong></a>&nbsp;&nbsp;<a href="#"><strong>注销</strong></a></th>
              	</tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="2">您还有3个订单未处理</td>
                </tr> 
              </tbody>
            </table>
          </td>
        </tr> 
        <tr>
          <td style="width:15%;height:99%;">
            <div style="height:75%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:25%;width:99%;background-color:#A9A9A9;font-size:10pt;text-align:center;">技术支持:谈冬、张振<br/>QQ:935760092</div>
          </td>
          <td style="width:85%;height:100%;">
            <div style="width:100%;height:92%;">
               <iframe id="contentFrame" name="contentFrame" style="width:100%;height:100%;" frameborder="0" src="welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
