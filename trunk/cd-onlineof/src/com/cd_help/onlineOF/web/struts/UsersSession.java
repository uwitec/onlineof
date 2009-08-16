/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.web.struts;

import java.io.Serializable;
import java.util.List;

import com.cd_help.onlineOF.web.vo.PrivilegeVo;
import com.cd_help.onlineOF.web.vo.UsersVo;
import com.cd_help.onlineOF.web.WebConstants;

/**
 * <b><code></code></b>
 * <p/>
 * Comment here
 * <p/>
 * <b>Creation Time:</b> Jul 14, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class UsersSession implements Serializable{
	
    private UsersVo usersVo;  // 当前登录用户对象	
    
    private List<PrivilegeVo> privileges;  // 用户拥有权限集合
    
    @SuppressWarnings("unused")
	private String usersId;  // 当前登录用户ID
    
    @SuppressWarnings("unused")
    private String roleId; // 角色
    
    @SuppressWarnings("unused")
    private String rolePath; // 角色标识
    
    @SuppressWarnings("unused")
    private String usersName;  // 当前登录用户名
    
    /**
     * Constructs a <code>Session</code>
     * @since cd_help-onlineOF 0.0.0.1
     */
    public UsersSession(){}
    
    /**
     * Constructs a <code>Session</code>
     * @param usersVo
     * @param roles
     * @param privileges
     * @since cd_help-onlineOF 0.0.0.1
     */
    public UsersSession(UsersVo usersVo,List<PrivilegeVo> privileges, String roleId, String rolePath){
    	this.usersVo = usersVo;
    	this.privileges = privileges;
    	this.usersId = usersVo.getUsersId();
    	this.usersName = usersVo.getUsersname();
    	this.roleId = roleId;
    	this.rolePath = rolePath;
    }
    
    /**
     * 是否是系统管理员
     * @return
     * @since cd_help-onlineOF 0.0.0.1
     */
    public boolean isAdministrator(){
    	if (rolePath.equals(WebConstants.ROLE_PATH_ADMINISTRATOR)) {
			return true;
		} else {
			return false;
		}
    }
    
    /**
     * 是否是餐厅/酒店管理员
     * @return
     * @since cd_help-onlineOF 0.0.0.1
     */
    public boolean isRestaurantAdmin(){
    	if (rolePath.equals(WebConstants.ROLE_PATH_RESTAURANTADMIN)) {
			return true;
		} else {
			return false;
		}
    }

	public UsersVo getUsersVo() {
		return usersVo;
	}

	public void setUsersVo(UsersVo usersVo) {
		this.usersVo = usersVo;
	}

	public List<PrivilegeVo> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegeVo> privileges) {
		this.privileges = privileges;
	}

	public String getUsersId() {
		return usersVo.getUsersId();
	}
	
	public String getUsersName() {
		return usersVo.getUsersname();
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRolePath() {
		return rolePath;
	}

	public void setRolePath(String rolePath) {
		this.rolePath = rolePath;
	}
}
