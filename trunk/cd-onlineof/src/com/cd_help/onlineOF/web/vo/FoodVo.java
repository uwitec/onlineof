/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public class FoodVo {

	/**
	 * ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String foodId;
	/**
	 * 名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	/**
	 * 价格
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private double price;
	/**
	 * 介绍
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String introduction;
	/**
	 * 数量
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer number;
	/**
	 * 图片
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private byte[] img;
	/**
	 * 是否是特色
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer isSigns;
	/**
	 * 所属菜系ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String food_kind_Id;
	/**
	 * 所属菜系名
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String food_kind_Name;
	/**
	 * 所属餐厅ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;
	/**
	 * 所属餐厅名
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantName;

	/**
	 * Constructs a <code>FoodVo</code>
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo() {
	}

	/**
	 * Constructs a <code>FoodVo</code>
	 * 
	 * @param foodId
	 * @param name
	 * @param price
	 * @param introduction
	 * @param img
	 * @param isSigns
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo(String foodId, String name, double price,
			String introduction, byte[] img, Integer isSigns) {
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.introduction = introduction;
		this.img = img;
		this.isSigns = isSigns;
	}

	public String getFood_kind_Id() {
		return food_kind_Id;
	}

	public void setFood_kind_Id(String food_kind_Id) {
		this.food_kind_Id = food_kind_Id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getIsSigns() {
		return isSigns;
	}

	public void setIsSigns(Integer isSigns) {
		this.isSigns = isSigns;
	}

	public String getFood_kind_Name() {
		return food_kind_Name;
	}

	public void setFood_kind_Name(String food_kind_Name) {
		this.food_kind_Name = food_kind_Name;
	}
}
