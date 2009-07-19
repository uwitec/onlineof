/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 信誉,等级(餐厅,用户,菜)
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "credibility")
public class CredibilityData implements Serializable{
	
    /**
     * 信誉ID
     * @since cd_help-onlineOF 0.0.0.1
     */
	@Id
    private String credibilityId;
    /**
     * 信誉称号
     * @since cd_help-onlineOF 0.0.0.1
     */
	@Column(name = "name", nullable = true, length = 15)
    private String name;
    
	public String getCredibilityId() {
		return credibilityId;
	}
	public void setCredibilityId(String credibilityId) {
		this.credibilityId = credibilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
