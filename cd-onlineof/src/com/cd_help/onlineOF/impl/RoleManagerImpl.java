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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.OnlineOF;
import com.cd_help.onlineOF.api.RoleDataDao;
import com.cd_help.onlineOF.api.RoleManager;
import com.cd_help.onlineOF.data.RoleData;
import com.cd_help.onlineOF.data.UsersData;
import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 26, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("roleManager")
@Transactional
public class RoleManagerImpl implements RoleManager{

	@SuppressWarnings("unused")
	@Autowired
	@Resource(name = "roleDataDao")
	private RoleDataDao roleDataDao;
	
	@Autowired
	@Resource(name = "onlineOF")
	private OnlineOF onlineOF;
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#loadAll(com.cd_help.onlineOF.data.UsersSession)
	 */
	@SuppressWarnings("unchecked")
	public List<RoleVo> loadAllRole(UsersSession session) throws AppException {
		List<RoleData> roleDatas = null;
		List<RoleVo> roleVos = null;
		if(this.onlineOF.checkPrivilege(session,"loadAllRole")){
			try{
				roleDatas = roleDataDao.findByNamedQuery("loadAllRole");
				roleVos = convertDataToVoList(roleDatas);
			}catch(Exception e){
				throw new AppException("000000","系统出错!请联系系统管理员.");
			}
			return roleVos;
		}else{
			throw new AppException("000000","没有权限!");
		}
	}
	
	public void setRoleDataDao(RoleDataDao roleDataDao) {
		this.roleDataDao = roleDataDao;
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#searchByPage(java.lang.String, java.lang.String[], java.lang.Object[], com.cd_help.onlineOF.utils.PageBean, com.cd_help.onlineOF.data.UsersSession)
	 */
	@SuppressWarnings("unchecked")
	public PageBean searchRolesByPage(UsersSession session,String hqlName, String[] paramName,
			Object[] condition, PageBean pageBean)
			throws AppException {
		if(this.onlineOF.checkPrivilege(session,"searchRolesByPage")){
			PageBean page = null;
			List<RoleVo> roleVos = new ArrayList<RoleVo>();
			try{
				page = roleDataDao.searchByPage(hqlName, paramName, condition, pageBean);
				for(Iterator i = page.getArray().iterator(); i.hasNext();){
					RoleData roleData = (RoleData)i.next();
					roleVos.add(this.convertDataToVo(roleData));
				}
				page.setArray(roleVos);
			}catch(Exception e){
				throw new AppException("0000014", "加载角色信息出错!");
			}
			return page;
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#delete(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void deleteRole(UsersSession session, String id) throws AppException {
		if(this.onlineOF.checkPrivilege(session,"deleteRole")){
			try{
				RoleData roleData = (RoleData)roleDataDao.get(RoleData.class, id);
				List<UsersData> usersDatas = roleDataDao.findByNamedQueryAndNamedParam("getUsersByRoleId", "roleId", id);
				for(UsersData usersData : usersDatas){
					usersData.setRoleId(null);
					roleDataDao.update(usersData);
				}
				roleDataDao.delete(roleData);
			}catch(Exception e){
				e.printStackTrace();
				throw new AppException("0000014", "删除失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}
	
	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#addRole(com.cd_help.onlineOF.data.UsersSession, com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void addRole(UsersSession session, RoleVo roleVo) throws AppException{
		if(this.onlineOF.checkPrivilege(session,"addRole")){
            RoleData roleData = null;
			try{
				roleVo.setRoleId(StringUtil.getUUID());
				roleData = this.convertVoToData(roleVo);
				roleDataDao.save(roleData);
			}catch(Exception e){
				throw new AppException("0000014", "新建失败!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#getRoleById(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	public RoleVo getRoleById(UsersSession session, String roleId)
			throws AppException {
		RoleData roleData = null;
		RoleVo roleVo = null;
		if(this.onlineOF.checkPrivilege(session,"getRoleById")){
			try{
				roleData = (RoleData)roleDataDao.get(RoleData.class, roleId);
				roleVo = this.convertDataToVo(roleData);
			}catch(Exception e){
				throw new AppException("0000014", "系统错误!");
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
		return roleVo;
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#updateRole(com.cd_help.onlineOF.data.UsersSession, com.cd_help.onlineOF.web.vo.RoleVo)
	 */
	public void updateRole(UsersSession session, RoleVo roleVo) throws AppException {
		if(this.onlineOF.checkPrivilege(session,"updateRole")){
			try{
				RoleData roleData = this.convertVoToData(roleVo);
				roleDataDao.update(roleData);
			}catch(Exception e){
				throw new AppException("0000014", "修改失败!",e);
			}
		}else{
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.RoleManager#saveRolePrivileges(com.cd_help.onlineOF.data.UsersSession, java.lang.String, java.lang.String)
	 */
	public void saveRolePrivileges(UsersSession session, String[] privileges,
			String roleId) throws AppException {
		try{
			if(this.onlineOF.checkPrivilege(session,"saveRolePrivileges")){
			    roleDataDao.saveRolePrivileges(privileges, roleId);
			}else{
				throw new AppException("0000000", "权限不够!");
			}
		}catch(Exception e){
			throw new AppException("",e.getMessage(),e);
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
	private List<RoleVo> convertDataToVoList(List<RoleData> roleDatas) throws Exception{
		List<RoleVo> roleVos = new ArrayList<RoleVo>();
		for(Iterator i = roleDatas.iterator(); i.hasNext();){
			RoleData rd = (RoleData)i.next();
			RoleVo rv = new RoleVo();
			BeanUtilsHelp.copyProperties(rv, rd);
			roleVos.add(rv);
		}
		return roleVos;
	}
	
	/**
	 * 将data转成DTO(VO)
	 * @param roleData
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private RoleVo convertDataToVo(RoleData roleData) throws Exception {
		RoleVo roleVo = new RoleVo();
		BeanUtilsHelp.copyProperties(roleVo, roleData);
		return roleVo;
	}
	
	/**
	 * 将DTO(VO)转成data
	 * @param roleData
	 * @return
	 * @throws Exception
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private RoleData convertVoToData(RoleVo roleVo) throws Exception {
		RoleData roleData = new RoleData();
		BeanUtilsHelp.copyProperties(roleData, roleVo);
		return roleData;
	}

	public OnlineOF getOnlineOF() {
		return onlineOF;
	}

	public void setOnlineOF(OnlineOF onlineOF) {
		this.onlineOF = onlineOF;
	}
}
