/*
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
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.api.UsersManager;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.RoleData;
import com.cd_help.onlineOF.data.UsersData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.ConvertUtils;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.admin.struts.UsersSession;
import com.cd_help.onlineOF.web.vo.UsersVo;

/**
 * <b><code></code></b>
 * <p/>
 * 用户管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("usersManager")
@Transactional
public class UsersManagerImpl implements UsersManager {
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(UsersManagerImpl.class);

	@Autowired
	@Resource(name = "usersDataDao")
	private UsersDataDao usersDataDao;
	
	@Autowired
	@Resource(name = "onlineOF")
	private OnlineOF onlineOF;
	
	public void deleteUsers(UsersSession session, String id) throws AppException {
		if (this.onlineOF.checkPrivilege(session,"deleteUsers")) {
			try {
				usersDataDao.delete((UsersData)usersDataDao.get(UsersData.class, id));
			} catch (Exception e) {
				throw new AppException("0000012", "删除失败",e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	public UsersVo getUsersById(UsersSession session, String id) throws AppException {
		if (this.onlineOF.checkPrivilege(session,"getUsersById")) {
			try {
				UsersData usersData = (UsersData)usersDataDao.get(UsersData.class,id);
				return this.convertDataToVo(usersData);
			} catch (Exception e) {
				throw new AppException("0000013", "获取用户信息出错!",e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	@SuppressWarnings("unchecked")
	public List<UsersVo> loadAllUsers(UsersSession session) throws AppException {
		if (this.onlineOF.checkPrivilege(session,"loadAllUsers")) {
			try {
				List<UsersData> usersDatas = usersDataDao.findByNamedQuery("loadAllUsers");
				return this.convertDataToVoList(usersDatas);
			} catch (Exception e) {
				throw new AppException("0000014", "加载用户信息出错!",e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersManager#login(java.lang.String, java.lang.String)
	 */
	public UsersVo login(String username, String password) throws AppException {
		UsersVo usersVo = null;
		try {
			UsersData usersData = usersDataDao.login(username, password);
			if(null != usersData){
				usersVo = this.convertDataToVo(usersData); 
				if (null != usersVo.getRestaurantId()
						&& usersVo.getRestaurantId().length() > 0) {
					usersVo.setRestaurantName(((RestaurantData)usersDataDao.get(
							RestaurantData.class, usersVo.getRestaurantId())).getName());
					RestaurantData restaurantData= (RestaurantData)usersDataDao.get(RestaurantData.class,
							usersVo.getRestaurantId());
					usersVo.setRestaurantName(restaurantData.getName());
				}
				if (null != usersVo.getRoleId()
						&& usersVo.getRoleId().length() > 0) {
					usersVo.setRoleName(((RoleData)usersDataDao.get(RoleData.class, usersVo.getRoleId())).getRoleName());
				}else{
					throw new AppException("0000011", "对不起,您没有足够权限!");
				}
			}else{
				throw new AppException("0000011", "用户名或密码错误!");
			}
		} catch (Exception e) {
			log.error(e);
			throw new AppException("0000011", e.getMessage(),e);
		}
		return usersVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersManager#update(com.cd_help.onlineOF.web.admin.struts.UsersSession, com.cd_help.onlineOF.web.vo.UsersVo)
	 */
	public void updateUsers(UsersSession session, UsersVo usersVo) throws AppException {
		if (this.onlineOF.checkPrivilege(session,"updateUsers")) {
			try {
				UsersData usersData = (UsersData)usersDataDao.get(UsersData.class, usersVo.getUsersId());
				usersData.setUsersname(usersVo.getUsersname());
				usersData.setBirthday(ConvertUtils.toDate3(usersVo.getBirthdayStr()));
				usersData.setRestaurantId(usersVo.getRestaurantId());
				usersData.setGender(usersVo.getGender());
				usersData.setRoleId(usersVo.getRoleId());
				usersData.setEmail(usersVo.getEmail());
				usersData.setQQ(usersVo.getQQ());
				usersData.setPhone(usersVo.getPhone());
				usersData.setMovebile(usersVo.getMovebile());
				usersDataDao.update(usersData);
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000011", "修改失败!",e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	public void setUsersDataDao(UsersDataDao usersDataDao) {
		this.usersDataDao = usersDataDao;
	}

	@SuppressWarnings("unchecked")
	public PageBean searchUsersByPage(String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean, UsersSession session)
			throws AppException {
		if(this.onlineOF.checkPrivilege(session,"searchUsersByPage")){
			PageBean page = null;
			List<UsersVo> usersVos = new ArrayList<UsersVo>();
			try{
				page = usersDataDao.searchByPage(hqlName, paramName, condition, pageBean);
				for(Iterator i = page.getArray().iterator(); i.hasNext();){
					UsersData usersData = (UsersData)i.next();
					usersVos.add(this.convertDataToVo(usersData));
				}
				page.setArray(usersVos);
			}catch(Exception e){
				throw new AppException("0000014", "加载用户信息出错!",e);
			}
			return page;
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersManager#checkUsersByName(java.lang.String)
	 */
	public boolean checkUsersByName(String usersname) throws AppException {
		try{
			return usersDataDao.checkUsersByName(usersname);
		}catch(Exception e){
			throw new AppException("00000000",e.getMessage(),e);
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersManager#addUsers(com.cd_help.onlineOF.web.admin.struts.UsersSession, com.cd_help.onlineOF.data.UsersData)
	 */
	public void addUsers(UsersSession session, UsersVo usersVo)
			throws AppException {
		if(this.onlineOF.checkPrivilege(session,"addUsers")){
			try{
				usersVo.setUsersId(StringUtil.getUUID());
				UsersData usersData = new UsersData();
				BeanUtilsHelp.copyProperties(usersData, usersVo);
				usersData.setPassword(StringUtil.encodePassword(usersVo.getPassword(), "MD5"));
				usersDataDao.save(usersData);
			}catch(Exception e){
				log.error(e);
				throw new AppException("0000000","添加用户失败!",e);
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}
	
	/**
	 * 将data集合转成DTO(VO)集合
	 * @param roleDatas
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@SuppressWarnings("unchecked")
	private List<UsersVo> convertDataToVoList(List<UsersData> usersData) throws Exception{
		List<UsersVo> usersVos = new ArrayList<UsersVo>();
		for(Iterator i = usersData.iterator(); i.hasNext();){
			UsersData data = (UsersData)i.next();
			UsersVo usersVo = new UsersVo();
			BeanUtilsHelp.copyProperties(usersVo, data);
			if(data.getRoleId().length() > 0){
				usersVo.setRoleName(((RoleData)usersDataDao.get(RoleData.class,data.getRoleId())).getRoleName());
			}
			if(data.getRestaurantId().length() > 0){
				usersVo.setRestaurantName(((RestaurantData)usersDataDao.get(RestaurantData.class, usersVo.getRestaurantId())).getName());
			}
			usersVos.add(usersVo);
		}
		return usersVos;
	}
	
	/**
	 * 将data转成DTO(VO)
	 * @param roleData
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private UsersVo convertDataToVo(UsersData usersData) throws Exception {
		UsersVo usersVo = new UsersVo();
		BeanUtilsHelp.copyProperties(usersVo, usersData);
		if(null != usersVo.getRoleId() && usersVo.getRoleId().length() > 0){
			usersVo.setRoleName(((RoleData)usersDataDao.get(RoleData.class,usersVo.getRoleId())).getRoleName());
		}
		if(null != usersVo.getRestaurantId() && usersVo.getRestaurantId().length() > 0){
			usersVo.setRestaurantName(((RestaurantData)usersDataDao.get(RestaurantData.class, usersVo.getRestaurantId())).getName());
		}
		return usersVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersManager#resetPassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean resetUsersPassword(String usersId, String oldPassword, String newPassword)
			throws AppException {
		try{
			UsersData usersData = (UsersData)usersDataDao.get(UsersData.class, usersId);
			if(usersData.getPassword().equals(StringUtil.encodePassword(oldPassword, "MD5"))){
				usersData.setPassword(StringUtil.encodePassword(newPassword, "MD5"));
				usersDataDao.update(usersData);
				return true;
			}else{
				throw new AppException("000000","输入密码错误!");
			}
		}catch(Exception e){
			throw new AppException("000000","重置密码出错!",e);
		}
	}

	public void setOnlineOF(OnlineOF onlineOF) {
		this.onlineOF = onlineOF;
	}

	public OnlineOF getOnlineOF() {
		return onlineOF;
	}
}
