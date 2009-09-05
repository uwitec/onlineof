/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食类(菜,饭,酒席)
 * <p/>
 * <b>Creation Time:</b> Jul 5, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "food")
@NamedQueries( {
		/* 获取所有饮食信息 */
		@NamedQuery(name = "loadAllFood", query = "select new com.cd_help.onlineOF.web.vo.FoodVo(f.foodId,f.name,f.price,f.introduction,f.img,f.isSig) from FoodData f"),
		/* 根据餐厅和类别获取饮食信息 */
		@NamedQuery(name="getFoodAll",query="from FoodData"),
		/* 获取招牌饮食信息 */
		@NamedQuery(name="getSignFoods",query="from FoodData f where f.isSig=1"),
		@NamedQuery(name="getFoodByKindId",query="from FoodData f where f.food_kindId=:kindId"),
		@NamedQuery(name="getFoodByresIdAndKindId",query="from FoodData f where f.restaurantId = :restaurantId and f.food_kindId = :kindId and f.name like :foodName"),
		@NamedQuery(name="getFoodByresIdAndFoodName",query="from FoodData f where f.restaurantId = :restaurantId and f.name like :foodName"),
		// 首页获取招牌菜
		@NamedQuery(name="getFoodByRestaurantId",query="from FoodData f where f.restaurantId=:restaurantId and f.isSig=1")
		})
public class FoodData implements Serializable {

	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length = 32)
	private String foodId;
	/**
	 * 名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	/**
	 * 价格
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "price", nullable = true, length = 15)
	private double price;
	/**
	 * 介绍
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "introduction", nullable = true, length = 50)
	private String introduction;
	/**
	 * 图片
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "img", columnDefinition = "LONGBLOB", nullable = true)
	private Blob img;
	/**
	 * 是否是特色
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "isSig", nullable = true, length = 15)
	private Integer isSig = 0;

	/**
	 * 类别ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String food_kindId;
	
	/**
	 * 餐厅ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
    
	public Integer getIsSig() {
		return isSig;
	}

	public void setIsSig(Integer isSig) {
		this.isSig = isSig;
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

}