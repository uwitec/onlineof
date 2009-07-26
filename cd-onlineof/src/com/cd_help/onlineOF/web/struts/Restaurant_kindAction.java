package com.cd_help.onlineOF.web.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.Restaurant_kindManager;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

@SuppressWarnings("serial")
@Service("restaurant_kindAction")
public class Restaurant_kindAction extends BaseAction {

	@Autowired
	@Resource(name = "restaurant_kindManager")
	private Restaurant_kindManager restaurant_kindManager = null;

	public void setRestaurant_kindManager(
			Restaurant_kindManager restaurant_kindManager) {
		this.restaurant_kindManager = restaurant_kindManager;
	}

	@Resource(name = "pageBean")
	private PageBean pageBean = null;

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	/* 餐厅分类对象 */
	private Restaurant_kindVo restaurant_kindVo = null;
	/* 餐厅分类信息集合 */
	private List<Restaurant_kindVo> restaurant_kindVos = null;
	/* 当前页 */
	private int page = 1;
	/* 分类名称 */
	private String kindName;

	/**
	 * 取分页数据的集合 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getRestaurantKindPage() throws Exception {
		// TODO Auto-generated method stub\
		log.debug("laod RestaurantKindPage...");
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		try {
			this.pageBean.setCurrentPage(page);
			this.pageBean.setPagesize(2);
			if (null == this.getKindName() || "".equals(this.kindName)) {
				hqlName = "getResKindAllPage";
			} else {
				hqlName = "getResKindByNamePage";
				params = new String[] { "kindName" };
				conditions = new Object[] { this.getKindName() };
			}
			restaurant_kindManager.getRestaurantKindPage(hqlName, params,
					conditions, this.pageBean, this.getSession());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "restaurantKindPage";
	}

	public void setRestaurant_kindVo(Restaurant_kindVo restaurant_kindVo) {
		this.restaurant_kindVo = restaurant_kindVo;
	}

	public List<Restaurant_kindVo> getRestaurant_kindVos() {
		return restaurant_kindVos;
	}

	public void setRestaurant_kindVos(List<Restaurant_kindVo> restaurant_kindVos) {
		this.restaurant_kindVos = restaurant_kindVos;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Restaurant_kindVo getRestaurant_kindVo() {
		return restaurant_kindVo;
	}
}
