/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <b><code></code></b>
 * <p/>
 * 分页实体
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * 
 * @author TanDong
 * @version 0.0.0.1
 * 
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("pageBean")
@SuppressWarnings("unchecked")
public class PageBean {

	private int pagesize = 10; // 每页数据的条数
	private int currentPage = 1; // 当前页号
	private int totalPage; // 总页数
	private int totalRow; // 总记录数
	private List array; // 查询出来的数据
	
	public PageBean(){}
	
	public PageBean(int totalRow){
		this.totalPage = totalRow / pagesize;
	}
	
	public PageBean(int currentPage,int pagesize){
		this.currentPage = currentPage;
		this.pagesize = pagesize;
	}

	public List getArray() {
		return this.array;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getPagesize() {
		return this.pagesize;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public int getTotalRow() {
		return this.totalRow;
	}

	public void setArray(List array) {
		this.array = array;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
}