/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.admin.struts;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.RestaurantVo;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * <b><code></code></b> <p/> 餐厅处理 Action <p/> <b>Creation Time:</b> Jul 4,
 * 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("restaurantManagerAction")
@Scope("prototype")
public class RestaurantManagerAction extends BaseAction {

	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(RestaurantManagerAction.class);

	private PageBean pageBean = new PageBean();

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	private boolean success = true;
	/* 餐厅信息集合 */
	private List<RestaurantVo> restaurantVos = null;
	/* 餐厅信息 */
	private RestaurantVo restaurantVo = null;
	/* 当前页 */
	private int page = 1;
	/* 分类名称 */
	private String kindId;
	/* 删除餐厅分类的ID集合 */
	private String[] checksItem;
	/* 餐厅图片 */
	private File resFile;
	/* 餐厅图片文件名 */
	private String resFileFileName;
	/* 餐厅分类的集合 */
	private List<Restaurant_kindVo> restaurant_kindVos = null;
	/* 餐厅名称 */
	private String restaurantName;
	/**
	 * 餐厅集合
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private List<RestaurantVo> restaurantList = new ArrayList<RestaurantVo>();

	/**
	 * 获取所有餐厅信息
	 * 
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loadAllRestaurant() throws AppException {
		log.debug("--->> begin loadAll");
		try {
			restaurantList = this.getOnlineOF().getRestaurantManager()
					.loadARestaurantAll();
		} catch (Exception e) {
			throw new AppException("", e.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * 加载餐厅分页信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getRestaurantPage() throws Exception {
		// TODO Auto-generated method stub
		restaurant_kindVos = this.getOnlineOF().getRestaurant_kindManager()
				.getRestaurantKindAll();
		log.debug("load RestaurantPage...");
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		try {
			this.pageBean.setCurrentPage(page);
			this.pageBean.setPagesize(10);
			if (null == kindId || "".endsWith(kindId)) {
				hqlName = "getRestaurantAllPage";
			} else {
				hqlName = "getRestaurantByKindName";
				params = new String[] { "rkindId", "rname" };
				conditions = new Object[] { this.kindId,
						"%" + this.getRestaurantName() + "%" };
			}
			this.pageBean = this.getOnlineOF().getRestaurantManager()
					.seachRestaurantPage(hqlName, params, conditions, pageBean,this.getSession());
			log.debug("pageBean.array.size="
					+ this.getPageBean().getArray().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AppException("restaurant0001", "加载餐厅信息失败!");
		}
		return SUCCESS;
	}

	/**
	 * 编辑餐厅信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editRestaurant() throws Exception {
		// TODO Auto-generated method stub
		log.debug("edit Restaurant...");
		restaurant_kindVos = this.getOnlineOF().getRestaurant_kindManager()
				.getRestaurantKindAll();
		if (null != restaurantVo && null != restaurantVo.getRestaurantId()
				&& restaurantVo.getRestaurantId().length() > 0) {
			restaurantVo = this.getOnlineOF().getRestaurantManager()
					.getRestaurantById(restaurantVo.getRestaurantId());
		} else {
			restaurantVo = new RestaurantVo();
		}
		return SUCCESS;
	}

	/**
	 * 保存餐厅信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String savaRestaurant() throws Exception {
		// TODO Auto-generated method stub
		log.debug("sava Restaurant...");
		if (null != this.restaurantVo
				&& null != this.restaurantVo.getRestaurantId()
				&& this.restaurantVo.getRestaurantId().length() > 0) {
			// 处理修改餐厅信息
			if (this.resFile != null) {
				FileInputStream inputStream = new FileInputStream(this.resFile);
				restaurantVo.setImg(Hibernate.createBlob(inputStream));
			}
			this.getOnlineOF().getRestaurantManager().updateRestaurant(
					restaurantVo);
		} else {
			// 处理添加餐厅信息
			log.debug("size=" + this.resFile.length());
			restaurantVo.setRestaurantId(StringUtil.getUUID());
			FileInputStream inputStream = new FileInputStream(this.resFile);
			restaurantVo.setImg(Hibernate.createBlob(inputStream));
			this.getOnlineOF().getRestaurantManager().saveRestaurant(restaurantVo);
		}
		return this.getRestaurantPage();
	}

	/**
	 * 删除餐厅信息 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteRestaurant() throws Exception {
		// TODO Auto-generated method stub
		log.debug("delete restaurant...");
		if (null != restaurantVo && null != restaurantVo.getRestaurantId()
				&& restaurantVo.getRestaurantId().length() > 0) {
			this.getOnlineOF().getRestaurantManager().deleteRestaurant(
					restaurantVo.getRestaurantId());
		}
		if (null != checksItem && checksItem.length > 0) {
			for (String str : checksItem) {
				this.getOnlineOF().getRestaurantManager().deleteRestaurant(str);
			}
		}
		return this.getRestaurantPage();
	}

	/**
	 * 餐厅信息预览 comment here
	 * 
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String restaurantPreView() throws Exception {
		// TODO Auto-generated method stub
		if (null != restaurantVo && null != restaurantVo.getRestaurantId()) {
			restaurantVo = this.getOnlineOF().getRestaurantManager()
					.getRestaurantById(restaurantVo.getRestaurantId());
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

	public List<RestaurantVo> getRestaurantVos() {
		return restaurantVos;
	}

	public void setRestaurantVos(List<RestaurantVo> restaurantVos) {
		this.restaurantVos = restaurantVos;
	}

	public RestaurantVo getRestaurantVo() {
		return restaurantVo;
	}

	public void setRestaurantVo(RestaurantVo restaurantVo) {
		this.restaurantVo = restaurantVo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
	}

	public File getResFile() {
		return resFile;
	}

	public void setResFile(File resFile) {
		this.resFile = resFile;
	}

	public String getResFileFileName() {
		return resFileFileName;
	}

	public void setResFileFileName(String resFileFileName) {
		this.resFileFileName = resFileFileName;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public List<Restaurant_kindVo> getRestaurant_kindVos() {
		return restaurant_kindVos;
	}

	public void setRestaurant_kindVos(List<Restaurant_kindVo> restaurant_kindVos) {
		this.restaurant_kindVos = restaurant_kindVos;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
