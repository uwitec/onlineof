/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.RoleVo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色处理Action
 * <p/>
 * <b>Creation Time:</b> Jul 25, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction{
	
	private RoleVo roleVo;
	private PageBean pb; // 分页
	private int page = 1;
	private String roleName;
	private String checksItem[] = {};
	private String roleId;
	private String action;
	private String rolePrivileges;
	
	/**
	 * 根据条件分页查询
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchRolesByPage() throws AppException{
		log.debug("--->> searchRolesByPage");
		String params[] = null;
		Object conditions[] = null;
		String hql = "searchRolesByPage";
		try{
			this.pb.setCurrentPage(page);
			this.pb.setPagesize(10);
			log.debug("--->> search by roleName: "+roleName);
			params = new String[] { "roleName"};
			conditions = new Object[] {
					null == this.roleName ? "%" : "%" + this.roleName + "%"};
			this.pb = this.getOnlineOF().getRoleManager().searchRolesByPage(hql,
					params, conditions, this.pb, this.getSession());
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 删除角色
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteRole() throws AppException{
		log.debug("--->> begin deleteRole");
		try {
			if(null != this.checksItem){
				for(int i=0; i<this.checksItem.length; i++){
					log.debug(this.checksItem[i]);
					this.getOnlineOF().getRoleManager().deleteRole(this.getSession(),
							this.checksItem[i]);
				}
			}
			this.searchRolesByPage();
		} catch (Exception e) {
			log.error(e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到新建角色页面
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String forwardAddNewRole(){
		log.debug("--->> begin forwardAddNewRole");
		action="addRole.do";
		roleVo = null;
		return SUCCESS;
	}
	
	/**
	 * 新建角色
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String addRole() throws AppException{
		log.debug("--->> begin addRole");
		try{
			this.getOnlineOF().getRoleManager().addRole(this.getSession(), roleVo);
			this.searchRolesByPage();
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到编辑角色页面
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editRole() throws AppException{
		log.debug("--->> begin editRole");
		try{
		    roleVo = this.getOnlineOF().getRoleManager().getRoleById(this.getSession(), roleId);
		    action="updateRole.do";
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到设置角色权限页面
	 * @return
	 * @throws Exception 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String setRolePrivilege() throws Exception{
		// 将角色ID放入request作用域
		log.debug("--->>> begin setRolePrivilege");
		try{
			String id = this.getRequest().getParameter("roleId");
			roleVo = this.getOnlineOF().getRoleManager().getRoleById(this.getSession(), id);
		}catch(Exception e){
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	
	/**
	 * 保存角色拥有权限
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String saveRolePrivilege() throws AppException{
		log.debug("--->> begin saveRolePrivilege--当前角色: "+roleId);
		try{
			String[] privileges = null;
			if (rolePrivileges != null) {
				privileges = rolePrivileges.split(",");
			}
			this.getOnlineOF().getRoleManager().saveRolePrivileges(this.getSession(), privileges, roleId);
			roleVo = this.getOnlineOF().getRoleManager().getRoleById(this.getSession(), roleId);
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage(),e);
		}
	    return SUCCESS;
	}
	
	/**
	 * 修改角色信息
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String updateRole() throws AppException {
		log.debug("--->> begin updateRole");
		try{
		    this.getOnlineOF().getRoleManager().updateRole(this.getSession(), roleVo);
		    this.searchRolesByPage();
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}

	public RoleVo getRoleVo() {
		return roleVo;
	}

	public void setRoleVo(RoleVo roleVo) {
		this.roleVo = roleVo;
	}

	public PageBean getPb() {
		return pb;
	}

	@Autowired
	@Resource(name = "pageBean")
	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String[] getChecksItem() {
		return checksItem;
	}

	public void setChecksItem(String[] checksItem) {
		this.checksItem = checksItem;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRolePrivileges() {
		return rolePrivileges;
	}

	public void setRolePrivileges(String rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}
}
