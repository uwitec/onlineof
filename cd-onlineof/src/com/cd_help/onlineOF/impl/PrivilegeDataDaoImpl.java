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
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
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

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#deletePrivilege(java.lang.String)
	 */
	public void deletePrivilege(String id) throws Exception {
		PrivilegeData privilegeData = (PrivilegeData)this.get(PrivilegeData.class, id);
        this.delete(privilegeData);	
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
	public void updatePrivilege(PrivilegeVo privilegeVo) throws Exception {
		PrivilegeData privilegeData = (PrivilegeData)this.get(PrivilegeData.class, privilegeVo.getPrivilegeId());
		BeanUtilsHelp.copyProperties(privilegeData, privilegeVo);
		this.update(privilegeData);
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

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#searchByPageBean(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean)
	 */
	public PageBean searchByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		
		pageBean = this.searchByPage(hqlName, paramName,
				condition, pageBean);
		
		List<PrivilegeVo> list = new ArrayList<PrivilegeVo>();
		PrivilegeData privilegeData = null;
		PrivilegeVo privilegeVo = null;
		for (Object obj : pageBean.getArray()) {
			privilegeData = (PrivilegeData) obj;
			privilegeVo = new PrivilegeVo();
			BeanUtilsHelp.copyProperties(privilegeVo, privilegeData);
			list.add(privilegeVo);
		}
		pageBean.setArray(list);
		return pageBean;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#getPrivilegeById(java.lang.String)
	 */
	public PrivilegeVo getPrivilegeById(String privilegeId) throws Exception {
		PrivilegeVo privilegeVo = new PrivilegeVo();
		PrivilegeData privilegeData = (PrivilegeData)this.get(PrivilegeData.class, privilegeId);
		BeanUtilsHelp.copyProperties(privilegeVo, privilegeData);
		return privilegeVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeDataDao#addPrivilege(com.cd_help.onlineOF.web.vo.PrivilegeVo)
	 */
	public void addPrivilege(PrivilegeVo privilegeVo) throws Exception {
		PrivilegeData privilegeData = new PrivilegeData();
		BeanUtilsHelp.copyProperties(privilegeData, privilegeVo);
		privilegeData.setPrivilegeId(StringUtil.getUUID());
		this.save(privilegeData); 
	}

}
