/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食类别VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class Food_kindVo {
	
	/**
	 * 类别ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String food_kind_Id;
	/**
	 * 类别名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	
	/**
	 * Constructs a <code>Food_kindVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Food_kindVo(){}
	
	/**
	 * Constructs a <code>Food_kindVo</code>
	 * @param food_kind_Id
	 * @param food_kind_Name
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Food_kindVo(String food_kind_Id,String name){
		this.food_kind_Id = food_kind_Id;
		this.name = name;
	}
	
	public String getFood_kind_Id() {
		return food_kind_Id;
	}
	public void setFood_kind_Id(String food_kind_Id) {
		this.food_kind_Id = food_kind_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
