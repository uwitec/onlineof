/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.Restaurant_kindDataDao;
import com.cd_help.onlineOF.api.Restaurant_kindManager;
import com.cd_help.onlineOF.data.Restaurant_kindData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * <b><code></code></b> <p/> 餐厅类别管理实现类 <p/> <b>Creation Time:</b> Jul 12,
 * 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("restaurant_kindManager")
@SuppressWarnings("unchecked")
public class Restaurant_kindManagerImpl implements Restaurant_kindManager {

	/**
	 * 检查权限
	 * 
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(Session session) throws AppException {
		return true;
	}

	@Autowired
	@Resource(name = "restaurant_kindDataDao")
	private Restaurant_kindDataDao restaurant_kindDataDao = null;

	public void setRestaurant_kindDataDao(
			Restaurant_kindDataDao restaurant_kindDataDao) {
		this.restaurant_kindDataDao = restaurant_kindDataDao;
	}

	/**
	 * 餐厅实体对象到值对象 comment here
	 * 
	 * @param restaurantType
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected Restaurant_kindVo getRestaurantTypeVo(
			Restaurant_kindData restaurantType) throws AppException {
		Restaurant_kindVo restaurantTypeVo = new Restaurant_kindVo();
		try {
			BeanUtils.copyProperties(restaurantTypeVo, restaurantType);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		}
		return restaurantTypeVo;
	}

	/**
	 * 值对象到实体对象 comment here
	 * 
	 * @param restaurantTypeVo
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected Restaurant_kindData getRestaurantTypeData(
			Restaurant_kindVo restaurantTypeVo) throws AppException {
		Restaurant_kindData restaurantTypeData = new Restaurant_kindData();
		try {
			BeanUtils.copyProperties(restaurantTypeData, restaurantTypeVo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		}
		return restaurantTypeData;
	}

	/**
	 * 添加餐厅分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantTypeManager#addRestaurantType(com.cd_help.onlineOF.web.vo.Restaurant_kindVo)
	 */
	public void addRestaurantType(Restaurant_kindVo restaurantTypeVo)
			throws AppException {
		// TODO Auto-generated method stub
		Restaurant_kindData restaurantTypeData = this
				.getRestaurantTypeData(restaurantTypeVo);
		restaurant_kindDataDao.save(restaurantTypeData);
	}

	/**
	 * 删除餐厅分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantTypeManager#delRestaurantType(java.lang.String)
	 */
	public void delRestaurantType(String id) throws AppException {
		// TODO Auto-generated method stub
		Restaurant_kindData restaurantTypeData = (Restaurant_kindData) restaurant_kindDataDao
				.get(Restaurant_kindData.class, id);
		restaurant_kindDataDao.delete(restaurantTypeData);
	}

	/**
	 * 查询所有的餐厅分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantTypeManager#getRestaurantTypeAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant_kindVo> getRestaurantTypeAll() throws AppException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		List<Restaurant_kindData> restaurantTypes = restaurant_kindDataDao
				.find("from RestaurantTypeData");
		List<Restaurant_kindVo> restaurantTypeVos = null;
		if (restaurantTypes != null && restaurantTypes.size() > 0) {
			restaurantTypeVos = new ArrayList<Restaurant_kindVo>();
			for (Restaurant_kindData restaurantTypeData : restaurantTypes) {
				restaurantTypeVos.add(this
						.getRestaurantTypeVo(restaurantTypeData));
			}
		}
		return restaurantTypeVos;
	}

	/**
	 * 根据ID查询餐厅分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantTypeManager#getRestaurantTypeById(java.lang.String)
	 */
	public Restaurant_kindVo getRestaurantTypeById(String id)
			throws AppException {
		// TODO Auto-generated method stub
		Restaurant_kindData restaurantTypeData = (Restaurant_kindData) restaurant_kindDataDao
				.get(Restaurant_kindData.class, id);
		return this.getRestaurantTypeVo(restaurantTypeData);
	}

	/**
	 * 修改餐厅分类信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantTypeManager#updRestaurantType(com.cd_help.onlineOF.web.vo.Restaurant_kindVo)
	 */
	public void updRestaurantType(Restaurant_kindVo restaurantTypeVo)
			throws AppException {
		// TODO Auto-generated method stub
		Restaurant_kindData restaurantTypeData = (Restaurant_kindData) restaurant_kindDataDao
				.get(Restaurant_kindData.class, restaurantTypeVo
						.getRestaurant_kind_Id());
		restaurantTypeVo.setCreateTime(restaurantTypeData.getCreateTime());
		try {
			BeanUtils.copyProperties(restaurantTypeData, restaurantTypeVo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("rpexception0001", "数据转换异常!");
		}
	}

	/**
	 * 查询分页数据
	 * 
	 * @see com.cd_help.onlineOF.api.Restaurant_kindManager#getRestaurantKindPage(java.lang.String,
	 *      java.lang.String[], java.lang.Object[],
	 *      com.cd_help.onlineOF.data.Session)
	 */
	public PageBean getRestaurantKindPage(String qhl, String[] params,
			Object[] objs, PageBean pageBean, Session session)
			throws AppException {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = restaurant_kindDataDao.getRestaurantKindPage(qhl, params,
					objs, pageBean);
		} catch (AppException e) {
			throw new AppException("0000014", "加载餐厅分类信息出错!");
		}
		return page;
	}
}