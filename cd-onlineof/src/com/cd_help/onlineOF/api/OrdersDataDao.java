/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;

/**
 * <b><code></code></b>
 * <p/>
 * 订单数据处理接口
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface OrdersDataDao extends BaseDao {

	/**
	 * 
	 * 加载订单
	 * 
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchOrdersByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception;

}