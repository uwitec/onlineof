/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.FoodDataDao;
import com.cd_help.onlineOF.data.FoodData;
import com.cd_help.onlineOF.data.Food_kindData;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.FoodVo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("foodDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class FoodDataDaoImpl extends BaseDaoSupport implements FoodDataDao{

	public void delete(String id) throws Exception {
		if(!this.exist(id)){
			throw new Exception();
		}else{
			this.delete(this.get(FoodData.class, id));
		}
	}

	public boolean exist(String id) throws Exception {
		try {
			FoodData foodData = (FoodData) getHibernateTemplate().get(
					FoodData.class, id);
			return foodData == null ? false : true;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public FoodVo get(String id) throws Exception {
		FoodData foodData = (FoodData)this.get(FoodData.class,id);
		FoodVo foodVo = new FoodVo();
		BeanUtilsHelp.copyProperties(foodVo,foodData);
		if(null!=foodData.getRestaurantId()){
			RestaurantData restaurant = (RestaurantData) super.get(RestaurantData.class, foodData.getRestaurantId());
			foodVo.setRestaurantId(restaurant.getRestaurantId());
		}
		if(null!=foodData.getFood_kindId()){
			Food_kindData food_kind = (Food_kindData) super.get(Food_kindData.class, foodData.getFood_kindId());
			foodVo.setFood_kindId(food_kind.getFood_kind_Id());
			foodVo.setFood_kind_Name(food_kind.getName());
		}
		return foodVo;
	}

	public List<FoodVo> loadAll() throws Exception {
		List<FoodVo> foodVoList =  this.findByNamedQuery("loadAllFood");
		System.out.println(foodVoList.size());
		for(FoodVo fv : foodVoList){
			System.out.println("饮食名称 ---->>> "+fv.getName());
		}
		return foodVoList;
	}

	public FoodVo save(FoodVo foodVo) throws Exception {
		foodVo.setFoodId(StringUtil.getUUID());
		FoodData foodData = new FoodData();
		BeanUtilsHelp.copyProperties(foodData,foodVo);
		this.save(foodData);
		foodVo.setFoodId(foodData.getFoodId());
		return foodVo;
	}

	public void update(FoodVo foodVo) throws Exception {
	    FoodData foodData = (FoodData)this.get(FoodData.class,foodVo.getFoodId());
	    if(null==foodVo.getImg()){
	    	foodVo.setImg(foodData.getImg());
	    }
        BeanUtilsHelp.copyProperties(foodData, foodVo);
		this.update(foodData);  
	}
}
