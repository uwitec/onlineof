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
 * 分页标签1
 * <p/>
 * <b>Creation Time:</b> Jul 12, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class PageTag1 extends TagSupport {

	private int pagesize; // 每页数据的条数
	private int currentPage; // 当前页号
	private int totalPage; // 总页数
	private int totalRow; // 总记录数
	private int liststep; // 最多显示分页页数
	private String dispalytext; // 页面显示的文字
	private String url; // 一个包含参数的url

	@Override
	public int doEndTag() throws JspException {
		try {
			int listbegin = this.currentPage - this.liststep / 2;
			if (listbegin < 1) {
				listbegin = 1;
			}

			int listend = this.currentPage + this.liststep / 2;
			if (listend > this.totalPage) {
				listend = this.totalPage;
			}
			this.pageContext.getOut().write(
					this.getTextString(listbegin, listend));
		} catch (Exception e) {

		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public String getDispalytext() {
		return this.dispalytext;
	}

	public int getListstep() {
		return this.liststep;
	}

	public int getPagesize() {
		return this.pagesize;
	}

	private String getTextString(int listbegin, int listend) {

		StringBuffer text = new StringBuffer();
		text.append("<span class=\"gray\"><strong>");
		text.append(this.totalRow);
		text.append(this.dispalytext);
		text.append("</strong></span><span class=\"gray\"><strong>");
		text.append(this.currentPage);
		text.append("/");
		text.append(this.totalPage);

		text.append("页</strong></span>");
		if (this.url.indexOf("?") == -1) {
			// url不包含有?
			this.url = this.url + "?";
		} else {
			this.url = this.url + "&";
		}
		if (this.currentPage > 1) {
			text.append("<span class=\"number\"><a href=\"");
			text.append(this.url);
			text.append("page=");
			text.append(1);
			text.append("\">首页</a></span>");
			text.append("<span class=\"number\"><a href=\"");
			text.append(this.url);
			text.append("page=");
			text.append(this.currentPage - 1);
			text.append("\">上一页</a></span>");
		} else {
			text.append("<span class=\"number\">");
			text.append("首页</span>");
			text.append("<span class=\"number\">");
			text.append("上一页</span>");
		}

		for (int i = listbegin; i <= listend; i++) {
			if (i == this.currentPage) {
				text.append("<span class=\"number current\">");
				text.append(i);
				text.append("</span>");
			} else {
				text.append("<span class=\"number\"><a href=\"");
				text.append(this.url);
				text.append("page=");
				text.append(i);
				text.append("\">");
				text.append(i);
				text.append("</a></span>");
			}
		}

		if (this.currentPage == this.totalPage) {
			text.append("<span class=\"number\">");
			text.append("下一页</span>");
			text.append("<span class=\"number\">");
			text.append("尾页</span>");
		} else {
			text.append("<span class=\"number\"><a href=\"");
			text.append(this.url);
			text.append("page=");
			text.append(this.currentPage + 1);
			text.append("\">下一页</a></span>");
			text.append("<span class=\"number\"><a href=\"");
			text.append(this.url);
			text.append("page=");
			text.append(this.totalPage);
			text.append("\">尾页</a></span>");
		}

		return text.toString();
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

	public void setDispalytext(String dispalytext) {
		this.dispalytext = dispalytext;
	}

	public void setListstep(int liststep) {
		this.liststep = liststep;
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
