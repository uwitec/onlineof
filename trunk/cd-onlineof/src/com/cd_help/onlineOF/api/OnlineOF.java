/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.AppException;

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
	public UsersManager getUsersManager() throws Exception;
	
	/**
	 * 订单管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersManager getOrdersManager() throws Exception;
	
	/**
	 * 餐厅管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RestaurantManager getRestaurantManager() throws Exception;
	
	/**
	 * 餐厅类别管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Restaurant_kindManager getRestaurant_kindManager() throws Exception;
	
	/**
	 * 饮食类别管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Food_kindManager getFood_kindManager() throws Exception;
    
	/**
	 * 菜系管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public CuisineManager getCuisineManager() throws Exception;
	
	/**
	 * 饮食管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodManager getFoodManager() throws Exception;
	
	/**
	 * 信誉管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public CredibilityManager getCredibilityManager() throws Exception;
	
	/**
	 * 角色管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleManager getRoleManager() throws Exception;
	
	/**
	 * 用户session管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public SessionManager getSessionManager() throws Exception;
	
	/**
	 * 权限管理
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeManager getPrivilegeManager() throws Exception;
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public UsersSession login(String username,String password) throws Exception;
	
}
