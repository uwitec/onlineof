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

import com.cd_help.onlineOF.api.InfoDataDao;
import com.cd_help.onlineOF.api.InfoManager;
import com.cd_help.onlineOF.data.InfoData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.InfoVo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息管理实现类
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("infoManager")
@SuppressWarnings("unchecked")
public class InfoManagerImpl implements InfoManager{
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(UsersManagerImpl.class);
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "infoDataDao")
	private InfoDataDao infoDataDao;

	public InfoVo createInfo(UsersSession session, InfoVo infoVo)
			throws AppException {
		return null;
	}

	public void deleteInfo(UsersSession session, String id) throws AppException {
		
	}

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#getNewInfo(com.cd_help.onlineOF.web.admin.struts.UsersSession)
	 */
	@SuppressWarnings("unchecked")
	public List<InfoVo> getNewInfo(UsersSession session) throws AppException {
		try{
			List<InfoData> dataList = infoDataDao.findByNamedQuery("getNewInfo");
			List<InfoVo> infoVos = new ArrayList<InfoVo>();
			for(Iterator i = dataList.iterator(); i.hasNext(); ){
				infoVos.add(convertDataToVo((InfoData)i.next()));
			}
			return infoVos;
		}catch(Exception e){
			throw new AppException("00000400","系统错误,请联系系统管理员!",e);
		}
	}

	public void updateInfo(UsersSession session, InfoVo infoVo)
			throws AppException {
	}

	public void setInfoDataDao(InfoDataDao infoDataDao) {
		this.infoDataDao = infoDataDao;
	}

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#searchInfosByPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean, com.cd_help.onlineOF.web.admin.struts.UsersSession)
	 */
	public PageBean searchInfosByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, UsersSession session)
			throws AppException {
		try{
			List<InfoVo> infoVos = new ArrayList<InfoVo>();
			PageBean page = infoDataDao.searchByPage(hqlName, paramName, condition, pageBean);
			for(Iterator i = page.getArray().iterator(); i.hasNext();){
				infoVos.add(convertDataToVo((InfoData)i.next()));
			}
			page.setArray(infoVos);
			return page;
		}catch(Exception e){
			throw new AppException("0000014", "加载信息出错!",e);
		}
	}
	
	/**
	 * 将data转成DTO(VO)
	 * @param roleData
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private InfoVo convertDataToVo(InfoData infoData) throws Exception {
		InfoVo infoVo = new InfoVo();
		BeanUtilsHelp.copyProperties(infoVo, infoData);
		if(null != infoData.getInfokind()){
			infoVo.setInfoKindId(infoData.getInfokind().getInfoKindId());
			infoVo.setInfoKindName(infoData.getInfokind().getName());
		}
		return infoVo;
	}
}