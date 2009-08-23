/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.front.struts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 初始化首页数据
 * <p/>
 * <b>Creation Time:</b> Aug 23, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("initialAction")
@Scope("prototype")
public class InitialAction extends BaseAction{
	
	/**
     * 所有餐厅集合
     * @since cd_help-onlineOF 0.0.0.1
     */
    private List<RestaurantVo> restaurants = new ArrayList<RestaurantVo>();
    
    /**
     * 所有餐厅_类别集合
     * @since cd_help-onlineOF 0.0.0.1
     */
    private List<Restaurant_kindVo> restaurantKinds = new ArrayList<Restaurant_kindVo>();
	
	/**
	 * 初始化首页数据
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String initialData() throws AppException{
		restaurants = this.getOnlineOF().getRestaurantManager().loadARestaurantAll();
		restaurantKinds = this.getOnlineOF().getRestaurant_kindManager().getRestaurantKindAll();
		return SUCCESS;
	}

	public List<RestaurantVo> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantVo> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Restaurant_kindVo> getRestaurantKinds() {
		return restaurantKinds;
	}

	public void setRestaurantKinds(List<Restaurant_kindVo> restaurantKinds) {
		this.restaurantKinds = restaurantKinds;
	}
}
