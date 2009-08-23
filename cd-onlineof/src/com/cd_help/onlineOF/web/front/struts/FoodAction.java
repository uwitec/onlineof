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
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.FoodVo;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食管理
 * <p/>
 * <b>Creation Time:</b> Aug 23, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("foodAction")
@Scope("prototype")
public class FoodAction extends BaseAction{
	
	/* 分页Bean */
	private PageBean pageBean = null;
	/* 餐厅ID */
	private String restaurantId;
	/* 餐厅类别ID */
	private String restaurantKindId;
	/* 类别ID */
	private String foodKindId;
	/* 当前页 */
	private int page = 1;
	
	/**
	 * 饮食
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private List<FoodVo> foodVos = new ArrayList<FoodVo>();
	
	/**
	 * 分页获取饮食
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getSignFoods() throws AppException{
		log.debug("--->> begin getFoodByPage");
		foodVos = this.getOnlineOF().getFoodManager().getSignFoods();
		return SUCCESS;
	}
	
	/**
	 * 获取某个餐厅类别下的招牌菜信息
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getFoodByRestaurantKind() throws AppException {
		RestaurantVo rv = this.getOnlineOF().getRestaurantManager().getTopRestaurantByKind(restaurantKindId);
		if(null != rv){
			foodVos = this.getOnlineOF().getFoodManager().getSignFoodsByRestaurantId(rv.getRestaurantId());
		}else{
			foodVos = null;
		}
		return SUCCESS;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getFoodKindId() {
		return foodKindId;
	}

	public void setFoodKindId(String foodKindId) {
		this.foodKindId = foodKindId;
	}

	public List<FoodVo> getFoodVos() {
		return foodVos;
	}

	public void setFoodVos(List<FoodVo> foodVos) {
		this.foodVos = foodVos;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getRestaurantKindId() {
		return restaurantKindId;
	}

	public void setRestaurantKindId(String restaurantKindId) {
		this.restaurantKindId = restaurantKindId;
	}
}
