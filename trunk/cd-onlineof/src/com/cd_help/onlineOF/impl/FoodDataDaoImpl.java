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
import com.cd_help.onlineOF.utils.AppException;
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

	public void delete(String id) throws AppException {
		if(!this.exist(id)){
			throw new AppException();
		}else{
			this.delete(this.get(FoodData.class, id));
		}
	}

	public boolean exist(String id) throws AppException {
		try {
			FoodData foodData = (FoodData) getHibernateTemplate().get(
					FoodData.class, id);
			return foodData == null ? false : true;
		} catch (Exception e) {
			throw new AppException();
		}
	}

	public FoodVo get(String id) throws AppException {
		FoodData foodData = (FoodData)this.get(FoodData.class,id);
		FoodVo foodVo = new FoodVo();
		BeanUtilsHelp.copyProperties(foodVo,foodData);
		return foodVo;
	}

	public List<FoodVo> loadAll() throws AppException {
		List<FoodVo> foodVoList =  this.findByNamedQuery("loadAllFood");
		System.out.println(foodVoList.size());
		for(FoodVo fv : foodVoList){
			System.out.println("饮食名称 ---->>> "+fv.getName());
		}
		return foodVoList;
	}

	public FoodVo save(FoodVo foodVo) throws AppException {
		foodVo.setFoodId(StringUtil.getUUID());
		FoodData foodData = new FoodData();
		BeanUtilsHelp.copyProperties(foodData,foodVo);
		this.save(foodData);
		foodVo.setFoodId(foodData.getFoodId());
		return foodVo;
	}

	public void update(FoodVo foodVo) throws AppException {
	    FoodData foodData = (FoodData)this.get(FoodData.class,foodVo.getFoodId());
        BeanUtilsHelp.copyProperties(foodData, foodVo);
		this.update(foodData);  
	}

}
