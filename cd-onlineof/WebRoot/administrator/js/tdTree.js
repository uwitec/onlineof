    /**
     * <p/>
     *   Common tree contorl
     * <p/>
     * <b>Creation Time:</b> Jun 25, 2009
     * @author TanDong
     * @param {} Config
     * @version 0.0.0.1
     * @since cd_help-onlineOF 0.0.0.1
     */
    function Tree(Config)
	{
		var ElementChild = document.getElementById(Config.Render);
		ElementChild.style.cursor = "default";
		var ShowRoot = true;
		var Nodes = this.AllNodes = [];
		var NodesDelay = this.NodesDelay = [];
		
		this.Icons = Config.Icons;
		this.DefaultIcon = Config.DefaultIcon;
		this.DefaultOpenIcon = Config.DefaultOpenIcon;
		this.SplitIconPath = Config.SplitIconPath;
		
		this.SelectedNode;
		
		this.OnNodeClick;
		this.OnNodeSelect;
		this.OnNodeDblClick;
		this.OnNodeExpand;
		this.OnNodeCollapse;
		
		this.Root = new TreeNode();
		this.Root.Id = -1;
		this.Root.Text = "Root";
		this.Root.Tree = this;
		
		if (Config.Root)
		{
			if (Config.Root.Text) this.Root.Text = Config.Root.Text;
			if (Config.Root.Id) this.Root.Id = Config.Root.Id;
		}
		Nodes[this.Root.Id] = this.Root;
		if (Config.ShowRoot == false) ShowRoot = false;

		this.Clear = function()
		{
			while(this.Root.Nodes.Count > 0)
			{
				this.RemoveNode(this.Root.Nodes.Items(0));
			}
			this.SelectedNode = null;
		}

		this.RenderNode = function(Node)
		{
			if (!Node) return;
			if (Node.Rendered == false)
			{
				var ParentElement;
				if (Node.ParentNode)
				{
					if (Node.ParentNode.Rendered == false) return;
					if (!Node.ParentNode.ElementChild)
					{
						Node.ParentNode.ElementChild = document.createElement("DIV");
						Node.ParentNode.ElementChild.style.display = "";
						Node.ParentNode.ElementChild.style.width = "1px";
						if (Node.ParentNode != this.Root || ShowRoot == true)
						{
							Node.ParentNode.ElementChild.style.paddingLeft = "16px";
						}
						Node.ParentNode.ElementChild.style.backgroundRepeat = "repeat-y";
						if (Node.ParentNode.IsChildLineOld == true) Node.ParentNode.ElementChild.style.backgroundImage = "url('" + this.SplitIconPath + "/0.gif')";
						if (Node.ParentNode.ElementLabel.nextSibling)
						{
							if (Node.ParentNode.ParentNode)
								Node.ParentNode.ParentNode.ElementChild.insertBefore(Node.ParentNode.ElementChild, Node.ParentNode.ElementLabel.nextSibling);
							else
								ElementChild.appendChild(Node.ParentNode.ElementChild);
						}
						else
						{
							if (Node.ParentNode.ParentNode)
								Node.ParentNode.ParentNode.ElementChild.appendChild(Node.ParentNode.ElementChild);
							else
								ElementChild.appendChild(Node.ParentNode.ElementChild);
						}
					}
					ParentElement = Node.ParentNode.ElementChild;
				}
				else
				{
					ParentElement = ElementChild;
				}
				var Result = this.CheckNodeStatus(Node); 
				
				Node.ElementLabel = document.createElement("NOBR");
				if (Node == this.Root && ShowRoot == false)
				{
					Node.ElementLabel.style.display = "none";
				}
				else
				{
					Node.ElementLabel.style.display = "block";
				}
				Node.ElementLabel.style.cursor = "hand";
			
				Node.ElementSplit = document.createElement("IMG");
				Node.ElementSplit.Node = Node;
				Node.ElementSplit.IconNumber = Node.SplitNumberOld = Result.SplitNumber;
				Node.ElementSplit.src = this.SplitIconPath + "/" + Result.SplitNumber + ".gif";
				Node.ElementSplit.width = 19;
				Node.ElementSplit.height = 20;
				Node.ElementSplit.style.verticalAlign = "middle";
				
				Node.ElementIcon = document.createElement("IMG");
				Node.ElementIcon.Node = Node;
				if (Node.Icon)
					Node.ElementIcon.src = this.Icons[Node.Icon];
				else
					Node.ElementIcon.src = this.Icons[this.DefaultIcon];
				Node.ElementIcon.style.verticalAlign = "middle";
				Node.ElementIcon.width = 16;
				Node.ElementIcon.height = 16;
				
				Node.ElementText = document.createElement("SPAN");
				Node.ElementText.Node = Node;
				Node.ElementText.style.height = 17;
				
				Node.ElementText.style.padding= "2px 2px 0px 1px";
				Node.ElementText.innerHTML = Node.Text;
		
				Node.IsChildLineOld = Result.IsChildLine;
				
				Node.ElementSplit.onclick = new Function("this.Node.Tree.onnodesplit(this.Node);");
				Node.ElementIcon.onmouseup = Node.ElementText.onmouseup = new Function("this.Node.Tree.onnodeclick(this.Node);");
				Node.ElementIcon.ondblclick = Node.ElementText.ondblclick = new Function("this.Node.Tree.onnodedblclick(this.Node);this.Node.Tree.onnodesplit(this.Node);");
				
				Node.ElementLabel.appendChild(Node.ElementSplit);
				Node.ElementLabel.appendChild(Node.ElementIcon);
				Node.ElementLabel.appendChild(Node.ElementText);
				ParentElement.appendChild(Node.ElementLabel);
				
				Node.Rendered = true;
			}
			else
			{
				var Result = this.CheckNodeStatus(Node);
				if (Result.SplitNumber != Node.SplitNumberOld)
				{
					Node.ElementSplit.src = this.SplitIconPath + "/" + Result.SplitNumber + ".gif";
					Node.SplitNumberOld = Result.SplitNumber;
				}
				if (Result.IsChildLine != Node.IsChildLineOld && Node.ElementChild)
				{
					if (Result.IsChildLine == true)
					{
						Node.ElementChild.style.backgroundImage = "url('" + this.SplitIconPath + "/0.gif')";
					}
					else
					{
						Node.ElementChild.style.backgroundImage = "";
					}
					Node.IsChildLineOld = Result.IsChildLine;
				}
			}
		}
	
		this.CheckNodeStatus = function(Node)
		{
			var Result = {};
			var IsLast = false;
			if (Node.ParentNode)
			{
				if (Node.ParentNode.Nodes.Count == 1)
				{
					Result.IsChildLine = false;
					IsLast = true;
				}
				else
				{
					if (Node.ParentNode.Nodes.Items(Node.ParentNode.Nodes.Count - 1) == Node)
					{
						IsLast = true;
						Result.IsChildLine = false;
					}
					else
					{
						if (Node.Nodes.Count > 0)
							Result.IsChildLine = true;
						else
							Result.IsChildLine = false;
					}
				}
			}
			else
			{
				IsLast = true;
				Result.IsChildLine = false;
			}
			if (Node.Nodes.Count > 0  || Node.Asyn == true)
			{
				//有子节点
				if (Node.Expanded == true)
				{
					if (IsLast == true)
						Result.SplitNumber = 3;
					else
						Result.SplitNumber = 4;
				}
				else
				{
					if (IsLast == true)
						Result.SplitNumber = 1;
					else
						Result.SplitNumber = 2;
				}
			}
			else
			{
				//无子节点
				if (IsLast == true)
					Result.SplitNumber = 5;
				else
					Result.SplitNumber = 6;
			}
			return Result;
		}
		
		this.onnodesplit = function(Node)
		{
			if (Node.Nodes.Count == 0 && Node.Asyn == false) return;
			if (Node.Expanded == true){
				this.CollapseNode(Node, true);
			}else{
				this.ExpandNode(Node, true);
			}
		}
		
		this.onnodedblclick = function(Node)
		{
			if (this.OnNodeDblClick) this.OnNodeDblClick(Node);
		}
		/**
		 * on click
		 * @param {} Node
		 */
		this.onnodeclick = function(Node)
		{
			Node.SetSelect(true);
			if (Node.OnClick) Node.OnClick(Node);
			if (this.OnNodeClick) this.OnNodeClick(Node);
		}
		/**
		 * Expand node
		 * @param {} Node
		 * @param {} IsUserClick
		 */
		this.ExpandNode = function(Node, IsUserClick)
		{
			if (Node.Expanded == true) return;
			if (Node.ParentNode)
			{
				if (Node.ParentNode.Expanded == false) {
					this.ExpandNode(Node.ParentNode);
				}
			}
			if (Node.Rendered == false) {
				this.RenderNode(Node);
			}
			
			Node.Expanded = true;
			for (var i=0;i<Node.Nodes.Count;i++){
				if (Node.Nodes.Items(i).Rendered == false) {
					this.RenderNode(Node.Nodes.Items(i));
				}
			}
			if (Node.ElementChild) {
			    Node.ElementChild.style.display = "";
			}
			this.RenderNode(Node);
			if (!IsUserClick) IsUserClick = false;
			if (Node.OnExpand) {
				Node.OnExpand(Node, IsUserClick);
			}
			if (this.OnNodeExpand) {
			    this.OnNodeExpand(Node, IsUserClick);
			}
		}
		/**
		 * Collapse node
		 * @param {} Node
		 * @param {} IsUserClick
		 */
		this.CollapseNode = function(Node, IsUserClick)
		{
			if (Node.Expanded == false) return;
			if (Node == this.Root && ShowRoot == false) return;
				if (Node.ElementChild) Node.ElementChild.style.display = "none";
			Node.Expanded = false;
			this.RenderNode(Node);
			if (!IsUserClick) IsUserClick = false;
			if (this.OnNodeCollapse) this.OnNodeCollapse(Node, IsUserClick);
		}
		/**
		 * Add Node 
		 * @param {} Config
		 */
		this.AddNode = function(Config)
		{
			if (!Config.Id) return;
			if (Nodes[Config.Id]) return;
			
			var Node = new TreeNode();
			Node.Text = Config.Text;
			Node.Id = Config.Id;
			Node.ParentNode = Nodes[Config.ParentId];
			Node.ParentId = Config.ParentId;
			Node.Tree = this;
			Node.Icon = Config.Icon;
			Node.IconOpen = Config.IconOpen;
			Node.OnClick = Config.Click;
			Node.OnExpand = Config.Expand;
			Node.ExpandBefor = Config.ExpandBefor;
			Node.Item = Config.Item;
			Node.Statu = Config.Statu;

			if (Config.Asyn) {
				Node.Asyn = Config.Asyn;
			}
			
			this.RenderNode(Node);
			if (Node.ParentNode)
			{   
				/****** Change the icon after add *******/
                Node.ParentNode.SetIcon("0");
	            Node.ParentNode.SetIconOpen("1");
				/**************************************/
				Node.ParentNode.Nodes.Add(Node);
				Nodes[Node.Id] = Node;
				// CheckNodeStatus(Node.ParentNode);
				if (Node.ParentNode.Rendered == true && Node.ParentNode.Nodes.Count == 1)
				{

					this.RenderNode(Node.ParentNode);
				}
				if (Node.ParentNode.Rendered == true && ( Node.ParentNode.Expanded == true || ( Node.ParentNode.Nodes.Count > 0 && Node.ParentNode.Nodes.Items(0).Rendered == true ) ) )
				{
					if (Node.ParentNode.Rendered == true && Node.ParentNode.Nodes.Count > 1)
					{
						this.RenderNode(Node.ParentNode.Nodes.Items(Node.ParentNode.Nodes.Count-2),true);
					}					
					this.RenderNode(Node);
				}
				// this.RenderNode(Node);
				if (NodesDelay[Node.Id])
				{
					var Childrens = NodesDelay[Node.Id];
					for (var Child in Childrens)
					{
						this.AddNode({
							Text : Childrens[Child].Text,
							Id : Childrens[Child].Id,
							ParentId : Childrens[Child].ParentId,
							Icon : Childrens[Child].Icon,
							IconOpen : Childrens[Child].IconOpen,
							Click : Childrens[Child].OnClick,
							Expand : Childrens[Child].OnExpand,
							Item : Childrens[Child].Item,
							Asyn : Childrens[Child].Asyn,
                            Statu : Childrens[Child].Statu,
                            ExpandBefor : Childres[Child].ExpandBefor  
						});
					}
					delete NodesDelay[Node.Id];
				}
			}
			else
			{
				if (!NodesDelay[Config.ParentId]) NodesDelay[Config.ParentId] = [];
				NodesDelay[Config.ParentId].push(Node);
			}
			return Node;
		}
		/**
		 * Switch node
		 * @param {} Id1
		 * @param {} Id2
		 */
		this.SwitchNode = function(Id1,Id2)
		{
			var Node1 = this.FindNode(Id1);
			var Node2 = this.FindNode(Id2);
			if (Node1 && Node2 && (Node1 != Node2) && (Node1.ParentNode == Node2.ParentNode))
			{
				Node1.ParentNode.Nodes.Switch(Node1, Node2);
				if (Node1.Rendered == true && Node2.Rendered == true)
				{
					var ElementNext1 = (Node1.ElementChild) ? Node1.ElementChild.nextSibling : Node1.ElementLabel.nextSibling;
					var ElementNext2 = (Node2.ElementChild) ? Node2.ElementChild.nextSibling : Node2.ElementLabel.nextSibling;
					
					if (ElementNext1 == Node2.ElementLabel)
					{
						Node1.ParentNode.ElementChild.insertBefore(Node2.ElementLabel, Node1.ElementLabel);
						if (Node2.ElementChild) Node1.ParentNode.ElementChild.insertBefore(Node2.ElementChild, Node1.ElementLabel);
					}
					else
					{
						if (ElementNext2 == Node1.ElementLabel)
						{
							Node1.ParentNode.ElementChild.insertBefore(Node1.ElementLabel, Node2.ElementLabel);
							if (Node1.ElementChild) Node1.ParentNode.ElementChild.insertBefore(Node1.ElementChild, Node2.ElementLabel);
						}
						else
						{
							if (ElementNext1)
							{
								Node1.ParentNode.ElementChild.insertBefore(Node2.ElementLabel, ElementNext1);
								if (Node2.ElementChild) Node1.ParentNode.ElementChild.insertBefore(Node2.ElementChild, ElementNext1);
							}
							else
							{
								Node1.ParentNode.ElementChild.appendChild(Node2.ElementLabel);
								if (Node2.ElementChild) Node1.ParentNode.ElementChild.appendChild(Node2.ElementChild);
							}
							if (ElementNext2)
							{
								Node1.ParentNode.ElementChild.insertBefore(Node1.ElementLabel, ElementNext2);
								if (Node1.ElementChild) Node1.ParentNode.ElementChild.insertBefore(Node1.ElementChild, ElementNext2);
							}
							else
							{
								Node1.ParentNode.ElementChild.appendChild(Node1.ElementLabel);
								if (Node1.ElementChild) Node1.ParentNode.ElementChild.appendChild(Node1.ElementChild);
							}
						}
					}
					this.RenderNode(Node1);
					this.RenderNode(Node2);
				}
			}
		}
		/**
		 * FindNode by id
		 * @param {} Id
		 * @return {}
		 */
		this.FindNode = function(Id)
		{
			return Nodes[Id];
		}
		/**
		 * Remove node
		 * @param {} Node
		 * @param {} IsLoop
		 */
		this.RemoveNode = function (Node, IsLoop)
		{
			var NodeDeleteIds = [];
			if (!Nodes[Node.Id]) return;
			if (Node == this.Root) return false;
			for (var i=Node.Nodes.Count-1;i>=0;i--)
				NodeDeleteIds = NodeDeleteIds.concat(this.RemoveNode(Node.Nodes.Items(i), true))
			var NodeIndex;
			if (!IsLoop) NodeIndex = Node.ParentNode.Nodes.IndexOf(Node);
			Node.ParentNode.Nodes.Remove(Node);
			delete Nodes[Node.Id];
			if (!IsLoop)
			{
				if (Node.Rendered == true)
				{
					Node.ParentNode.ElementChild.removeChild(Node.ElementLabel);
					Node.ElementLabel = null;
					if (Node.ElementChild)
					{
						Node.ParentNode.ElementChild.removeChild(Node.ElementChild);
						Node.ElementChild = null;
					}
					if (NodeIndex > 0 && Node.ParentNode.Nodes.Count >= 1 && Node.ParentNode.Nodes.Items(NodeIndex-1).Rendered == true) this.RenderNode(Node.ParentNode.Nodes.Items(NodeIndex-1));
				}
				if (Node.ParentNode.Rendered && Node.ParentNode.Nodes.Count == 0)
				{
					/*Change the icon wehen the node has not childNode*/ 
					Node.ParentNode.SetIcon("2");
					Node.ParentNode.SetIconOpen("2");
					Node.ParentNode.SetAsyn(false);
					/**************************************/
					if (Node.ParentNode == this.Root)
					{
						ElementChild.removeChild(Node.ParentNode.ElementChild);
						Node.ParentNode.ElementChild = null;
					}
					else
					{
						if (Node.ParentNode.ElementChild) Node.ParentNode.ParentNode.ElementChild.removeChild(Node.ParentNode.ElementChild);
						Node.ParentNode.ElementChild = null;
					}
					this.RenderNode(Node.ParentNode);
				}
			}
			if (Node.Selected == true) Node.SetSelect(false);
			NodeDeleteIds.push(Node.Id);
			delete Node;
			return NodeDeleteIds;
		}
		
		function TreeNode()
		{
			this.Text;
			this.Id;
			this.ParentNode;
			this.ParentId;
			this.Tree;
			this.Nodes = new NodeList();
			this.Statu;
			
			this.Expanded = false;
			this.Asyn = false;
			this.Selected = false;
			this.OnClick;
			this.OnExpand;
			this.ExpandBefor;
			
			this.Rendered = false;
			this.ElementLabel;
			this.ElementSplit;
			this.ElementIcon;
			this.ElementText
			this.ElementChild;

			this.SplitNumberOld;
			this.IsChildLineOld = false;
			
			this.Icon;
			this.IconOpen;
			
			this.Item;

			this.SetText = function(Text)
			{
				this.Text = Text;
				if (this.ElementText)
				{
					this.ElementText.innerHTML = Text;
				}
			}
			this.SetStatu = function(Statu){
			    this.Statu = Statu;
			}
			this.GetStatu = function(){
			     return this.Statu;
			}
			this.SetIcon = function(Icon)
			{
				this.Icon = Icon;
				if (this.ElementIcon && !this.Selected) this.ElementIcon.src = this.Tree.Icons[Icon];
			}
			this.SetIconOpen = function(IconOpen)
			{
				this.IconOpen = IconOpen;
				if (this.ElementIcon && this.Selected) this.ElementIcon.src = this.Tree.Icons[IconOpen];
			}
			this.SetSelect = function(Selected)
			{
				if (Selected == true)
				{
					//设置选择
					if (this.Selected == false)
					{
						if (this.Tree.SelectedNode) this.Tree.SelectedNode.SetSelect(false);
						this.ElementText.style.backgroundColor = "#316AC5";
						this.ElementText.style.color = "#FFFFFF";
						for (var x in this.ElementText.all)
							if (this.ElementText.all[x].style) this.ElementText.all[x].style.color = "#FFFFFF";
						this.ElementText.style.border = "1px solid #666666";
						this.ElementText.style.padding = "1px 2px 0px 1px";
						if (this.IconOpen){
							this.ElementIcon.src = this.Tree.Icons[this.IconOpen];
						}else{
							this.ElementIcon.src = this.Tree.Icons[this.Tree.DefaultOpenIcon];
						}
						this.Tree.SelectedNode = this;
						this.Selected = true;
						if (this.Tree.OnNodeSelect) this.Tree.OnNodeSelect(this, true);
					}
				}
				else
				{
					//取消选择
					if (this.Selected == true)
					{
						this.ElementText.style.backgroundColor = "";
						this.ElementText.style.color = "";
						for (var x in this.ElementText.all)
							if (this.ElementText.all[x].style) this.ElementText.all[x].style.color = "";
						this.ElementText.style.border = "";
						this.ElementText.style.padding = "2px 2px 0px 1px";
						if (this.Icon)
							this.ElementIcon.src = this.Tree.Icons[this.Icon];
						else
							this.ElementIcon.src = this.Tree.Icons[this.Tree.DefaultIcon];
						this.Tree.SelectedNode = null;
						this.Selected =false;
						if (this.Tree.OnNodeSelect) this.Tree.OnNodeSelect(this, false);
					}
				}
			}
			this.AsynEnd = function()
			{
				this.Asyn = false;
				this.Tree.RenderNode(this);
			}
			this.SetAsyn = function(Asyn){
			    this.Asyn = Asyn;
			}
			this.GetAsyn = function(){
			    return this.Asyn;
			}
			this.GetFullPath = function(SplitChar)
			{
				var FullPath = "";
				var Node = this;
				while (Node.ParentNode != ((this.Tree.ShowRoot) ? this.Tree.Root : null ) )
				{
					if (FullPath != "") FullPath = SplitChar + FullPath;
					FullPath = Node.Text + FullPath;
					Node = Node.ParentNode;
				}
				return FullPath;
			}
		}

		function NodeList()
		{
			this.Count = 0;
			var List = [];
			this.Add = function (Node)
			{
				List.push(Node);
				this.Count ++;
			}
			this.Remove = function(Node)
			{
				for (var i=0;i<List.length;i++)
				{
					if (List[i].Id== Node.Id)
					{
						List.splice(i,1);
						this.Count --;
						break;
					}
				}
			}
			this.IndexOf = function(Node)
			{
				for (var i=0;i<List.length;i++)
					if (List[i] == Node) return i;
				return -1;
			}
			this.Switch = function(Node1,Node2)
			{
				var Index1 = -1,Index2 = -1;
				for (var i=0;i<List.length;i++)
				{
					if (List[i].Id== Node1.Id) Index1 = i;
					if (List[i].Id== Node2.Id) Index2 = i;
					if (Index1 != -1 && Index2 != -1)
					{
						List[Index1] = Node2;
						List[Index2] = Node1;
						break;
					}
				}
			}
			this.Items = function (Index)
			{
				return List[Index];
			}
		}
		if (ShowRoot == true)
			this.RenderNode(this.Root);
		else
			this.ExpandNode(this.Root);

	}