/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b><code></code></b>
 * <p/>
 * 订单类
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "orders")
@NamedQueries( {
		@NamedQuery(name = "searchTodayOrders", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ordersDate > :odate order by o.ordersDate"),
		@NamedQuery(name = "adminSearchTodayOrders", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ownerRestaurantData.name like :resName and o.ordersDate > :odate order by o.ordersDate"),

		@NamedQuery(name = "searchHistoryOrders", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ordersDate < :odate order by o.ordersDate"),
		@NamedQuery(name = "adminSearchHistoryOrders", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ownerRestaurantData.name like :resName and o.ordersDate < :odate order by o.ordersDate"),

		@NamedQuery(name = "searchOrdersByTimetamp", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ordersDate between :start and :end order by o.ordersDate"),
		@NamedQuery(name = "adminSearchOrdersByTimetamp", query = "from OrdersData o where o.memberName like :memName and o.status like :status and o.ownerRestaurantData.name like :resName and o.ordersDate between :start and :end order by o.ordersDate") })
public class OrdersData implements Serializable {

	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@Column(length = 32)
	private String ordersId;
	/**
	 * 订单号
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "orders_code", nullable = true, length = 24)
	private String ordersCode;

	/**
	 * 下单日期
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Temporal(TemporalType.DATE)
	private Date ordersDate;

	/**
	 * 备注
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "remark", nullable = true, length = 15)
	private String remark;

	/**
	 * 送餐地址
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "requestAddress", nullable = true, length = 15)
	private String requestAddress;
	/**
	 * 联系人
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactName", nullable = true, length = 15)
	private String contactName;

	/**
	 * 联系人性别
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactGender", nullable = true, length = 11)
	private Integer contactGender;
	/**
	 * 联系电话
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "contactPhone", nullable = true, length = 15)
	private String contactPhone;
	/**
	 * 狀態
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "status", nullable = true, length = 20)
	private String status;
	/**
	 * 订单项列表
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToMany(mappedBy = "ordersData", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<OrdersItemData> itemData;
	/**
	 * 订单用户Id
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "memberId", nullable = true, length = 32)
	private String memberId;
	/**
	 * 订单用户Name
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "memberName", nullable = true, length = 32)
	private String memberName;
	/**
	 * 所属餐厅酒店
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantId")
	private RestaurantData ownerRestaurantData;

	public List<OrdersItemData> getItemData() {
		return itemData;
	}

	public void setItemData(List<OrdersItemData> itemData) {
		this.itemData = itemData;
	}

	public RestaurantData getOwnerRestaurantData() {
		return ownerRestaurantData;
	}

	public void setOwnerRestaurantData(RestaurantData ownerRestaurantData) {
		this.ownerRestaurantData = ownerRestaurantData;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getContactGender() {
		return contactGender;
	}

	public void setContactGender(Integer contactGender) {
		this.contactGender = contactGender;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ordersId != null ? this.ordersId.hashCode() : super
				.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrdersData)) {
			return false;
		}
		OrdersData other = (OrdersData) object;
		if (this.ordersId != other.ordersId
				&& (this.ordersId == null || !this.ordersId
						.equals(other.ordersId))) {
			return false;
		}
		return true;
	}
}
