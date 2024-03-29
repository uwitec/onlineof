/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.io.Serializable;
import java.util.Date;

import com.cd_help.onlineOF.utils.StringUtil;

/**
 * <b><code></code></b>
 * <p/>
 * 系统用户VO
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class UsersVo implements Serializable{

	/**
	 * 用户ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String usersId;
	/**
	 * 用户名
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String usersname;
	/**
	 * 密码
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String password;

	/**
	 * 出生日期
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String birthdayStr;

	private Date birthday;

	/**
	 * 性别(1:男 0:女)
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer gender;

	/**
	 * 所属餐厅ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;

	/**
	 * 所属餐厅名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantName;

	/**
	 * 是否是超级用户
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer isSuper = 0;

	/**
	 * 所属角色ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String roleId;

	/**
	 * 所属角色名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String roleName;
	
	/**
	 * QQ
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    private String QQ;
    
    /**
	 * 电子邮箱
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    private String email;
    
    /**
	 * 电话
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    private String phone;
    
    /**
	 * 手机
	 * @since cd_help-onlineOF 0.0.0.1
	 */
    private String movebile;

	/**
	 * Constructs a <code>UsersVo</code>
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo() {
	}

	/**
	 * Constructs a <code>UsersVo</code>
	 * 
	 * @param usersId
	 * @param usersname
	 * @param password
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo(String usersId, String usersname, String password,
			Date birthday, Integer gender, String restaurantId,
			String restaurantName, Integer isSuper, String roleId,
			String roleName,String QQ, String email, String phone, String movebile) {
		this.usersId = usersId;
		this.usersname = usersname;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.gender = gender;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.isSuper = isSuper;
		this.roleId = roleId;
		this.roleName = roleName;
		this.QQ = QQ;
		this.email = email;
		this.phone = phone;
		this.movebile = movebile;
	}

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
		return StringUtil.encodePassword(password, "MD5");
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
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

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Integer isSuper) {
		this.isSuper = isSuper;
	}

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

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qq) {
		QQ = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMovebile() {
		return movebile;
	}

	public void setMovebile(String movebile) {
		this.movebile = movebile;
	}
}
