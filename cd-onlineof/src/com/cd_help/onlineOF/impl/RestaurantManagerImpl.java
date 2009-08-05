/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.api.RestaurantManager;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b>
 * <p/>
 * 餐厅管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("restaurantManager")
public class RestaurantManagerImpl implements RestaurantManager{

	@Autowired
	@Resource(name = "restaurantDataDao")
	private RestaurantDataDao restaurantDataDao;
	public void setRestaurantDataDao(RestaurantDataDao restaurantDataDao) {
		this.restaurantDataDao = restaurantDataDao;
	}
	/**
	 * @throws AppException 
	 * @see com.cd_help.onlineOF.api.RestaurantManager#loadAll()
	 */
	public List<RestaurantVo> loadAll() throws AppException{
		List<RestaurantVo> restaurantList = null;
		try{
		    restaurantList = restaurantDataDao.loadAll();
		}catch(Exception e){
			throw new AppException("","加载出错!");
		}
		return restaurantList;
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RestaurantManager#save(com.cd_help.onlineOF.web.vo.RestaurantVo)
	 */
	public RestaurantVo save(RestaurantVo restaurantVo) throws AppException {
		try{
		  return restaurantDataDao.save(restaurantVo);
		}catch(Exception e){
			throw new AppException("","保存出错!");
		}
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RestaurantManager#delete(java.lang.String)
	 */
	public void delete(String id) throws AppException {
		try{
			restaurantDataDao.delete(restaurantDataDao.get(RestaurantData.class, id));
		}catch(Exception e){
			throw new AppException("","删除出错!");
		}
	}
	
	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unused")
	private boolean checkPrivilege(Session session) throws AppException{
		return true;
	}
	@Override
	public PageBean getRestaurantPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		// TODO Auto-generated method stub
		PageBean page = null;
		try {
			page = restaurantDataDao.getRestaurantPage(hqlName, paramName,
					condition, pageBean);
		} catch (AppException e) {
			throw new AppException("0000014", "加载餐厅分类信息出错!");
		}
		return page;
	}
	@Override
	public RestaurantVo getRestaurantById(String restaurantId) throws Exception {
		// TODO Auto-generated method stub
		if(restaurantId!=null && restaurantId.length() > 0){
			RestaurantVo restaurantVo = restaurantDataDao.get(restaurantId);
			return restaurantVo;
		}
		return null;
	}
	@Override
	public void updateRestaurant(RestaurantVo restaurantVo) throws Exception {
		// TODO Auto-generated method stub
		restaurantDataDao.update(restaurantVo);
	}
	
}
