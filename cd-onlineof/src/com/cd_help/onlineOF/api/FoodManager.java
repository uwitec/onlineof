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
import com.cd_help.onlineOF.web.vo.FoodVo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席管理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface FoodManager {

    /**
     * 加载所有
     * @return
     * @throws AppException
     * @since cd_help-onlineOF 0.0.0.1
     */
    public List<FoodVo> loadFoodAll() throws AppException;
	
	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo getFoodById(String id) throws AppException;
	
	/**
	 * 保存
	 * @param foodVo
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo saveFood(FoodVo foodVo) throws AppException;
	
	/**
	 * 判断是否存在
	 * @param id
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public boolean existFood(String id) throws AppException;
	
	/**
	 * 删除
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteFood(String id) throws AppException;
	
	/**
	 * 修改
	 * @param foodVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateFood(FoodVo foodVo) throws AppException;
	
	/**
	 * 查询菜分页信息
	 * comment here
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param pageBean
	 * @param session
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean seachFoodPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean,UsersSession session)throws AppException;
	
	/**
	 * 根据餐厅ID获取招牌饮食
	 * @param restaurantId
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<FoodVo> getSignFoodsByRestaurantId(String restaurantId) throws AppException;
	
	/**
	 * 获取招牌饮食
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<FoodVo> getSignFoods() throws AppException;
	
}
