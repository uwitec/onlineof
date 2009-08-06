/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 19, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface PrivilegeManager {
	
	public List<PrivilegeVo> loadAllPrivilege(Session session) throws Exception;

	public List<PrivilegeVo> loadAllModelPrivilege(Session session) throws Exception;
	
	public void updatePrivilege(Session session,PrivilegeVo privilegeVo) throws Exception;
	
	public void deletePrivilege(Session session,String id) throws Exception;
	
	public List<PrivilegeVo> loadTopModelPrivilege(Session session) throws Exception;
    
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(Session session,String parentId) throws Exception;
	
	public List<PrivilegeVo> getPrivilegeByRoleId(Session session, String roleId) throws Exception;
	
	public PageBean searchPrivilegesByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, Session session) throws Exception;
	
	public PrivilegeVo getPrivilegeById(Session session, String privilegeId) throws Exception;
	
	public PrivilegeVo addPrivilege(Session session, PrivilegeVo privilegeVo) throws Exception;
	
    public List<PrivilegeVo> getTopPrivilege(Session session) throws Exception;
	
	public List<PrivilegeVo> getChildPrivilege(Session session, String parentId) throws Exception;

}
