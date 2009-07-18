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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 系统用户
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "users")
@NamedQueries( { 
	@NamedQuery(name = "login", query = "select new com.cd_help.onlineOF.web.vo.UsersVo(u.usersId,u.usersname,u.password) from UsersData u where u.usersname = :usersname"), 
})
public class UsersData {
	
	/**
	 * 用户ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length=32)
	private String usersId;
	/**
	 * 用户名
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "usersname", nullable = true, length = 15)
	private String usersname;
	/**
	 * 密码
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "password", nullable = true, length = 15)
	private String password;
	
	/**
	 * 拥有角色
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "usersId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
	private List<RoleData> roleList = new ArrayList<RoleData>();

	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersname() {
		return usersname;
	}
	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleData> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleData> roleList) {
		this.roleList = roleList;
	}
}
