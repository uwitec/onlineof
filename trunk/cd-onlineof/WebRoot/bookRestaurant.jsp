<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/pages" %>
<html>
  <head>
    <title>餐厅大全</title>
    <link ref="stylesheet" type="text/css" href="common/css/table.css"/>
    <link ref="stylesheet" type="text/css" href="common/css/page.css"/> 
  </head>
  <body>
     <table id="infoTable">
       <thead>
          <tr>
            <th>
               餐厅大全
            </th>
          </tr>
       </thead>
       <tbody>
	       <tr> 
	        <s:iterator value="restaurantList">
	           <td><s:property value="name"/></td>
	        </s:iterator>
	       </tr>
       </tbody>
     </table>
  </body>
</html>
