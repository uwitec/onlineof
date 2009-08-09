/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
public class PrivilegeAction extends BaseAction{
	
	private List<PrivilegeVo> privilegeVos;  // 所有权限
	private PageBean pb; // 分页
	private int page = 1;
	private String privilegeName;
	private PrivilegeVo privilegeVo;
	private String privilegeId;
	private String action;

	/**
	 * 权限管理
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String doPrivilegeManager(){
	   action="addPrivilege.do";	
	   return SUCCESS;	
	}
	/**
	 * 跳转到新建权限页面
	 * @return
	 * @throws AppException 
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String forwardAddNewPrivilege() throws AppException{
		log.debug("--->> begin forwardAddNewPrivilege");
		try{
			action="addPrivilege.do";
			privilegeVo = null;
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage());
		}
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
			privilegeVo = this.getOnlineOF().getPrivilegeManager().addPrivilege(this.getSession(), privilegeVo);
			this.getRequest().setAttribute("addSuccess", "addSuccess");
		}catch(Exception e){
			log.error(e);
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
			log.error(e);
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
		    this.getRequest().setAttribute("updateSuccess", "updateSuccess");
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage(),e);
		}
		return SUCCESS;
	}

	/**
	 * 根据ID删除权限
	 * @return
	 * @throws AppException
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String deletePrivilegeById() throws AppException{
		log.debug("--->> begin deletePrivilege");
		try{
			this.getOnlineOF().getPrivilegeManager().deletePrivilege(this.getSession(),privilegeId);
			privilegeVo = null;
			this.getRequest().setAttribute("deleteSuccess", "deleteSuccess");
		}catch(Exception e){
			log.error(e);
			throw new AppException("",e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 弹出窗口选择父权限
	 * @return
	 * @since cd_help-onlineOF 0.0.0.1
	 */
	public String selectParentPrivilege(){
		log.debug("--->> begin selectParentPrivilege");
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
