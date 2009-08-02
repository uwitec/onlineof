/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色数据接口
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface RoleDataDao extends BaseDao{
	
	/**
	 * 加载所有角色
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<RoleVo> loadAllRole() throws Exception;
	
	/**
	 * 删除角色
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteRole(String id) throws Exception;
	
	/**
	 * 分页查询
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchRolesByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception;
	
	/**
	 * 新建角色
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void addRole(RoleVo roleVo) throws Exception;
	
	/**
	 * 根据ID获取角色信息
	 * @param roleId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleVo getRoleById(String roleId) throws Exception; 
	
	/**
	 * 修改角色
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateRole(RoleVo roleVo) throws Exception;
	
	/**
	 * 保存角色权限
	 * @param privileges
	 * @param roleId
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void saveRolePrivileges(String[] privileges,String roleId) throws Exception;

}
