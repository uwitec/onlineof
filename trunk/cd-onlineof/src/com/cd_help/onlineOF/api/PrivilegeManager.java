/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.UsersSession;
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
	
	public List<PrivilegeVo> loadAllPrivilege(UsersSession session) throws Exception;

	public List<PrivilegeVo> loadAllModelPrivilege(UsersSession session) throws Exception;
	
	public void updatePrivilege(UsersSession session,PrivilegeVo privilegeVo) throws Exception;
	
	public void deletePrivilege(UsersSession session,String id) throws Exception;
	
	public List<PrivilegeVo> loadTopModelPrivilege(UsersSession session) throws Exception;
    
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(UsersSession session,String parentId) throws Exception;
	
	public List<PrivilegeVo> getPrivilegeByRoleId(UsersSession session, String roleId) throws Exception;
	
	public PrivilegeVo getPrivilegeById(UsersSession session, String privilegeId) throws Exception;
	
	public PrivilegeVo addPrivilege(UsersSession session, PrivilegeVo privilegeVo) throws Exception;
	
    public List<PrivilegeVo> getTopPrivilege(UsersSession session) throws Exception;
	
	public List<PrivilegeVo> getChildPrivilege(UsersSession session, String parentId) throws Exception;

}
