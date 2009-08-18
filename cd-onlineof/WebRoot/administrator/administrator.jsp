<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>在线订餐后台管理系统</title>
	<link href="administrator/css/main.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
	   function get_time() {
	    var date=new Date();
	    var year="",month="",day="",week="",hour="",minute="",second="";
	    year=date.getYear();
	    month=add_zero(date.getMonth()+1);
	    day=add_zero(date.getDate());
	    week=date.getDay();
	    switch (date.getDay()) {
	      case 0:val="星期天";break
	      case 1:val="星期一";break
	      case 2:val="星期二";break
	      case 3:val="星期三";break
	      case 4:val="星期四";break
	      case 5:val="星期五";break
	      case 6:val="星期六";break
	    }
	    hour=add_zero(date.getHours());
	    minute=add_zero(date.getMinutes());
	    second=add_zero(date.getSeconds());
	    $("timeSpan").innerText=" "+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+val;
	  }
	  function add_zero(temp)
	  {
	    if(temp<10) return "0"+temp;
	    else return temp;
	  }
	  setInterval("get_time()",1000);
	</script>
</head>
<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
     <table style="width:100%;height:100%;padding:0px;">
        <tr>
          <td style="width:100%;height:10%;background:#E6EAE9;text-align:left;" colspan="2">
            <strong style="font-size:20pt;">多滋味后台管理系统</strong>
            <!--  
            <embed src="administrator/image/towp.swf" style="width:100%;height:100%;RIGHT: 10px; "> </embed>
            -->
          </td>
        </tr> 
        <tr>
          <td style="width:15%;height:90%;">
            <div style="height:85%;width:98%;border:1px solid #A9A9A9;overflow:auto;">
               <!-- 导入用户权限树页面 -->
               <jsp:include page="navigationTree.jsp"></jsp:include>
            </div>
            <div style="height:15%;width:99%;font-size:10pt;text-align:left;background: #FFFFFF;">
              <strong>版权信息:</strong><br/>
                 常德市help信息科技有限公司<br/>
               ©2003-2009湘ICP证030173号    
            </div>
          </td>
          <td style="width:85%;height:90%;">
            <table style="width:100%;font-size:10pt;border:1px solid #A9A9A9;height:5%;padding:0px;background: #E6EAE9;">
               <tr style="width:100%;height:100%;">
	               <td style="width:100%;height:100%;text-align:left;">
	                   <span style="white-space: nowrap;width:60%;height:100%;background: #CAE8EA;padding:0px;">
		                   <b>您的位置:</b>
		                   <font id="position"></font>
	                   </span>
	                   <span style="white-space: nowrap;width:40%;height:100%;background: #CAE8EA;padding:0px;">
	                      <b>您好:</b>${session.usersVo.usersname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                      <b>今天是:</b>
	                      <span id="timeSpan"></span>
	                   </span>
	               </td>
               </tr>
            </table>
            <div style="width:100%;height:95%;background: #E6EAE9;">
               <iframe id="contentFrame" name="contentFrame" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/administrator/welcom.jsp"></iframe>
            </div> 
          </td>
        </tr>
     </table>
</body>
</html>
