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

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.api.PrivilegeManager;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 19, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("privilegeManager")
public class PrivilegeManagerImpl implements PrivilegeManager{

	@Autowired
	@Resource(name = "privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;
	
	public void setPrivilegeDataDao(PrivilegeDataDao privilegeDataDao) {
		this.privilegeDataDao = privilegeDataDao;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadAll(com.cd_help.onlineOF.data.Session)
	 */
	public List<PrivilegeVo> loadAllPrivilege(Session session) throws AppException {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
		        privilegeVos = privilegeDataDao.loadAllPrivilege();
		        if(privilegeVos.size() > 0){
		        	for(PrivilegeVo pv : privilegeVos){
		        		System.out.println("权限: "+pv.getPrivilegeName());
		        	}
		        	return privilegeVos;
		        }else{
		        	return null;
		        }
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			throw new AppException("0000015","获取所有权限出错!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadChildModelPrivilegeByParent(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(Session session,
			String parentId) throws AppException {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
				privilegeVos = privilegeDataDao.loadChildModelPrivilegeByParent(parentId,session.getUsersVo().getRoleId());
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			throw new AppException("0000015","获取模块子权限出错!");
		}
		return privilegeVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadTopModelPrivilege(com.cd_help.onlineOF.data.Session)
	 */
	public List<PrivilegeVo> loadTopModelPrivilege(Session session) throws AppException {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
				privilegeVos = privilegeDataDao.loadTopModelPrivilege(session.getUsersVo().getRoleId());
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("0000015","获取顶级模块权限出错!");
		}
		return privilegeVos;
	}

	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(Session session) throws AppException{
		return true;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getPrivilegeByRoleId(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public List<PrivilegeVo> getPrivilegeByRoleId(Session session, String roleId)
			throws AppException {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
				privilegeVos = privilegeDataDao.getPrivilegeByRoleId(roleId);
				if(privilegeVos.size() > 0){
					return privilegeVos;
				}else{
					return null;
				}
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("0000015","获取权限出错!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#searchByPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean, com.cd_help.onlineOF.data.Session)
	 */
	public PageBean searchPrivilegesByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, Session session)
			throws Exception {
		if(this.checkPrivilege(session)){
			PageBean page = null;
			try{
				page = privilegeDataDao.searchByPageBean(hqlName, paramName, condition, pageBean);
			}catch(Exception e){
				throw new AppException("0000014", "加载权限信息出错!");
			}
			return page;
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getPrivilegeById(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public PrivilegeVo getPrivilegeById(Session session, String privilegeId)
			throws Exception {
		PrivilegeVo privilegeVo = null;
		if(this.checkPrivilege(session)){
			try{
				privilegeVo = privilegeDataDao.getPrivilegeById(privilegeId);
			}catch(Exception e){
				throw new AppException("0000014", "系统错误!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
		return privilegeVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#addPrivilege(com.cd_help.onlineOF.data.Session, com.cd_help.onlineOF.web.vo.PrivilegeVo)
	 */
	public PrivilegeVo addPrivilege(Session session, PrivilegeVo privilegeVo)
			throws Exception {
		if(this.checkPrivilege(session)){
			try{
				return privilegeDataDao.addPrivilege(privilegeVo);
			}catch(Exception e){
				throw new AppException("0000014", "新建失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
		
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#deletePrivilege(com.cd_help.onlineOF.data.Session, java.lang.String)
	 */
	public void deletePrivilege(Session session, String id) throws Exception {
		if(this.checkPrivilege(session)){
			try{
				privilegeDataDao.deletePrivilege(id);
			}catch(Exception e){
				throw new AppException("0000014", "删除失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#updatePrivilege(com.cd_help.onlineOF.data.Session, com.cd_help.onlineOF.web.vo.PrivilegeVo)
	 */
	public void updatePrivilege(Session session, PrivilegeVo privilegeVo) throws Exception {
		if(this.checkPrivilege(session)){
			try{
				privilegeDataDao.updatePrivilege(privilegeVo);
			}catch(Exception e){
				throw new AppException("0000014", "修改失败!",e);
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadAllModelPrivilege(com.cd_help.onlineOF.data.Session)
	 */
	public List<PrivilegeVo> loadAllModelPrivilege(Session session) throws Exception {
		if(this.checkPrivilege(session)){
			try{
				return privilegeDataDao.loadAllModelPrivilege();
			}catch(Exception e){
				throw new AppException("0000014", "系统错误!",e);
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getChildPrivilege(java.lang.String)
	 */
	public List<PrivilegeVo> getChildPrivilege(Session session, String parentId)
			throws Exception {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
				privilegeVos = privilegeDataDao.getChildPrivilege(parentId);
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			throw new AppException("0000015","获取模块子权限出错!");
		}
		return privilegeVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getTopPrivilege()
	 */
	public List<PrivilegeVo> getTopPrivilege(Session session) throws Exception {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
				privilegeVos = privilegeDataDao.getTopPrivilege();
			}else{
				throw new AppException("0000000","权限不够!");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("0000015","获取顶级模块权限出错!");
		}
		return privilegeVos;
	}

}
