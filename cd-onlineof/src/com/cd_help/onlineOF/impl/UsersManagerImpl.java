/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.api.UsersManager;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 用户管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("usersManager")
public class UsersManagerImpl implements UsersManager {

	@Autowired
	@Resource(name = "usersDataDao")
	private UsersDataDao usersDataDao;

	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "restaurantDataDao")
	private RestaurantDataDao restaurantDataDao;
	
	public void delete(Session session, String id) throws AppException {
		try {
			if (this.checkPrivilege(session)) {
				usersDataDao.delete(id);
			} else {
				throw new AppException("0000000", "权限不够!");
			}
		} catch (AppException e) {
			throw new AppException("0000012", "删除用户出错!");
		}
	}

	public UsersVo get(Session session, String id) throws AppException {
		UsersVo usersVo = null;
		try {
			if (this.checkPrivilege(session)) {
				usersVo = usersDataDao.get(id);
			} else {
				throw new AppException("0000000", "权限不够!");
			}
		} catch (AppException e) {
			throw new AppException("0000013", "获取用户信息出错!");
		}
		return usersVo;
	}

	public List<UsersVo> loadAll(Session session) throws AppException {
		List<UsersVo> usersVoList = null;
		try {
			if (this.checkPrivilege(session)) {
				usersVoList = usersDataDao.loadAll();
			} else {
				throw new AppException("0000000", "权限不够!");
			}
		} catch (AppException e) {
			throw new AppException("0000014", "加载用户信息出错!");
		}
		return usersVoList;
	}

	public UsersVo login(String username, String password) throws AppException {
		UsersVo usersVo = null;
		try {
			usersVo = usersDataDao.login(username, password);
			if(null != usersVo.getRestaurantId() && usersVo.getRestaurantId().length() > 0){
				usersVo.setRestaurantName(restaurantDataDao.get(usersVo.getRestaurantId()).getName());
			}
		} catch (AppException e) {
			throw new AppException("0000011", "登陆出错,请检查用户名和密码!");
		}
		return usersVo;
	}

	public void update(Session session, String id) throws AppException {
		try {
			if (this.checkPrivilege(session)) {
				usersDataDao.update(id);
			} else {
				throw new AppException("0000000", "权限不够!");
			}
		} catch (AppException e) {
			throw new AppException("0000011", "修改用户信息出错!");
		}
	}

	/**
	 * 检查权限
	 * 
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(Session session) throws AppException {
		return true;
	}

	public void setUsersDataDao(UsersDataDao usersDataDao) {
		this.usersDataDao = usersDataDao;
	}

	public void setRestaurantDataDao(RestaurantDataDao restaurantDataDao) {
		this.restaurantDataDao = restaurantDataDao;
	}

	public PageBean loadAll(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws AppException {
		return this.usersDataDao.getPageBean(hqlName, paramName, condition,
				pageBean);
	}
}
