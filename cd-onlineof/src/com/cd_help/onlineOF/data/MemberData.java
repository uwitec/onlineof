/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 会员
 * <p/>
 * <b>Creation Time:</b> Jul 27, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "member")
public class MemberData implements Serializable{
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=32)
	private String memberId;
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "gender", nullable = true, length = 11)
	private Integer gender;
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "loginname", nullable = true, length = 15)
	private String loginname;
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "password", nullable = true, length = 32)
	private String password;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}