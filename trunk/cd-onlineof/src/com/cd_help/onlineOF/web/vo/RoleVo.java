/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.io.Serializable;

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
@SuppressWarnings("serial")
public class RoleVo implements Serializable{
	
	/**
	 * 角色ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String roleId;
	/**
	 * 角色名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String roleName;
	
	/**
	 * 标识
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String path;
	
	/**
	 * 描述
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String description;
	
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
	public RoleVo(String roleId,String roleName,String description, String path){
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.path = path;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
