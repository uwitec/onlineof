/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.admin.dwr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.admin.struts.BaseAction;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 获取首页数据
 * <p/>
 * <b>Creation Time:</b> Aug 15, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("initIndexDataDwrAction")
public class InitIndexDataDwrAction extends BaseAction{
	
	/**
	 * 根据餐厅等级获取餐厅集合
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<RestaurantVo> getRestaurantDataByCredibility() throws AppException{
		List<RestaurantVo> restaurantVos = new ArrayList<RestaurantVo>();
		try{
			restaurantVos = this.getOnlineOF().getRestaurantManager().loadARestaurantAll();
		}catch(AppException e){
			throw new AppException("00000300",e.getMessage(),e);
		}
		return restaurantVos;
	}
	
	/**
	 * 获取餐厅类别
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<Restaurant_kindVo> getRestaurant_kindData() throws AppException{
		List<Restaurant_kindVo> restaurant_kindVos = new ArrayList<Restaurant_kindVo>();
		try{
			restaurant_kindVos = this.getOnlineOF().getRestaurant_kindManager().getRestaurantKindAll();
		}catch(Exception e){
			throw new AppException("00000300",e.getMessage(),e);
		}
		return restaurant_kindVos;
	}
	

}
