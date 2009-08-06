/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 餐厅类别管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface Restaurant_kindManager {
	/*添加餐厅分类信息*/
	public void addRestaurantKind(Restaurant_kindVo restaurantTypeVo)throws Exception;
	/*删除餐厅分类信息*/
	public void delRestaurantKind(String id)throws Exception;
	/*修改餐厅分类信息*/
	public void updRestaurantKind(Restaurant_kindVo restaurantTypeVo)throws Exception;
	/*根据ID返回餐厅分类信息*/
	public Restaurant_kindVo getRestaurantKindById(String id)throws Exception;
	/*返回集合餐厅分类信息的集合*/
	public List<Restaurant_kindVo> getRestaurantKindAll()throws Exception;
	/*查询分页信息*/
	public PageBean seachRestaurantKindPage(String qhl,String[] params,Object[] objs,PageBean pageBean,Session session)throws Exception;
	
}
