/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.io.Serializable;
import java.util.List;

import com.cd_help.onlineOF.utils.PageBean;

/**
 * <b><code></code></b>
 * <p/>
 * 数据库处理基类接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unchecked")
public interface BaseDao {

	public List find(String queryString) throws Exception;

	public List find(String queryString, Object value) throws Exception;

	public List find(final String queryString, final Object[] values) throws Exception;

	public List findByNamedParam(String queryString, String paramName,
			Object value) throws Exception;

	public List findByNamedQuery(String queryName) throws Exception;

	public List findByNamedQuery(String queryName, Object value) throws Exception;

	public int countByNamedQuery(String queryName) throws Exception;

	public List findByNamedQuery(String queryName, int start, int limit) throws Exception;

	public List findByNamedQuery(final String queryName, final Object[] values) throws Exception;

	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) throws Exception;

	public List findByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values) throws Exception;

	public void flush() throws Exception;

	public void clear() throws Exception;

	public boolean exist(Class entityClass, Serializable id) throws Exception;

	public Object get(Class entityClass, Serializable id) throws Exception;

	public void save(Object entity) throws Exception;

	public void update(Object entity) throws Exception;

	public void delete(Object entity) throws Exception;

	public List loadAll(final Class entityClass) throws Exception;
	
	public PageBean searchByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception;
	
}
