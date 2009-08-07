/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.FoodDataDao;
import com.cd_help.onlineOF.api.FoodManager;
import com.cd_help.onlineOF.api.Food_kindDataDao;
import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.FoodVo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("foodManager")
@Transactional(propagation=Propagation.REQUIRED)
public class FoodManagerImpl implements FoodManager{

	@Autowired
	@Resource(name = "foodDataDao")
	private FoodDataDao foodDataDao;
	public void setFoodDataDao(FoodDataDao foodDataDao) {
		this.foodDataDao = foodDataDao;
	}
	@Resource(name = "food_kindDao")
	private Food_kindDataDao food_kindDao = null;

	public void setFood_kindDao(Food_kindDataDao food_kindDao) {
		this.food_kindDao = food_kindDao;
	}
	@Resource(name = "restaurantDataDao")
	private RestaurantDataDao restaurantDataDao;

	public void setRestaurantDataDao(RestaurantDataDao restaurantDataDao) {
		this.restaurantDataDao = restaurantDataDao;
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#delete(java.lang.String)
	 */
	public void delete(String id) throws AppException {
		try{
			foodDataDao.delete(id);
		}catch(Exception e){
			throw new AppException("","删除出错!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#exist(java.lang.String)
	 */
	public boolean exist(String id) throws AppException {
		boolean bool = false;
		try{
			bool = foodDataDao.exist(id);
		}catch(Exception e){
			throw new AppException("","系统错误!");
		}
		return bool;
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#get(java.lang.String)
	 */
	public FoodVo get(String id) throws AppException {
		FoodVo foodVo = null;
		try{
			foodVo = foodDataDao.get(id);
		}catch(Exception e){
			throw new AppException("","系统错误!");
		}
		return foodVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#loadAll()
	 */
	public List<FoodVo> loadAll() throws AppException {
		List<FoodVo> foodVos = null;
		try{
			foodVos = foodDataDao.loadAll();
		}catch(Exception e){
			throw new AppException("","系统错误!");
		}
		return foodVos;
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#save(com.cd_help.onlineOF.web.vo.FoodVo)
	 */
	public FoodVo save(FoodVo foodVo) throws AppException {
		FoodVo fv = null;
		try{
			fv = foodDataDao.save(foodVo);
		}catch(Exception e){
			throw new AppException("","保存出错!");
		}
		return fv;
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#update(com.cd_help.onlineOF.web.vo.FoodVo)
	 */
	public void update(FoodVo foodVo) throws AppException {
		try{
			foodDataDao.update(foodVo);
		}catch(Exception e){
			throw new AppException("","更新出错!");
		}
	}
	
	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unused")
	private boolean checkPrivilege(Session session) throws AppException{
		return true;
	}

	/**
	 * 获取菜的分页信息
	 * @see com.cd_help.onlineOF.api.FoodManager#seachFoodPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean, com.cd_help.onlineOF.data.Session)
	 */
	public PageBean seachFoodPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, Session session)
			throws Exception {
		// TODO Auto-generated method stub
		PageBean page = null;
		page = foodDataDao.searchByPage(hqlName, paramName, condition, pageBean);
		if(null!=page && null!=page.getArray()){
			List<FoodVo> foodVos = new ArrayList<FoodVo>();
			FoodVo foodVo = null;
			FoodData food = null;
			for(Object obj:page.getArray()){
				foodVo = new FoodVo();
				food = (FoodData)obj;
				BeanUtilsHelp.copyProperties(foodVo, food);
				if(food.getFood_kindId()!=null){
					Food_kindData food_kindData = (Food_kindData) food_kindDao.get(Food_kindData.class, food.getFood_kindId());
					foodVo.setFood_kind_Id(food_kindData.getFood_kind_Id());
					foodVo.setFood_kind_Name(food_kindData.getName());
					RestaurantData restaurantData = (RestaurantData) restaurantDataDao.get(RestaurantData.class, food_kindData.getRestaurantId());
					foodVo.setRestaurantId(restaurantData.getRestaurantId());
					foodVo.setRestaurantName(restaurantData.getName());
				}
				foodVos.add(foodVo);
			}
			page.setArray(foodVos);
		}
		return page;
	}
}
