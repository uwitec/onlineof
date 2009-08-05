/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.CuisineDataDao;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.CuisineVo;

/**
 * <b><code></code></b>
 * <p/>
 * 菜系数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("cuisineDataDao")
@Transactional
public class CuisineDataDaoImpl extends BaseDaoSupport implements CuisineDataDao{

	public void delete(String id) throws Exception {
		
	}

	public boolean exist(String id) throws Exception {
		return false;
	}

	public CuisineVo get(String id) throws Exception {
		return null;
	}

	public List<CuisineVo> loadAll() throws Exception {
		return null;
	}

	public CuisineVo save(CuisineVo cuisineDataVo) throws Exception {
		return null;
	}

	public void update(CuisineVo cuisineDataVo) throws Exception {
		
	}

	/**
	 * 取菜系的分页数据
	 * @see com.cd_help.onlineOF.api.CuisineDataDao#getCuisinePage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean)
	 */
	public PageBean getCuisinePage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
