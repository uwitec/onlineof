/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.util.Date;

import com.cd_help.onlineOF.utils.ConvertUtils;

/**
 * <b><code></code></b>
 * <p/>
 * 订单VO对象
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("unused")
public class OrdersVo {

	/**
	 * Constructs a <code>OrdersVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public OrdersVo() {

	}

	/**
	 * Constructs a <code>OrdersVo</code>
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
	public OrdersVo(Integer ordersId, String ordersCode, Integer number,
			String remark, String contactPhone, String contactName,
			Integer contactGender, Date requestTime, String requestAddress,
			Date ordersDate) {
		this.ordersId = ordersId;
		this.ordersCode = ordersCode;
		this.number = number;
		this.remark = remark;
		this.contactPhone = contactPhone;
		this.contactName = contactName;
		this.contactGender = contactGender;
		this.requestTime = ConvertUtils.toString1(requestTime);
		this.requestAddress = requestAddress;
		this.ordersDate = ConvertUtils.toString1(ordersDate);
	}

	/**
	 * 订单ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer ordersId;
	/**
	 * 订单号
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String ordersCode;
	/**
	 * 数量
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer number;
	/**
	 * 联系人
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactName;
	/**
	 * 联系人性别
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer contactGender;
	/**
	 * 联系电话
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String contactPhone;
	/**
	 * 下单日期
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String ordersDate;
	/**
	 * 备注
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String remark;
	/**
	 * 送餐时间
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String requestTime;
	/**
	 * 送餐地址
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String requestAddress;

	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public String getOrdersCode() {
		return ordersCode;
	}

	public void setOrdersCode(String ordersCode) {
		this.ordersCode = ordersCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public Integer getContactGender() {
		return contactGender;
	}

	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
	}
}
