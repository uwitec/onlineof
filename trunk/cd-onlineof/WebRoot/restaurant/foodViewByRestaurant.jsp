<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页饮食展示</title>
  </head>
  <body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
    <form action="getFoodByPage.do" method="post">
     <s:if test="foodVos.size != 0"> 
     <table style="width:100%;font-size:10pt;">
         <tr><td>&nbsp;</td></tr>
		 <tr> 
	     <s:iterator id="foods" value="foodVos" status="st">           
		     <td>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="#"><img src="image?resId=<s:property value='foodId'/>&typeId=2" style="width:110px;height:110px;border:0px;"/></a><br/>&nbsp;&nbsp;&nbsp;&nbsp;
	            <s:property value="name"/>&nbsp;&nbsp;<s:property value="price"/><br/>&nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="">订购</a>&nbsp;&nbsp;<a href="">详细</a>
		     </td> 
		     <!-- 判断是否整除5 也可以这样写 #st.getIndex()%5==0 --> 
		         <s:if test="#st.modulus(5)==0"> 
		          <s:if test="#st.last"> 
		         </tr> 
		          </s:if>
		          <s:else> 
		            </tr><tr> 
		          </s:else> 
		         </s:if> 
		</s:iterator> 
     </table>
     </s:if>
     <s:else>
        <table style="width:100%;height:100%;">
         <tr>
           <td style="text-align:center;width:100%;height:100%;">
           		<span style="white-space: nowrap;"><font style="color:red;">暂无饮食信息</font></span>
           </td> 
         </tr>
        </table>
      </s:else> 
     <table style="width:100%;font-size:10pt;">
       <tr>
         <td style="text-align:right;"><a href="">>>更多</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
       </tr>
     </table>
  </body>
</html>
