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
