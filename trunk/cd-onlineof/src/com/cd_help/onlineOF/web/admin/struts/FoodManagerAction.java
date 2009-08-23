package com.cd_help.onlineOF.web.admin.struts;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.FoodVo;
import com.cd_help.onlineOF.web.vo.Food_kindVo;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * 
 * <b><code>菜信息处理Action</code></b> <p/> Comment here <p/> <b>Creation Time:</b>
 * Aug 7, 2009
 * 
 * @author ZhangZhen
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("foodManagerAction")
@Scope("prototype")
public class FoodManagerAction extends BaseAction {
	/* 分页Bean */
	private PageBean pageBean = null;
	/* 餐厅ID */
	private String restaurantId;
	/* 类别ID */
	private String foodKindId;
	/* 菜VO对象 */
	private FoodVo foodVo = null;
	/* 餐厅集合 */
	private List<RestaurantVo> restaurantVos = null;
	/* 类别集合 */
	private List<Food_kindVo> food_kindVos = null;
	/* 菜名称 */
	private String foodName;
	/* 当前页 */
	private int page = 1;
	/* 删除餐厅分类的ID集合 */
	private String[] checksItem;
	/* 上传的菜图片 */
	private File foodImg;
	/* 菜图片名称 */
	private String foodImgFileName;

	/**
	 * 取菜的分页信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getFoodPage() throws AppException {
		log.debug("load FoodKind Page...");
		restaurantVos = this.getOnlineOF().getRestaurantManager()
				.loadARestaurantAll();
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPagesize(10);
		if (null != this.getFoodKindId()
				&& !"".equals(this.getFoodKindId())) {
			if (null == this.restaurantId || "".equals(this.restaurantId)) {
				hqlName = "getFoodByKindId";
				params = new String[] { "kindId" };
				conditions = new Object[] { this.getFoodKindId() };
			} else {
				hqlName = "getFoodByresIdAndKindId";
				params = new String[] { "restaurantId", "kindId",
						"foodName" };
				conditions = new Object[] {
						this.getRestaurantId(),
						this.getFoodKindId(),
						this.foodName == null ? "%" : "%" + this.foodName
								+ "%" };
			}
		}else {
			if (null != this.restaurantId && !"".equals(this.restaurantId)) {
				hqlName = "getFoodByresIdAndFoodName";
				params = new String[] { "restaurantId", "foodName" };
				conditions = new Object[] {
						this.getRestaurantId(),
						this.foodName == null ? "%" : "%" + this.foodName
								+ "%" };
			} else {
				hqlName = "getFoodAll";
			}
		}
		pageBean = this.getOnlineOF().getFoodManager().seachFoodPage(
				hqlName, params, conditions, pageBean, this.getSession());
		return SUCCESS;
	}
	
	/**
	 * 编辑菜信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editFood() throws Exception {
		// TODO Auto-generated method stub
		restaurantVos = this.getOnlineOF().getRestaurantManager()
				.loadARestaurantAll();
		if (null != this.getFoodVo() && null != this.getFoodVo().getFoodId()
				&& this.getFoodVo().getFoodId().length() > 0) {
			this.foodVo = this.getOnlineOF().getFoodManager().getFoodById(
					this.getFoodVo().getFoodId());
		} else {
			this.foodVo = new FoodVo();
		}
		return SUCCESS;
	}

	/**
	 * 保存菜信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String savaFood() throws Exception {
		// TODO Auto-generated method stub
		if (null != this.getFoodVo() && null != this.getFoodVo().getFoodId()
				&& this.getFoodVo().getFoodId().length() > 0) {
			// 处理修改菜信息
			if (null != this.foodImg) {
				FileInputStream inputStream = new FileInputStream(this.foodImg);
				foodVo.setImg(Hibernate.createBlob(inputStream));
			}
			this.getOnlineOF().getFoodManager().updateFood(foodVo);
		} else {
			// 处理添加菜信息
			this.foodVo.setFoodId(StringUtil.getUUID());
			FileInputStream inputStream = new FileInputStream(this.foodImg);
			foodVo.setImg(Hibernate.createBlob(inputStream));
			this.getOnlineOF().getFoodManager().saveFood(foodVo);
		}
		return this.getFoodPage();
	}

	/**
	 * 删除菜信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteFood() throws Exception {
		// TODO Auto-generated method stub
		if (null != this.getFoodVo() && null != this.getFoodVo().getFoodId()
				&& this.getFoodVo().getFoodId().length() > 0) {
			this.getOnlineOF().getFoodManager().deleteFood(
					this.getFoodVo().getFoodId());
		}
		if (null != this.checksItem && this.checksItem.length > 0) {
			for (String str : checksItem) {
				this.getOnlineOF().getFoodManager().deleteFood(str);
			}
		}
		return this.getFoodPage();
	}

	/**
	 * 菜信息预览 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String foodPreView() throws Exception {
		// TODO Auto-generated method stub
		if (null != foodVo && null != foodVo.getFoodId()) {
			foodVo = this.getOnlineOF().getFoodManager().getFoodById(
					foodVo.getFoodId());
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

	public FoodVo getFoodVo() {
		return foodVo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setFoodVo(FoodVo foodVo) {
		this.foodVo = foodVo;
	}

	public List<RestaurantVo> getRestaurantVos() {
		return restaurantVos;
	}

	public void setRestaurantVos(List<RestaurantVo> restaurantVos) {
		this.restaurantVos = restaurantVos;
	}

	public List<Food_kindVo> getFood_kindVos() {
		return food_kindVos;
	}

	public void setFood_kindVos(List<Food_kindVo> food_kindVos) {
		this.food_kindVos = food_kindVos;
	}

	public String getFoodName() {
		return foodName;
	}

	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public File getFoodImg() {
		return foodImg;
	}

	public void setFoodImg(File foodImg) {
		this.foodImg = foodImg;
	}

	public String getFoodImgFileName() {
		return foodImgFileName;
	}

	public void setFoodImgFileName(String foodImgFileName) {
		this.foodImgFileName = foodImgFileName;
	}
}
