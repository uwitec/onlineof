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
	public List<RoleVo> loadAll() throws AppException;
	
	/**
	 * 删除角色
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void delete(String id) throws AppException;
	
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
	public PageBean searchByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws AppException;
	
	/**
	 * 新建角色
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void add(RoleVo roleVo) throws AppException;
	
	/**
	 * 根据ID获取角色信息
	 * @param roleId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleVo getRoleById(String roleId) throws AppException; 
	
	/**
	 * 修改角色
	 * @param roleVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateRole(RoleVo roleVo) throws AppException;

}
