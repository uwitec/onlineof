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
public class LoadPrivilegeTreeAction extends BaseAction {
	
	/**
	 * 获取所有顶级权限
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> getTopPrivilege() throws AppException{
		log.debug("--->> begin getTopPrivilege");
		List<PrivilegeVo> topPrivileges = null;
		try{
			HttpSession httpSession = WebContextFactory.get().getSession();
			Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			topPrivileges = this.getOnlineOF().getPrivilegeManager().getTopPrivilege(session);
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return topPrivileges;
	}
	
	/**
	 * 获取所有子权限
	 * @param parentId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> getChildPrivilege(String parentId) throws AppException{
		log.debug("--->> begin getChildPrivilege");
		List<PrivilegeVo> childPrivileges = null;
		try{
			HttpSession httpSession = WebContextFactory.get().getSession();
			Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			childPrivileges = this.getOnlineOF().getPrivilegeManager().getChildPrivilege(session,parentId);
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return childPrivileges;
	}
	
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
		 }catch(Exception e){
			 log.error(null,e);
			 throw new AppException("",e.getMessage(),e);
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
		 }catch(Exception e){
			 log.error(e);
			 throw new AppException("",e.getMessage(),e);
		 }
		 return childPrivileges;
	}
	
	/**
	 * 加载所有权限
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> loadAllPrivilege() throws AppException{
		List<PrivilegeVo> privilegeVos = null;
		try{
			 HttpSession httpSession = WebContextFactory.get().getSession();
			 Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			 privilegeVos = this.getOnlineOF().getPrivilegeManager().loadAllPrivilege(session);
		}catch(Exception e){
			 log.error(null,e);
			 throw new AppException("",e.getMessage(),e);
		}
		return privilegeVos;
	}
	
	/**
	 * 获取角色所拥有的权限
	 * @param roleId
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> getPrivilegeByRoleId(String roleId) throws AppException{
		log.debug("--->>> begin getPrivilegeByRoleId -- roleId: "+roleId);
		List<PrivilegeVo> privilegeVos = null;
		try{
			HttpSession httpSession = WebContextFactory.get().getSession();
			Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			privilegeVos = this.getOnlineOF().getPrivilegeManager().getPrivilegeByRoleId(session, roleId);
		}catch(Exception e){
			 log.error(null,e);
			 throw new AppException("",e.getMessage(),e);
		}
		return privilegeVos;
	}
	
	/**
	 * 获取所有模块权限
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> loadAllModelPrivilege() throws AppException {
		try{
			HttpSession httpSession = WebContextFactory.get().getSession();
			Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			return this.getOnlineOF().getPrivilegeManager().loadAllModelPrivilege(session);
		}catch(Exception e){
			throw new AppException("",e.getMessage(),e);
		}
	}

}
