/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.CuisineVo;

/**
 * <b><code></code></b>
 * <p/>
 * 菜系数据接口
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface CuisineDataDao extends BaseDao{
	
    public List<CuisineVo> loadAll() throws Exception;
	
	public CuisineVo get(String id) throws Exception;
	
	public CuisineVo save(CuisineVo cuisineDataVo) throws Exception;
	
	public boolean exist(String id) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void update(CuisineVo cuisineDataVo) throws Exception;
	
	public PageBean getCuisinePage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean)throws Exception;
}
