/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.OrdersDataDao;
import com.cd_help.onlineOF.data.OrdersData;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单数据处理接口实现类
 * 
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("ordersDataDao")
public class OrdersDataDaoImpl extends BaseDaoSupport implements OrdersDataDao {

	public PageBean searchOrdersByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		pageBean = this.searchByPage(hqlName, paramName, condition, pageBean);
		return pageBean;
	}

	@Override
	public boolean addOrder(OrdersVo ordersVo) throws Exception {
		OrdersData ordersData = new OrdersData();
		BeanUtilsHelp.copyProperties(ordersData, ordersVo);
		ordersData.setOrdersId(StringUtil.getUUID());
		this.save(ordersData);
		return true;
	}

}