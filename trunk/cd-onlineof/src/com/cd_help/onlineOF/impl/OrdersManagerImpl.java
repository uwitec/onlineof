/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.OrdersDataDao;
import com.cd_help.onlineOF.api.OrdersManager;
import com.cd_help.onlineOF.data.OrdersData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("ordersManager")
@SuppressWarnings("unchecked")
public class OrdersManagerImpl implements OrdersManager{

	@Autowired
	@Resource(name="ordersDataDao")
	private OrdersDataDao ordersDataDao;
	
	public void create(OrdersVo ordersVo) throws AppException {
		OrdersData ordersData = new OrdersData();
		BeanUtilsHelp.copyProperties(ordersData, ordersVo);
		ordersDataDao.save(ordersData);
	}

	public OrdersVo get(Integer id) throws AppException {
		return null;
	}
	
	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(Session session) throws AppException{
		return true;
	}

	public void setOrdersDataDao(OrdersDataDao ordersDataDao) {
		this.ordersDataDao = ordersDataDao;
	}
}
