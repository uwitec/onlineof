/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b>
 * <p/>
 * 餐厅处理 Action
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("restaurantAction")
public class RestaurantAction extends BaseAction{

	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(RestaurantAction.class);
	
	private boolean success = true;
	
	/**
	 * 餐厅集合
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private List<RestaurantVo> restaurantList = new ArrayList<RestaurantVo>(); 
	
	/**
	 * 获取所有餐厅信息
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loadAllRestaurant(){
		log.debug("--->> begin loadAll");
		try {
			restaurantList = this.getOnlineOF().getRestaurantManager().loadAll();
		} catch (AppException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<RestaurantVo> getRestaurantList() {
		return restaurantList;
	}
	public void setRestaurantList(List<RestaurantVo> restaurantList) {
		this.restaurantList = restaurantList;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
