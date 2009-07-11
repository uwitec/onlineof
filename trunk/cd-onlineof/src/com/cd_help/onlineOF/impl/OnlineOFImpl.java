/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.FoodManager;
import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.api.OrdersManager;
import com.cd_help.onlineOF.api.RestaurantManager;
import com.cd_help.onlineOF.utils.AppException;

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
	 * 饮食管理
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Autowired
	@Resource(name = "foodManager")
	private FoodManager foodManager = null;
	
	public void setOrdersManager(OrdersManager ordersManager) {
		this.ordersManager = ordersManager;
	}

	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	public void setFoodManager(FoodManager foodManager) {
		this.foodManager = foodManager;
	}

	public OrdersManager getOrdersManager() {
		return ordersManager;
	}

	public RestaurantManager getRestaurantManager() {
		return restaurantManager;
	}

	public FoodManager getFoodManager() {
		return foodManager;
	}
}
