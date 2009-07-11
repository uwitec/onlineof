/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席VO对象
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class BanquetVo {
	
	/**
	 * Constructs a <code>BanquetVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public BanquetVo(){}
	
	/**
	 * Constructs a <code>BanquetVo</code>
	 * @param banquetId
	 * @param name
	 * @param price
	 * @param discount
	 * @param restaurantId
	 * @param img
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public BanquetVo(Integer banquetId,String name,float price,float discount,Integer restaurantId,byte[] img){
		this.banquetId = banquetId;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.restaurantId = restaurantId;
		this.img = img;
	}
	
	/**
	 * 酒席ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer banquetId;
	/**
	 * 名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	/**
	 * 所属餐厅
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer restaurantId;
	/**
	 * 价格
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private float price;
	/**
	 * 折扣
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private float discount;
	/**
	 * 图片
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private byte[] img;
	
	public Integer getBanquetId() {
		return banquetId;
	}
	public void setBanquetId(Integer banquetId) {
		this.banquetId = banquetId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
}
