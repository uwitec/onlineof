/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.vo;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食VO
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
public class FoodVo {
	
	/**
	 * ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String foodId;
	/**
	 * 名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String name;
	/**
	 * 价格
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private float price;
	/**
	 * 介绍
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private String introduction;
	/**
	 * 图片
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private byte[] img;
	/**
	 * 是否是特色
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	private Integer isSigns;
	
	/**
	 * Constructs a <code>FoodVo</code>
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo(){}
	/**
	 * Constructs a <code>FoodVo</code>
	 * @param foodId
	 * @param name
	 * @param price
	 * @param introduction
	 * @param img
	 * @param isSigns
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public FoodVo(String foodId,String name,float price,String introduction,byte[] img,Integer isSigns){
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.introduction = introduction;
		this.img = img;
		this.isSigns = isSigns;
	}
	private String food_kind_Name;
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public Integer getIsSigns() {
		return isSigns;
	}
	public void setIsSigns(Integer isSigns) {
		this.isSigns = isSigns;
	}
	public String getFood_kind_Name() {
		return food_kind_Name;
	}
	public void setFood_kind_Name(String food_kind_Name) {
		this.food_kind_Name = food_kind_Name;
	}
}
