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
 * 权限VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class PrivilegeVo implements Serializable{

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
	 * 权限类别(模块/操作)
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String kind;
	/**
	 * 请求路径
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String url;
	/**
	 * 对应的方法名
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String methodName;
	/**
	 * 是否有子
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer hasChild;
	/**
	 * 是否有子模块
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer hasModelChild;

	/**
	 * Constructs a <code>PrivilegeVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeVo() {
	}

	/**
	 * Constructs a <code>PrivilegeVo</code>
	 * @param privilegeId
	 * @param privilegeName
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public PrivilegeVo(String privilegeId, String privilegeName,
			String parentId, String parentName, String kind, String url,
			String methodName, Integer hasChild,Integer hasModelChild) {
		this.privilegeId = privilegeId;
		this.privilegeName = privilegeName;
		this.parentId = parentId;
		this.parentName = parentName;
		this.kind = kind;
		this.url = url;
		this.methodName = methodName;
		this.hasChild = hasChild;
		this.hasModelChild = hasModelChild;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Integer getHasChild() {
		return hasChild;
	}

	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}

	public Integer getHasModelChild() {
		return hasModelChild;
	}

	public void setHasModelChild(Integer hasModelChild) {
		this.hasModelChild = hasModelChild;
	}
}
