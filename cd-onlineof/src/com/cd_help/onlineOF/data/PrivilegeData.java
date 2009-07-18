/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 用户权限
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name="privilege")
@NamedQueries( {
	/*获取用户所有权限*/
	@NamedQuery(name="getPrivilegeByUsersId",query="select new com.cd_help.onlineOF.web.vo.PrivilegeVo(p.privilegeId,p.privilegeName,p.parent.privilegeId,p.parent.privilegeName) from PrivilegeData p join p.roleList r join r.userList u where u.usersId = :usersId"),
})
public class PrivilegeData {
	
	/**
	 * 权限ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	private String privilegeId;
	
	/**
	 * 权限名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "privilegeName", nullable = true, length = 15)
	private String privilegeName;
	
	/**
	 * 父权限
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private PrivilegeData parent;
	
	/**
	 * 子权限
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PrivilegeData> childPrivileges = new ArrayList<PrivilegeData>();
	
	/**
	 * 所属角色
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(mappedBy = "privilegeList")
	private List<RoleData> roleList = new ArrayList<RoleData>();

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public List<RoleData> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleData> roleList) {
		this.roleList = roleList;
	}

	public PrivilegeData getParent() {
		return parent;
	}

	public void setParent(PrivilegeData parent) {
		this.parent = parent;
	}

	public List<PrivilegeData> getChildPrivileges() {
		return childPrivileges;
	}

	public void setChildPrivileges(List<PrivilegeData> childPrivileges) {
		this.childPrivileges = childPrivileges;
	}
}
