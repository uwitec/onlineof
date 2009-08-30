/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.admin.struts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.BaseAction;
import com.cd_help.onlineOF.web.vo.InfoVo;

/**
 * <b><code></code></b>
 * <p/>
 * 信息管理Action
 * <p/>
 * <b>Creation Time:</b> Aug 30, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("infoManagerAction")
@Scope("prototype")
public class InfoManagerAction extends BaseAction {

	private String infoId;
	private InfoVo infoVo = new InfoVo(); // 用户
	@Autowired
	@Resource(name = "pageBean")
	private PageBean pb; // 分页
	private int page = 1;
	private String title; // 信息标题
	private List<InfoVo> infoVos = new ArrayList<InfoVo>();

	/**
	 * 分页获取信息列表
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchInfosByPage() throws AppException {
		String hqlName= "searchInfosByPage";
		String params[] = null;
		Object conditions[] = null;
		try{
			this.pb.setCurrentPage(page);
			this.pb.setPagesize(10);
			log.debug("--->> search by title: " + title);
			params = new String[] { "title"};
			conditions = new Object[] {
					null == this.title ? "%" : "%" + this.title + "%"};
			
			this.getOnlineOF().getInfoManager().searchInfosByPage(hqlName,
					params, conditions, pb, this.getSession());
		}catch(AppException e){
			throw new AppException(e.getError_code(),e.getMessage(),e);
		}
		return SUCCESS;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public InfoVo getInfoVo() {
		return infoVo;
	}

	public void setInfoVo(InfoVo infoVo) {
		this.infoVo = infoVo;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<InfoVo> getInfoVos() {
		return infoVos;
	}

	public void setInfoVos(List<InfoVo> infoVos) {
		this.infoVos = infoVos;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
