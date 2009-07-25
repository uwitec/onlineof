/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.dwr;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.struts.BaseAction;

/**
 * <b><code></code></b>
 * <p/>
 * 用户管理相关的DWR处理
 * <p/>
 * <b>Creation Time:</b> Jul 24, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("usersManagerDwrAction")
public class UsersManagerDwrAction extends BaseAction{
	
	/**
	 * 检测用户是否存在
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public boolean checkUsers(String usersname) throws AppException{
		try {
			boolean bool = this.getOnlineOF().getUsersManager().checkUsersByName(usersname);
			return bool;
		} catch (AppException e) {
			throw new AppException(e.getError_code(),e.getMessage());
		}
	}

}
