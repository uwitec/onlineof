package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.Food_kindDataDao;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.Food_kindVo;

@Service("food_kindDao")
@Transactional(propagation=Propagation.REQUIRED)
public class Food_kindDataDaoImpl extends BaseDaoSupport implements
		Food_kindDataDao {
	/**
	 * 查询菜分类的分页信息
	 * 
	 * @see com.cd_help.onlineOF.api.Food_kindDataDao#seachFoodKindPage(java.lang.String,
	 *      java.lang.String[], java.lang.Object[],
	 *      com.cd_help.onlineOF.utils.PageBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public PageBean seachFoodKindPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		// TODO Auto-generated method stub
		if(null!=paramName && paramName.length > 0 ){
			pageBean = this.searchByPage(hqlName, paramName, condition, pageBean);
			String hql = "select new com.cd_help.onlineOF.web.vo.Food_kindVo(fk.food_kind_Id,fk.name,fk.description,r.restaurantId,r.name) from Food_kindData fk join fk.restaurant r where fk.name like '"
				+ condition[0] + "' and r.name like '" + condition[1]+"'";
			List<Food_kindVo> food_kindVos = super.find(hql,
					(pageBean.getCurrentPage() - 1)
							* pageBean.getPagesize(), pageBean
							.getPagesize());
			pageBean.setArray(food_kindVos);
		}else{
			pageBean = this.searchByPage(hqlName, paramName, condition, pageBean);
			List<Food_kindVo> food_kindVos = new ArrayList<Food_kindVo>();
			Food_kindData food_kind = null;
			Food_kindVo food_kindVo = null;
			for (Object obj : pageBean.getArray()) {
				food_kind = (Food_kindData) obj;
				food_kindVo = new Food_kindVo();
				BeanUtilsHelp.copyProperties(food_kindVo, food_kind);
				if (food_kind.getRestaurant() != null) {
					food_kindVo.setRestaurantId(food_kind.getRestaurant()
							.getRestaurantId());
					food_kindVo.setRestaurantName(food_kind.getRestaurant()
							.getName());
				}
				food_kindVos.add(food_kindVo);
			}
			pageBean.setArray(food_kindVos);
		}
		return pageBean;
	}

}
