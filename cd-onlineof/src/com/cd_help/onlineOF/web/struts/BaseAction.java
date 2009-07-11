/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cd_help.onlineOF.api.OnlineOF;
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
	 * 在线订餐系统
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "onlineOF")
	private OnlineOF onlineOF = null;

	public OnlineOF getOnlineOF() {
		return onlineOF;
	}

	public void setOnlineOF(OnlineOF onlineOF) {
		this.onlineOF = onlineOF;
	}
}
