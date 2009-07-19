/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 菜系(川菜,粤菜,.....)
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name="cuisine")
public class CuisineData implements Serializable{
	
	/**
	 * 菜系ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	private String cuisineId;
	/**
	 * 菜系名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	
	/**
	 * 所属餐厅
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(mappedBy = "cuisineDataList")
	private List<RestaurantData> restaurantList = new ArrayList<RestaurantData>();
	
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
	public List<RestaurantData> getRestaurantList() {
		return restaurantList;
	}
	public void setRestaurantList(List<RestaurantData> restaurantList) {
		this.restaurantList = restaurantList;
	}
}
