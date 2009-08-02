/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.PageBean;
import com.cd_help.onlineOF.web.vo.PrivilegeVo;

/**
 * <b><code></code></b>
 * <p/>
 * 权限管理
 * <p/>
 * <b>Creation Time:</b> Aug 2, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
@Service("privilegeAction")
public class PrivilegeAction extends BaseAction{
	
	private List<PrivilegeVo> privilegeVos;  // 所有权限
	private PageBean pb; // 分页
	private int page = 1;
	private String privilegeName;
	private PrivilegeVo privilegeVo;
	private String privilegeId;
	private String action;
	private String checksItem[] = {};
	
	/**
	 * 获取所有权限
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String searchPrivilegesByPage() throws AppException{
		log.debug("--->> searchPrivilegesByPage");
		String params[] = null;
		Object conditions[] = null;
		String hql = "searchPrivilegeByPage";
		try{
			this.pb.setCurrentPage(page);
			this.pb.setPagesize(10);
			params = new String[] { "privilegeName"};
			conditions = new Object[] {
					null == this.privilegeName ? "%" : "%" + this.privilegeName + "%"};
			this.pb = this.getOnlineOF().getPrivilegeManager().searchPrivilegesByPage(hql,
					params, conditions, this.pb, this.getSession());
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到新建权限页面
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String forwardAddNewPrivilege(){
		log.debug("--->> begin forwardAddNewPrivilege");
		action="addPrivilege.do";
		privilegeVo = null;
		return SUCCESS;
	}
	
	/**
	 * 新建权限
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String addPrivilege() throws AppException{
		log.debug("--->> begin addPrivilege");
		try{
			this.getOnlineOF().getPrivilegeManager().addPrivilege(this.getSession(), privilegeVo);
			this.searchPrivilegesByPage();
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到编辑权限
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String editPrivilege() throws AppException{
		log.debug("--->> begin editPrivilege");
		try{
		    privilegeVo = this.getOnlineOF().getPrivilegeManager().getPrivilegeById(this.getSession(), privilegeId);
		    action="updatePrivilege.do";
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}
	/**
	 * 修改权限信息
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String updatePrivilege() throws AppException {
		log.debug("--->> begin updatePrivilege");
		try{
		    this.getOnlineOF().getPrivilegeManager().updatePrivilege(this.getSession(), privilegeVo);
		    this.searchPrivilegesByPage();
		}catch(Exception e){
			log.error(null,e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * 删除权限
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deletePrivilege() throws AppException{
		log.debug("--->> begin deletePrivilege");
		try {
			if(null != this.checksItem){
				for(int i=0; i<this.checksItem.length; i++){
					log.debug(this.checksItem[i]);
					this.getOnlineOF().getPrivilegeManager().deletePrivilege(this.getSession(),
							this.checksItem[i]);
				}
			}
			this.searchPrivilegesByPage();
		} catch (Exception e) {
			log.error(e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}

	public List<PrivilegeVo> getPrivilegeVos() {
		return privilegeVos;
	}

	public void setPrivilegeVos(List<PrivilegeVo> privilegeVos) {
		this.privilegeVos = privilegeVos;
	}

	public PageBean getPb() {
		return pb;
	}

	@Autowired
	@Resource(name = "pageBean")
	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public PrivilegeVo getPrivilegeVo() {
		return privilegeVo;
	}
	public void setPrivilegeVo(PrivilegeVo privilegeVo) {
		this.privilegeVo = privilegeVo;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
