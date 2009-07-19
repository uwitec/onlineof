/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("privilegeDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeDataDaoImpl extends BaseDaoSupport implements PrivilegeDataDao{

	public void delete(String id) throws AppException {
	}

	public PrivilegeVo get(String id) throws AppException {
		return null;
	}

	public List<PrivilegeVo> loadAll() throws AppException {
		return null;
	}

	public void update(Session session,String id) throws AppException {
		
	}

	public List<PrivilegeVo> loadChildModelPrivilegeByParent(String parentId,String usersId) throws AppException {
		String parameNames[] = {"parentId","usersId"};
		String values[] = {parentId,usersId};
		return this.findByNamedQueryAndNamedParam("getChildModelPrivilegeByUsersId", parameNames, values);
	}

	public List<PrivilegeVo> loadTopModelPrivilege(String usersId)
			throws AppException {
		return this.findByNamedQueryAndNamedParam("getTopModelPrivilegeByUsersId", "usersId", usersId);
	}

	public void update(String id) throws AppException {
		
	}

}
