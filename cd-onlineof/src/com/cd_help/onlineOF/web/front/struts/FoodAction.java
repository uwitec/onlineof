/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.front.struts;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.BaseAction;

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
	/* 类别ID */
	private String foodKindId;
	/* 当前页 */
	private int page = 1;
	
	/**
	 * 分页获取饮食
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getFoodByPage() throws AppException{
		log.debug("--->> begin getFoodByPage");
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPagesize(10);
		if (null != this.getRestaurantId()
				&& !"".equals(this.getRestaurantId())) {
			hqlName = "getFoodByRestaurantId";
			params = new String[] { "restaurantId"};
			conditions = new Object[] {
					this.getRestaurantId()};
		}else {
		   hqlName = "getFoodAll";
		}
		pageBean = this.getOnlineOF().getFoodManager().seachFoodPage(
				hqlName, params, conditions, pageBean, this.getSession());
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
}
