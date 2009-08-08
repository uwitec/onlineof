package com.cd_help.onlineOF.web.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <b><code></code></b>
 * <p/>
 * Comment here
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author ZhangZhen
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class Restaurant_kindVo implements Serializable{
	/*餐厅分类ID*/
	private String restaurant_kind_Id;
	/*餐厅分类名称*/
	private String name;
	/*餐厅分类描述*/
	private String description;
	/*餐厅分类创建时间*/
	private Timestamp createTime;

	
	public String getRestaurant_kind_Id() {
		return restaurant_kind_Id;
	}
	public void setRestaurant_kind_Id(String restaurant_kind_Id) {
		this.restaurant_kind_Id = restaurant_kind_Id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
