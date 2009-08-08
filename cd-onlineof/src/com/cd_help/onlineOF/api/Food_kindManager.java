/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Food_kindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 菜类别管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface Food_kindManager {
	/**
	 * 取餐厅菜的分类信息
	 * comment here
	 * @param qhl
	 * @param params
	 * @param objs
	 * @param pageBean
	 * @param session
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean seachFoodKindPage(String qhl,String[] params,Object[] objs,PageBean pageBean,Session session)throws Exception;
	/**
	 * 添加菜分类信息
	 * comment here
	 * @param food_kindVo
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void savaFoodKind(Food_kindVo food_kindVo)throws Exception;
	/**
	 * 删除菜分类信息
	 * comment here
	 * @param foodKindId
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteFoodKind(String foodKindId)throws Exception;
	/**
	 * 修改菜分类信息
	 * comment here
	 * @param food_kindVo
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateFoodKind(Food_kindVo food_kindVo)throws Exception;
	/**
	 * 根据ID查询菜分类信息
	 * comment here
	 * @param foodKindId
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Food_kindVo getFood_kindVoById(String foodKindId)throws Exception;
	
	/**
	 * 根据餐厅ID返回菜分类集合
	 * comment here
	 * @param restaurantId
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<Food_kindVo> getFoodKindByRestaurantId(String restaurantId)throws Exception;
}
