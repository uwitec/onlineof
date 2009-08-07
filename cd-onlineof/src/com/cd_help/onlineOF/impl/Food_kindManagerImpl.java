/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.Food_kindDataDao;
import com.cd_help.onlineOF.api.Food_kindManager;
import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Food_kindVo;

/**
 * <b><code></code></b> <p/> 饮食类别管理实现类 <p/> <b>Creation Time:</b> Jul 12,
 * 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("food_kindManager")
@Transactional(propagation = Propagation.REQUIRED)
public class Food_kindManagerImpl implements Food_kindManager {

	@Autowired
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
	 * 检查权限
	 * 
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unused")
	private boolean checkPrivilege(Session session) throws AppException {
		return true;
	}

	/**
	 * 删除菜分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#deleteFoodKind(java.lang.String)
	 */
	public void deleteFoodKind(String foodKindId) throws Exception {
		// TODO Auto-generated method stub
		Food_kindData food_kindData = (Food_kindData) food_kindDao.get(
				Food_kindData.class, foodKindId);
		if (null != food_kindData) {
			food_kindDao.delete(food_kindData);
		} else {
			throw new Exception("删除菜分类信息失败!");
		}
	}

	/**
	 * 根据ID查询菜分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#getFood_kindVoById(java.lang.String)
	 */
	public Food_kindVo getFood_kindVoById(String foodKindId) throws Exception {
		// TODO Auto-generated method stub
		Food_kindVo food_kindVo = new Food_kindVo();
		Food_kindData food_kindData = (Food_kindData) food_kindDao.get(
				Food_kindData.class, foodKindId);
		BeanUtilsHelp.copyProperties(food_kindVo, food_kindData);
		if (food_kindData.getRestaurant() != null) {
			food_kindVo.setRestaurantId(food_kindData.getRestaurant()
					.getRestaurantId());
			food_kindVo.setRestaurantName(food_kindData.getRestaurant()
					.getName());
		}
		return food_kindVo;
	}

	/**
	 * 保存菜分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#savaFoodKind(com.cd_help.onlineOF.web.vo.Food_kindVo)
	 */
	public void savaFoodKind(Food_kindVo food_kindVo) throws Exception {
		// TODO Auto-generated method stub
		Food_kindData food_kindData = new Food_kindData();
		BeanUtilsHelp.copyProperties(food_kindData, food_kindVo);
		if (food_kindVo.getRestaurantId() != null) {
			RestaurantData restaurantData = (RestaurantData) restaurantDataDao
					.get(RestaurantData.class, food_kindVo.getRestaurantId());
			food_kindData.setRestaurant(restaurantData);
		}
		food_kindDao.save(food_kindData);
	}

	/**
	 * 取菜分类的分页信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#seachFoodKindPage(java.lang.String,
	 *      java.lang.String[], java.lang.Object[],
	 *      com.cd_help.onlineOF.utils.PageBean,
	 *      com.cd_help.onlineOF.data.Session)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PageBean seachFoodKindPage(String hql, String[] params,
			Object[] objs, PageBean pageBean, Session session) throws Exception {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = food_kindDao.seachFoodKindPage(hql, params, objs, pageBean);
		} catch (Exception e) {
			throw new AppException("0000014", "加载菜分类分类信息出错!");
		}
		return page;
	}

	/**
	 * 修改菜分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#updateFoodKind(com.cd_help.onlineOF.web.vo.Food_kindVo)
	 */
	public void updateFoodKind(Food_kindVo food_kindVo) throws Exception {
		// TODO Auto-generated method stub
		Food_kindData food_kindData = (Food_kindData) food_kindDao.get(
				Food_kindData.class, food_kindVo.getFood_kind_Id());
		BeanUtilsHelp.copyProperties(food_kindData, food_kindVo);
		if (null != food_kindVo.getRestaurantId()) {
			RestaurantData restaurant = (RestaurantData) restaurantDataDao.get(
					RestaurantData.class, food_kindVo.getRestaurantId());
			food_kindData.setRestaurant(restaurant);
		}
	}

	@Override
	public PageBean seachFoodKindByRestaurantId(String hqlName,
			String[] paramName, Object[] condition, PageBean pageBean,
			Session sessio) throws Exception {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = food_kindDao.seachFoodKindByRestaurantId(hqlName, paramName,
					condition, pageBean);
		} catch (Exception e) {
			throw new AppException("0000014", "加载菜分类分类信息出错!");
		}
		return page;
	}
}
