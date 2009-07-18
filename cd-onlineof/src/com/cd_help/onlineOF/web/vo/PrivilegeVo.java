/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class PrivilegeVo {

	/**
	 * ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String privilegeId;
	/**
	 * 名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String privilegeName;
	/**
	 * 上级
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String parentId;
	
	/**
	 * 上级名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String parentName;
	
	/**
	 * Constructs a <code>PrivilegeVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeVo(){}
	
	/**
	 * Constructs a <code>PrivilegeVo</code>
	 * @param privilegeId
	 * @param privilegeName
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeVo(String privilegeId,String privilegeName,String parentId,String parentName){
		this.privilegeId = privilegeId;
		this.privilegeName = privilegeName;
		this.parentId = parentId;
		this.parentName = parentName;
	}

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
