/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.UsersVo;

@SuppressWarnings("serial")
@Service("usersAction")
public class UsersAction extends BaseAction{
	
	private String usersId;
	private UsersVo usersVo;
	private List<UsersVo> usersVoList;
	private PageBean pb = new PageBean();
	private int page = 1;
	
	/**
	 * 加载所有用户
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loadAllUsers(){
		log.debug("--->> begin loadAllUsers");
	    try {
	    	//usersVoList = this.getOnlineOF().getUsersManager().loadAll(this.getSession());
	    	pb.setCurrentPage(page);
	    	System.out.println(page);
	    	pb.setPagesize(2);
	    	pb = this.getOnlineOF().getUsersManager().loadAll("loadAllByPage", null, null, pb);
		} catch (AppException e) {
			e.printStackTrace();
		}	
	    return SUCCESS;	
	}
	
	/**
	 * 删除用户
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deleteUsers(){
		log.debug("--->> begin deleteUsers");
		try {
			this.getOnlineOF().getUsersManager().delete(this.getSession(), usersId);
			usersVoList = this.getOnlineOF().getUsersManager().loadAll(this.getSession());
		} catch (AppException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 根据ID获取信息
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String getUsersById(){
		log.debug("--->> begin getUsersById");
		try{
			usersVo = this.getOnlineOF().getUsersManager().get(this.getSession(), usersId);
		}catch(AppException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public UsersVo getUsersVo() {
		return usersVo;
	}
	public void setUsersVo(UsersVo usersVo) {
		this.usersVo = usersVo;
	}
	public List<UsersVo> getUsersVoList() {
		return usersVoList;
	}
	public void setUsersVoList(List<UsersVo> usersVoList) {
		this.usersVoList = usersVoList;
	}
	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
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
}
