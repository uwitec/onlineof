/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.OrdersDataDao;
import com.cd_help.onlineOF.api.OrdersManager;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.MemberData;
import com.cd_help.onlineOF.data.OrdersData;
import com.cd_help.onlineOF.data.OrdersItemData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.ConvertUtils;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.PropertiesFinalValue;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.OrdersItemVo;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("ordersManager")
@Transactional
public class OrdersManagerImpl implements OrdersManager {

	@Autowired
	@Resource(name = "ordersDataDao")
	private OrdersDataDao ordersDataDao;

	/**
	 * 添加订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#create(com.cd_help.onlineOF.data.UsersSession,
	 *      com.cd_help.onlineOF.web.vo.OrdersVo, java.lang.String,
	 *      java.lang.String, java.lang.String[], java.lang.String[])
	 */
	public void create(UsersSession session, OrdersVo ordersVo,
			String memberId, String restaurantId, String[] foodIds,
			String[] nums) throws AppException {
		List<OrdersItemData> oitemList = new ArrayList<OrdersItemData>();
		OrdersItemData ordersItemData = null;
		OrdersData ordersData = new OrdersData();
		// 生成订单项集合
		for (int i = 0; i < foodIds.length; i++) {
			ordersItemData = new OrdersItemData();
			ordersItemData.setOrders_itemId(StringUtil.getUUID());
			ordersItemData.setNum(new Integer(nums[i]));
			try {
				ordersItemData.setFoodData((FoodData) ordersDataDao.get(
						FoodData.class, foodIds[i]));
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException("", "系统错误!");
			}
			oitemList.add(ordersItemData);
		}
		BeanUtilsHelp.copyProperties(ordersData, ordersVo);
		ordersData.setOrdersDate(new Date());
		ordersData.setItemData(oitemList);
		ordersData.setOrdersId(StringUtil.getUUID());
		try {
			ordersData.setRestaurantData((RestaurantData) ordersDataDao.get(
					RestaurantData.class, restaurantId));
			ordersData.setMemberData((MemberData) ordersDataDao.get(
					MemberData.class, memberId));
			ordersDataDao.save(ordersData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("", "系统错误!");
		}
	}

	/**
	 * 删除订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#delte(java.lang.String)
	 */
	public void delte(UsersSession session, String id) throws AppException {
		OrdersData ordersData = null;
		if (checkPrivilege(session)) {
			try {
				ordersData = (OrdersData) this.ordersDataDao.get(
						OrdersData.class, id);
				this.ordersDataDao.delete(ordersData);
			} catch (Exception e) {
				throw new AppException("", "系统错误");
			}
		}
	}

	/**
	 * 更新订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#update(com.cd_help.onlineOF.web.vo.OrdersVo)
	 */
	public void update(UsersSession seesion, OrdersVo ordersVo)
			throws AppException {
		OrdersData ordersData;
		try {
			ordersData = (OrdersData) ordersDataDao.get(OrdersData.class,
					ordersVo.getOrdersId());
		} catch (Exception e1) {
			throw new AppException("", "系统错误");
		}
		if (!ordersData.getStatus().equals(ordersVo.getStatus())) {
			ordersData.setStatus(ordersVo.getStatus());
			try {
				ordersDataDao.update(ordersData);
			} catch (Exception e) {
				throw new AppException("", "系统错误!");
			}
		}
	}

	/**
	 * 获取订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#get(java.lang.String)
	 */
	public OrdersVo get(UsersSession seesion, String id) throws AppException {
		OrdersData ordersData = null;
		try {
			ordersData = (OrdersData) ordersDataDao.get(OrdersData.class, id);
		} catch (Exception e) {
			throw new AppException("", "系统错误");
		}
		return ordersDataSwitchVo(ordersData);
	}

	/**
	 * 根据订单ID获取foodList
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#searchFoodListByOrderId(java.lang.String)
	 */
	@Override
	public List<OrdersItemVo> searchFoodListByOrderId(UsersSession seesion,
			String ordersId) throws Exception {
		OrdersData ordersData = null;
		try {
			ordersData = (OrdersData) ordersDataDao.get(OrdersData.class,
					ordersId);
		} catch (Exception e) {
			throw new AppException("", "系统错误");
		}
		if (null == ordersData.getItemData()
				|| ordersData.getItemData().size() == 0) {
			return null;
		}
		List<OrdersItemVo> oitemVOs = new ArrayList<OrdersItemVo>();
		OrdersItemData oitemData = null;
		OrdersItemVo oItemVo = null;
		FoodData foodData = null;
		for (Iterator<OrdersItemData> iterator = ordersData.getItemData()
				.iterator(); iterator.hasNext();) {
			oitemData = (OrdersItemData) iterator.next();
			foodData = oitemData.getFoodData();
			oItemVo = new OrdersItemVo();
			BeanUtilsHelp.copyProperties(oItemVo, oitemData);
			oItemVo.setFoodId(foodData.getFoodId());
			oItemVo.setName(foodData.getName());
			oItemVo.setPrice(foodData.getPrice());
			oItemVo.setKindName(((Food_kindData) ordersDataDao.get(
					Food_kindData.class, foodData.getFood_kindId())).getName());
			oitemVOs.add(oItemVo);
		}
		return oitemVOs;
	}

	/**
	 * 查询历史订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#searchHistoryOrdersByPage(com.cd_help.onlineOF.web.vo.OrdersVo,
	 *      java.lang.String, com.cd_help.onlineOF.utils.PageBean,
	 *      com.cd_help.onlineOF.data.Session)
	 */
	@Override
	public PageBean searchHistoryOrdersByPage(UsersSession seesion,
			OrdersVo ordersVo, String endTime, PageBean pageBean)
			throws AppException {
		String hql = "";
		String[] paramName = null;
		Object[] condition = null;
		if (seesion.getUsersVo().getIsSuper().equals(1)) {
			if (null != endTime && (!endTime.equals(""))) {
				hql = "adminSearchOrdersByTimetamp";
				paramName = new String[] { "memberName", "status", "resName",
						"start", "end" };
				condition = new Object[] {
						StringUtil.hqlParamLike(ordersVo.getLoginName()),
						StringUtil.hqlParamLike(ordersVo.getStatus()),
						StringUtil.hqlParamLike(ordersVo.getRestaurantName()),
						ConvertUtils.toDate3(ordersVo.getOrdersDate()),
						ConvertUtils.toDate3(endTime) };
			} else {
				hql = "adminSearchHistoryOrders";
				paramName = new String[] { "memberName", "status", "resName",
						"odate" };
				condition = new Object[] {
						StringUtil.hqlParamLike(ordersVo.getLoginName()),
						StringUtil.hqlParamLike(ordersVo.getStatus()),
						StringUtil.hqlParamLike(ordersVo.getRestaurantName()),
						StringUtil.getDateByInt(0) };
			}
		} else {
			if (null != endTime && (!endTime.equals(""))) {
				hql = "searchOrdersByTimetamp";
				paramName = new String[] { "memberName", "status", "start",
						"end" };
				condition = new Object[] {
						StringUtil.hqlParamLike(ordersVo.getLoginName()),
						StringUtil.hqlParamLike(ordersVo.getStatus()),
						ConvertUtils.toDate3(ordersVo.getOrdersDate()),
						ConvertUtils.toDate3(endTime) };
			} else {
				hql = "searchHistoryOrders";
				paramName = new String[] { "memberName", "status", "odate" };
				condition = new Object[] {
						StringUtil.hqlParamLike(ordersVo.getLoginName()),
						StringUtil.hqlParamLike(ordersVo.getStatus()),
						StringUtil.getDateByInt(0) };
			}
		}

		try {
			pageBean = ordersDataDao.searchOrdersByPage(hql, paramName,
					condition, pageBean);
		} catch (Exception e) {
			throw new AppException("", "系统错误！");
		}
		return getOrdersVoPageBean(pageBean);
	}

	/**
	 * 查询今日订单
	 * 
	 * @see com.cd_help.onlineOF.api.OrdersManager#searchTodayOrdersByPage(com.cd_help.onlineOF.web.vo.OrdersVo,
	 *      com.cd_help.onlineOF.utils.PageBean,
	 *      com.cd_help.onlineOF.data.Session)
	 */
	@Override
	public PageBean searchTodayOrdersByPage(UsersSession seesion,
			OrdersVo ordersVo, PageBean pageBean) throws AppException {
		String hql = "";
		String[] paramName = null;
		Object[] condition = null;
		if (seesion.getUsersVo().getIsSuper().equals(1)) {
			hql = "adminSearchTodayOrders";
			paramName = new String[] { "memberName", "status", "resName",
					"odate" };
			condition = new Object[] {
					StringUtil.hqlParamLike(ordersVo.getLoginName()),
					StringUtil.hqlParamLike(ordersVo.getStatus()),
					StringUtil.hqlParamLike(ordersVo.getRestaurantName()),
					StringUtil.getDateByInt(-1) };
		} else {
			hql = "searchTodayOrders";
			paramName = new String[] { "memberName", "status", "odate" };
			condition = new Object[] {
					StringUtil.hqlParamLike(ordersVo.getLoginName()),
					StringUtil.hqlParamLike(ordersVo.getStatus()),
					StringUtil.getDateByInt(-1) };
		}
		try {
			pageBean = ordersDataDao.searchOrdersByPage(hql, paramName,
					condition, pageBean);
		} catch (Exception e) {
			throw new AppException("", "系统错误！");
		}
		return getOrdersVoPageBean(pageBean);
	}

	/**
	 * 
	 * pageBean.array data转vo
	 * 
	 * @param pageBean
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unchecked")
	private PageBean getOrdersVoPageBean(PageBean pageBean) {
		List<OrdersVo> ordersList = new ArrayList<OrdersVo>();
		OrdersData orderData = null;
		for (Iterator iterator = pageBean.getArray().iterator(); iterator
				.hasNext();) {
			orderData = (OrdersData) iterator.next();
			ordersList.add(ordersDataSwitchVo(orderData));
		}
		pageBean.setArray(ordersList);
		return pageBean;
	}

	/**
	 * 
	 * OrdersData 转 OrdersVo
	 * 
	 * @param ordersData
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private OrdersVo ordersDataSwitchVo(OrdersData ordersData) {
		if (null == ordersData) {
			return null;
		}
		OrdersVo ordersVo = new OrdersVo();
		try {
			BeanUtilsHelp.copyProperties(ordersVo, ordersData);
		} catch (AppException e) {
		}
		if (null != ordersData.getItemData()
				&& ordersData.getItemData().size() > 0) {
			double total = 0D;
			OrdersItemData ordersItemData = null;
			for (Iterator<OrdersItemData> iterator = ordersData.getItemData()
					.iterator(); iterator.hasNext();) {
				ordersItemData = (OrdersItemData) iterator.next();
				total = total
						+ (ordersItemData.getFoodData().getPrice() * ordersItemData
								.getNum()) + PropertiesFinalValue.TIP;
			}
			ordersVo.setTotalPrice(total);
		}
		ordersVo.setRestaurantName(ordersData.getRestaurantData().getName());
		ordersVo.setLoginName(ordersData.getMemberData().getLoginname());
		return ordersVo;
	}

	/**
	 * 检查权限
	 * 
	 * @param session
	 * @return
	 * @throws AppAppAppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(UsersSession session) throws AppException {
		if (null == session.getUsersVo()) {
			return false;
		}
		return true;
	}

	public void setOrdersDataDao(OrdersDataDao ordersDataDao) {
		this.ordersDataDao = ordersDataDao;
	}
}