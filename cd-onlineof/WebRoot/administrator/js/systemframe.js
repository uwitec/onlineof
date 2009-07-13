  /*****************************
     ������ TanDong 2009-7-13
  *****************************/
  function initial() {
      intialNavigate($("NavigateContainer"));
  }
   
  function $(name) {
      return document.getElementById(name);
  }
  
  function get_time() {
    var date=new Date();
    var year="",month="",day="",week="",hour="",minute="",second="";
    year=date.getYear();
    month=add_zero(date.getMonth()+1);
    day=add_zero(date.getDate());
    week=date.getDay();
    switch (date.getDay()) {
      case 0:val="星期天������";break
      case 1:val="星期一";break
      case 2:val="���星期二";break
      case 3:val="星期三��";break
      case 4:val="星期四�����";break
      case 5:val="星期五";break
      case 6:val="������星期六";break
    }
    hour=add_zero(date.getHours());
    minute=add_zero(date.getMinutes());
    second=add_zero(date.getSeconds());
    $("timetable").innerText=" "+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+val;
  }

  function add_zero(temp)
  {
    if(temp<10) return "0"+temp;
    else return temp;
  }

  setInterval("get_time()",1000);
  
  /*****************************
     ������ TanDong 2009-7-13
  *****************************/
  
  var navHandle = null;

  var currentSelectNavItem = null;

  function intialNavigate(handle) {
      navHandle = handle; 
	  var selectIndex = navHandle.defaultIndex;
	  var left = 0;
	  var cWidth = 88;
	  for(var i = 0 ; i<navHandle.children.length;i++) {
	     var item = navHandle.children(i);
		 if(item.className == "NavItem") {
			 item.style.left  = left;
			 item.style.width = cWidth;
			 left  += cWidth;
			 //left  += item.offsetWidth;
		 } else if(item.className == "NavSpace") {
		     item.style.left  = left;
             left   += 5;
		 } if(item.className == "NavItemSelect" ) {
			 item.style.left  = left;
			 item.style.width = cWidth;
			 left  += cWidth;
             selectNavItem(item);
		 }
	  }

	  if(currentSelectNavItem == null) {
		 if(navHandle.children[selectIndex]) {
             selectNavItem(navHandle.children[selectIndex]);
		 } else {
             selectNavItem(navHandle.children[0]);
		 }
      }   
	  navHandle.style.width = left;
      navHandle.style.display = "block";
  }

  function selectNavItem(csNavItem) {
      if(typeof(csNavItem) != "undefined" && csNavItem != null) {   
           if(currentSelectNavItem) {
		      currentSelectNavItem.className = "NavItem";
			  if($(currentSelectNavItem.submenu)) {
                  $(currentSelectNavItem.submenu).style.display = "none";
			  }
		   } 
           currentSelectNavItem = csNavItem;
		   currentSelectNavItem.className = "NavItemSelect";
		   if($(csNavItem.submenu)) {
			//  $(currentSelectNavItem.submenu).filters[0].Apply();
              $(csNavItem.submenu).style.display = "block";
			//  $(currentSelectNavItem.submenu).filters[0].play();
		   }
	  }else {
         alert("没有此项����");
	  }
  }

  function doNavigateMouseDown() {
     var srcItem = window.event.srcElement;
	 if(srcItem.tagName == "DIV" && srcItem.className == "NavItem") {
        if(currentSelectNavItem) {
		   currentSelectNavItem.className = "NavItem";
           $(currentSelectNavItem.submenu).style.display = "none";
		} 
        currentSelectNavItem = srcItem;
		currentSelectNavItem.className = "NavItemSelect";
		$(currentSelectNavItem.submenu).filters[0].Apply();
		$(currentSelectNavItem.submenu).style.display = "block";
		$(currentSelectNavItem.submenu).filters[0].play();
	 }   
  }


  /*****************************
     �˵� TanDong 2009-7-13
  *****************************/
  //��ǰ�򿪵��Ӳ˵�
  var currentSubMenu    = null;
  //��ǰѡ��˵�
  var currentSelectMenu = null;

  function doMenuMouseDown() {
    var srcItem = window.event.srcElement ;
	//�Ƿ�ѡ���Ӳ˵�
	if(srcItem.tagName == "IMG" && srcItem.parentElement.tagName == "DIV" && srcItem.parentElement.className=="SubMenuItem") {
		if(currentSubMenu) {
		   if(currentSubMenu != srcItem.parentElement) {
			   if(currentSubMenu.nextSibling.style.display == "block") {
				  setSubMenuHidden(currentSubMenu,true);
			   }                
		   }
		}

        setSubMenuHidden(srcItem.parentElement,(srcItem.parentElement.nextSibling.style.display == "block"));

		currentSubMenu = srcItem.parentElement;
	} else {
		srcItem = getMenuItemElement(srcItem);
		if(srcItem!=null) { 
			if(currentSelectMenu) {
			   if(currentSelectMenu != srcItem) {
				 currentSelectMenu.className = "MenuItem";
			   }
			}
			currentSelectMenu = srcItem;
			currentSelectMenu.className = "MenuItemSelect";
			window.status = srcItem.url;
			ContentFrame.location.href = srcItem.url;
		}
	}
  }

  function doMenuMouseOver() {
    var srcItem = getMenuItemElement(window.event.srcElement);
	if(srcItem!=null) { 
	   if(currentSelectMenu != srcItem) {
		   srcItem.className = "MenuItemOver";
	   }		
	}
  }

  function doMenuMouseOut() {
    var srcItem = getMenuItemElement(window.event.srcElement);
	if(srcItem!=null) { 
	   if(currentSelectMenu != srcItem) {
		   srcItem.className = "MenuItem";
	   }		
	}
  }

  function setSubMenuHidden(src,isHidden) {
     if(isHidden) {
        src.nextSibling.style.display = "none";
		src.children[0].src = "../image/open.gif"
	 } else {
		src.nextSibling.filters[0].Apply();
        src.nextSibling.style.display = "block";
		src.nextSibling.filters[0].play();
		src.children[0].src = "../image/close.gif"
	 }
  }

  function getMenuItemElement(srcItem) {
	 if(srcItem.tagName == "SPAN" && srcItem.parentElement.className.indexOf("MenuItem") == 0) {
		//alert("��������·��Ϊ["+url+"]");
		//ContentFrame.location.href = url;
		return srcItem.parentElement;
	 } else if(srcItem.tagName == "DIV" && srcItem.parentElement.className.indexOf("MenuItem") == 0) {
        return srcItem;
	 } else {
        return null;
	 }
  }