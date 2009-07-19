/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.vo.UsersVo;

@SuppressWarnings("serial")
@Service("usersAction")
public class UsersAction extends BaseAction{
	
	private UsersVo usersVo;
	private List<UsersVo> usersVoList;
	
	/**
	 * 加载所有用户
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String loadAllUsers(){
		log.debug("--->> begin loadAllUsers");
	    try {
	    	usersVoList = this.getOnlineOF().getUsersManager().loadAll(this.getSession());
		} catch (AppException e) {
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
}
