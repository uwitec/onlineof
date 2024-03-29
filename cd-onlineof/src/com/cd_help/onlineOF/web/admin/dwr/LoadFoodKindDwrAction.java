/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.admin.dwr;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.Food_kindVo;

@SuppressWarnings("serial")
@Service("loadFoodKindDwrAction")
public class LoadFoodKindDwrAction extends BaseAction {

	public List<Food_kindVo> loadFoodKindByRestaurantId(String restaurantId) throws Exception{
		List<Food_kindVo> food_kindVos = null;
		try {
			food_kindVos = this.getOnlineOF().getFood_kindManager()
					.getFoodKindByRestaurantId(restaurantId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("","加载餐厅下的菜分类信息出错!");
		}
		return food_kindVos;
	}
}
