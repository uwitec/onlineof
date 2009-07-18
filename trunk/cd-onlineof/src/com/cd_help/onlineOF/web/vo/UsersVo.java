/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 系统用户VO
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class UsersVo {
	
	/**
	 * 用户ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String usersId;
	/**
	 * 用户名
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String usersname;
	/**
	 * 密码
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String password;
	
	/**
	 * Constructs a <code>UsersVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo(){}
	
	/**
	 * Constructs a <code>UsersVo</code>
	 * @param usersId
	 * @param usersname
	 * @param password
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo(String usersId,String usersname,String password){
		this.usersId = usersId;
		this.usersname = usersname;
		this.password = password;
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
