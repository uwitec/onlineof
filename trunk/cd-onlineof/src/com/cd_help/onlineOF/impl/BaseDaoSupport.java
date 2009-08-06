/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.cd_help.onlineOF.api.BaseDao;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.PageService;

/**
 * <b><code></code></b>
 * <p/>
 * 数据库处理基类实现类
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unchecked")
public class BaseDaoSupport implements BaseDao {

	private HibernateTemplate hibernateTemplate;
	private PageService pageService;

	@Autowired
	@Resource(name = "sessionFactory")
	public final void setSessionFactory(SessionFactory sessionFactory) {
		if (this.hibernateTemplate == null
				|| sessionFactory != this.hibernateTemplate.getSessionFactory()) {
			this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
	}

	public final SessionFactory getSessionFactory() {
		return (this.hibernateTemplate != null ? this.hibernateTemplate
				.getSessionFactory() : null);
	}

	public PageService getPageService() {
		return pageService;
	}

	@Autowired
	@Resource(name = "pageService")
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	protected final HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	protected final void releaseSession(Session session) throws Exception {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
	} 

	public List find(String queryString) throws Exception{
		return find(queryString, (Object[]) null);
	}

	public List find(String queryString, Object value) throws Exception{
		return find(queryString, new Object[] { value });
	}

	public List find(final String queryString, final Object[] values) throws Exception{
		return getHibernateTemplate().find(queryString, values);
	}

	public List findByNamedParam(String queryString, String paramName,
			Object value) throws Exception{
		return getHibernateTemplate().findByNamedParam(queryString, paramName,
				value);
	}

	public List findByNamedQuery(String queryName) throws Exception{
		return findByNamedQuery(queryName, (Object[]) null);
	}

	public List findByNamedQuery(final String queryName, final int start,
			final int limit) throws Exception{
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.getNamedQuery(queryName).setFirstResult(start)
						.setMaxResults(limit).list();
			}
		});
	}
	
	public List find(final String hql, final int start,
			final int limit) throws Exception{
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(hql).setFirstResult(start)
						.setMaxResults(limit).list();
			}
		});
	}

	public List findByNamedQuery(String queryName, Object value) throws Exception{
		return findByNamedQuery(queryName, new Object[] { value });
	}

	public List findByNamedQuery(final String queryName, final Object[] values) throws Exception{
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) throws Exception{
		return findByNamedQueryAndNamedParam(queryName,
				new String[] { paramName }, new Object[] { value });
	}

	public List findByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values) throws Exception{
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
				paramNames, values);
	}

	public void flush() throws Exception{
		getHibernateTemplate().flush();
	}

	public void clear() throws Exception{
		getHibernateTemplate().clear();
	}

	public Object get(Class entityClass, Serializable id) throws Exception{
		return getHibernateTemplate().get(entityClass, id);
	}

	public boolean exist(Class entityClass, Serializable id) throws Exception{
		return getHibernateTemplate().get(entityClass, id) == null ? false
				: true;
	}

	public void save(Object entity) throws Exception{
		getHibernateTemplate().save(entity);
	}

	public void update(Object entity) throws Exception{
		getHibernateTemplate().update(entity);
	}

	public void delete(Object entity) throws Exception{
		getHibernateTemplate().delete(entity);
	}

	public List loadAll(final Class entityClass) throws Exception{
		return getHibernateTemplate().loadAll(entityClass);
	}

	public int countByNamedQuery(final String queryName) throws Exception{
		return ((Long) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.getNamedQuery(queryName).uniqueResult();
			}
		})).intValue();
	}
	
	public int queryCountByHql(String hqlName, String[] paramName,
			Object[] condition) throws Exception{
		SessionFactory factory = new AnnotationConfiguration().buildSessionFactory();
		Session session = factory.openSession();
		String hqlString = session.getNamedQuery(hqlName).getQueryString();
		Query query = session.createQuery("select count(*) " + hqlString);
		if (paramName != null && condition != null) {

			for (int i = 0; i < paramName.length; i++) {
				query.setParameter(paramName[i], condition[i]);
			}
		}
		query.setCacheable(true);
		int total = Integer.valueOf(query.list().get(0).toString());
		return total;
	}
	
	public PageBean searchByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) throws Exception{
		return this.pageService.getPageBean(hqlName, paramName, condition,
				pageBean, this.getHibernateTemplate().getSessionFactory().openSession());
	}
}
