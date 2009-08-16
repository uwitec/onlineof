/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.api.SessionManager;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.RoleData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.web.struts.UsersSession;
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
@Transactional
public class SessionManagerImpl implements SessionManager{
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(SessionManagerImpl.class);
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "usersDataDao")
	private UsersDataDao usersDataDao;
	
	@Autowired
	@Resource(name = "privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;
	
	@Autowired
	@Resource(name = "roleDataDao")
	private RoleDataDao roleDataDao;

	/**
	 * @see com.cd_help.onlineOF.api.SessionManager#createSession(com.cd_help.onlineOF.web.vo.UsersVo)
	 */
	@Transactional
	public UsersSession createSession(UsersVo usersVo) throws AppException {
		@SuppressWarnings("unused")
		UsersVo vo = usersVo;
		UsersSession session = null;
		try{
			List<PrivilegeData> privileges = privilegeDataDao.findByNamedQueryAndNamedParam("getPrivilegeByRoleId", "roleId", usersVo.getRoleId());
			List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
			RoleData roleData = (RoleData)roleDataDao.get(RoleData.class, usersVo.getRoleId());
			RoleVo userRole = new RoleVo();
			BeanUtilsHelp.copyProperties(userRole, roleData);
			for(PrivilegeData p : privileges){
				PrivilegeVo pv = new PrivilegeVo();
				BeanUtilsHelp.copyProperties(pv,p);
				if(p.getParent() != null){
					pv.setParentId(p.getParent().getPrivilegeId());
					pv.setParentName(p.getParent().getPrivilegeName());
				}else{
					pv.setParentId("-1");
				}
				privilegeVos.add(pv);
			}
		    session = new UsersSession(usersVo, privilegeVos, usersVo.getRoleId(), userRole.getPath());
		}catch(Exception e){
			log.error(e);
			throw new AppException("","系统错误!");
		}
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
