<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>信息发布</title>
    <link type="text/css" rel="stylesheet" href="common/css/common.css"/>
    <script type="text/javascript" src="common/js/common.js"></script>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
       function afterCreate(){
          if(${not empty msg}){
             alert("发布成功!");
          }
       };
       // 历史发布查询
       function searchHistoryList(){
          window.location.href="searchInfosByPage.do";
       }
    </script>
  </head>
  
  <body onload="afterCreate();">
   <form id="createInfoForm" name="createInfoForm" action="createInfo.do" method="post">
    <table style="width:100%;">
       <thead>
          <tr>
             <th colspan='2'>信息发布</th>
          </tr>
       </thead>
       <tbody>
          <tr>
            <td style="text-align:right;">标题</td>
            <td style="text-align:left;"><input type="text" name="infoVo.title" value="${infoVo.title}"/></td>
          </tr>
          <tr>
            <td style="text-align:right;">分类</td>
            <td style="text-align:left;">
              <select name="infoVo.infoKindId">
      	        <s:if test="infoKinds.size == 0">
      	           <option>暂无数据</option>
      	        </s:if>
      	        <s:else>
      	            <option value="">--请选择--</option>
	      	        <s:iterator value="infoKinds">
	      	           <s:if test="infoKindId == infoVo.infoKindId">
                            <option value="<s:property value='infoKindId'/>" selected ><s:property value="name"/></option>
                       </s:if>
                       <s:else>
	      	      	   		<option value="<s:property value='infoKindId'/>"><s:property value="name"/></option>
	      	      	   </s:else>
	      	      	</s:iterator>
      	      	</s:else>
      	      </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">内容</td>
            <td style="text-align:left;">
               <textarea rows='5' cols='30' name="infoVo.content"><s:property value="infoVo.content"/></textarea>
            </td>
          </tr>
          <tr>
            <td colspan='2'>
               <input type="submit" value="发布"/>
               <input type="reset" value="重置"/>
               <input type="button" value="历史发布查询" onclick="searchHistoryList()"/>
            </td>
          </tr>
       </tbody>
    </table>
   </form>
  </body>
</html>
