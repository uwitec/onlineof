/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.dwr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.WebConstants;
import com.cd_help.onlineOF.web.struts.BaseAction;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 根据当前用户加载权限树
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("loadPrivilegeTreeAction")
public class LoadPrivilegeTreeAction extends BaseAction{
	
	 /**
	 * 根据当前用户加载权限树(初始化加载顶级模块)
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> loadPrivilegeTree() throws AppException {
		 log.debug("--->> being loadPrivilegeTree");
		 List<PrivilegeVo> privileges = null;
		 try{
			 // Session session = this.getSession();
			 HttpSession httpSession = WebContextFactory.get().getSession();
			 Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			 System.out.println("用户ID: "+session.getUsersVo().getUsersId());
			 privileges = this.getOnlineOF().getPrivilegeManager().loadTopModelPrivilege(session);
			 for(PrivilegeVo pv : privileges){
				 System.out.print("模块权限: "+pv.getPrivilegeName());
			 }
		 }catch(AppException e){
			 throw new AppException(e.getError_code(),e.getMessage());
		 }
		 return privileges;
	 }
	
	/**
	 * 加载子权限(模块)
	 * @param parentId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> loadChildModelPrivilegeTree(String parentId) throws AppException {
		 List<PrivilegeVo> childPrivileges = null;
		 try{
			 HttpSession httpSession = WebContextFactory.get().getSession();
			 Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			 childPrivileges = this.getOnlineOF().getPrivilegeManager().loadChildModelPrivilegeByParent(session, parentId);
			 for(PrivilegeVo pv : childPrivileges){
				 System.out.print("模块权限: "+pv.getPrivilegeName());
			 }
		 }catch(AppException e){
			 throw new AppException(e.getError_code(),e.getMessage());
		 }
		 return childPrivileges;
	}

}
