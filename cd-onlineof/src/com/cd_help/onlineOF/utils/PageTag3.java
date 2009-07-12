/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <b><code></code></b>
 * <p/>
 * 分页标签3
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class PageTag3 extends TagSupport {

	private int pagesize; // 每页数据的条数
	private int currentPage; // 当前页号
	private int totalPage; // 总页数
	private int totalRow; // 总记录数
	private String url; // 一个包含参数的url

	public int doEndTag() throws JspException {
		try {
			StringBuffer text = new StringBuffer();

			if (this.url.indexOf("?") == -1) {
				// url不包含有?
				this.url = this.url + "?";
			} else {
				this.url = this.url + "&";
			}

			if (this.currentPage > 1) {
				text.append("<span class=\"nopage\"><a href=\"");
				text.append(this.url);
				text.append("page=");
				text.append(this.currentPage - 1);
				text.append("\">前一页</a></span>");
			} else {
				text.append("<span class=\"nopage\">");
				text.append("前一页</span>");
			}

			text.append("<span>...</span>");

			if (this.currentPage == this.totalPage) {
				text.append("<span>");
				text.append("下一页</span>");
			} else {
				text.append("<span><a href=\"");
				text.append(this.url);
				text.append("page=");
				text.append(this.currentPage + 1);
				text.append("\">下一页</a></span>");
			}

			this.pageContext.getOut().write(text.toString());
		} catch (Exception e) {

		}
		return Tag.EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
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

	public String getUrl() {
		return this.url;
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

	public void setUrl(String url) {
		this.url = url;
	}

}
