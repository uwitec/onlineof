/*--------------------------------------------------|

| dTree 2.05 | www.destroydrop.com/javascript/tree/ |

|---------------------------------------------------|

| Copyright (c) 2002-2003 Geir Landr?              |

|                                                   |

| This script can be used freely as long as all     |

| copyright messages are intact.                    |

|                                                   |

| Updated: 11-2-2009                            |

|--------------------------------------------------*/



// Node object	
 //申明树的一个节点
function Node(id, pid, name, url, title, target, icon, iconOpen, open,inputName,inputValue,inputType,myOnClick) {

	this.id = id; 
	this.pid = pid; 
	this.name = name; 
	this.url = url; 
	this.title = title; 
	this.target = target; 
	this.icon = icon; 
	this.iconOpen = iconOpen; 
	this._io = open || false; 
	this._is = false; 
	this._ls = false; 
	this._hc = false; 
	this._ai = 0; 
	this._p; 
	this.inputName=inputName;
	this.inputValue=inputValue;
	this.inputType = inputType;
	this.myOnClick = myOnClick;
	this.isSetChildParent = true;
 
	 
};

 
// Tree object
//定义一棵树
function dTree(objName,pathImgCss,inputType,pathImgCssDir) {

	this.config = { 
		target					: null, 
		folderLinks			: true, 
		useSelection		: true, 
		useCookies			: true, 
		useLines				: true, 
		useIcons				: true, 
		useStatusText		: false, 
		closeSameLevel	: false, 
		inOrder					: false
       
	}

	    
	if(pathImgCss==null || pathImgCss.length<1)
		pathImgCss="administrator";
		
	if(pathImgCssDir==null || pathImgCssDir.length<1)
		pathImgCssDir="/image/dtree";
		
	this.icon = { 
		root				: pathImgCss + pathImgCssDir +'/base.gif',
		folder			: pathImgCss + pathImgCssDir +'/folder.gif',
		folderOpen	: pathImgCss + pathImgCssDir +'/folderopen.gif',
		node				: pathImgCss + pathImgCssDir +'/page.gif',
		empty				: pathImgCss + pathImgCssDir +'/empty.gif',
		line				: pathImgCss + pathImgCssDir +'/line.gif',
		join				: pathImgCss + pathImgCssDir +'/join.gif',
		joinBottom	: pathImgCss + pathImgCssDir +'/joinbottom.gif',
		plus				: pathImgCss + pathImgCssDir +'/plus.gif',
		plusBottom	: pathImgCss + pathImgCssDir +'/plusbottom.gif',
		minus				: pathImgCss + pathImgCssDir +'/minus.gif',
		minusBottom	: pathImgCss + pathImgCssDir +'/minusbottom.gif',
		nlPlus			: pathImgCss + pathImgCssDir +'/nolines_plus.gif',
		nlMinus			: pathImgCss + pathImgCssDir +'/nolines_minus.gif'
    }
	this.obj = objName;

	this.aNodes = [];

	this.aIndent = [];

	this.root = new Node(-1);

	this.selectedNode = null;

	this.selectedFound = false;

	this.completed = false;

	
	this.inputType = inputType;

	this.inputName = "inputName";
	this.inputValue = "";
	this.myOnClick = ""; 

 } 
// Adds a new node to the node array
//定义树添加节点的方法
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open) { 
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open,this.inputName,this.inputValue,this.inputType,this.myOnClick);

};



// Open/close all nodes
//定义全部节点展开的方法
dTree.prototype.openAll = function() {

	this.oAll(true);

};

dTree.prototype.closeAll = function() {

	this.oAll(false);

};



// Outputs the tree to the page
// 将树输出
dTree.prototype.toString = function() {

	var str = '<div id="div_dtree" class="dtree">\n';

	if (document.getElementById) {

		if (this.config.useCookies) this.selectedNode = this.getSelected();

		str += this.addNode(this.root);

	} else str += 'Browser not supported.';

	str += '</div>';

	if (!this.selectedFound) this.selectedNode = null;

	this.completed = true;
	
	//alert(str);
	//alert(document.all("tt").value=str) ;
	return str;

};



// Creates the tree structure
//增加节点(给节点对象)
dTree.prototype.addNode = function(pNode) {

	var str = ''; 
	var n=0; 
	if (this.config.inOrder) n = pNode._ai; 
	for (n; n<this.aNodes.length; n++) { 
		if (this.aNodes[n].pid == pNode.id) { 
			var cn = this.aNodes[n]; 
			cn._p = pNode; 
			cn._ai = n; 
			this.setCS(cn); 
			if (!cn.target && this.config.target) cn.target = this.config.target; 
			if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id); 
			if (!this.config.folderLinks && cn._hc) cn.url = null; 
			if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) { 
					cn._is = true; 
					this.selectedNode = n; 
					this.selectedFound = true; 
			}

			str += this.node(cn, n); 
			if (cn._ls) break;

		}

	}

	return str;
					   
};



// Creates the node icon, url and text
//创建节点图片、URL、和文本
dTree.prototype.node = function(node, nodeId) {

	var str = '<div  class="dTreeNode">' + this.indent(node, nodeId);

	if (this.config.useIcons) {

		if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);

		if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;

		if (this.root.id == node.pid) { 
			node.icon = this.icon.root; 
			node.iconOpen = this.icon.root; 
		}
		str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
 }

	//  alert(node.id+"=="+node.inputName);
	//?????
	//alert(this.inputType);
	if(node.inputType!=null && node.inputType.length>2)
		str +=
 '<INPUT TYPE="'+ node.inputType +'"  treeName="'+ this.obj +'"  isSetChildParent="'+ this.isSetChildParent +'"  onclick=\"Onclk(this);'+ node.myOnClick +'\" nodeId="'+ nodeId +'"  id="id_'+ node.inputValue +'"   nodeName ="'+ node.name +'"  value="'+ node.id +'" NAME="'+ node.inputName +'" class="check">';
	if (node.url) {

		str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';

		if (node.title) str += ' title="' + node.title + '"';

		if (node.target) str += ' target="' + node.target + '"';

		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';

		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))

			str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';

		str += '>';

	}

	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)

		str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';

	str += node.name;

	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';

	str += '</div>';

	if (node._hc) {

		str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';

		str += this.addNode(node);

		str += '</div>';

	}

	this.aIndent.pop();

	return str;

};



// Adds the empty and line icons

dTree.prototype.indent = function(node, nodeId) {

	var str = '';

	if (this.root.id != node.pid) {

		for (var n=0; n<this.aIndent.length; n++)

			str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
			
		(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);

		if (node._hc) {

			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';

			if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;

			else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );

			str += '" alt="" /></a>';

		} else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';

			
	}

	return str;

};



// Checks if a node has any children and if it is the last sibling

dTree.prototype.setCS = function(node) {

	var lastId;

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.id) node._hc = true;

		if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;

	}

	if (lastId==node.id) node._ls = true;

};



// Returns the selected node
//返回选中的节点的Id
dTree.prototype.getSelected = function() {

	var sn = this.getCookie('cs' + this.obj);

	return (sn) ? sn : null;

};
//获取选中的节点对象
dTree.prototype.getSelectNode = function (){
	//获取节点Id
	var sn = this.getCookie('cs' + this.obj);
	//在集合中查询去节点对象
	for(var n=0;n<this.aNodes.length;n++){
		if(this.aNodes[n].id==sn){
			return this.aNodes[n];
		}
	}
};



// Highlights the selected node

dTree.prototype.s = function(id) {

	if (!this.config.useSelection) return;

	var cn = this.aNodes[id];

	if (cn._hc && !this.config.folderLinks) return;

	if (this.selectedNode != id) {

		if (this.selectedNode || this.selectedNode==0) {

			eOld = document.getElementById("s" + this.obj + this.selectedNode);

			eOld.className = "node";

		}

		eNew = document.getElementById("s" + this.obj + id);

		eNew.className = "nodeSel";

		this.selectedNode = id;

		if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);

	}

};



// Toggle Open or close

dTree.prototype.o = function(id) {

	var cn = this.aNodes[id];

	this.nodeStatus(!cn._io, id, cn._ls);

	cn._io = !cn._io;

	if (this.config.closeSameLevel) this.closeLevel(cn);

	if (this.config.useCookies) this.updateCookie();

};



// Open or close all nodes
//获取所有节点
dTree.prototype.oAll = function(status) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {

			this.nodeStatus(status, n, this.aNodes[n]._ls)

			this.aNodes[n]._io = status;

		}

	}

	if (this.config.useCookies) this.updateCookie();

};



// Opens the tree to a specific node
// 打开树具体的节点
dTree.prototype.openTo = function(nId, bSelect, bFirst) {

	if (!bFirst) {

		for (var n=0; n<this.aNodes.length; n++) {

			if (this.aNodes[n].id == nId) {

				nId=n;

				break;

			}

		}

	}

	var cn=this.aNodes[nId];

	if (cn.pid==this.root.id || !cn._p) return;

	cn._io = true;

	cn._is = bSelect;

	if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);

	if (this.completed && bSelect) this.s(cn._ai);

	else if (bSelect) this._sn=cn._ai;

	this.openTo(cn._p._ai, false, true);

};



// Closes all nodes on the same level as certain node
//关闭所有的子节点
dTree.prototype.closeLevel = function(node) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {

			this.nodeStatus(false, n, this.aNodes[n]._ls);

			this.aNodes[n]._io = false;

			this.closeAllChildren(this.aNodes[n]);

		}

	}

}



// Closes all children of a node
//关闭所有的子节点
dTree.prototype.closeAllChildren = function(node) {

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {

			if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);

			this.aNodes[n]._io = false;

			this.closeAllChildren(this.aNodes[n]);		

		}

	}

}


// Change the status of a node(open or closed)
//改变节点的状态
dTree.prototype.nodeStatus = function(status, id, bottom) {

	eDiv	= document.getElementById('d' + this.obj + id);

	eJoin	= document.getElementById('j' + this.obj + id);

	if (this.config.useIcons) {

		eIcon	= document.getElementById('i' + this.obj + id);

		eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;

	}

	eJoin.src = (this.config.useLines)?

	((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):

	((status)?this.icon.nlMinus:this.icon.nlPlus);

	eDiv.style.display = (status) ? 'block': 'none';

};





// [Cookie] Clears a cookie
//删除Cookie
dTree.prototype.clearCookie = function() {

	var now = new Date();

	var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);

	this.setCookie('co'+this.obj, 'cookieValue', yesterday);

	this.setCookie('cs'+this.obj, 'cookieValue', yesterday);

};



// [Cookie] Sets value in a cookie
//设置Cookie
dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {

	document.cookie =

		escape(cookieName) + '=' + escape(cookieValue)

		+ (expires ? '; expires=' + expires.toGMTString() : '')

		+ (path ? '; path=' + path : '')

		+ (domain ? '; domain=' + domain : '')

		+ (secure ? '; secure' : '');

};



// [Cookie] Gets a value from a cookie
// 获取Cookie
dTree.prototype.getCookie = function(cookieName) {

	var cookieValue = '';

	var posName = document.cookie.indexOf(escape(cookieName) + '=');

	if (posName != -1) {

		var posValue = posName + (escape(cookieName) + '=').length;

		var endPos = document.cookie.indexOf(';', posValue);

		if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));

		else cookieValue = unescape(document.cookie.substring(posValue));

	}

	return (cookieValue);

};



// [Cookie] Returns ids of open nodes as a string
// 修改Cookie
dTree.prototype.updateCookie = function() {

	var str = '';

	for (var n=0; n<this.aNodes.length; n++) {

		if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {

			if (str) str += '.';

			str += this.aNodes[n].id;

		}

	}

	this.setCookie('co' + this.obj, str);

};



// [Cookie] Checks if a node id is in a cookie

dTree.prototype.isOpen = function(id) {

	var aOpen = this.getCookie('co' + this.obj).split('.');

	for (var n=0; n<aOpen.length; n++)

		if (aOpen[n] == id) return true;

	return false;

};



// If Push and pop is not implemented by the browser

if (!Array.prototype.push) {

	Array.prototype.push = function array_push() {

		for(var i=0;i<arguments.length;i++)

			this[this.length]=arguments[i];

		return this.length;

	}

};

if (!Array.prototype.pop) {

	Array.prototype.pop = function array_pop() {

		lastElement = this[this.length-1];

		this.length = Math.max(this.length-1,0);

		return lastElement;

	}

};

 function Onclk(obj)
{ 
	 //alert(obj.type);
	if(obj.type=='radio')
		return;
    if(obj.isSetChildParent=='false')
    	return; 
	//alert(obj.nodeId);  
	var childs = document.getElementById('d'+ obj.treeName + obj.nodeId); 
	if(childs != null)
	{
	    var  items = childs.getElementsByTagName("INPUT");	  
		for(var i=0;items.length>i;i++)
		{	
		   if(!items[i].disabled) 
				items[i].checked=obj.checked;  
		  
		}
	}
	if(!obj.checked) {
       return;
	}

	 setParent(obj)	;

}
//?????????????
function setParent(obj)
{	
	//	alert(obj.outerHTML);
    if(obj.nodeId==0) return ; 
	if(obj.parentElement.parentElement.previousSibling){
		var  items = obj.parentElement.parentElement.previousSibling.getElementsByTagName("INPUT");
		items[0].checked = obj.checked;
        setParent(items[0]); 
	}
}


	function disableAll()
	{
		  //var ids = strIds.split(","); 
		  var objs = document.all("div_dtree").getElementsByTagName("INPUT");
		  for(var i=0;i<objs.length;i++)
		  { 
		      objs[i].disabled="true";
	      }
	} 	
	
	 
	function clearAll()
	{
		  //var ids = strIds.split(","); 
		  var objs = document.all("div_dtree").getElementsByTagName("INPUT");
		  for(var i=0;i<objs.length;i++)
		  { 
		      objs[i].checked=false;
	      }
	} 	

	function setChecked(strIds)
	{
		clearAll();
		  var ids = strIds.split(","); 
		  for(var i=0;i<ids.length;i++)
		  { 
		      if(ids[i]=="") return ;
			  var obj = document.all("id_"+ ids[i] );
		      obj.checked=true;
	      } 
	} 	

	
	function setUsable(strIds)
	{
	      
	      disableAll(); 
	      	
	      var ids = strIds.split(","); 
		  for(var i=0;i<ids.length;i++)
		  { 
		      if(ids[i]=="") return ;
			  var obj = document.all("id_"+ ids[i] );
		      obj.disabled="";
	      } 
	} 
 