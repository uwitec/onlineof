/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;


import com.cd_help.onlineOF.utils.PageBean;

/**
 * <b><code></code></b>
 * <p/>
 * 菜类别数据处理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface Food_kindDataDao extends BaseDao{
	/**
	 * 取餐厅菜分类信息
	 * comment here
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean seachFoodKindPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception ;
	/**
	 * 根据餐厅ID取分页信息
	 * comment here
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean seachFoodKindByRestaurantId(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception ;

}
