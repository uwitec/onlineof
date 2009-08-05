package com.cd_help.onlineOF.web.vo;

/**
 * 餐厅菜系VO类
 * <b><code></code></b>
 * <p/>
 * Comment here
 * <p/>
 * <b>Creation Time:</b> Aug 5, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class CuisineDataVo {
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
	
	/**
	 * 菜系描述
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String description;
	/**
	 * 餐厅编号
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;
	/**
	 * 餐厅名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
}
