/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.RestaurantDataDao;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.Restaurant_kindData;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
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
		System.out.println(restaurantVoList.size());
		for (RestaurantVo rv : restaurantVoList) {
			System.out.println(rv.getName());
		}
		return restaurantVoList;
	}

	public RestaurantVo get(String id) throws Exception {
		RestaurantData restaurantData = (RestaurantData) this.get(
				RestaurantData.class, id);
		RestaurantVo restaurantVo = new RestaurantVo();
		BeanUtilsHelp.copyProperties(restaurantVo, restaurantData);
		return restaurantVo;
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

	public RestaurantVo save(RestaurantVo restaurantVo) throws Exception {
		restaurantVo.setRestaurantId(StringUtil.getUUID());
		RestaurantData restaurantData = new RestaurantData();
		BeanUtilsHelp.copyProperties(restaurantData, restaurantVo);
		restaurantData.setRestaurant_kindId(restaurantVo.getResKindId());
		this.save(restaurantData);
		restaurantVo.setRestaurantId(restaurantData.getRestaurantId());
		return restaurantVo;
	}

	public void delete(String id) throws Exception {
		if (!this.exist(id)) {
			throw new Exception();
		} else {
			this.delete(this.get(RestaurantData.class, id));
		}
	}

	public void update(RestaurantVo restaurantVo) throws Exception {
		RestaurantData restaurantData = (RestaurantData) this.get(
				RestaurantData.class, restaurantVo.getRestaurantId());
		if (restaurantVo.getImg() == null) {
			restaurantVo.setImg(restaurantData.getImg());
		}
		BeanUtilsHelp.copyProperties(restaurantData, restaurantVo);
		restaurantData.setRestaurant_kindId(restaurantVo.getResKindId());
		this.update(restaurantData);
	}

	/**
	 * 取餐厅的分页信息
	 * 
	 * @see com.cd_help.onlineOF.api.RestaurantDataDao#getRestaurantPage(java.lang.String,
	 *      java.lang.String[], java.lang.Object[],
	 *      com.cd_help.onlineOF.utils.PageBean)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PageBean getRestaurantPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		// TODO Auto-generated method stub
		pageBean = this.searchByPage(hqlName, paramName, condition, pageBean);
		List<RestaurantVo> restaurantVos = null;
		RestaurantVo restaurantVo = null;
		RestaurantData restaurantData = null;
		if (pageBean.getArray() != null && pageBean.getArray().size() > 0) {
			restaurantVos = new ArrayList<RestaurantVo>();
			for (Object obj : pageBean.getArray()) {
				restaurantData = (RestaurantData) obj;
				restaurantVo = new RestaurantVo();
				BeanUtilsHelp.copyProperties(restaurantVo, restaurantData);
				if (restaurantData.getRestaurant_kindId() != null) {
					restaurantVo.setResKindId(restaurantData
							.getRestaurant_kindId());
					Restaurant_kindData restaurant_kindData = (Restaurant_kindData) super
							.get(Restaurant_kindData.class, restaurantData
									.getRestaurant_kindId());
					restaurantVo.setResKindName(restaurant_kindData.getName());
				}
				restaurantVos.add(restaurantVo);
			}
			pageBean.setArray(restaurantVos);
		}
		return pageBean;
	}
}
