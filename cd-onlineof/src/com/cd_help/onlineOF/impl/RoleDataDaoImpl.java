/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.RoleData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("roleDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class RoleDataDaoImpl extends BaseDaoSupport implements RoleDataDao{
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#loadAll()
	 */
	public List<RoleVo> loadAllRole() throws Exception{
		List<RoleVo> roleVos =  this.findByNamedQuery("loadAllRole");
		return roleVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#searchByPageBean(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean)
	 */
	public PageBean searchRolesByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		pageBean = this.searchByPage(hqlName, paramName,
				condition, pageBean);
		
		List<RoleVo> list = new ArrayList<RoleVo>();
		RoleData roledata = null;
		RoleVo roleVo = null;
		for (Object obj : pageBean.getArray()) {
			roledata = (RoleData) obj;
			roleVo = new RoleVo();
			BeanUtilsHelp.copyProperties(roleVo, roledata);
			list.add(roleVo);
		}
		pageBean.setArray(list);
		return pageBean;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#delete(java.lang.String)
	 */
	public void deleteRole(String id) throws Exception {
		RoleData roleData = (RoleData)this.get(RoleData.class, id);
		if (null == roleData) {
			throw new AppException("1006", "没有找到角色[id=" + id + "]");
		}
        this.delete(roleData);		
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#add(com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void addRole(RoleVo roleVo) throws Exception {
		RoleData roleData = new RoleData();
		BeanUtilsHelp.copyProperties(roleData, roleVo);
		roleData.setRoleId(StringUtil.getUUID());
		this.save(roleData);
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#getRoleById(java.lang.String)
	 */
	public RoleVo getRoleById(String roleId) throws Exception {
		RoleVo roleVo = new RoleVo();
		RoleData roleData = (RoleData)this.get(RoleData.class, roleId);
		BeanUtilsHelp.copyProperties(roleVo, roleData);
		return roleVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#updateRole(com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void updateRole(RoleVo roleVo) throws Exception {
		RoleData roleData = (RoleData)this.get(RoleData.class, roleVo.getRoleId());
		BeanUtilsHelp.copyProperties(roleData, roleVo);
		roleData.setRoleName(roleVo.getRoleName());
		roleData.setDescription(roleVo.getDescription());
		this.update(roleData);
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleDataDao#saveRolePrivileges(java.lang.String[], java.lang.String)
	 */
	public void saveRolePrivileges(String[] privileges, String roleId)
			throws Exception {
		List<PrivilegeData> privilegeDatas = new ArrayList<PrivilegeData>();
		for(int i=0; i<privileges.length; i++){
			PrivilegeData pd = (PrivilegeData)this.get(PrivilegeData.class, privileges[i]);
			privilegeDatas.add(pd);
		}
		RoleData roleData = (RoleData)this.get(RoleData.class, roleId);
		List<PrivilegeData> pdatas = roleData.getPrivilegeList();
		for(PrivilegeData pd : privilegeDatas){
			if(!pdatas.contains(pd)){
				pdatas.add(pd);
			}
		}
		roleData.setPrivilegeList(pdatas);
	}

}
