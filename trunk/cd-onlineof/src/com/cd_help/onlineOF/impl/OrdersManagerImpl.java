/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.OrdersDataDao;
import com.cd_help.onlineOF.api.OrdersManager;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.OrdersData;
import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.ConvertUtils;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单管理实现类 超級管理員：查詢所有訂單， 酒店管理員：查詢自家酒店訂單， 訂單查詢附加：按酒店名、用戶名、訂餐人、訂單狀態、時間段查詢
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

	public void create(OrdersVo ordersVo) throws AppException {
		try {
			ordersDataDao.addOrder(ordersVo);
		} catch (Exception e) {
			throw new AppException("", "系统错误!");
		}
	}

	public OrdersVo get(Integer id) throws AppException {
		return null;
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

	@Override
	public PageBean searchHistoryOrdersByPage(OrdersVo ordersVo,
			String endTime, PageBean pageBean, UsersSession seesion)
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
		return ordersDataSwitchVo(pageBean);
	}

	@Override
	public PageBean searchTodayOrdersByPage(OrdersVo ordersVo,
			PageBean pageBean, UsersSession seesion) throws AppException {
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
		return ordersDataSwitchVo(pageBean);
	}

	/**
	 * 
	 * data转vo
	 * 
	 * @param pageBean
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private PageBean ordersDataSwitchVo(PageBean pageBean) {
		List<OrdersVo> ordersList = new ArrayList<OrdersVo>();
		OrdersData orderData = null;
		OrdersVo orders = null;
		for (Object obj : pageBean.getArray()) {
			orderData = (OrdersData) obj;
			orders = new OrdersVo();
			try {
				System.out.println(orderData.getOrdersDate().toString());
				BeanUtilsHelp.copyProperties(orders, orderData);
			} catch (AppException e) {
			}
			if (null != orderData.getFoodList()
					&& orderData.getFoodList().size() > 0) {
				double total = 0D;
				for (Iterator<FoodData> iterator = orderData.getFoodList()
						.iterator(); iterator.hasNext();) {
					FoodData foodData = (FoodData) iterator.next();
					total += foodData.getPrice();
				}
				orders.setTotalPrice(total);
			}
			orders.setLoginName(orderData.getMemberData().getLoginname());
			ordersList.add(orders);
		}
		pageBean.setArray(ordersList);
		return pageBean;
	}
}