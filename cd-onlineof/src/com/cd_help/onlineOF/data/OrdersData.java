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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "orders")
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
	@Column(name = "orders_code", nullable = true, length = 15)
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
	 * 所订饮食
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "orders_food", joinColumns = { @JoinColumn(name = "foodId") }, inverseJoinColumns = { @JoinColumn(name = "ordersId") })
	private List<FoodData> foodList;
	/**
	 * 订单用户
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId", referencedColumnName = "memberId", nullable = false, insertable = false, updatable = false)
	private MemberData memberData;

	public MemberData getMemberData() {
		return memberData;
	}

	public void setMemberData(MemberData memberData) {
		this.memberData = memberData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FoodData> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodData> foodList) {
		this.foodList = foodList;
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
