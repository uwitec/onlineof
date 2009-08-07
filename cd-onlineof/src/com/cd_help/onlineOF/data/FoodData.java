/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
		@NamedQuery(name = "loadAllFood", query = "select new com.cd_help.onlineOF.web.vo.FoodVo(f.foodId,f.name,f.price,f.number,f.introduction,f.img,f.isSigns) from FoodData f"),
		/* 根据餐厅和类别获取饮食信息 */
		@NamedQuery(name="getFoodAll",query="from FoodData"),
		@NamedQuery(name="getFoodByKindId",query="from FoodData f where f.food_kindId=:kindId"),
		@NamedQuery(name="getFoodByresIdAndKindId",query="from FoodData f where f.restaurantId = :restaurantId and f.food_kindId = :kindId and f.name like :foodName")
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
	 * 数量
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "number", nullable = true, length = 15)
	private Integer number;
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
	@Column(name = "isSigns", nullable = true, length = 15)
	private Integer isSigns = 0;

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

	/**
	 * 訂單
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(mappedBy = "foodList", fetch = FetchType.LAZY)
	private List<OrdersData> ordersList;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<OrdersData> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrdersData> ordersList) {
		this.ordersList = ordersList;
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

	public Integer getIsSigns() {
		return isSigns;
	}

	public void setIsSigns(Integer isSigns) {
		this.isSigns = isSigns;
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