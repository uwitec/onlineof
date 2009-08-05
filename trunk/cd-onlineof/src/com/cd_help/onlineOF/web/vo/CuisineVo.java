/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 菜系VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class CuisineVo {
	/**
	 * 菜系ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String cuisineId;
	/**
	 * 菜系名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	public String getCuisineId() {
		return cuisineId;
	}
	public void setCuisineId(String cuisineId) {
		this.cuisineId = cuisineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
