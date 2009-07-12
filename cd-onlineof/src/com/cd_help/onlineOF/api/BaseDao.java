/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.io.Serializable;
import java.util.List;

/**
 * <b><code></code></b>
 * <p/>
 * 数据库处理基类接口
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unchecked")
public interface BaseDao {
	
	public List find(String queryString);

	public List find(String queryString, Object value);

	public List find(final String queryString, final Object[] values);

	public List findByNamedParam(String queryString, String paramName,
			Object value);

	public List findByNamedQuery(String queryName);

	public List findByNamedQuery(String queryName, Object value);

	public long countByNamedQuery(String queryName);

	public List findByNamedQuery(String queryName, int start, int limit);

	public List findByNamedQuery(final String queryName, final Object[] values);

	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value);

	public List findByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values);

	public void flush();

	public void clear();
	
	public boolean exist(Class entityClass, Serializable id);

	public Object get(Class entityClass, Serializable id);

	public void save(Object entity);

	public void update(Object entity);

	public void delete(Object entity);

	public List loadAll(final Class entityClass);

}
