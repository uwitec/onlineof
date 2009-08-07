/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b><code></code></b> <p/> 餐厅类 <p/> <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "restaurant")
@NamedQueries( {
		@NamedQuery(name = "loadAllRestaurant", query = "select new com.cd_help.onlineOF.web.vo.RestaurantVo(r.restaurantId,r.name,r.address,r.openTime,r.closeTime,r.createName,r.contactName,r.contactPhone,r.QQ,r.mobilePhone,r.contactGender,r.status,r.introduction,r.email,r.img) from RestaurantData r"),
		@NamedQuery(name = "getRestaurantById", query = "select new com.cd_help.onlineOF.web.vo.RestaurantVo(r.restaurantId,r.name,r.address,r.openTime,r.closeTime,r.createName,r.contactName,r.contactPhone,r.QQ,r.mobilePhone,r.contactGender,r.status,r.introduction,r.email,r.img) from RestaurantData r where r.restaurantId = :restaurantId"),
		@NamedQuery(name = "getRestaurantAllPage", query = "from RestaurantData"),
		@NamedQuery(name = "getRestaurantByKindName", query = "from RestaurantData r where r.restaurant_kindId = :rkindId and r.name like :rname") 
		})
public class RestaurantData implements Serializable {

	/**
	 * 餐厅ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length = 32)
	private String restaurantId;
	/**
	 * 信誉ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "credibilityId", referencedColumnName = "credibilityId", nullable = true, insertable = false, updatable = false)
	private CredibilityData credibilityData;

	/**
	 * 拥有菜系
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToMany(mappedBy = "restaurant", cascade = { CascadeType.REFRESH,
			CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<CuisineData> cuisineDataList = new ArrayList<CuisineData>();

	/**
	 * 餐厅名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = true, length = 15)
	private String name;
	/**
	 * 餐厅地址
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "address", nullable = true, length = 15)
	private String address;
	/**
	 * 联系电话
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactPhone", nullable = true, length = 15)
	private String contactPhone;
	/**
	 * QQ
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "QQ", nullable = true, length = 15)
	private String QQ;
	/**
	 * 联系手机
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "mobilePhone", nullable = true, length = 15)
	private String mobilePhone;
	/**
	 * 联系人性别
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactGender", nullable = true, length = 11)
	private Integer contactGender;
	/**
	 * 创建人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "createName", nullable = true, length = 15)
	private String createName;
	/**
	 * 状态
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "status", nullable = true, length = 15)
	private Integer status;
	/**
	 * 开门时间
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "openTime", nullable = true, length = 15)
	private String openTime;
	/**
	 * 关门时间
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "closeTime", nullable = true, length = 15)
	private String closeTime;
	/**
	 * 餐厅简介
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "introduction", nullable = true, length = 500)
	private String introduction;
	/**
	 * 电子邮箱
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "email", nullable = true, length = 50)
	private String email;

	/**
	 * 联系人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactName", nullable = true, length = 15)
	private String contactName;
	/**
	 * 图片
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "img", columnDefinition = "LONGBLOB", nullable = true)
	private Blob img;
	/**
	 * 餐厅分类ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurant_kindId;
	/**
	 * 餐厅和菜分类一对多关联
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToMany(mappedBy="restaurant",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	private List<Food_kindData> foodKindlist = new ArrayList<Food_kindData>();

	public List<Food_kindData> getFoodKindlist() {
		return foodKindlist;
	}

	public void setFoodKindlist(List<Food_kindData> foodKindlist) {
		this.foodKindlist = foodKindlist;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurant_kindId() {
		return restaurant_kindId;
	}

	public void setRestaurant_kindId(String restaurant_kindId) {
		this.restaurant_kindId = restaurant_kindId;
	}

	public CredibilityData getCredibilityData() {
		return credibilityData;
	}

	public void setCredibilityData(CredibilityData credibilityData) {
		this.credibilityData = credibilityData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qq) {
		QQ = qq;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public Integer getContactGender() {
		return contactGender;
	}

	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public List<CuisineData> getCuisineDataList() {
		return cuisineDataList;
	}

	public void setCuisineDataList(List<CuisineData> cuisineDataList) {
		this.cuisineDataList = cuisineDataList;
	}
}
