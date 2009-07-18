/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.RestaurantVo;


/**
 * <b><code></code></b>
 * <p/>
 * 餐厅管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface RestaurantManager{
	/**
	 * 获取所有餐厅信息
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<RestaurantVo> loadAll() throws AppException;
	
	/**
	 * 保存
	 * @param restaurantVo
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RestaurantVo save(RestaurantVo restaurantVo) throws AppException;
	
	/**
	 * 删除
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void delete(String id) throws AppException;
}
