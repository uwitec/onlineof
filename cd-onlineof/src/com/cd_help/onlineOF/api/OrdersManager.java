/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.OrdersItemVo;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface OrdersManager {

	/**
	 * 
	 * 删除订单
	 * 
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteOrders(UsersSession session, String id) throws AppException;

	/**
	 * 更新订单
	 * 
	 * @param ordersVo
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateOrders(UsersSession session, OrdersVo ordersVo)
			throws Exception;

	/**
	 * 根据ID获取订单
	 * 
	 * @param id
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersVo getOrder(UsersSession seesion, String id) throws Exception;

	/**
	 * 
	 * 根据订单ID获取訂單項List
	 * 
	 * @param ordersId
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<OrdersItemVo> loadAllFoods(UsersSession seesion,
			String ordersId) throws Exception;

	/**
	 * 生成订单
	 * 
	 * @param ordersVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void addOrder(UsersSession session, OrdersVo ordersVo,
			String memberId, String restaurantId, String[] foodIds,
			String[] nums) throws Exception;

	/**
	 * 今日訂單
	 * 
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @param seesion
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchTodayOrdersByPage(UsersSession seesion,
			OrdersVo ordersVo, PageBean pageBean) throws AppException;

	/**
	 * 歷史訂單
	 * 
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @param seesion
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchHistoryOrdersByPage(UsersSession seesion,
			OrdersVo ordersVo, String endTime, PageBean pageBean)
			throws AppException;
}
