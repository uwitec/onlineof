/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.InfoVo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息管理接口
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface InfoManager {

	/**
	 * 发布信息
	 * @param infoVo
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public InfoVo createInfo(UsersSession session, InfoVo infoVo) throws AppException;
	
	/**
	 * 删除信息
	 * @param session
	 * @param id
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void deleteInfo(UsersSession session, String id) throws AppException;
	
	/**
	 * 修改信息
	 * @param session
	 * @param infoVo
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public void updateInfo(UsersSession session, InfoVo infoVo) throws AppException;
	
	/**
	 * 获取最新信息
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<InfoVo> getNewInfo(UsersSession session) throws AppException;
	
	/**
	 * 分页获取信息列表
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PageBean searchInfosByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, UsersSession session) throws AppException;
}
