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
import com.cd_help.onlineOF.api.Food_kindDataDao;
import com.cd_help.onlineOF.api.Food_kindManager;
import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.struts.UsersSession;
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

	@Resource(name = "foodDataDao")
	private FoodDataDao foodDataDao;

	public void setFoodDataDao(FoodDataDao foodDataDao) {
		this.foodDataDao = foodDataDao;
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
	private boolean checkPrivilege(UsersSession session) throws AppException {
		return true;
	}

	/**
	 * 删除菜分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#deleteFoodKind(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void deleteFoodKind(String foodKindId) throws Exception {
		// TODO Auto-generated method stub
		Food_kindData food_kindData = (Food_kindData) food_kindDao.get(
				Food_kindData.class, foodKindId);
		if (null != food_kindData) {
			List<FoodData> foodDatas = foodDataDao
					.findByNamedQueryAndNamedParam("getFoodByKindId", "kindId",
							foodKindId);
			if (null != foodDatas && foodDatas.size() > 0) {
				for (FoodData food : foodDatas) {
					foodDataDao.delete(food);
				}
			}
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
		if (food_kindData.getRestaurantId() != null) {
			RestaurantData rstData = (RestaurantData) food_kindDao.get(
					RestaurantData.class, food_kindData.getRestaurantId());
			food_kindVo.setRestaurantId(rstData.getRestaurantId());
			food_kindVo.setRestaurantName(rstData.getName());
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
		food_kindDao.save(food_kindData);
	}

	/**
	 * 查询菜分类(All|restaurantId)的分页信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#seachFoodKindPage(java.lang.String,
	 *      java.lang.String[], java.lang.Object[],
	 *      com.cd_help.onlineOF.utils.PageBean,
	 *      com.cd_help.onlineOF.web.struts.UsersSession)
	 */
	@SuppressWarnings("unchecked")
	public PageBean seachFoodKindPage(String hqlName, String[] params,
			Object[] objs, PageBean pageBean, UsersSession session)
			throws Exception {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = food_kindDao.searchByPage(hqlName, params, objs, pageBean);
			if (null != page && null != page.getArray()) {
				List<Food_kindVo> food_kindVos = new ArrayList<Food_kindVo>();
				Food_kindData food_kind = null;
				Food_kindVo food_kindVo = null;
				for (Object obj : pageBean.getArray()) {
					food_kind = (Food_kindData) obj;
					food_kindVo = new Food_kindVo();
					BeanUtilsHelp.copyProperties(food_kindVo, food_kind);
					if (null != food_kind.getRestaurantId()
							&& !"".equals(food_kind.getRestaurantId())) {
						RestaurantData rstData = (RestaurantData) restaurantDataDao
								.get(RestaurantData.class, food_kind
										.getRestaurantId());
						food_kindVo.setRestaurantName(rstData.getName());
					}
					food_kindVos.add(food_kindVo);
				}
				page.setArray(food_kindVos);
			}
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
	}

	/**
	 * 根据餐厅ID
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindManager#getFoodKindByRestaurantId(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Food_kindVo> getFoodKindByRestaurantId(String restaurantId)
			throws Exception {
		// TODO Auto-generated method stub
		List<Food_kindVo> food_kindVos = null;
		food_kindVos = food_kindDao.findByNamedQueryAndNamedParam(
				"getFoodkindByRestaurantId", "restaurantId", restaurantId);
		if (null == food_kindVos) {
			food_kindVos = new ArrayList<Food_kindVo>();
		}
		return food_kindVos;
	}
}
