/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订餐用户管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unchecked")
public interface UsersManager {

	public UsersVo getUsersById(UsersSession session, String id) throws Exception;
	
	public boolean checkUsersByName(String usersname) throws Exception;
	
	public void addUsers(UsersSession session,UsersVo usersVo) throws Exception;
	
    public List<UsersVo> loadAll(UsersSession session) throws Exception;

	public PageBean searchByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, UsersSession session)
			throws Exception;
	
	public void updateUsers(UsersSession session, UsersVo usersVo) throws Exception;

	public void deleteUsers(UsersSession session, String id) throws Exception;

	public UsersVo login(String username, String password) throws Exception;
	
	public boolean resetPassword(String usersId, String oldPassword, String newPassword) throws Exception; 
	
}
