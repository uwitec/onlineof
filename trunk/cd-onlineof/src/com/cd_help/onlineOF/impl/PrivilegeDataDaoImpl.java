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

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#loadAll()
	 */
	public List<PrivilegeVo> loadAll() throws Exception {
		List<PrivilegeData> privileges = this.findByNamedQuery("loadAllPrivilege");
		List<PrivilegeVo> privilegeVos = null;
		if(privileges.size() > 0){
		    privilegeVos = new ArrayList<PrivilegeVo>();
	    	for(Iterator iterator = privileges.iterator();iterator.hasNext();){
	    		PrivilegeData p = (PrivilegeData)iterator.next();
				PrivilegeVo pv = new PrivilegeVo();
				BeanUtilsHelp.copyProperties(pv,p);
				if(null != p.getParent()){
					pv.setParentId(p.getParent().getPrivilegeId());
				}else{
					pv.setParentId("-1");
				}
				privilegeVos.add(pv);
			}
		}
		return privilegeVos;
	}

	public void update(Session session,String id) throws AppException {
		
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#loadChildModelPrivilegeByParent(java.lang.String, java.lang.String)
	 */
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(String parentId,String roleId) throws Exception {
		String parameNames[] = {"parentId","roleId"};
		String values[] = {parentId,roleId};
		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getChildModelPrivilegeByRoleId", parameNames, values);
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		try{
		for(Iterator iterator = privileges.iterator();iterator.hasNext();){
			PrivilegeData p = (PrivilegeData)iterator.next();
			PrivilegeVo pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv,p);
			pv.setParentId(parentId);
			privilegeVos.add(pv);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return privilegeVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#loadTopModelPrivilege(java.lang.String)
	 */
	public List<PrivilegeVo> loadTopModelPrivilege(String roleId)
			throws Exception {
		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getTopModelPrivilegeByRoleId", "roleId", roleId);
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		for(Iterator iterator = privileges.iterator();iterator.hasNext();){
			PrivilegeData p = (PrivilegeData)iterator.next();
			PrivilegeVo pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv,p);
			privilegeVos.add(pv);
		}
		return privilegeVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#update(java.lang.String)
	 */
	public void update(String id) throws Exception {
		
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#getPrivilegeByRoleId(java.lang.String)
	 */
	public List<PrivilegeVo> getPrivilegeByRoleId(String roleId)
			throws Exception {
		List<PrivilegeData> privileges = this.findByNamedQueryAndNamedParam("getPrivilegeByRoleId", "roleId", roleId);
		List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
		PrivilegeVo pv = null;
		for(PrivilegeData pd : privileges){
			pv = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(pv, pd);
			privilegeVos.add(pv);
		}
		return privilegeVos;
	}

}
