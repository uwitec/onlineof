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

	public void delete(Session session, String id) throws AppException {
		
	}

	public PrivilegeVo get(Session session, String id) throws AppException {
		return null;
	}


	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadAll(com.cd_help.onlineOF.data.Session)
	 */
	public List<PrivilegeVo> loadAll(Session session) throws AppException {
		List<PrivilegeVo> privilegeVos = null;
		try{
			if(this.checkPrivilege(session)){
		        privilegeVos = privilegeDataDao.loadAll();
		        if(privilegeVos.size() > 0){
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

	public void update(Session session, String id) throws AppException {
		
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

}
