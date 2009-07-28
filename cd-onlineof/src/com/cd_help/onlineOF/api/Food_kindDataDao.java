/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.web.vo.Food_kindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 菜类别数据处理接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface Food_kindDataDao extends BaseDao{
	
    public List<Food_kindVo> loadAll() throws Exception;
	
	public Food_kindVo get(String id) throws Exception;
	
	public Food_kindVo save(Food_kindVo food_kindVo) throws Exception;
	
	public boolean exist(String id) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void update(Food_kindVo food_kindVo) throws Exception;

}
