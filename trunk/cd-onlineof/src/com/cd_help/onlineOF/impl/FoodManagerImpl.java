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

import com.cd_help.onlineOF.api.FoodDataDao;
import com.cd_help.onlineOF.api.FoodManager;
import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.FoodVo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("foodManager")
@SuppressWarnings("unchecked")
public class FoodManagerImpl implements FoodManager{

	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "foodDataDao")
	private FoodDataDao foodDataDao;
	
	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#delete(java.lang.String)
	 */
	public void delete(String id) throws AppException {
		foodDataDao.delete(id);
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#exist(java.lang.String)
	 */
	public boolean exist(String id) throws AppException {
		return foodDataDao.exist(id);
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#get(java.lang.String)
	 */
	public FoodVo get(String id) throws AppException {
		return foodDataDao.get(id);
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#loadAll()
	 */
	public List<FoodVo> loadAll() throws AppException {
		return foodDataDao.loadAll();
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#save(com.cd_help.onlineOF.web.vo.FoodVo)
	 */
	public FoodVo save(FoodVo foodVo) throws AppException {
		return foodDataDao.save(foodVo);
	}

	/**
	 * @see com.cd_help.onlineOF.api.FoodManager#update(com.cd_help.onlineOF.web.vo.FoodVo)
	 */
	public void update(FoodVo foodVo) throws AppException {
		foodDataDao.update(foodVo);
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

	public void setFoodDataDao(FoodDataDao foodDataDao) {
		this.foodDataDao = foodDataDao;
	}
}
