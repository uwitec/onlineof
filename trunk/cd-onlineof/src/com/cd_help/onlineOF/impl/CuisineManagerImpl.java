/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.CuisineManager;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.struts.UsersSession;

/**
 * <b><code></code></b>
 * <p/>
 * 菜系管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("cuisineManager")
public class CuisineManagerImpl implements CuisineManager{

	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unused")
	private boolean checkPrivilege(UsersSession session) throws Exception{
		return true;
	}
}
