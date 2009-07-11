/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import org.springframework.stereotype.Service;

/**
 * <b><code></code></b>
 * <p/>
 * 处理用户登录 Action
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("loginAction")
public class LoginAction extends BaseAction{
	
	/**
	 * 登陆名
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String loginName;
	/**
	 * 密码
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String password;
	
	/**
	 * 用户登录
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String doLogin(){
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
