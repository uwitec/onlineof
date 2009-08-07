/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食类别(主菜,配菜,饮料......)
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "food_kind")
@NamedQueries({
	@NamedQuery(name="getFoodkindAll",query="from Food_kindData"),
	@NamedQuery(name="countFoodkindByName",query="from Food_kindData fk join fk.restaurant r where fk.name like :kindName and r.name like :restaurantName"),
	@NamedQuery(name="countFoodkindByResId",query="from Food_kindData fk join fk.restaurant r where r.restaurantId = :restaurantId")
})
public class Food_kindData implements Serializable{

	/**
	 * 菜类别ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length=32,name="food_kind_Id")
	private String food_kind_Id;
	/**
	 * 菜类别名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	
	/**
	 * 菜类别描述
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String description;
	/**
	 * 关联餐厅
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	@JoinColumn(name="restaurantId")
	private RestaurantData restaurant = null;
	
	/**
	 * 关联菜
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToMany(mappedBy="food_kindData",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	private List<FoodData> foodList = new ArrayList<FoodData>();
	
	public List<FoodData> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<FoodData> foodList) {
		this.foodList = foodList;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RestaurantData getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(RestaurantData restaurant) {
		this.restaurant = restaurant;
	}
}
