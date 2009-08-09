/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.web.WebConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <b><code></code></b>
 * <p/>
 * Action基类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
    
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(BaseAction.class);
	
	/**
	 * 用户Session
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private UsersSession session;
	
	private String errorMsg;
	
	/**
	 * 在线订餐系统
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "onlineOF")
	private OnlineOF onlineOF = null;

	public OnlineOF getOnlineOF() {
		return onlineOF;
	}
	
	/**
	 * 返回Request
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 返回response
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 返回用户Session
	 */
	public UsersSession getSession(){
		session = (UsersSession)getRequest().getSession().getAttribute(WebConstants.ATTRIBUTE_SESSION);
		return session;
	}
	
	public void setSession(UsersSession session) {
		this.session = session;
	}

	/**
	 * 获得servlet上下文
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
