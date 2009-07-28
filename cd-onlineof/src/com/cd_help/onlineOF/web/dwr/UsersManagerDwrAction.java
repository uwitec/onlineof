/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.dwr;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.struts.BaseAction;
import com.cd_help.onlineOF.web.vo.UsersVo;

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
		} catch (Exception e) {
			log.error(null,e);
			 throw new AppException("",e.getMessage());
		}
	}
	
	/**
	 * 用户登录
	 * @param usersname
	 * @param password
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo login(String params[]) throws AppException{
		log.debug("usersname: "+params[0]+"/password: "+params[1]);
		UsersVo usersVo = null; 
		try {
		    usersVo = this.getOnlineOF().getUsersManager().login(params[0], params[1]);
		} catch (Exception e) {
			log.error(null,e);
			 throw new AppException("",e.getMessage());
		}
		return usersVo;
	}
}
