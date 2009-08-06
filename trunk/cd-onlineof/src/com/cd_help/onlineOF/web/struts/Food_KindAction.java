package com.cd_help.onlineOF.web.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.Food_kindVo;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code>处理餐厅菜分类的Action</code></b> <p/> Comment here <p/> <b>Creation
 * Time:</b> Aug 5, 2009
 * 
 * @author ZhangZhen
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("food_KindAction")
public class Food_KindAction extends BaseAction {
	@Autowired
	@Resource(name = "pageBean")
	private PageBean pageBean = null;

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	/* 餐厅菜分类值对象 */
	private Food_kindVo food_kindVo = null;
	/* 餐厅菜分类值对象集合 */
	private List<Food_kindVo> food_kindVos = null;
	/* 餐厅菜分类名称 */
	private String foodKindName = null;
	/* 删除餐厅分类的ID集合 */
	private String[] checksItem;
	/* 当前页数 */
	private int page = 1;
	/* 餐厅名称 */
	private String restaruantName;
	/* 餐厅集合 */
	private List<RestaurantVo> restaurantVos = null;

	/**
	 * 取餐厅菜分类的分页信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getFoodKindPage() throws Exception {
		// TODO Auto-generated method stub
		log.debug("load FoodKind Page...");
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		try {
			this.pageBean.setCurrentPage(page);
			this.pageBean.setPagesize(2);
			if (null == this.foodKindName || "".equals(this.foodKindName)) {
				hqlName = "getFoodkindAll";
			} else {
				hqlName = "countFoodkindByName";
				params = new String[] { "kindName", "restaurantName" };
				conditions = new Object[] { "%" + this.getFoodKindName() + "%",
						"%" + this.getRestaruantName() + "%" };
			}
			this.pageBean = this.getOnlineOF().getFood_kindManager()
					.seachFoodKindPage(hqlName, params, conditions, pageBean,
							this.getSession());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AppException("loadFoodKindPException", "加载菜分类信息失败.");
		}
		return SUCCESS;
	}

	/**
	 * 保存菜类别信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String savaFoodKind() throws Exception {
		// TODO Auto-generated method stub
		if (null != this.getFood_kindVo()
				&& null != this.getFood_kindVo().getFood_kind_Id()
				&& this.getFood_kindVo().getFood_kind_Id().length() > 0) {
			// 处理修改菜类别信息
			this.getOnlineOF().getFood_kindManager().updateFoodKind(
					this.food_kindVo);
		} else {
			// 处理添加菜类别信息
			this.getFood_kindVo().setFood_kind_Id(StringUtil.getUUID());
			this.getOnlineOF().getFood_kindManager().savaFoodKind(
					this.food_kindVo);
		}
		return this.getFoodKindPage();
	}

	/**
	 * 删除菜类别信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteFoodKind() throws Exception {
		// TODO Auto-generated method stub
		if (null != this.getFood_kindVo()
				&& null != this.getFood_kindVo().getFood_kind_Id()
				&& this.getFood_kindVo().getFood_kind_Id().length() > 0) {
			this.getOnlineOF().getFood_kindManager().deleteFoodKind(
					this.getFood_kindVo().getFood_kind_Id());
		}
		if (null != this.checksItem && this.getChecksItem().length > 0) {
			for (String str : this.checksItem) {
				this.getOnlineOF().getFood_kindManager().deleteFoodKind(str);
			}
		}
		return this.getFoodKindPage();
	}

	/**
	 * 编辑菜分类信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editFoodKind() throws Exception {
		// TODO Auto-generated method stub
		restaurantVos = this.getOnlineOF().getRestaurantManager().loadAll();
		if (null != this.getFood_kindVo()
				&& null != this.getFood_kindVo().getFood_kind_Id()
				&& this.getFood_kindVo().getFood_kind_Id().length() > 0) {
			this.food_kindVo = this
					.getOnlineOF()
					.getFood_kindManager()
					.getFood_kindVoById(this.getFood_kindVo().getFood_kind_Id());
		} else {
			this.food_kindVo = new Food_kindVo();
		}
		return SUCCESS;
	}

	public Food_kindVo getFood_kindVo() {
		return food_kindVo;
	}

	public void setFood_kindVo(Food_kindVo food_kindVo) {
		this.food_kindVo = food_kindVo;
	}

	public List<Food_kindVo> getFood_kindVos() {
		return food_kindVos;
	}

	public void setFood_kindVos(List<Food_kindVo> food_kindVos) {
		this.food_kindVos = food_kindVos;
	}

	public String getFoodKindName() {
		return foodKindName;
	}

	public void setFoodKindName(String foodKindName) {
		this.foodKindName = foodKindName;
	}

	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public String getRestaruantName() {
		return restaruantName;
	}

	public void setRestaruantName(String restaruantName) {
		this.restaruantName = restaruantName;
	}

	public List<RestaurantVo> getRestaurantVos() {
		return restaurantVos;
	}

	public void setRestaurantVos(List<RestaurantVo> restaurantVos) {
		this.restaurantVos = restaurantVos;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
