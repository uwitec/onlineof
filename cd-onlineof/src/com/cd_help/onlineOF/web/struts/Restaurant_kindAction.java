package com.cd_help.onlineOF.web.struts;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.Restaurant_kindManager;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * 处理餐厅分类的Action <b><code></code></b> <p/> Comment here <p/> <b>Creation
 * Time:</b> Jul 28, 2009
 * 
 * @author ZhangZhen
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("restaurantKindAction")
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
	/* 删除餐厅分类的ID集合 */
	private String[] checksItem;

	/**
	 * 取分页数据的集合 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getRestaurantKindPage() throws Exception {
		// TODO Auto-generated method stub\
		log.debug("load RestaurantKindPage...");
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
				params = new String[] { "name" };
				conditions = new Object[] { this.getKindName() };
			}
			this.pageBean = restaurant_kindManager.getRestaurantKindPage(
					hqlName, params, conditions, pageBean, this
							.getSession());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AppException("loadRestaurantKindPException","加载餐厅分类信息失败.");
		}
		return SUCCESS;
	}

	/**
	 * 保存餐厅分类信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String savaRestaurantKind() throws Exception {
		// TODO Auto-generated method stub
		if (restaurant_kindVo != null
				&& restaurant_kindVo.getRestaurant_kind_Id() != null
				&& restaurant_kindVo.getRestaurant_kind_Id().length() > 0) {
			// 修改餐厅分类
			restaurant_kindManager.updRestaurantKind(restaurant_kindVo);
		} else {
			// 新增餐厅分类
			restaurant_kindVo.setRestaurant_kind_Id(StringUtil.getUUID());
			Timestamp createTime = new Timestamp(System.currentTimeMillis());
			restaurant_kindVo.setCreateTime(createTime);
			restaurant_kindManager.addRestaurantKind(restaurant_kindVo);
		}
		return SUCCESS;
	}

	/**
	 * 编辑餐厅分类信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editRestaurantKind() throws Exception {
		// TODO Auto-generated method stub
		if (restaurant_kindVo != null
				&& restaurant_kindVo.getRestaurant_kind_Id() != null
				&& restaurant_kindVo.getRestaurant_kind_Id().length() > 0) {
			restaurant_kindVo = restaurant_kindManager
					.getRestaurantKindById(restaurant_kindVo
							.getRestaurant_kind_Id());
		} else {
			restaurant_kindVo = new Restaurant_kindVo();
		}
		return SUCCESS;
	}

	/**
	 * 删除餐厅分类 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteRestaurantKind() throws Exception {
		// TODO Auto-generated method stub
		if (restaurant_kindVo != null
				&& restaurant_kindVo.getRestaurant_kind_Id() != null
				&& restaurant_kindVo.getRestaurant_kind_Id().length() > 0) {
			restaurant_kindManager.delRestaurantKind(restaurant_kindVo
					.getRestaurant_kind_Id());
		} else if (checksItem != null && checksItem.length > 0) {
			for (String id : checksItem) {
				restaurant_kindManager.delRestaurantKind(id);
			}
		} else {
			throw new AppException("delete001", "删除餐厅分类错误!");
		}
		return this.getRestaurantKindPage();
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

	public PageBean getPageBean() {
		return pageBean;
	}

	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
	}
}
