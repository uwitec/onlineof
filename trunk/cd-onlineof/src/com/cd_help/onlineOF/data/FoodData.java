/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食类(菜,饭,酒席)
 * <p/>
 * <b>Creation Time:</b> Jul 5, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name="food")
public class FoodData {
	
	/**
	 * ID 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer foodId;
	/**
	 * 名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = false, length = 15)
	private String name;
	/**
	 * 价格
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "price", nullable = false, length = 15)
	private float price;
	/**
	 * 介绍
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "introduction", nullable = false, length = 50)
	private String introduction;
	/**
	 * 图片
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name="img", columnDefinition="BLOB",nullable=true)
	private byte[] img;
	/**
	 * 是否是特色
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "isSigns", nullable = false, length = 15)
	private Integer isSigns = 0;
	
	/**
	 * 所属餐厅
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false, insertable = false, updatable = false)
	private RestaurantData restaurantData;
	
	/**
	 * 类别
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_kind_Id", referencedColumnName = "food_kind_Id", nullable = false, insertable = false, updatable = false)
	private Food_kindData food_kindData;
	
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
	public RestaurantData getRestaurantData() {
		return restaurantData;
	}
	public void setRestaurantData(RestaurantData restaurantData) {
		this.restaurantData = restaurantData;
	}
	public Food_kindData getFood_kindData() {
		return food_kindData;
	}
	public void setFood_kindData(Food_kindData food_kindData) {
		this.food_kindData = food_kindData;
	}
}
