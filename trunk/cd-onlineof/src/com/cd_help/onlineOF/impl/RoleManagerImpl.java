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
import com.cd_help.onlineOF.web.vo.RoleVo;

@Service("roleManager")
public class RoleManagerImpl implements RoleManager{

	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "roleDataDao")
	private RoleDataDao roleDataDao;
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#loadAll(com.cd_help.onlineOF.data.Session)
	 */
	public List<RoleVo> loadAll(Session session) throws AppException {
		List<RoleVo> roleVos = null;
		if(this.checkPrivilege(session)){
			roleVos = roleDataDao.loadAll();
			if(null != roleVos && roleVos.size() > 0 ){
				return roleVos;
			}else{
				throw new AppException("000000","没有角色数据!");
			}
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
}
