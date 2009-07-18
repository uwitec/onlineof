/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 角色VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class RoleVo {
	
	private String roleId;
	private String roleName;
	
	/**
	 * Constructs a <code>RoleVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleVo(){}
	
	/**
	 * Constructs a <code>RoleVo</code>
	 * @param roleId
	 * @param roleName
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RoleVo(String roleId,String roleName){
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
