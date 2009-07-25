/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.data;

import java.io.Serializable;
import java.util.List;

import com.cd_help.onlineOF.web.vo.PrivilegeVo;
import com.cd_help.onlineOF.web.vo.UsersVo;

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
public class Session implements Serializable{
	
    private UsersVo usersVo;	
    private List<PrivilegeVo> privileges;
    
    /**
     * Constructs a <code>Session</code>
     * @since cd_help-onlineOF 0.0.0.1
     */
    public Session(){}
    
    /**
     * Constructs a <code>Session</code>
     * @param usersVo
     * @param roles
     * @param privileges
     * @since cd_help-onlineOF 0.0.0.1
     */
    public Session(UsersVo usersVo,List<PrivilegeVo> privileges){
    	this.usersVo = usersVo;
    	this.privileges = privileges;
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
}