/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.api.SessionManager;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;
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
	
	@Autowired
	@Resource(name = "privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;

	/**
	 * @see com.cd_help.onlineOF.api.SessionManager#createSession(com.cd_help.onlineOF.web.vo.UsersVo)
	 */
	public Session createSession(UsersVo usersVo) throws AppException {
		@SuppressWarnings("unused")
		UsersVo vo = usersVo;
		List<PrivilegeData> privileges = privilegeDataDao.findByNamedQueryAndNamedParam("getPrivilegeByRoleId", "roleId", usersVo.getRoleId());
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		for(PrivilegeData p : privileges){
			PrivilegeVo pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv,p);
			if(null != p.getParent()){
				pv.setParentId(p.getParent().getPrivilegeId());
			}
			privilegeVos.add(pv);
		}
		Session session = new Session(usersVo,privilegeVos);
		return session;
	}

	public void setUsersDataDao(UsersDataDao usersDataDao) {
		this.usersDataDao = usersDataDao;
	}

	public void setPrivilegeDataDao(PrivilegeDataDao privilegeDataDao) {
		this.privilegeDataDao = privilegeDataDao;
	}
    
}
