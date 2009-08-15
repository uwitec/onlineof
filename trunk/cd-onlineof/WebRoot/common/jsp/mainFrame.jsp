<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
	<link href="images/css.css" rel="stylesheet" type="text/css" />

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
  
  <body>
	<table width="1140" height="29" border="0" align="center" cellpadding="0" cellspacing="0" style="border:solid 1px #ddd1b7;">
	  <tr>
	    <td width="1" bgcolor="#FFFFFF"></td>
	    <td width="*" background="images/gg-04.jpg">&nbsp;</td>
	    <td width="1" bgcolor="#FFFFFF"></td>
	  </tr>
	</table>
	<table width="1140" height="3" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" height="71" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="24%" bgcolor="#FFFFFF"><img src="images/gg-01.jpg" width="276" height="71" /></td>
	    <td width="1%" bgcolor="#FFFFFF"></td>
	    <td width="24%" bgcolor="#FFFFFF"><img src="images/gg-02.jpg" width="276" height="71" /></td>
	    <td width="1%" bgcolor="#FFFFFF"></td>
	    <td width="24%" bgcolor="#FFFFFF"><img src="images/gg-03.jpg" width="276" height="71" /></td>
	    <td width="1%" bgcolor="#FFFFFF"></td>
	    <td width="24%" bgcolor="#FFFFFF"><img src="images/gg-02.jpg" width="276" height="71" /></td>
	  </tr>
	</table>
	<table width="1140" height="2" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="75%" rowspan="5" valign="top">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td width="48%" valign="top">
					<table width="100%" height="255" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #f0f0f0;">
			          <tr>
			            <td align="center" valign="middle">主图片位置</td>
			          </tr>
			        </table>
		     	</td>
		        <td width="1%"></td>
		        <td width="49%" valign="top">
					<table width="100%" height="255" border="0" cellpadding="0" cellspacing="0">
			          <tr>
			            <td width="100" height="49" align="center" valign="top" background="images/gg-05.jpg" bgcolor="#fbfbfb">&nbsp;</td>
			            <td width="223" align="center" valign="top" background="images/gg-07.jpg" bgcolor="#fbfbfb">&nbsp;</td>
			            <td width="49" align="center" valign="top" background="images/gg-06.jpg" bgcolor="#fbfbfb">&nbsp;</td>
			          </tr>
			          <tr>
			            <td height="206" colspan="3" align="left" valign="top" bgcolor="#fbfbfb" style="border:solid 1px #f0f0f0; border-top:none;">信息</td>
			          </tr>
			        </table>
		        </td>
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
		          <td width="43" height="32" background="images/gg-09.jpg"></td>
		          <td width="87" style="padding-top:7px;FONT-WEIGHT: bold;font-size:14px;color:#000000" align="center" valign="middle" background="images/gg-08.jpg">招牌菜推荐</td>
		          <td width="620" style="padding-top:7px;padding-right:7px;font-size:12px;color:#958559" align="right" background="images/gg-08.jpg">
		          	<a href="">川菜</a>&nbsp;&nbsp;
		          	<a href="">湘菜</a>&nbsp;&nbsp;
		          	<a href="">粤菜</a>&nbsp;&nbsp;
		          	<a href="">江浙菜</a>&nbsp;&nbsp;
		          	<a href="">西餐</a>&nbsp;&nbsp;
		          	<a href="">鲁菜</a>&nbsp;&nbsp;
		          	<a href="">咖啡厅</a>&nbsp;&nbsp;
		          	<a href="">家常菜</a>&nbsp;&nbsp;
		          	<a href="">甜品</a>
		          </td>
		        </tr>
		    </table>
		    <table width="100%" height="344" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc; border-top:none;">
		        <tr>
		          <td align="center" valign="middle">&nbsp;</td>
		        </tr>
		    </table>
	    </td>
	    <td width="1%" rowspan="5" valign="top"></td>
	    <td width="24%" height="499" valign="top" style="border:solid 1px #f0f0f0;">&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="4" valign="top" bgcolor="#FFFFFF"></td>
	  </tr>
	  <tr>
	    <td height="65" align="center" valign="middle">广告位</td>
	  </tr>
	  <tr>
	    <td height="4" valign="top"></td>
	  </tr>
	  <tr>
	    <td height="65" align="center" valign="middle">广告位</td>
	  </tr>
	</table>
	<table width="1140" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" height="26" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="123" style="FONT-WEIGHT: bold;font-size:14px;color:#000000" align="center" valign="middle" background="images/gg-10.jpg">健康·餐饮</td>
	    <td width="879" background="images/gg-11.jpg" style="border:solid 1px #ececec; border-left:none;">&nbsp;</td>
	  </tr>
	</table>
	<table width="1140" height="7" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="7" valign="top"></td>
	    <td width="350" valign="top"><table width="100%" height="286" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td width="27" height="30" valign="top" background="images/gg-12.jpg">&nbsp;</td>
	        <td width="64" align="center" valign="middle" background="images/gg-13.jpg"><a style="FONT-WEIGHT: bold;font-size:13px;color:#000000">饮食秘籍</a></td>
	        <td width="259" valign="top" background="images/gg-13.jpg">&nbsp;</td>
	      </tr>
	      <tr>
	        <td height="256" colspan="3" valign="top" style="border:solid 1px #bebebe; border-top:none;">&nbsp;</td>
	      </tr>
	    </table></td>
	    <td width="12" valign="bottom"><img src="images/gg-16.jpg" width="12" height="88" /></td>
	    <td width="493" valign="top"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #bebebe;border-bottom:none;">
	      <tr>
	        <td width="82" align="center" background="images/gg-15.jpg" class="dg1" id="dg[0]" onMouseOver="secBoard1(0)">养身食谱</td>
	        <td width="1" bgcolor="#c4c4c4"></td>
	        <td width="82" align="center" background="images/gg-15.jpg"class="dg2" id="dg[1]" onMouseOver="secBoard1(1)">健康前沿</td>
	        <td width="1" bgcolor="#c4c4c4"></td>
	        <td width="82" align="center" background="images/gg-15.jpg"class="dg2" id="dg[2]" onMouseOver="secBoard1(2)">天天美食</td>
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
	    <td width="285" height="261" valign="top"><table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #bebebe; border-bottom:none">
	      <tr>
	        <td width="1" bgcolor="#ffffff"></td>
	        <td width="11" background="images/gg-17.jpg">&nbsp;</td>
	        <td style="FONT-WEIGHT: bold;font-size:13px;color:#3b6188" width="62" align="center" background="images/gg-17.jpg">健康名店</td>
	        <td width="168" background="images/gg-17.jpg">&nbsp;</td>
	        <td width="1" bgcolor="#ffffff"></td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
	<table width="1140" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" height="29" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #cccccc;">
	  <tr>
	    <td width="1" bgcolor="#ffffff"></td>
	    <td width="30" align="center" valign="middle" background="images/gg-18.jpg" style="padding-top:7px;FONT-WEIGHT: bold;font-size:14px;color:#000000">&nbsp;</td>
	    <td width="80" align="center" background="images/gg-18.jpg"><a style="FONT-WEIGHT: bold;font-size:14px;color:#000000">文化·餐饮</a></td>
	    <td width="887" align="right" background="images/gg-18.jpg">&nbsp;</td>
	    <td width="1" align="center" bgcolor="#ffffff"></td>
	  </tr>
	</table>
	<table width="1140" height="7" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	<table width="1140" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="7" valign="top"></td>
	    <td width="380" valign="top">
		<table width="100%" height="237" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #efefef;">
	      <tr>
	        <td height="30" align="left" valign="middle" style="padding-left:7px;FONT-WEIGHT: bold;font-size:14px;color:#d6bf9d">酱版文化</td>
	      </tr>
	      <tr>
	        <td height="207" valign="top">&nbsp;</td>
	      </tr>
	    </table></td>
	    <td width="12" valign="bottom">&nbsp;</td>
	    <td width="440" valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0" style="border:solid 1px #efefef;">
	          <tr>
	            <td height="30" align="left" valign="middle" style="padding-left:7px;FONT-WEIGHT: bold;font-size:14px;color:#d6bf9d">武陵吃文化</td>
	          </tr>
	          <tr>
	            <td height="207" valign="top">&nbsp;</td>
	          </tr>
	        </table></td>
	      </tr>
	    </table></td>
	    <td width="5" valign="top"></td>
	    <td width="255" valign="top"><table width="100%" height="237" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td height="25" valign="top" background="images/gg-19.jpg">&nbsp;</td>
	      </tr>
	      <tr>
	        <td height="212" valign="top">&nbsp;</td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
	<table width="1140" height="4" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
	  <tr>
	    <td></td>
	  </tr>
	</table>
	
<div style="border:1px solid #A9A9A9;width:1140;height:60px;">
	<div class="rollBox">
     <div class="LeftBotton" onmousedown="ISL_GoUp()" onmouseup="ISL_StopUp()" onmouseout="ISL_StopUp()"></div>
     <div class="Cont" id="ISL_Cont">
      <div class="ScrCont">
       <div id="List1">
       
        <!-- 图片列表 begin -->
         <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s1.jpg" width="109" height="87" /></a>
         </div>       
        
		 <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s2.jpg" width="109" height="87"  /></a>
         </div>
         <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s3.jpg" width="109" height="87" /></a>
         </div>
         <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s4.jpg" width="109" height="87" /></a>
         </div>
         <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s5.jpg" width="109" height="87" /></a>
         </div>
		 <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s6.jpg" width="109" height="87" /></a>
         </div>      
         <div class="pic">
          <a href="/" target="_blank"><img src="images/wall_s7.jpg" width="109" height="87" /></a>
         </div>
        <!-- 图片列表 end -->
        
       </div>
       <div id="List2"></div>
      </div>
     </div>
     <div class="RightBotton" onmousedown="ISL_GoDown()" onmouseup="ISL_StopDown()" onmouseout="ISL_StopDown()"></div>
     <div style="border:1px solid #A9A9A9;">
     	<embed height="100" src="images/banner.swf"/>
     	<img src="images/dzw-02.jpg" />
     </div>
    </div>
	

	<script language="javascript" type="text/javascript">
	<!--//--><![CDATA[//><!--
	//图片滚动列表 mengjia 070816
	var Speed = 1; //速度(毫秒)
	var Space = 5; //每次移动(px)
	var PageWidth = 528; //翻页宽度
	var fill = 0; //整体移位
	var MoveLock = false;
	var MoveTimeObj;
	var Comp = 0;
	var AutoPlayObj = null;
	GetObj("List2").innerHTML = GetObj("List1").innerHTML;
	GetObj('ISL_Cont').scrollLeft = fill;
	GetObj("ISL_Cont").onmouseover = function(){clearInterval(AutoPlayObj);}
	GetObj("ISL_Cont").onmouseout = function(){AutoPlay();}
	AutoPlay();
	function GetObj(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}}
	function AutoPlay(){ //自动滚动
	 clearInterval(AutoPlayObj);
	 AutoPlayObj = setInterval('ISL_GoDown();ISL_StopDown();',3000); //间隔时间
	}
	function ISL_GoUp(){ //上翻开始
	 if(MoveLock) return;
	 clearInterval(AutoPlayObj);
	 MoveLock = true;
	 MoveTimeObj = setInterval('ISL_ScrUp();',Speed);
	}
	function ISL_StopUp(){ //上翻停止
	 clearInterval(MoveTimeObj);
	 if(GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0){
	  Comp = fill - (GetObj('ISL_Cont').scrollLeft % PageWidth);
	  CompScr();
	 }else{
	  MoveLock = false;
	 }
	 AutoPlay();
	}
	function ISL_ScrUp(){ //上翻动作
	 if(GetObj('ISL_Cont').scrollLeft <= 0){GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft + GetObj('List1').offsetWidth}
	 GetObj('ISL_Cont').scrollLeft -= Space ;
	}
	function ISL_GoDown(){ //下翻
	 clearInterval(MoveTimeObj);
	 if(MoveLock) return;
	 clearInterval(AutoPlayObj);
	 MoveLock = true;
	 ISL_ScrDown();
	 MoveTimeObj = setInterval('ISL_ScrDown()',Speed);
	}
	function ISL_StopDown(){ //下翻停止
	 clearInterval(MoveTimeObj);
	 if(GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0 ){
	  Comp = PageWidth - GetObj('ISL_Cont').scrollLeft % PageWidth + fill;
	  CompScr();
	 }else{
	  MoveLock = false;
	 }
	 AutoPlay();
	}
	function ISL_ScrDown(){ //下翻动作
	 if(GetObj('ISL_Cont').scrollLeft >= GetObj('List1').scrollWidth){GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft - GetObj('List1').scrollWidth;}
	 GetObj('ISL_Cont').scrollLeft += Space ;
	}
	function CompScr(){
	 var num;
	 if(Comp == 0){MoveLock = false;return;}
	 if(Comp < 0){ //上翻
	  if(Comp < -Space){
	   Comp += Space;
	   num = Space;
	  }else{
	   num = -Comp;
	   Comp = 0;
	  }
	  GetObj('ISL_Cont').scrollLeft -= num;
	  setTimeout('CompScr()',Speed);
	 }else{ //下翻
	  if(Comp > Space){
	   Comp -= Space;
	   num = Space;
	  }else{
	   num = Comp;
	   Comp = 0;
	  }
	  GetObj('ISL_Cont').scrollLeft += num;
	  setTimeout('CompScr()',Speed);
	 }
	}
	//--><!]]>
	</script>
</div>
  </body>
</html>
