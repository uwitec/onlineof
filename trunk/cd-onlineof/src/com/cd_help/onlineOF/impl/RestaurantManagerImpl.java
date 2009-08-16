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
import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.api.RestaurantManager;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.Restaurant_kindData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b> <p/> 餐厅管理实现类 <p/> <b>Creation Time:</b> Jul 4, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("restaurantManager")
@Transactional(propagation = Propagation.REQUIRED)
public class RestaurantManagerImpl implements RestaurantManager {

	@Autowired
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

	@Resource(name = "food_kindDao")
	private Food_kindDataDao food_kindDao = null;

	public void setFood_kindDao(Food_kindDataDao food_kindDao) {
		this.food_kindDao = food_kindDao;
	}

	/**
	 * @throws AppException
	 * @see com.cd_help.onlineOF.api.RestaurantManager#loadAll()
	 */
	public List<RestaurantVo> loadARestaurantAll() throws AppException {
		List<RestaurantVo> restaurantList = null;
		try {
			restaurantList = restaurantDataDao.loadAll();
		} catch (Exception e) {
			throw new AppException("", "加载出错!");
		}
		return restaurantList;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RestaurantManager#save(com.cd_help.onlineOF.web.vo.RestaurantVo)
	 */
	public RestaurantVo saveRestaurant(RestaurantVo restaurantVo) throws AppException {
		try {
			RestaurantData restaurantData = new RestaurantData();
			BeanUtilsHelp.copyProperties(restaurantData, restaurantVo);
			restaurantData.setRestaurant_kindId(restaurantVo.getResKindId());
			restaurantDataDao.save(restaurantData);
			restaurantVo.setRestaurantId(restaurantData.getRestaurantId());
			return restaurantVo;
		} catch (Exception e) {
			throw new AppException("", "保存出错!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.RestaurantManager#delete(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void deleteRestaurant(String id) throws AppException {
		try {
			RestaurantData restaurantData = (RestaurantData) restaurantDataDao
					.get(RestaurantData.class, id);
			List<Food_kindData> food_kinds = food_kindDao
					.findByNamedQueryAndNamedParam("getFoodkindByRestaurantId",
							"restaurantId", id);
			//删除餐厅下的所有菜分类
			if (null != food_kinds && food_kinds.size() > 0) {
				for (Food_kindData fk : food_kinds) {
					if (fk != null) {
						List<FoodData> foodDatas = foodDataDao
								.findByNamedQueryAndNamedParam(
										"getFoodByKindId", "kindId", fk
												.getFood_kind_Id());
						//删除分类下的所有菜
						if (null != foodDatas && foodDatas.size() > 0) {
							for (FoodData food : foodDatas) {
								foodDataDao.delete(food);
							}
						}
						food_kindDao.delete(fk);
					}
				}
			}
			
			restaurantDataDao.delete(restaurantData);
		} catch (Exception e) {
			throw new AppException("", "删除出错!");
		}
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

	@Override
	public PageBean seachRestaurantPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean,UsersSession session) throws AppException {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = restaurantDataDao.searchByPage(hqlName, paramName,
					condition, pageBean);
			List<RestaurantVo> restaurantVos = null;
			RestaurantVo restaurantVo = null;
			RestaurantData restaurantData = null;
			if (page.getArray() != null && page.getArray().size() > 0) {
				restaurantVos = new ArrayList<RestaurantVo>();
				for (Object obj : page.getArray()) {
					restaurantData = (RestaurantData) obj;
					restaurantVo = new RestaurantVo();
					BeanUtilsHelp.copyProperties(restaurantVo, restaurantData);
					if (null != restaurantData.getRestaurant_kindId()
							&& !""
									.equals(restaurantData
											.getRestaurant_kindId())) {
						restaurantVo.setResKindId(restaurantData
								.getRestaurant_kindId());
						Restaurant_kindData restaurant_kindData = (Restaurant_kindData) restaurantDataDao
								.get(Restaurant_kindData.class, restaurantData
										.getRestaurant_kindId());
						restaurantVo.setResKindName(restaurant_kindData
								.getName());
					}
					restaurantVos.add(restaurantVo);
				}
				page.setArray(restaurantVos);
			}
		} catch (Exception e) {
			throw new AppException("0000014", "加载餐厅分类信息出错!");
		}
		return page;
	}

	@Override
	public RestaurantVo getRestaurantById(String restaurantId)
			throws AppException {
		try {
			if (restaurantId != null && restaurantId.length() > 0) {
				RestaurantData restaurantData = (RestaurantData) restaurantDataDao
						.get(RestaurantData.class, restaurantId);
				RestaurantVo restaurantVo = new RestaurantVo();
				BeanUtilsHelp.copyProperties(restaurantVo, restaurantData);
				restaurantVo
						.setResKindId(restaurantData.getRestaurant_kindId());
				return restaurantVo;
			}
			return null;
		} catch (Exception e) {
			throw new AppException("", e.getMessage(), e);
		}
	}

	@Override
	public void updateRestaurant(RestaurantVo restaurantVo) throws AppException {
		try {
			RestaurantData restaurantData = (RestaurantData) restaurantDataDao
					.get(RestaurantData.class, restaurantVo.getRestaurantId());
			if (restaurantVo.getImg() == null) {
				restaurantVo.setImg(restaurantData.getImg());
			}
			BeanUtilsHelp.copyProperties(restaurantData, restaurantVo);
			restaurantData.setRestaurant_kindId(restaurantVo.getResKindId());
			restaurantDataDao.update(restaurantData);
		} catch (Exception e) {
			throw new AppException("", e.getMessage(), e);
		}
	}

}
