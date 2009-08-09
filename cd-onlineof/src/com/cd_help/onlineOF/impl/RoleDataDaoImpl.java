/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.RoleData;

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
@SuppressWarnings("unchecked")
public class RoleDataDaoImpl extends BaseDaoSupport implements RoleDataDao{
	
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
		roleData.setPrivilegeList(privilegeDatas);
	}

}
