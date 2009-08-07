/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.web.vo.FoodVo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席数据处理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface FoodDataDao extends BaseDao{
    
	public List<FoodVo> loadAll() throws Exception;
	
	public FoodVo get(String id) throws Exception;
	
	public FoodVo save(FoodVo foodVo) throws Exception;
	
	public boolean exist(String id) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void update(FoodVo foodVo) throws Exception;
}
