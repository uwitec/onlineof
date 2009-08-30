/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.util.Date;

/**
 * <b><code></code></b>
 * <p/>
 * 信息VO
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class InfoVo {
	
	/**
	 * ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String infoId;
	
	/**
	 * 信息标题
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String title;
	
	/**
	 * 信息内容
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String content;
	
	/**
	 * 发布时间
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Date createTime;
	
	private String createTimeStr;
	
	private String modifyTimeStr;
	
	/**
	 * 修改时间
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Date modifyTime;
	
	/**
	 * 发布者
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String createUser;
	
	/**
	 * 修改者
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String modifyUser;
	
	/**
	 * 信息类别ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String infoKindId;
	/**
	 * 信息类别名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String infoKindName;

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getInfoKindId() {
		return infoKindId;
	}

	public void setInfoKindId(String infoKindId) {
		this.infoKindId = infoKindId;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getModifyTimeStr() {
		return modifyTimeStr;
	}

	public void setModifyTimeStr(String modifyTimeStr) {
		this.modifyTimeStr = modifyTimeStr;
	}

	public String getInfoKindName() {
		return infoKindName;
	}

	public void setInfoKindName(String infoKindName) {
		this.infoKindName = infoKindName;
	}
}
