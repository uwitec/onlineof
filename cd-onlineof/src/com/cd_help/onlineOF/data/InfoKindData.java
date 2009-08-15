/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 信息类别实体类
 * <p/>
 * <b>Creation Time:</b> Aug 15, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name="infokind")
public class InfoKindData implements Serializable {

	
	/**
	 * 信息类别ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String infoKindId;
	
	/**
	 * 信息类别名称
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
