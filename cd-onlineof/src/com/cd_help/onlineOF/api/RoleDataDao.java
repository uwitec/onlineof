/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

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
	 * 保存角色权限
	 * @param privileges
	 * @param roleId
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void saveRolePrivileges(String[] privileges,String roleId) throws Exception;

}
