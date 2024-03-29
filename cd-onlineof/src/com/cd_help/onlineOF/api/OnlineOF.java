/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 在线订餐系统
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface OnlineOF {
	
	/**
	 * 订餐用户管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersManager getUsersManager() throws AppException;
	
	/**
	 * 信息分类管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public InfoKindManager getInfoKindManager() throws AppException;
	
	/**
	 * 订单管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersManager getOrdersManager() throws AppException;
	
	/**
	 * 餐厅管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RestaurantManager getRestaurantManager() throws AppException;
	
	/**
	 * 餐厅类别管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Restaurant_kindManager getRestaurant_kindManager() throws AppException;
	
	/**
	 * 饮食类别管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Food_kindManager getFood_kindManager() throws AppException;
    
	/**
	 * 菜系管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public CuisineManager getCuisineManager() throws AppException;
	
	/**
	 * 饮食管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodManager getFoodManager() throws AppException;
	
	/**
	 * 信誉管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public CredibilityManager getCredibilityManager() throws AppException;
	
	/**
	 * 信息管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public InfoManager getInfoManager() throws AppException;
	
	/**
	 * 角色管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleManager getRoleManager() throws AppException;
	
	/**
	 * 用户session管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public SessionManager getSessionManager() throws AppException;
	
	/**
	 * 权限管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeManager getPrivilegeManager() throws AppException;
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersVo login(String username,String password) throws AppException;
	
	/**
	 * 检查权限
	 * @param userssession
	 * @param methodName
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public boolean checkPrivilege(UsersSession userssession,String methodName) throws AppException;
	
}
