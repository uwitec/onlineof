<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="onlineOF/pages.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>多滋味</title>
<link href="images/index/css.css" rel="stylesheet" type="text/css" />
<link href="common/css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
.xmenu td{font-size:12px;font-family:verdana,arial;color:#F09029;border:1px solid #ffffff;background:#ffffff;filter:blendtrans(duration=0.5);cursor:hand;text-align:center;}
.bj1 {
	background-image: url(images/cdsy_47.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
}
.bj2 {
	background-image: url(images/index/cdsy_49.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	font-size: 14px;
	font-weight: bold;
	color: #000000;
}
.xw1 {
	font-size: 14px;
	font-weight: bold;
	color: #ff0000;
}
.xw2 {
	font-size: 14px;
	font-weight: normal;
	color: #000000;
}
.dg1 {
	font-size: 14px;
	font-weight: bold;
	color: #d19406;
}
.dg2 {
	font-size: 12px;
	font-weight: normal;
	color: #000000;
}
body {
	background-image: url(images/index/beijing.jpg);
}
.bj3 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	font-size: 14px;
	font-weight: bold;
	color: #FD6001;
	background-image: url(images/index/cdsy_163.jpg);
	background-repeat: repeat-x;
}
.bj4 {
	font-size: 14px;
	font-weight: bold;
	color: #000000;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: none;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	border-bottom-color: #EACEA7;
	background-image: url(images/index/cdsy_165.jpg);
	background-repeat: repeat-x;
}
.bj5 {
	font-size: 12px;
	font-weight: bold;
	color: #FF5C01;
	background-image: url(images/index/cdsy_220.jpg);
	background-repeat: repeat-x;
	border-top-width: 1px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #EACEA7;
	border-right-color: #EACEA7;
	border-left-color: #EACEA7;
}
.bj6 {
	font-size: 12px;
	color: #000000;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #EACEA7;
}
.zt1 {
	font-size: 12px;
	color: #0063C8;
	border-bottom:1px solid #D4D6D5;
}
.zt2 {
	font-size: 12px;
	color: #000000;
	border-bottom:1px solid #D4D6D5;
}
-->
</style>
<script>
function correctPNG() 
   {
   for(var i=0; i<document.images.length; i++)
      {
      var img = document.images[i]
      var imgName = img.src.toUpperCase()
      if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
         {
         var imgID = (img.id) ? "id='" + img.id + "' " : ""
         var imgClass = (img.className) ? "class='" + img.className + "' " : ""
         var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
         var imgStyle = "display:inline-block;" + img.style.cssText 
         if (img.align == "left") imgStyle = "float:left;" + imgStyle
         if (img.align == "right") imgStyle = "float:right;" + imgStyle
         if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle        
         var strNewHTML = "<span "+ imgID + imgClass + imgTitle + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";" + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src='" + img.src + "', sizingMethod='scale');\"></span>" 
   img.outerHTML = strNewHTML
         i = i-1
         }
      }
   }
window.attachEvent("onload", correctPNG);
</script>
<SCRIPT language=JavaScript type=text/JavaScript>
	<!--
	var hn=new Array();
	function  secBoard1(n)
	{
		for(i=0;i<mainTable1.tBodies.length;i++)
		mainTable1.tBodies[i].style.display="none";
		mainTable1.tBodies[n].style.display="block";
		for(i=0;i<3;i++)
		document.getElementById("dg["+i+"]").className="dg2";
		document.getElementById("dg["+n+"]").className="dg1";
	}
	//-->
</SCRIPT>
</head>

<body style="margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;">
<table width="1002" height="3" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#6F1B2A"></td>
  </tr>
</table>
<table width="1002" height="48" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" background="images/index/dzw-01.jpg"><table width="100%" height="48" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="169" rowspan="3" align="center" valign="middle"><img src="images/index/logo.png" width="164" height="43" /></td>
        <td width="19" rowspan="3">&nbsp;</td>
        <td height="10" colspan="20"></td>
      </tr>
      <tr>
        <td width="12" height="30"><img src="images/index/d.png" width="12" height="30" /></td>
        <td width="65" align="center" valign="middle" background="images/index/dzw-02.jpg"><a style="font-size:14px;color:#ffffff" href="index.html">首页</a></td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="83" align="center" valign="middle" background="images/index/dzw-02.jpg">在线订餐</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="77" align="center" valign="middle" background="images/index/dzw-02.jpg">觅食推介</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="82" align="center" valign="middle" background="images/index/dzw-02.jpg">餐厅大全</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="82" align="center" valign="middle" background="images/index/dzw-02.jpg">美食搜索</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="78" align="center" valign="middle" background="images/index/dzw-02.jpg">健康饮食</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="80" align="center" valign="middle" background="images/index/dzw-02.jpg">饮食礼仪</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="80" align="center" valign="middle" background="images/index/dzw-02.jpg">餐饮禁忌</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="82" align="center" valign="middle" background="images/index/dzw-02.jpg">订餐流程</td>
        <td width="2" background="images/index/dzw-03.jpg"></td>
        <td width="75" align="center" valign="middle" background="images/index/dzw-02.jpg">用户注册</td>
      </tr>
      <tr>
        <td height="8" colspan="20"></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="1002" height="1" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="90" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="769" align="center" valign="middle">&nbsp;</td>
    <td width="4" bgcolor="#FFFFFF"></td>
    <td width="229" align="center" valign="middle">&nbsp;</td>
  </tr>
</table>
<table width="1002" height="1" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="29" border="0" align="center" cellpadding="0" cellspacing="0" style="border:solid 1px #ddd1b7;">
  <tr>
    <td width="1" bgcolor="#FFFFFF"></td>
    <td width="998" background="images/index/gg-04.jpg">&nbsp;</td>
    <td width="1" bgcolor="#FFFFFF"></td>
  </tr>
</table>
<table width="1002" height="3" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="71" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="246" bgcolor="#FFFFFF"><img src="images/index/gg-01.jpg" width="246" height="71" /></td>
    <td width="6" bgcolor="#FFFFFF"></td>
    <td width="246" bgcolor="#FFFFFF"><img src="images/index/gg-02.jpg" width="246" height="71" /></td>
    <td width="6" bgcolor="#FFFFFF"></td>
    <td width="246" bgcolor="#FFFFFF"><img src="images/index/gg-03.jpg" width="246" height="71" /></td>
    <td width="6" bgcolor="#FFFFFF"></td>
    <td width="246" bgcolor="#FFFFFF"><img src="images/index/gg-02.jpg" width="246" height="71" /></td>
  </tr>
</table>
<table width="1002" height="2" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="753" rowspan="5" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="365" valign="top">
		<table width="100%" height="255" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #f0f0f0;">
          <tr>
            <td align="center" valign="middle">主图片位</td>
          </tr>
        </table></td>
        <td width="6"></td>
        <td width="381" valign="top">
		<table width="100%" height="255" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="109" height="49" align="center" valign="top" background="images/index/gg-05.jpg" bgcolor="#fbfbfb">&nbsp;</td>
            <td width="223" align="center" valign="top" background="images/index/gg-07.jpg" bgcolor="#fbfbfb">&nbsp;</td>
            <td width="49" align="center" valign="top" background="images/index/gg-06.jpg" bgcolor="#fbfbfb">&nbsp;</td>
          </tr>
          <tr>
            <td height="206" colspan="3" align="left" valign="top" bgcolor="#fbfbfb" style="border:solid 1px #f0f0f0; border-top:none;">
              <s:if test="offersInfos.size != 0"> 
               <s:iterator value="offersInfos">
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	               <a href="#">
	                 <s:property value="content"/>
	               </a><br/>
	           </s:iterator>
	          </s:if>
	          <s:else>
	             <span style="white-space: nowrap;"><font style="color:red;">暂无优惠信息</font></span>
	          </s:else>
            </td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="3" bgcolor="#FFFFFF"></td>
        </tr>
      </table>
      <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc;">
        <tr>
          <td height="1" colspan="3" bgcolor="#FFFFFF"></td>
        </tr>
        <tr>
          <td width="43" height="32" background="images/index/gg-09.jpg"></td>
          <td width="87" style="padding-top:7px;FONT-WEIGHT: bold;font-size:14px;color:#000000" align="center" valign="middle" background="images/index/gg-08.jpg">招牌菜推荐</td>
          <td width="620" style="padding-top:7px;padding-right:7px;font-size:12px;color:#958559" align="right" background="images/index/gg-08.jpg">
             <s:iterator value="restaurantKinds">
               <a href="getFoodByRestaurantKind.do?restaurantKindId=<s:property value='restaurant_kind_Id'/>" target="restaurantView">
                 <s:property value="name"/>
               </a>
             </s:iterator>
          </td>
        </tr>
      </table>
      <table width="100%" height="344" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc; border-top:none;">
        <tr>
          <td align="center" valign="middle">
            <!-- 饮食展示 -->
            <iframe width="100%" height="344" frameborder="0" scrolling="no" id="restaurantView" name="restaurantView" src="getSignFoods.do"></iframe>
          </td>
        </tr>
      </table></td>
    <td width="5" rowspan="5" valign="top"></td>
    <td width="245" height="499" valign="top" style="border:solid 1px #f0f0f0;">
      <!-- 餐厅排行 -->
      <table style="width:100%;" class="table">
        <thead>
          <tr>
            <th>餐厅</th>
            <th>人气</th>
          </tr>
        </thead>
        <tbody>
	        <s:iterator value="restaurants">
		      <tr>
		        <td><s:property value="name"/></td>
		        <td><s:property value="prestige"/></td>
		      </tr>
		    </s:iterator>
	    </tbody>
      </table>
	</td>
  </tr>
  <tr>
    <td height="4" valign="top" bgcolor="#FFFFFF"></td>
  </tr>
  <tr>
    <td height="65" align="center" valign="middle">广告</td>
  </tr>
  <tr>
    <td height="4" valign="top"></td>
  </tr>
  <tr>
    <td height="65" align="center" valign="middle">广告</td>
  </tr>
</table>
<table width="1002" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="26" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="123" style="FONT-WEIGHT: bold;font-size:14px;color:#000000" align="center" valign="middle" background="images/index/gg-10.jpg">健康·餐饮</td>
    <td width="879" background="images/index/gg-11.jpg" style="border:solid 1px #ececec; border-left:none;">&nbsp;</td>
  </tr>
</table>
<table width="1002" height="7" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="7" valign="top"></td>
    <td width="320" valign="top"><table width="100%" height="286" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="27" height="30" valign="top" background="images/index/gg-12.jpg">&nbsp;</td>
        <td width="64" align="center" valign="middle" background="images/index/gg-13.jpg"><a style="FONT-WEIGHT: bold;font-size:13px;color:#000000">饮食秘籍</a></td>
        <td width="229" valign="top" background="images/index/gg-14.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td height="256" colspan="3" valign="top" style="border:solid 1px #bebebe; border-top:none;">&nbsp;</td>
      </tr>
    </table></td>
    <td width="12" valign="bottom"><img src="images/index/gg-16.jpg" width="12" height="88" /></td>
    <td width="413" valign="top"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #bebebe;border-bottom:none;">
      <tr>
        <td width="82" align="center" background="images/index/gg-15.jpg" class="dg1" id="dg[0]" onMouseOver="secBoard1(0)">养身食谱</td>
        <td width="1" bgcolor="#c4c4c4"></td>
        <td width="82" align="center" background="images/index/gg-15.jpg"class="dg2" id="dg[1]" onMouseOver="secBoard1(1)">健康前沿</td>
        <td width="1" bgcolor="#c4c4c4"></td>
        <td width="82" align="center" background="images/index/gg-15.jpg"class="dg2" id="dg[2]" onMouseOver="secBoard1(2)">天天美食</td>
        <td width="1" bgcolor="#c4c4c4"></td>
        <td width="159" bgcolor="#f5f3f4">&nbsp;</td>
      </tr>
    </table>
      <table width="100%" height="260" border="0" cellpadding="0" cellspacing="0" id="mainTable1" style="display:block;border:solid 1px #bebebe; border-top:none">
	  <tbody style="display:block;">
        <tr>
          <td align="left" valign="top">养身食谱列表</td>
        </tr>
	 </tbody>
		<tbody  style="display:none;">
        <tr>
          <td align="left" valign="top">健康前沿列表</td>
        </tr>
		</tbody>
		<tbody  style="display:none;">
        <tr>
          <td align="left" valign="top">天天美食列表</td>
        </tr>
		</tbody>
      </table></td>
    <td width="5" valign="top"></td>
    <td width="245" height="261" valign="top"><table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #bebebe; border-bottom:none">
      <tr>
        <td width="1" bgcolor="#ffffff"></td>
        <td width="11" background="images/index/gg-17.jpg">&nbsp;</td>
        <td style="FONT-WEIGHT: bold;font-size:13px;color:#3b6188" width="62" align="center" background="images/index/gg-17.jpg">健康名店</td>
        <td width="168" background="images/index/gg-17.jpg">&nbsp;</td>
        <td width="1" bgcolor="#ffffff"></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="1002" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="29" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc;">
  <tr>
    <td width="1" bgcolor="#ffffff"></td>
    <td width="30" align="center" valign="middle" background="images/index/gg-18.jpg" style="padding-top:7px;FONT-WEIGHT: bold;font-size:14px;color:#000000">&nbsp;</td>
    <td width="80" align="center" background="images/index/gg-18.jpg"><a style="FONT-WEIGHT: bold;font-size:14px;color:#000000">文化·餐饮</a></td>
    <td width="887" align="right" background="images/index/gg-18.jpg">&nbsp;</td>
    <td width="1" align="center" bgcolor="#ffffff"></td>
  </tr>
</table>
<table width="1002" height="7" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="7" valign="top"></td>
    <td width="320" valign="top">
	<table width="100%" height="237" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #efefef;">
      <tr>
        <td height="30" align="left" valign="middle" style="padding-left:7px;FONT-WEIGHT: bold;font-size:14px;color:#d6bf9d">酱版文化</td>
      </tr>
      <tr>
        <td height="207" valign="top">&nbsp;</td>
      </tr>
    </table></td>
    <td width="12" valign="bottom">&nbsp;</td>
    <td width="413" valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #efefef;">
          <tr>
            <td height="30" align="left" valign="middle" style="padding-left:7px;FONT-WEIGHT: bold;font-size:14px;color:#d6bf9d">武陵吃文</td>
          </tr>
          <tr>
            <td height="207" valign="top">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
    <td width="5" valign="top"></td>
    <td width="245" valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="25" valign="top" background="images/index/gg-19.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td height="212" valign="top">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="1002" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="110" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc;">
  <tr>
    <td width="12" height="3"></td>
    <td width="78" bgcolor="#cd9405"></td>
    <td width="910"></td>
  </tr>
  <tr>
    <td height="17" colspan="3" align="left" style="padding-left:20px;padding-top:3px;FONT-WEIGHT: bold;font-size:14px;color:#cd9405">贪吃美图</td>
  </tr>
  <tr>
    <td height="90" colspan="3">&nbsp;</td>
  </tr>
</table>
<table width="1002" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td></td>
  </tr>
</table>
<table width="1002" height="30" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td style="font-weight:bold;font-size:12px;color:#000000" align="center">关于我们 | 企业服务 | 招聘信息 | 联系我们</td>
  </tr>
</table>
<table width="1002" height="28" border="0" cellpadding="0" cellspacing="0" bgcolor="#444444">
  <tr>
    <td style="font-size:12px;color:#ffffff" align="center">餐饮�网版权所�有2009-2015   网络实名：餐饮网   联系电话�?3974268967   最佳浏览效�果:1024*1280</td>
  </tr>
</table>
</body>
</html>
