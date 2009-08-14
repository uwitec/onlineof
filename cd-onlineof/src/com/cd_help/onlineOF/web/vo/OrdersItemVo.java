/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

import java.io.Serializable;

/**
 * <b><code></code></b>
 * <p/>
 * 订单项VO
 * <p/>
 * <b>Creation Time:</b> Jul 3, 2009
 * 
 * @author SongHao
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
public class OrdersItemVo implements Serializable{

	/**
	 * comment here
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String orders_itemId;

	private int num;

	private String foodId;

	private String name;

	private String kindName;

	private double price;

	public OrdersItemVo() {

	}

	public OrdersItemVo(String orders_itemId, Integer num) {
		this.orders_itemId = orders_itemId;
		this.num = num;
	}

	public String getOrders_itemId() {
		return orders_itemId;
	}

	public void setOrders_itemId(String orders_itemId) {
		this.orders_itemId = orders_itemId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}