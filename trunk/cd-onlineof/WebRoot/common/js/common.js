/***************公共的JS方法*********************/
function getAllCheckedValue(){
	var selectCount = 0;
	var values = new Array();
	var checks = document.getElementsByName("checks");
	for(var i=0; i<checks.length; i++){
		if(checks[i].checked){
			values[i] = checks[i].value;
			selectCount+=1;
		}
	}
	if(selectCount==0){
		return null;
	}else{
		return values;
	}
	
}
