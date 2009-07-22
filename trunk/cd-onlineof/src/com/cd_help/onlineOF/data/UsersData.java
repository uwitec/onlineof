/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@SuppressWarnings("serial")
@Entity
@Table(name = "users")
@NamedQueries( { 
	@NamedQuery(name = "login", query = "select new com.cd_help.onlineOF.web.vo.UsersVo(u.usersId,u.usersname,u.password,u.birthday,u.gender) from UsersData u where u.usersname = :usersname"), 
	@NamedQuery(name = "loadAllUsers", query = "select new com.cd_help.onlineOF.web.vo.UsersVo(u.usersId,u.usersname,u.password,u.birthday,u.gender) from UsersData u where u.isSuper=0"),
	@NamedQuery(name = "loadAllByPage", query = "from UsersData u where u.isSuper=0"),
})
public class UsersData implements Serializable{
	
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
     * 出生日期
     * @since cd_help-onlineOF 0.0.0.1
     */
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    /**
     * 性别(1:男 0:女)
     * @since cd_help-onlineOF 0.0.0.1
     */
    @Column(name = "gender", nullable = true, length = 11)
    private Integer gender;
    
    /**
     * 是否是超级用户(1:是 0:否)
     * @since cd_help-onlineOF 0.0.0.1
     */
    @Column(name = "isSuper", nullable = true, length = 11)
    private Integer isSuper = 0;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getIsSuper() {
		return isSuper;
	}
	public void setIsSuper(Integer isSuper) {
		this.isSuper = isSuper;
	}
}
