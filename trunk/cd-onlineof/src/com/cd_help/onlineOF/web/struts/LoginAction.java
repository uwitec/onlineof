/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.WebConstants;
import com.cd_help.onlineOF.web.vo.UsersVo;

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
	public String doLogin() {
		log.debug("--->> begin doLogin");
		UsersSession session = null;
		UsersVo usersVo = null;
		try {
			usersVo = this.getOnlineOF().login(usersname, password);
			session = this.getOnlineOF().getSessionManager().createSession(usersVo);
			this.getRequest().getSession().setAttribute(WebConstants.ATTRIBUTE_SESSION,session);
			return SUCCESS;
		} catch (AppException e) {
			log.debug("异常信息: "+e.getError_code()+"----"+e.getMessage());
			this.setErrorMsg(e.getMessage());
			return ERROR;
		}
	}
	
	/**
	 * 注销
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loginOut(){
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
