/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.admin.dwr;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.WebConstants;
import com.cd_help.onlineOF.web.admin.struts.BaseAction;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
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
			 throw new AppException("0000000",e.getMessage());
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
	public boolean login(String username, String password) throws AppException{
		try {
			UsersVo usersVo = this.getOnlineOF().getUsersManager().login(username, password);
			if(null != usersVo){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			 log.error(e);
			 throw new AppException("",e.getMessage(),e);
		}
	}
	
	/**
	 * 重置密码
	 * @param usersId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public boolean resetUsersPassword(String usersId,String oldPassword, String newPassword) throws AppException{
	    try{
	    	HttpSession httpSession = WebContextFactory.get().getSession();
			UsersSession userssession = (UsersSession)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
	    	if(this.getOnlineOF().checkPrivilege(userssession, "resetUsersPassword")){
	    	   return this.getOnlineOF().getUsersManager().resetUsersPassword(usersId, oldPassword, newPassword);
	    	}else{
	    		throw new AppException("0000000","对不起,您没有权限!");
	    	}
	    }catch(Exception e){
	    	log.error(e);
			throw new AppException("",e.getMessage(),e);
	    }
	}
}
