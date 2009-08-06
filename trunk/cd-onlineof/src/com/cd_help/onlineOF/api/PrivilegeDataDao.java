/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限数据接口
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface PrivilegeDataDao extends BaseDao{
	
	public List<PrivilegeVo> loadAllPrivilege() throws Exception;
	
	public List<PrivilegeVo> loadAllModelPrivilege() throws Exception;

	public void updatePrivilege(PrivilegeVo privilegeVo) throws Exception;
	
	public void deletePrivilege(String id) throws Exception;
	
	public List<PrivilegeVo> loadTopModelPrivilege(String roleId) throws Exception;
    
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(String parentId,String roleId) throws Exception;
	
	public List<PrivilegeVo> getPrivilegeByRoleId(String roleId) throws Exception;
	
	public PageBean searchByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception;
	
	public PrivilegeVo getPrivilegeById(String privilegeId) throws Exception;
	
	public PrivilegeVo addPrivilege(PrivilegeVo privilegeVo) throws Exception;
	
	public List<PrivilegeVo> getTopPrivilege() throws Exception;
	
	public List<PrivilegeVo> getChildPrivilege(String parentId) throws Exception;
}
