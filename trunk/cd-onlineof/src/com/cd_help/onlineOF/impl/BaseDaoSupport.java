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
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.cd_help.onlineOF.api.BaseDao;
import com.cd_help.onlineOF.utils.PageBean;

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

	protected final HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
	}

	public List find(String queryString) {
		return find(queryString, (Object[]) null);
	}

	public List find(String queryString, Object value) {
		return find(queryString, new Object[] { value });
	}

	public List find(final String queryString, final Object[] values) {
		return getHibernateTemplate().find(queryString, values);
	}

	public List findByNamedParam(String queryString, String paramName,
			Object value) {
		return getHibernateTemplate().findByNamedParam(queryString, paramName,
				value);
	}

	public List findByNamedQuery(String queryName) {
		return findByNamedQuery(queryName, (Object[]) null);
	}

	public List findByNamedQuery(final String queryName, final int start,
			final int limit) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.getNamedQuery(queryName).setFirstResult(start)
						.setMaxResults(limit).list();
			}
		});
	}

	public List findByNamedQuery(String queryName, Object value) {
		return findByNamedQuery(queryName, new Object[] { value });
	}

	public List findByNamedQuery(final String queryName, final Object[] values) {
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) {
		return findByNamedQueryAndNamedParam(queryName,
				new String[] { paramName }, new Object[] { value });
	}

	public List findByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
				paramNames, values);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	public void clear() {
		getHibernateTemplate().clear();
	}

	public Object get(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, (Serializable) id);
	}

	public boolean exist(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, (Serializable) id) == null ? false
				: true;
	}

	public void save(Object entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	public List loadAll(final Class entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public long countByNamedQuery(final String queryName) {
		return (Long) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.getNamedQuery(queryName).uniqueResult();
			}
		});
	}

	public int queryCountByHql(String hqlName, String[] paramName,
			Object[] condition) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		String hqlString = session.getNamedQuery(hqlName).getQueryString();
		Query query = session.createQuery("select count(*) " + hqlString);
		if (paramName != null && condition != null) {

			for (int i = 0; i < paramName.length; i++) {
				query.setParameter(paramName[i], condition[i]);
			}
		}
		query.setCacheable(true);
		int total = Integer.valueOf(query.list().get(0).toString());
		transaction.commit();
		return total;
	}

	/**
	 * 获取分页
	 * 
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param types
	 * @param pageBean
	 * @param session
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean getPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean) {
		pageBean.setTotalRow(queryCountByHql(hqlName, paramName, condition)); // 设置总记录数

		// 以下是根据总记录数和每页大小计算总页数
		if (pageBean.getTotalRow() % pageBean.getPagesize() == 0) {
			pageBean.setTotalPage(pageBean.getTotalRow()
					/ pageBean.getPagesize());
		} else {
			pageBean.setTotalPage(pageBean.getTotalRow()
					/ pageBean.getPagesize() + 1);
		}

		// 如果当前页号少于1的话，当前页号等于1
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}

		// 如果当前页号大于总页数的话，当前页号等于总页数
		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}

		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery(hqlName);

		if (paramName != null && condition != null) {

			for (int i = 0; i < paramName.length; i++) {
				query.setParameter(paramName[i], condition[i]);
			}
		}
		query.setCacheable(true);
		// 设置取数据的区间
		query.setFirstResult((pageBean.getCurrentPage() - 1)
				* pageBean.getPagesize());
		query.setMaxResults(pageBean.getPagesize());

		pageBean.setArray(query.list());
		transaction.commit();
		return pageBean;
	}
}
