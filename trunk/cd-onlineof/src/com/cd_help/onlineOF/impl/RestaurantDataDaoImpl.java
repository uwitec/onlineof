/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.web.vo.RestaurantVo;

/**
 * <b><code></code></b> <p/> 餐厅数据处理实现类 <p/> <b>Creation Time:</b> Jul 4,
 * 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("restaurantDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class RestaurantDataDaoImpl extends BaseDaoSupport implements
		RestaurantDataDao {

	/**
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantDataDao#loadAll()
	 */
	public List<RestaurantVo> loadAll() throws Exception {
		List<RestaurantVo> restaurantVoList = this
				.findByNamedQuery("loadAllRestaurant");
//		System.out.println(restaurantVoList.size());
//		for (RestaurantVo rv : restaurantVoList) {
//			System.out.println(rv.getName());
//		}
		return restaurantVoList;
	}

	/**
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantDataDao#exist(java.lang.String)
	 */

	public boolean exist(String id) throws Exception {
		RestaurantData restaurantData = (RestaurantData) getHibernateTemplate()
				.get(RestaurantData.class, id);
		return restaurantData == null ? false : true;
	}


	public void delete(String id) throws Exception {
		if (!this.exist(id)) {
			throw new Exception();
		} else {
			this.delete(this.get(RestaurantData.class, id));
		}
	}
}
