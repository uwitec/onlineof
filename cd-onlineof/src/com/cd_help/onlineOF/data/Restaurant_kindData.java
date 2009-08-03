/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b><code></code></b> <p/> 餐厅类别 <p/> <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "restaurant_kind")
@NamedQueries( {
		@NamedQuery(name = "getResKindAllPage", query = "from Restaurant_kindData r"),
		@NamedQuery(name = "getResKindByNamePage", query = "from Restaurant_kindData r where r.name = :name") })
public class Restaurant_kindData implements Serializable {
	/**
	 * 餐厅类别ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length = 32)
	private String restaurant_kind_Id;
	/**
	 * 餐厅类别名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	/**
	 * 餐厅分类描述
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(nullable = true, columnDefinition = "TEXT")
	private String description;
	/**
	 * 餐厅分类创建时间
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Timestamp createTime;
	/**
	 * 餐厅分类和餐厅关系
	 */
	@OneToMany(mappedBy = "restaurant_kindData", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<RestaurantData> restaurantDatas = new ArrayList<RestaurantData>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	public List<RestaurantData> getRestaurantDatas() {
		return restaurantDatas;
	}

	public void setRestaurantDatas(List<RestaurantData> restaurantDatas) {
		this.restaurantDatas = restaurantDatas;
	}
}
