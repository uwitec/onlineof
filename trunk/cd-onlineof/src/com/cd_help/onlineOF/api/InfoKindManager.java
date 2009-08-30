/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.api;

import java.util.List;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.InfoKindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息分类管理接口
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public interface InfoKindManager {
	
	/**
	 * 获取所有信息分类
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<InfoKindVo> loadAllInfoKind(UsersSession session) throws AppException;

}
