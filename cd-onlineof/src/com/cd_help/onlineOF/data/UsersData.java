/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@NamedQuery(name = "getUsersByName", query = "select DISTINCT u from UsersData u where u.usersname = :usersname"), 
	@NamedQuery(name = "loadAllUsers", query = "select DISTINCT u from UsersData u where u.isSuper=0"), 
	@NamedQuery(name = "searchUsersByPage", query = "from UsersData u where u.isSuper=0 and u.usersname like :usersname and u.restaurantId like :restaurantId"),
	@NamedQuery(name = "countByUsersname", query = "select count(*) from UsersData u where u.usersname=:usersname"),
	@NamedQuery(name = "countByUsersnameAndRestaurantId", query = "select count(*) from UsersData u where u.usersname=:usersname and u.restaurantId = :restaurantId"),
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
	@Column(name = "password", nullable = true, length = 32)
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
	 * 所属餐厅ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    @Column(name = "restaurantId", nullable = true, length = 32)
	private String restaurantId;
    
    /**
	 * 所属角色ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    @Column(name = "roleId", nullable = true, length = 32)
	private String roleId;

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
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
