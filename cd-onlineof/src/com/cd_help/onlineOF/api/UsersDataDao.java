/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 用户数据处理接口
 * <p/>
 * <b>Creation Time:</b> Jul 15, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface UsersDataDao extends BaseDao {

	public UsersVo get(String id) throws Exception;
	
	/**
	 * 检测用户
	 * @param usersname
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public boolean checkUsersByName(String usersname) throws Exception;
	
	public void addUsers(UsersVo usersVo) throws Exception;

	public List<UsersVo> loadAll() throws Exception;

	public void update(UsersVo usersVo) throws Exception;

	public void delete(String id) throws Exception;

	public UsersVo login(String username, String password) throws Exception;
	
	public PageBean searchByPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception;
	
}
