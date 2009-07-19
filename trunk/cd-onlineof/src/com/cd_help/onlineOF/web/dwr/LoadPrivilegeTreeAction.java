/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.dwr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.data.Session;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.web.WebConstants;
import com.cd_help.onlineOF.web.struts.BaseAction;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 根据当前用户加载权限树
 * <p/>
 * <b>Creation Time:</b> Jul 18, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("loadPrivilegeTreeAction")
public class LoadPrivilegeTreeAction extends BaseAction{
	
	private List<PrivilegeVo> privileges = new ArrayList<PrivilegeVo>();
	
	 /**
	 * 根据当前用户加载权限树
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public List<PrivilegeVo> loadPrivilegeTree() {
		 log.debug("--->> being loadPrivilegeTree");
		 try{
			 // Session session = this.getSession();
			 HttpSession httpSession = WebContextFactory.get().getSession();
			 Session session = (Session)httpSession.getAttribute(WebConstants.ATTRIBUTE_SESSION);
			 System.out.println("用户ID: "+session.getUsersVo().getUsersId());
			 privileges = this.getOnlineOF().getPrivilegeManager().loadTopModelPrivilege(session);
			 for(PrivilegeVo pv : privileges){
				 System.out.print("模块权限: "+pv.getPrivilegeName());
			 }
		 }catch(AppException e){
			 e.printStackTrace();
		 }
		 return privileges;
	 }

	public List<PrivilegeVo> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegeVo> privileges) {
		this.privileges = privileges;
	}
}
