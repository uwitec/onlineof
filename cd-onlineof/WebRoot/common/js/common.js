/***************公共的JS方法*********************/

/**
 * getAllCheckedValue
 * @author TanDong
 */
function getAllCheckedValue(){
	var values = new Array();
	var checks = document.getElementsByName("checksItem");
	for(var i=0; i<checks.length; i++){
		if(checks[i].checked){
			values[i] = checks[i].value;
		}
	}
	return values.length;
}
/**
 * Close the window of model
 * @author TanDong
 */
function closeWindow(){
    window.close();
}

/**
 * Select all
 * @author TanDong
 */
function checkedAll() 
{ 
    for(var i=0; i<document.getElementsByName("checksItem").length; i++) 
    {  
	    if(document.getElementById("checkAll").checked==true){
			document.getElementsByName("checksItem")[i].checked = true;
	    }else{
		    document.getElementsByName("checksItem")[i].checked = false;
	    }
	} 
}

function winOpen(sTitle, sUrl, iWidth, iHeight, iScroll, bCentre){
    var sFeatures;
    var iTop, iLeft;
    iWidth = iWidth + 20;
    if (bCentre != true) {
        iTop = 0;
        iLeft = 0;
    }
    else {
        iTop = (screen.availHeight - iHeight) / 2;
        iLeft = (screen.availWidth - iWidth) / 2;
        //iTop=(screen.height-iHeight)/2;
        //iLeft=(screen.width-iWidth)/2;
    }
    sFeatures = "height=" + iHeight + ",width=" + iWidth + ",top=" + iTop + ",left=" + iLeft + ",status=no, toolbar=no, menubar=no, location=no, resizable=no, scrollbars=" + iScroll + "";
    var objWin;
    objWin = window.open(sUrl, sTitle, sFeatures, "true");
    objWin.focus();
    return objWin;
}
