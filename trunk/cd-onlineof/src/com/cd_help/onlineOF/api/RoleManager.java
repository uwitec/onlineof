/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 24, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface RoleManager {
	
	/**
	 * 获取所有角色信息
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<RoleVo> loadAllRole(UsersSession session) throws AppException;
	
	/**
	 * 根据条件分页查询
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchRolesByPage(UsersSession session,String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean)
			throws AppException;
	
	/**
	 * 删除角色
	 * @param session
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteRole(UsersSession session, String id) throws AppException;
	
	/**
	 * 新建角色
	 * @param session
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void addRole(UsersSession session,RoleVo roleVo) throws AppException;
	
	/**
	 * 根据ID获取角色信息
	 * @param session
	 * @param roleId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleVo getRoleById(UsersSession session, String roleId) throws AppException;
	
	/**
	 * 修改角色
	 * @param session
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateRole(UsersSession session, RoleVo roleVo) throws AppException;
	
	/**
	 * 保存角色权限
	 * @param session
	 * @param privileges
	 * @param roleId
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void saveRolePrivileges(UsersSession session, String[] privileges, String roleId) throws AppException;

}
