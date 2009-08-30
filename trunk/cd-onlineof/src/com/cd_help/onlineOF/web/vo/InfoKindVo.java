/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息分类VO
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class InfoKindVo {
	
	/**
	 * 信息分类ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String infoKindId;
	
	/**
	 * 分类名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	
	/**
	 * 描述
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String description;

	public String getInfoKindId() {
		return infoKindId;
	}

	public void setInfoKindId(String infoKindId) {
		this.infoKindId = infoKindId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
