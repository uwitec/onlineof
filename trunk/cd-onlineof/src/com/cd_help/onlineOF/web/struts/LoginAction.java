/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.WebConstants;

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
	private String usersname;
	/**
	 * 密码
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String password;
	
	/**
	 * 用户登录
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String doLogin() throws AppException{
		log.debug("--->> begin doLogin");
		Session session = null;
		try {
			session = this.getOnlineOF().login(usersname, password);
			System.out.println("用户名： "+usersname + "密码: "+password);
			this.getRequest().getSession().setAttribute(WebConstants.ATTRIBUTE_SESSION,session);
		} catch (Exception e) {
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
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
