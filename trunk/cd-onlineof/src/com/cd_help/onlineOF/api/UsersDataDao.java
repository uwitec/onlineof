/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
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

	public UsersVo get(String id) throws AppException;

	public List<UsersVo> loadAll() throws AppException;

	public void update(String id) throws AppException;

	public void delete(String id) throws AppException;

	public UsersVo login(String username, String password) throws AppException;
}
