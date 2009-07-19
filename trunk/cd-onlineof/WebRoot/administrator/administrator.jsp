<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="../common/css/table.css"/>
</head>
<body style="border-bottom:0px; border-top:0px; border-left:0px; border-right:0px;">
     <table style="width:100%;height:100%;">
        <tr>
          <td style="width:15%;height:99%;">
            <div style="height:10%;width:99%;"><img src="image/logo.jpg" style="width:100%;height:99%;"></div>
            <div style="height:75%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:15%;width:99%;background-color:#A9A9A9;font-size:10pt;text-align:center;">技术支持:谈冬、张振<br/>QQ:935760092</div>
          </td>
          <td style="width:85%;height:100%;">
            <div style="width:100%;height:20%;">
               <table class="table" style="width:100%;">
                  <thead>
                  <tr>
                    <th>2009年7月18日 22:53:55 星期六 您已成功登录！如在公共场合请注意您的密码安全，使用完毕后请一定安全退出！！！ </th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>还有未处理的订单 3 个  手工添加订单  </td>
                  </tr>
                  </tbody>
               </table>
            </div>
            <div style="width:100%;height:80%;">
               <iframe style="width:100%;" frameborder="0" src="welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
