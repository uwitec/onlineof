/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
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
	public List<RoleVo> loadAll(Session session) throws AppException;
	
	/**
	 * 获取用户拥有角色
	 * @param usersId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<RoleVo> getRoleByUsersId(Session session,String usersId) throws AppException;

}
