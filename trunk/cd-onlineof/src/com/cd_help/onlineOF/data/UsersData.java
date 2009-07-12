/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 订餐用户
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "users")
public class UsersData {
	
	/**
	 * 订餐用户ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length=32)
	private String usersId;
	/**
	 * 订餐用户名
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = false, length = 15)
	private String name;
	/**
	 * 密码
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "password", nullable = false, length = 15)
	private String password;
	
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
