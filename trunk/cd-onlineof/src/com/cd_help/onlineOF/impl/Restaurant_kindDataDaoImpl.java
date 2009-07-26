package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.Restaurant_kindDataDao;
import com.cd_help.onlineOF.data.Restaurant_kindData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Restaurant_kindVo;

@Service("restaurant_kindDataDao")
public class Restaurant_kindDataDaoImpl extends BaseDaoSupport implements Restaurant_kindDataDao {

	/**
	 * 餐厅分类取分页数据
	 * @see com.cd_help.onlineOF.api.Restaurant_kindDataDao#getRestaurantKindPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean)
	 */
	public PageBean getRestaurantKindPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws AppException {
		// TODO Auto-generated method stub
		pageBean = this.searchByPage(hqlName, paramName, condition, pageBean);
		List<Restaurant_kindVo> restaurantKindVos = new ArrayList<Restaurant_kindVo>();
		Restaurant_kindData restaurant_kind=null;
		Restaurant_kindVo restaurant_kindVo = null;
		for(Object obj : pageBean.getArray()){
			restaurant_kind = (Restaurant_kindData)obj;
			restaurant_kindVo = new Restaurant_kindVo();
			BeanUtilsHelp.copyProperties(restaurant_kindVo, restaurant_kind);
			restaurantKindVos.add(restaurant_kindVo);
		}
		pageBean.setArray(restaurantKindVos);
		return pageBean;
	}

}
