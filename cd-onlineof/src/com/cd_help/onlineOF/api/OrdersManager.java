/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.OrdersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 订单管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface OrdersManager {
	
	/**
	 * 根据ID获取订单
	 * @param id
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersVo get(Integer id) throws AppException;
	
	/**
	 * 生成订单
	 * @param ordersVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void create(OrdersVo ordersVo) throws AppException;

}
