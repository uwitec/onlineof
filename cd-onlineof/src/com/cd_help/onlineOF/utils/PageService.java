/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b><code></code></b>
 * <p/>
 * 数据分页处理
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("pageService")
public class PageService {

	/**
	 * 获取总数
	 * 
	 * @param hqlName
	 * @param paramName
	 * @param condition
	 * @param types
	 * @param session
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Transactional
	private int getCount(String hqlName, String[] paramName,
			Object[] condition, Session session) throws AppException {
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
	@Transactional(propagation=Propagation.SUPPORTS)
	public PageBean getPageBean(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, Session session)
			throws AppException {
//			Transaction transaction = session.beginTransaction();
//			transaction.begin();
			pageBean.setTotalRow(this.getCount(hqlName, paramName, condition,
					session)); // 设置总记录数

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
//			transaction.commit();
			return pageBean;
	}
}