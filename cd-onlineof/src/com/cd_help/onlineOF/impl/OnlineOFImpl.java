/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.CredibilityManager;
import com.cd_help.onlineOF.api.CuisineManager;
import com.cd_help.onlineOF.api.FoodManager;
import com.cd_help.onlineOF.api.Food_kindManager;
import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.api.OrdersManager;
import com.cd_help.onlineOF.api.RestaurantManager;
import com.cd_help.onlineOF.api.Restaurant_kindManager;
import com.cd_help.onlineOF.api.UsersManager;

/**
 * <b><code></code></b>
 * <p/>
 * Implementation of OnlineOF.
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("onlineOF")
public class OnlineOFImpl implements OnlineOF{
	
	/**
	 * 订餐用户管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "usersManager")
	private UsersManager usersManager = null;
	
	/**
	 * 订单管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "ordersManager")
	private OrdersManager ordersManager = null;
	/**
	 * 餐厅管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "restaurantManager")
	private RestaurantManager restaurantManager = null;
	
	/**
	 * 餐厅类别管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "restaurant_kindManager")
	private Restaurant_kindManager restaurant_kindManager = null;

	/**
	 * 饮食管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "foodManager")
	private FoodManager foodManager = null;
	
	/**
	 * 饮食类别管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "food_kindManager")
	private Food_kindManager food_kindManager = null;
	
	/**
	 * 菜系管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "cuisineManager")
	private CuisineManager cuisineManager = null;
	
	/**
	 * 信誉管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "credibilityManager")
	private CredibilityManager credibilityManager = null;

	public UsersManager getUsersManager() {
		return usersManager;
	}

	public void setUsersManager(UsersManager usersManager) {
		this.usersManager = usersManager;
	}

	public OrdersManager getOrdersManager() {
		return ordersManager;
	}

	public void setOrdersManager(OrdersManager ordersManager) {
		this.ordersManager = ordersManager;
	}

	public RestaurantManager getRestaurantManager() {
		return restaurantManager;
	}

	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	public Restaurant_kindManager getRestaurant_kindManager() {
		return restaurant_kindManager;
	}

	public void setRestaurant_kindManager(
			Restaurant_kindManager restaurant_kindManager) {
		this.restaurant_kindManager = restaurant_kindManager;
	}

	public FoodManager getFoodManager() {
		return foodManager;
	}

	public void setFoodManager(FoodManager foodManager) {
		this.foodManager = foodManager;
	}

	public Food_kindManager getFood_kindManager() {
		return food_kindManager;
	}

	public void setFood_kindManager(Food_kindManager food_kindManager) {
		this.food_kindManager = food_kindManager;
	}

	public CuisineManager getCuisineManager() {
		return cuisineManager;
	}

	public void setCuisineManager(CuisineManager cuisineManager) {
		this.cuisineManager = cuisineManager;
	}

	public CredibilityManager getCredibilityManager() {
		return credibilityManager;
	}

	public void setCredibilityManager(CredibilityManager credibilityManager) {
		this.credibilityManager = credibilityManager;
	}
}
