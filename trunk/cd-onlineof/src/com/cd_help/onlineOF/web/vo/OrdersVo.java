/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.util.Date;
import java.util.Map;

import com.cd_help.onlineOF.utils.ConvertUtils;

/**
 * <b><code></code></b>
 * <p/>
 * 订单VO对象
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public class OrdersVo {

	/**
	 * Constructs a <code>OrdersVo</code>
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersVo() {

	}

	/**
	 * Constructs a <code>OrdersVo</code>
	 * 
	 * @param ordersId
	 * @param ordersCode
	 * @param number
	 * @param contactName
	 * @param contactPhone
	 * @param ordersDate
	 * @param remark
	 * @param requestTime
	 * @param requestAddress
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersVo(String ordersId, String ordersCode, String remark,
			String contactPhone, String contactName, Integer contactGender,
			String requestAddress, Date ordersDate) {
		this.ordersId = ordersId;
		this.ordersCode = ordersCode;
		this.remark = remark;
		this.contactPhone = contactPhone;
		this.contactName = contactName;
		this.contactGender = contactGender;
		this.requestAddress = requestAddress;
		this.ordersDate = ConvertUtils.toString1(ordersDate);
	}

	/**
	 * 订单ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String ordersId;
	/**
	 * 订单号
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String ordersCode;
	/**
	 * 联系人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactName;
	/**
	 * 联系人性别
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer contactGender;
	/**
	 * 联系电话
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactPhone;
	/**
	 * 下单日期
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String ordersDate;
	/**
	 * 备注
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String remark;
	/**
	 * 送餐地址
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String requestAddress;

	/**
	 * 餐厅ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantId;

	/**
	 * 餐厅名
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String restaurantName;
	/**
	 * 訂單狀態
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String status;
	/**
	 * 訂單用戶
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String loginName;
	/**
	 * 訂單飯菜
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Map<String, FoodVo> foodMap;

	public Map<String, FoodVo> getFoodMap() {
		return foodMap;
	}

	public void setFoodMap(Map<String, FoodVo> foodMap) {
		this.foodMap = foodMap;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}

	public String getOrdersCode() {
		return ordersCode;
	}

	public void setOrdersCode(String ordersCode) {
		this.ordersCode = ordersCode;
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

	public String getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRequestAddress() {
		return requestAddress;
	}

	public void setRequestAddress(String requestAddress) {
		this.requestAddress = requestAddress;
	}

	public Integer getContactGender() {
		return contactGender;
	}

	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
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
}