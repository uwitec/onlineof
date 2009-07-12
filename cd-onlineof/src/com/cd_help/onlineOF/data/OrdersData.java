/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b><code></code></b>
 * <p/>
 * 订单类
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "orders")
@NamedQueries( { 
	@NamedQuery(name = "loadAllOrders", query = "select new com.cd_help.onlineOF.web.vo.OrdersVo(o.ordersId,o.ordersCode,o.number,o.remark,o.contactPhone,o.contactName,o.contactGender,o.requestTime,o.requestAddress,o.ordersDate) from OrdersData o"), 
})
public class OrdersData implements Serializable{
	
	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordersId;
	/**
	 * 订单号
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "orders_code", nullable = false, length = 15)
	private String ordersCode;
	
	/**
	 * 数量
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "number", nullable = false, length = 15)
	private Integer number;
	
	/**
	 * 下单日期
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Temporal(TemporalType.DATE)
	private Date ordersDate;
	/**
	 * 备注
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "remark", nullable = false, length = 15)
	private String remark;
	/**
	 * 就餐时间
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Temporal(TemporalType.DATE)
	private Date requestTime;
	/**
	 * 送餐地址
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "requestAddress", nullable = false, length = 15)
	private String requestAddress;
	/**
	 * 联系人
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactName", nullable = false, length = 15)
	private String contactName;
	
	/**
	 * 联系人性别
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactGender", nullable = false, length = 11)
	private Integer contactGender;
	/**
	 * 联系电话
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactPhone", nullable = false, length = 15)
	private String contactPhone;
	/**
	 * 所订饮食
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "foodId", referencedColumnName = "foodId", nullable = false, insertable = false, updatable = false)
	private FoodData foodData;
	
	/**
	 * 餐厅ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false, insertable = false, updatable = false)
	private RestaurantData restaurantData;
	
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
	public Date getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getRequestAddress() {
		return requestAddress;
	}
	public void setRequestAddress(String requestAddress) {
		this.requestAddress = requestAddress;
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
	public FoodData getFoodData() {
		return foodData;
	}
	public void setFoodData(FoodData foodData) {
		this.foodData = foodData;
	}
	public RestaurantData getRestaurantData() {
		return restaurantData;
	}
	public void setRestaurantData(RestaurantData restaurantData) {
		this.restaurantData = restaurantData;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getContactGender() {
		return contactGender;
	}
	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
	}
	public int hashCode() {
		int hash = 0;
		hash += (this.ordersId != null ? this.ordersId.hashCode() : super.hashCode());
		return hash;
	}
	public boolean equals(Object object) {
		if (!(object instanceof OrdersData)) {
			return false;
		}
		OrdersData other = (OrdersData) object;
		if (this.ordersId != other.ordersId
				&& (this.ordersId == null || !this.ordersId.equals(other.ordersId))){
			return false;
		}
		return true;
	}
}
