/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.RestaurantManager;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
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
	@Autowired
	@Resource(name="restaurantManager")
	private RestaurantManager restaurantManager = null;
	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}
	
	@Resource(name = "pageBean")
	private PageBean pageBean = null;

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	private boolean success = true;
	/*餐厅信息集合*/
	private List<RestaurantVo> restaurantVos = null;
	/*餐厅信息*/
	private RestaurantVo restaurantVo = null;
	/* 当前页 */
	private int page = 1;
	/* 分类名称 */
	private String kindName;
	/* 删除餐厅分类的ID集合 */
	private String[] checksItem;
	/*餐厅图片*/
	private File resFile;
	/*餐厅图片文件名*/
	private String resFileFileName;
	/**
	 * 餐厅集合
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private List<RestaurantVo> restaurantList = new ArrayList<RestaurantVo>(); 
	
	/**
	 * 获取所有餐厅信息
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loadAllRestaurant() throws AppException{
		log.debug("--->> begin loadAll");
		try {
			restaurantList = this.getOnlineOF().getRestaurantManager().loadAll();
		} catch (Exception e) {
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * 加载餐厅分页信息
	 * comment here
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getRestaurantPage() throws Exception {
		// TODO Auto-generated method stub
		log.debug("load RestaurantPage...");
		String[] params = null;
		Object[] conditions = null;
		String hqlName = "";
		try{
			this.pageBean.setCurrentPage(page);
			this.pageBean.setPagesize(2);
			if(null == kindName || "".endsWith(kindName)){
				hqlName = "getRestaurantAllPage";
			}else{
				hqlName = "getRestaurantByKindName";
				params = new String[]{"kindName"};
				conditions = new Object[]{this.kindName};
			}
			this.pageBean = restaurantManager.getRestaurantPage(hqlName, params, conditions, pageBean);
			log.debug("pageBean.array.size="+this.getPageBean().getArray().size());
		}catch(Exception ex){
			ex.printStackTrace();
			throw new AppException("loadRestaurantPage","加载餐厅信息失败!");
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
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
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
}
