/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.sql.Blob;

/**
 * <b><code></code></b> <p/> 餐厅VO对象 <p/> <b>Creation Time:</b> Jul 4, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public class RestaurantVo {

	/**
	 * Constructs a <code>RestaurantVo</code>
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RestaurantVo() {

	}

	/**
	 * Constructs a <code>RestaurantVo</code>
	 * 
	 * @param restaurantId
	 * @param name
	 * @param address
	 * @param openTime
	 * @param closeTime
	 * @param createName
	 * @param contactName
	 * @param contactPhone
	 * @param QQ
	 * @param mobilePhone
	 * @param contactGender
	 * @param status
	 * @param introduction
	 * @param email
	 * @param img
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public RestaurantVo(String restaurantId, String name, String address,
			String openTime, String closeTime, String createName,
			String contactName, String contactPhone, String QQ,
			String mobilePhone, Integer contactGender, Integer status,
			String introduction, String email, Blob img) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.closeTime = closeTime;
		this.openTime = openTime;
		this.address = address;
		this.createName = createName;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.email = email;
		this.img = img;
		this.introduction = introduction;
		this.mobilePhone = mobilePhone;
		this.status = status;
		this.contactGender = contactGender;
	}

	/**
	 * 餐厅ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;
	/**
	 * 名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	/**
	 * 地址
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String address;
	/**
	 * 餐厅开门时间
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String openTime;
	/**
	 * 餐厅关闭时间
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String closeTime;
	/**
	 * 创建人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String createName;
	/**
	 * 联系人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactName;
	/**
	 * 联系人电话
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactPhone;
	/**
	 * QQ
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String QQ;
	/**
	 * 联系人手机
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String mobilePhone;
	/**
	 * 联系人性别
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer contactGender;
	/**
	 * 状态
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer status;
	/**
	 * 餐厅简介
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String introduction;
	/**
	 * 联系人邮箱
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String email;
	/**
	 * 图片
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Blob img;
	/**
	 * 餐厅分类名称
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String resKindName;
	/**
	 * 餐厅分类ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String resKindId;

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
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

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public Integer getContactGender() {
		return contactGender;
	}

	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getResKindName() {
		return resKindName;
	}

	public void setResKindName(String resKindName) {
		this.resKindName = resKindName;
	}

	public String getResKindId() {
		return resKindId;
	}

	public void setResKindId(String resKindId) {
		this.resKindId = resKindId;
	}
}
