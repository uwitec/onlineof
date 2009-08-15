/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 订单项实体类
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author SongHao
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "orders_item")
public class OrdersItemData implements Serializable {

	/**
	 * comment here
	 * 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 32)
	private String orders_itemId;
	
	@Column(name = "foodId", nullable = true, length = 32)
	private String foodId;

	/**
	 * NUMBER
	 */
	@Column(name = "num", nullable = true, length = 11)
	private Integer num;

	/**
	 * ORDER
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "ordersId")
	private OrdersData ordersData;

	public OrdersData getOrdersData() {
		return ordersData;
	}

	public void setOrdersData(OrdersData ordersData) {
		this.ordersData = ordersData;
	}

	public String getOrders_itemId() {
		return orders_itemId;
	}

	public void setOrders_itemId(String orders_itemId) {
		this.orders_itemId = orders_itemId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
}
