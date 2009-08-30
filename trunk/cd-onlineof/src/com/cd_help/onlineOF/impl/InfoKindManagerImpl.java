/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.api.InfoKindDataDao;
import com.cd_help.onlineOF.api.InfoKindManager;
import com.cd_help.onlineOF.data.InfoKindData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.InfoKindVo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息分类管理实现类
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("infoKindManager")
@SuppressWarnings("unchecked")
public class InfoKindManagerImpl implements InfoKindManager{
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(UsersManagerImpl.class);
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "infoKindDataDao")
	private InfoKindDataDao infoKindDataDao;

	/**
	 * @see com.cd_help.onlineOF.api.InfoKindManager#loadAllInfoKind(com.cd_help.onlineOF.web.admin.struts.UsersSession)
	 */
	public List<InfoKindVo> loadAllInfoKind(UsersSession session)
			throws AppException {
		List<InfoKindVo> infoKinfVos = new ArrayList<InfoKindVo>();
		try{
			List<InfoKindData> infoKindDataList = infoKindDataDao.findByNamedQuery("loadAllInfoKind");
			for(Iterator i = infoKindDataList.iterator(); i.hasNext(); ){
				InfoKindData data = (InfoKindData)i.next();
				InfoKindVo vo = new InfoKindVo();
				BeanUtilsHelp.copyProperties(vo, data);
				infoKinfVos.add(vo);
			}
			return infoKinfVos;
		}catch(Exception e){
			throw new AppException("0000050000", "系统错误，请联系系统管理员！", e);
		}
	}

	public void setInfoKindDataDao(InfoKindDataDao infoKindDataDao) {
		this.infoKindDataDao = infoKindDataDao;
	}

}
