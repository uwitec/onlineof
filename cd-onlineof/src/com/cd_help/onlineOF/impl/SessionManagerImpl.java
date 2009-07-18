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
import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.api.SessionManager;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;
import com.cd_help.onlineOF.web.vo.RoleVo;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * Comment here
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unchecked")
@Service("sessionManager")
public class SessionManagerImpl implements SessionManager{
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "usersDataDao")
	private UsersDataDao usersDataDao;
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "roleDataDao")
	private RoleDataDao roleDataDao;
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;

	/**
	 * @see com.cd_help.onlineOF.api.SessionManager#createSession(com.cd_help.onlineOF.web.vo.UsersVo)
	 */
	public Session createSession(UsersVo usersVo) throws AppException {
		List<RoleVo> roles = roleDataDao.findByNamedQueryAndNamedParam("getRoleByUsersId", "usersId", usersVo.getUsersId());
		List<PrivilegeVo> privileges = privilegeDataDao.findByNamedQueryAndNamedParam("getPrivilegeByUsersId", "usersId", usersVo.getUsersId());
		Session session = new Session(usersVo,roles,privileges);
		return session;
	}

	public void setUsersDataDao(UsersDataDao usersDataDao) {
		this.usersDataDao = usersDataDao;
	}

	public void setRoleDataDao(RoleDataDao roleDataDao) {
		this.roleDataDao = roleDataDao;
	}

	public void setPrivilegeDataDao(PrivilegeDataDao privilegeDataDao) {
		this.privilegeDataDao = privilegeDataDao;
	}
    
}
