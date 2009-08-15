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
 * 信息实体类
 * <p/>
 * <b>Creation Time:</b> Aug 15, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name="info")
@SuppressWarnings("serial")
public class InfoData implements Serializable {
	
	private String infoId;
	
	private String title;
	
	private String content;
	
	private InfoKindData infokind;

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

	public InfoKindData getInfokind() {
		return infokind;
	}

	public void setInfokind(InfoKindData infokind) {
		this.infokind = infokind;
	}
}
