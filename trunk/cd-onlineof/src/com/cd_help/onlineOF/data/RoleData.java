/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 用户角色
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name="role")
@NamedQueries( {
	/*获取所有角色*/
	@NamedQuery(name="loadAllRole",query="select DISTINCT r from RoleData r"),
	/**/
	@NamedQuery(name="searchRolesByPage",query="from RoleData r where r.roleName like :roleName"),
})
public class RoleData implements Serializable{
	/**
	 * 角色ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	private String roleId;
	
	/**
	 * 角色名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "roleName", nullable = true, length = 15)
	private String roleName;
	
	/**
	 * 描述
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "description", nullable = true, length = 20)
	private String description;
	
	/**
	 * 拥有权限
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "privileges_role", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = { @JoinColumn(name = "privilegeId") })
	private List<PrivilegeData> privilegeList = new ArrayList<PrivilegeData>();

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<PrivilegeData> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<PrivilegeData> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}