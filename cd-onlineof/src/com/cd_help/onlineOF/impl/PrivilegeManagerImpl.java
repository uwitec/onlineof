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
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.api.PrivilegeManager;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.RoleData;
import com.cd_help.onlineOF.data.UsersSession;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.utils.StringUtil;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限管理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 19, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("privilegeManager")
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeManagerImpl implements PrivilegeManager {

	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	protected static Log log = LogFactory.getLog(PrivilegeManagerImpl.class);

	@Autowired
	@Resource(name = "privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;

	public void setPrivilegeDataDao(PrivilegeDataDao privilegeDataDao) {
		this.privilegeDataDao = privilegeDataDao;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadAll(com.cd_help.onlineOF.data.UsersSession)
	 */
	public List<PrivilegeVo> loadAllPrivilege(UsersSession session)
			throws AppException {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQuery("loadAllPrivilege");
				for (Iterator i = privilegeDatas.iterator(); i.hasNext();) {
					PrivilegeData pd = (PrivilegeData) i.next();
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, pd);
					if (pd.getParent() != null) {
						pv.setParentId(pd.getParent().getPrivilegeId());
						pv.setParentName(pd.getParent().getPrivilegeName());
					} else {
						pv.setParentId("-1");
					}
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadChildModelPrivilegeByParent(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	public List<PrivilegeVo> loadChildModelPrivilegeByParent(UsersSession session,
			String parentId) throws AppException {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				String paramNames[] = { "parentId", "roleId" };
				String values[] = { parentId, session.getUsersVo().getRoleId() };
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQueryAndNamedParam(
								"getChildModelPrivilegeByRoleId", paramNames,
								values);
				for (Iterator i = privilegeDatas.iterator(); i.hasNext();) {
					PrivilegeData pd = (PrivilegeData) i.next();
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, pd);
					pv.setParentId(parentId);
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadTopModelPrivilege(com.cd_help.onlineOF.data.UsersSession)
	 */
	public List<PrivilegeVo> loadTopModelPrivilege(UsersSession session)
			throws AppException {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQueryAndNamedParam(
								"getTopModelPrivilegeByRoleId", "roleId",
								session.getUsersVo().getRoleId());
				for (Iterator i = privilegeDatas.iterator(); i.hasNext();) {
					PrivilegeData pd = (PrivilegeData) i.next();
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, pd);
					pv.setParentId("-1");
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * 检查权限
	 * @param session
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private boolean checkPrivilege(UsersSession session) throws AppException {
		return true;
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getPrivilegeByRoleId(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	public List<PrivilegeVo> getPrivilegeByRoleId(UsersSession session, String roleId)
			throws AppException {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQueryAndNamedParam("getPrivilegeByRoleId",
								"roleId", roleId);
				for (PrivilegeData p : privilegeDatas) {
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, p);
					if (p.getParent() != null) {
						pv.setParentId(p.getParent().getPrivilegeId());
						pv.setParentName(p.getParent().getPrivilegeName());
					} else {
						pv.setParentId("-1");
					}
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getPrivilegeById(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	public PrivilegeVo getPrivilegeById(UsersSession session, String privilegeId)
			throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				PrivilegeData privilegeData = (PrivilegeData) privilegeDataDao
						.get(PrivilegeData.class, privilegeId);
				PrivilegeVo privilegeVo = new PrivilegeVo();
				BeanUtilsHelp.copyProperties(privilegeVo, privilegeData);
				if (null != privilegeData.getParent()) {
					privilegeVo.setParentId(privilegeData.getParent()
							.getPrivilegeId());
					privilegeVo.setParentName(privilegeData.getParent()
							.getPrivilegeName());
				} else {
					privilegeVo.setParentId("-1");
				}
				return privilegeVo;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000014", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#addPrivilege(com.cd_help.onlineOF.data.UsersSession, com.cd_help.onlineOF.web.vo.PrivilegeVo)
	 */
	public PrivilegeVo addPrivilege(UsersSession session, PrivilegeVo privilegeVo)
			throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				privilegeVo.setPrivilegeId(StringUtil.getUUID());
				PrivilegeData privilegeData = new PrivilegeData();
				BeanUtilsHelp.copyProperties(privilegeData, privilegeVo);
				PrivilegeData parentData = (PrivilegeData) privilegeDataDao
						.get(PrivilegeData.class, privilegeVo.getParentId());
				if (null != privilegeVo.getParentId()
						&& privilegeVo.getParentId().length() > 0) {
					privilegeData.setParent(parentData);
					if (privilegeVo.getKind().trim().equals("Model")) {
						parentData.setHasModelChild(1);
						parentData.setHasChild(1);
					} else {
						parentData.setHasChild(1);
					}
					privilegeDataDao.update(parentData);
				}
				if (privilegeVo.getHasModelChild() == 1) {
					privilegeData.setHasChild(1);
				}
				privilegeDataDao.save(privilegeData);
				return privilegeVo;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000014", "新建失败!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}

	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#deletePrivilege(com.cd_help.onlineOF.data.UsersSession, java.lang.String)
	 */
	public void deletePrivilege(UsersSession session, String id) throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				PrivilegeData privilegeData = (PrivilegeData) privilegeDataDao
						.get(PrivilegeData.class, id);
				List<RoleData> roleDatas = privilegeData.getRoleList();
				for(RoleData rd : roleDatas){
					rd.getPrivilegeList().remove(privilegeData);
				}
				
				String parentId = privilegeData.getParent().getPrivilegeId();
				privilegeDataDao.delete(privilegeData);
				PrivilegeData parentData = (PrivilegeData) privilegeDataDao
						.get(PrivilegeData.class, parentId);
				List<PrivilegeData> childPrivileges = privilegeDataDao
						.findByNamedQueryAndNamedParam("getChildPrivilege",
								"parentId", parentId);
				if (childPrivileges.size() == 0) {
					parentData.setHasChild(0);
					parentData.setHasModelChild(0);
				} else {
					List<PrivilegeData> privileges = privilegeDataDao
							.findByNamedQueryAndNamedParam(
									"getChildModelPrivilege", "parentId",
									parentId);
					if (privileges.size() == 0) {
						parentData.setHasModelChild(0);
					}
				}
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000014", "删除失败!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#updatePrivilege(com.cd_help.onlineOF.data.UsersSession, com.cd_help.onlineOF.web.vo.PrivilegeVo)
	 */
	public void updatePrivilege(UsersSession session, PrivilegeVo privilegeVo)
			throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				PrivilegeData privilegeData = (PrivilegeData) privilegeDataDao
						.get(PrivilegeData.class, privilegeVo.getPrivilegeId());
				BeanUtilsHelp.copyProperties(privilegeData, privilegeVo);
				if (privilegeVo.getHasModelChild() == 1) {
					privilegeData.setHasChild(1);
				} else {
					if (null != privilegeVo.getParentId()
							&& privilegeVo.getParentId().length() > 0) {
						PrivilegeData parentData = (PrivilegeData)privilegeDataDao.get(PrivilegeData.class, privilegeVo.getParentId());
						List<PrivilegeData> childModels = privilegeDataDao
						.findByNamedQueryAndNamedParam(
								"getChildModelPrivilege", "parentId",
								privilegeVo.getParentId());
						if (childModels.size() == 0) {
							parentData.setHasModelChild(0);
						}
						privilegeDataDao.update(parentData);
					}
				}
				privilegeDataDao.update(privilegeData);
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000014", "修改失败!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#loadAllModelPrivilege(com.cd_help.onlineOF.data.UsersSession)
	 */
	public List<PrivilegeVo> loadAllModelPrivilege(UsersSession session)
			throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = null;
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQuery("loadAllModelPrivilege");
				for (PrivilegeData p : privilegeDatas) {
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, p);
					if (null != p.getParent()) {
						pv.setParentId(p.getParent().getPrivilegeId());
						pv.setParentName(p.getParent().getPrivilegeName());
					} else {
						pv.setParentId("-1");
					}
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000014", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getChildPrivilege(java.lang.String)
	 */
	public List<PrivilegeVo> getChildPrivilege(UsersSession session, String parentId)
			throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQueryAndNamedParam("getChildPrivilege",
								"parentId", parentId);
				for (Iterator i = privilegeDatas.iterator(); i.hasNext();) {
					PrivilegeData pd = (PrivilegeData) i.next();
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, pd);
					pv.setParentId(parentId);
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.PrivilegeManager#getTopPrivilege()
	 */
	public List<PrivilegeVo> getTopPrivilege(UsersSession session) throws Exception {
		if (this.checkPrivilege(session)) {
			try {
				List<PrivilegeVo> privilegeVos = new ArrayList<PrivilegeVo>();
				List<PrivilegeData> privilegeDatas = privilegeDataDao
						.findByNamedQuery("getTopPrivilege");
				for (Iterator i = privilegeDatas.iterator(); i.hasNext();) {
					PrivilegeData pd = (PrivilegeData) i.next();
					PrivilegeVo pv = new PrivilegeVo();
					BeanUtilsHelp.copyProperties(pv, pd);
					pv.setParentId("-1");
					privilegeVos.add(pv);
				}
				return privilegeVos;
			} catch (Exception e) {
				log.error(e);
				throw new AppException("0000015", "系统错误,请联系系统管理员!", e);
			}
		} else {
			throw new AppException("0000000", "权限不够!");
		}
	}
}
