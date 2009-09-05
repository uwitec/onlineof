/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.InfoDataDao;
import com.cd_help.onlineOF.api.InfoManager;
import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.data.InfoData;
import com.cd_help.onlineOF.data.InfoKindData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
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
@Transactional
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
	
	@Autowired
	@Resource(name = "onlineOF")
	private OnlineOF onlineOF;

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#createInfo(com.cd_help.onlineOF.web.admin.struts.UsersSession, com.cd_help.onlineOF.web.vo.InfoVo)
	 */
	public InfoVo createInfo(UsersSession session, InfoVo infoVo)
			throws AppException {
		if (this.onlineOF.checkPrivilege(session,"createInfo")) {
			try{
				infoVo.setInfoId(StringUtil.getUUID());
				InfoData infoData = new InfoData();
				BeanUtilsHelp.copyProperties(infoData, infoVo);
				infoData.setCreateTime(new Date(System.currentTimeMillis()));
				infoData.setCreateUser(session.getUsersName());
				if(null != infoVo.getInfoKindId() && infoVo.getInfoKindId().length() > 0){
					InfoKindData infoKindData = (InfoKindData)infoDataDao.get(InfoKindData.class, infoVo.getInfoKindId());
					if(null != infoKindData){
						infoData.setInfokind(infoKindData);
					}
				}
				infoDataDao.save(infoData);
				infoVo.setInfoId(infoData.getInfoId());
				return infoVo;
			}catch(Exception e){
				e.printStackTrace();
				log.error(e);
				throw new AppException("00000400", "发布信息失败!", e);
			}
		}else{
			throw new AppException("00000400", "对不起！您没有足够权限。");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#deleteInfo(com.cd_help.onlineOF.web.admin.struts.UsersSession, java.lang.String)
	 */
	public void deleteInfo(UsersSession session, String id) throws AppException {
		if (this.onlineOF.checkPrivilege(session,"createInfo")) {
			try{
				infoDataDao.delete((InfoData)infoDataDao.get(InfoData.class, id));
			}catch(Exception e){
				log.error(e);
				throw new AppException("00000400", "删除信息失败!", e);
			}
		}else{
			throw new AppException("00000400", "对不起！您没有足够权限。");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#getNewInfo(com.cd_help.onlineOF.web.admin.struts.UsersSession)
	 */
	@SuppressWarnings("unchecked")
	public List<InfoVo> getNewInfo(UsersSession session) throws AppException {
		try{
			List<InfoData> dataList = infoDataDao.findByNamedQuery("getNewInfo");
			List<InfoVo> infoVos = new ArrayList<InfoVo>();
			int count = 0;
			for(Iterator i = dataList.iterator(); i.hasNext(); ){
				count++;
		    	if(count == 11){
		    		break;
		    	}else{
		    	    infoVos.add(convertDataToVo((InfoData)i.next()));
		    	}
			}
			return infoVos;
		}catch(Exception e){
			log.error(e);
			throw new AppException("00000400","系统错误,请联系系统管理员!",e);
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.InfoManager#updateInfo(com.cd_help.onlineOF.web.admin.struts.UsersSession, com.cd_help.onlineOF.web.vo.InfoVo)
	 */
	public void updateInfo(UsersSession session, InfoVo infoVo)
			throws AppException {
		if (this.onlineOF.checkPrivilege(session,"createInfo")) {
			try{
				InfoData infoData = (InfoData)infoDataDao.get(InfoData.class, infoVo.getInfoId());
				BeanUtilsHelp.copyProperties(infoData, infoVo);
				infoData.setModifyTime(new Date(System.currentTimeMillis()));
				infoData.setModifyUser(session.getUsersName());
				infoDataDao.update(infoData);
			}catch(Exception e){
				log.error(e);
				throw new AppException("00000400", "修改信息失败!", e);
			}
		}else{
			throw new AppException("00000400", "对不起！您没有足够权限。");
		}
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
			log.error(e);
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

	public void setInfoDataDao(InfoDataDao infoDataDao) {
		this.infoDataDao = infoDataDao;
	}
	
	public void setOnlineOF(OnlineOF onlineOF) {
		this.onlineOF = onlineOF;
	}
	
}
