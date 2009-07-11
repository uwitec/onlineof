<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>餐厅大全</title>
    <link ref="stylesheet" type="text/css" href="common/css/table.css"/> 
  </head>
  <body>
     <table id="infoTable">
       <tr> 
        <s:iterator value="restaurantList">
           <td><s:property value="name"/></td>
        </s:iterator>
       </tr>
     </table>
  </body>
</html>
