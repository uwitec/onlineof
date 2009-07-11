/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 信誉(餐厅,用户,菜)
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "credibility")
public class CredibilityData {
	
    /**
     * 信誉ID
     * @since cd_help-onlineOF 0.0.0.1
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer credibilityId;
    /**
     * 信誉称号
     * @since cd_help-onlineOF 0.0.0.1
     */
	@Column(name = "name", nullable = false, length = 15)
    private String name;
    
	public Integer getCredibilityId() {
		return credibilityId;
	}
	public void setCredibilityId(Integer credibilityId) {
		this.credibilityId = credibilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
