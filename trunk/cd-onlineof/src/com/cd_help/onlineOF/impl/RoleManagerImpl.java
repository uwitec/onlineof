/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.api.RoleManager;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 26, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("roleManager")
public class RoleManagerImpl implements RoleManager{

	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "roleDataDao")
	private RoleDataDao roleDataDao;
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#loadAll(com.cd_help.onlineOF.data.Session)
	 */
	public List<RoleVo> loadAllRole(Session session) throws AppException {
		List<RoleVo> roleVos = null;
		if(this.checkPrivilege(session)){
			try{
				roleVos = roleDataDao.loadAllRole();
			}catch(Exception e){
				throw new AppException("000000","系统出错!请联系系统管理员.");
			}
			return roleVos;
		}else{
			throw new AppException("000000","没有权限!");
		}
	}
	
	/**
	 * 检查权限
	 * 
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(Session session) throws AppException {
		return true;
	}

	public void setRoleDataDao(RoleDataDao roleDataDao) {
		this.roleDataDao = roleDataDao;
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#searchByPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean, com.cd_help.onlineOF.data.Session)
	 */
	public PageBean searchRolesByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, Session session)
			throws AppException {
		if(this.checkPrivilege(session)){
			PageBean page = null;
			try{
				page = roleDataDao.searchRolesByPageBean(hqlName, paramName, condition, pageBean);
			}catch(Exception e){
				throw new AppException("0000014", "加载角色信息出错!");
			}
			return page;
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#delete(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public void deleteRole(Session session, String id) throws AppException {
		if(this.checkPrivilege(session)){
			try{
				roleDataDao.deleteRole(id);
			}catch(Exception e){
				e.printStackTrace();
				throw new AppException("0000014", "删除失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#addRole(com.cd_help.onlineOF.data.Session, com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void addRole(Session session, RoleVo roleVo) throws AppException{
		if(this.checkPrivilege(session)){
			try{
				roleDataDao.addRole(roleVo);
			}catch(Exception e){
				throw new AppException("0000014", "新建失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#getRoleById(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public RoleVo getRoleById(Session session, String roleId)
			throws AppException {
		RoleVo roleVo = null;
		if(this.checkPrivilege(session)){
			try{
				roleVo = roleDataDao.getRoleById(roleId);
			}catch(Exception e){
				throw new AppException("0000014", "系统错误!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
		return roleVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#updateRole(com.cd_help.onlineOF.data.Session, com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void updateRole(Session session, RoleVo roleVo) throws AppException {
		if(this.checkPrivilege(session)){
			try{
				roleDataDao.updateRole(roleVo);
			}catch(Exception e){
				throw new AppException("0000014", "修改失败!",e);
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#saveRolePrivileges(com.cd_help.onlineOF.data.Session, java.lang.String, java.lang.String)
	 */
	public void saveRolePrivileges(Session session, String[] privileges,
			String roleId) throws Exception {
		try{
			if(this.checkPrivilege(session)){
			    roleDataDao.saveRolePrivileges(privileges, roleId);
			}else{
				throw new AppException("0000000", "权限不够!");
			}
		}catch(Exception e){
			throw new AppException("","",e);
		}
	}
}
