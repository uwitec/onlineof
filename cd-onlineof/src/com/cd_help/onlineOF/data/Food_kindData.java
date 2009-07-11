/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b><code></code></b>
 * <p/>
 * 饮食类别
 * <p/>
 * <b>Creation Time:</b> Jul 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Entity
@Table(name = "dishes_kind")
public class Food_kindData {

	/**
	 * 菜类别ID
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer food_kind_Id;
	/**
	 * 菜类别名称
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	@Column(name = "name", nullable = false, length = 15)
	private String name;
	
	public Integer getFood_kind_Id() {
		return food_kind_Id;
	}
	public void setFood_kind_Id(Integer food_kind_Id) {
		this.food_kind_Id = food_kind_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
