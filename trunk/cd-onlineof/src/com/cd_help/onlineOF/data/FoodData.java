/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries( { 
	/*获取所有饮食信息*/
	@NamedQuery(name = "loadAllFood", query = "select new com.cd_help.onlineOF.web.vo.FoodVo(f.foodId,f.name,f.price,f.introduction,f.img,f.isSigns) from FoodData f"), 
	/*根据餐厅获取饮食信息*/
	@NamedQuery(name = "getFoodByRestaurantId", query = "select new com.cd_help.onlineOF.web.vo.FoodVo(f.foodId,f.name,f.price,f.introduction,f.img,f.isSigns) from FoodData f join f.restaurantData r where r.restaurantId = :restaurantId"),
	/*根据餐厅和类别获取饮食信息*/
	@NamedQuery(name = "getFoodByKind", query = "select new com.cd_help.onlineOF.web.vo.FoodVo(f.foodId,f.name,f.price,f.introduction,f.img,f.isSigns) from FoodData f join f.food_kindData k where k.food_kind_Id = :food_kind_Id"),
})
public class FoodData {
	
	/**
	 * ID 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length=32)
	private String foodId;
	/**
	 * 名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	/**
	 * 价格
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "price", nullable = true, length = 15)
	private float price;
	/**
	 * 介绍
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "introduction", nullable = true, length = 50)
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
	@Column(name = "isSigns", nullable = true, length = 15)
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
