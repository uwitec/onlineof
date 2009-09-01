<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>信息管理</title>
    <link type="text/css" rel="stylesheet" href="common/css/common.css"/>
    <script type="text/javascript" src="common/js/common.js"></script>
    <link href="administrator/css/table.css" rel="stylesheet" type="text/css" />
    <script laguage="javascript">
       // 发布信息
       function forwardCreateInfo(){
          window.location.href="forwardCreateInfo.do";
       }
    </script>
  </head>
  
  <body>
  <form id="infoForm" name="infoForm" action="searchInfosByPage.do" mthod="post">
     <div style="width:100%;font-size:10pt;">
      	     <span style="white-space: nowrap;">
      	      <span style="white-space: nowrap;">标题</span>
      	      <input type="text" id="title" name="title" value="${title}"/>
      	      <span style="white-space: nowrap;"><input type="submit" value="查询"/></span>
      	      <span style="white-space: nowrap;"><input type="button" value="发布信息" onclick="forwardCreateInfo()"/></span>
      	     </span>
      </div>
     <table style="width:100%;">
         <thead>
           <tr>
               <th><input type="checkbox" id="checkAll" name="checkAll" onclick="checkedAll()"/></th>
	           <th><span style="white-space: nowrap;">标题</span></th>
	           <th><span style="white-space: nowrap;">发布者</span></th>
	           <th><span style="white-space: nowrap;">发布时间</span></th>
	           <th><span style="white-space: nowrap;">修改者</span></th>
	           <th><span style="white-space: nowrap;">修改时间</span></th>
	           <th><span style="white-space: nowrap;">信息类别</span></th>
	           <th><span style="white-space: nowrap;">操作</span></th>
           </tr>
         </thead>
         <tbody>
           <s:if test="pageBean.array.size != 0">
            <s:iterator value="pageBean.array">
	           <tr>
	             <td><input type="checkbox" id="checksItem" name="checksItem" value="<s:property value='infoId'/>"/></td>
	           	 <td><span style="white-space: nowrap;"><s:property value="title"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="createUser"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="createTime"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="modifyUser"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="modifyTime"/></span></td>
	             <td><span style="white-space: nowrap;"><s:property value="infoKindName"/></span></td>
	             <td><a href="#">编辑</a></td>
	           </tr>
	        </s:iterator>
	       </s:if>
	       <s:else>
	          <tr>
	            <td colspan="8"><span style="white-space: nowrap;"><font style="color:red;">暂无数据</font></span></td> 
	          </tr>
	       </s:else> 
         </tbody>
      </table>
        <!-- 分页start -->
		<div class="pagination" style="font-size:10pt;">
			<page:pages1 pagesize="${pageBean.pagesize}"
				currentPage="${pageBean.currentPage}" totalPage="${pageBean.totalPage}"
				totalRow="${pageBean.totalRow}" liststep="10" dispalytext="条记录"
				url="searchInfosByPage.do" />
		</div>
		<!-- 分页end -->
  </form>
  </body>
</html>
