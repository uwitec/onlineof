/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 餐厅类别VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class Restaurant_kindVo {
	
	/**
	 * ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurant_kind_Id;
	
	/**
	 * 类别名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	
	/**
	 * Constructs a <code>Restaurant_kindVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Restaurant_kindVo(){
		
	}
	
	/**
	 * Constructs a <code>Restaurant_kindVo</code>
	 * @param restaurant_kind_Id
	 * @param name
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public Restaurant_kindVo(String restaurant_kind_Id,String name){
		this.restaurant_kind_Id = restaurant_kind_Id;
		this.name = name;
	}

	public String getRestaurant_kind_Id() {
		return restaurant_kind_Id;
	}

	public void setRestaurant_kind_Id(String restaurant_kind_Id) {
		this.restaurant_kind_Id = restaurant_kind_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
