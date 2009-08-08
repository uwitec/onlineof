/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.io.Serializable;
import java.sql.Blob;

/**
 * <b><code></code></b> <p/> 饮食VO <p/> <b>Creation Time:</b> Jul 18, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class FoodVo implements Serializable{

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
	private Blob img;
	/**
	 * 是否是特色
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer isSigns;
	/**
	 * 所属菜分类ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String food_kindId;
	/**
	 * 所属菜分类名称
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
	public FoodVo(String foodId, String name, double price,Integer number,
			String introduction, Blob img, Integer isSigns) {
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.number = number;
		this.introduction = introduction;
		this.img = img;
		this.isSigns = isSigns;
	}

	/**
	 * 
	 * Constructs a <code>FoodVo</code>
	 * @param foodId 菜ID
	 * @param name   菜名称
	 * @param price  菜价格
	 * @param introduction 菜简介
	 * @param img         菜图片
	 * @param isSigns     是否招牌菜
	 * @param kindId      菜分类ID
	 * @param kindName    菜分类名称
	 * @param restauantId 所属餐厅ID
	 * @param restaurantName  所属餐厅名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo(String foodId, String name, double price,
			String introduction, Blob img, Integer isSigns, String kindId,
			String kindName, String restauantId, String restaurantName) {
		this.foodId = foodId;   
		this.name = name;
		this.price = price;
		this.introduction = introduction;
		this.img = img;
		this.isSigns = isSigns;
		this.food_kindId = kindId;
		this.food_kind_Name = kindName;
		this.restaurantId = restauantId;
		this.restaurantName = restaurantName;
	}



	public String getFood_kindId() {
		return food_kindId;
	}

	public void setFood_kindId(String food_kindId) {
		this.food_kindId = food_kindId;
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

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
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
