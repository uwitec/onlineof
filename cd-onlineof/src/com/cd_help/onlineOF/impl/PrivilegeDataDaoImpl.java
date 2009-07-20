/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
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
@SuppressWarnings("unchecked")
@Transactional
@Service("privilegeDataDao")
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

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#loadChildModelPrivilegeByParent(java.lang.String, java.lang.String)
	 */
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(String parentId,String usersId) throws AppException {
		String parameNames[] = {"parentId","usersId"};
		String values[] = {parentId,usersId};
		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getChildModelPrivilegeByUsersId", parameNames, values);
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		for(Iterator iterator = privileges.iterator();iterator.hasNext();){
			PrivilegeData p = (PrivilegeData)iterator.next();
			PrivilegeVo pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv,p);
			pv.setParentId(parentId);
			if(null != p.getParent()){
				pv.setParentId(p.getParent().getPrivilegeId());
			}
			privilegeVos.add(pv);
		}
//		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getChildModelPrivilegeByUsersId", parameNames, values);
//		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
//		for(Iterator iterator = privileges.iterator();iterator.hasNext();){
//			PrivilegeData p = (PrivilegeData)iterator.next();
//			PrivilegeVo pv = new PrivilegeVo();
//			BeanUtilsHelp.copyProperties(pv,p);
//			if(null != p.getParent()){
//				pv.setParentId(p.getParent().getPrivilegeId());
//			}
//			privilegeVos.add(pv);
//		}
		//List<PrivilegeVo> privilegeVos = this.findByNamedQueryAndNamedParam("getChildModelPrivilegeByUsersId", parameNames, values);
		return privilegeVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#loadTopModelPrivilege(java.lang.String)
	 */
	public List<PrivilegeVo> loadTopModelPrivilege(String usersId)
			throws AppException {
		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getTopModelPrivilegeByUsersId", "usersId", usersId);
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		for(Iterator iterator = privileges.iterator();iterator.hasNext();){
			PrivilegeData p = (PrivilegeData)iterator.next();
			PrivilegeVo pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv,p);
			privilegeVos.add(pv);
		}
		return privilegeVos;
	}

	public void update(String id) throws AppException {
		
	}

}
