/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.UsersData;
import com.cd_help.onlineOF.utils.StringUtil;

/**
 * <b><code></code></b>
 * <p/>
 * 用户数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 15, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("usersDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class UsersDataDaoImpl extends BaseDaoSupport implements UsersDataDao{

	public UsersData login(String usersname, String password)
			throws Exception {
		List<UsersData> usersList = this.findByNamedQueryAndNamedParam("getUsersByName", "usersname",usersname);
		if(usersList.size() > 0){
			UsersData usersdata = usersList.get(0);
			System.out.println("---------"+StringUtil.encodePassword(password, "MD5"));
			if(usersdata.getPassword().equals(StringUtil.encodePassword(password, "MD5"))){
			   return usersdata;
			}else{
			   return null;
			}
		}else{
           return null;			
		}
	}

	/**
	 * @see com.cd_help.onlineOF.api.UsersDataDao#checkUsersByName(java.lang.String)
	 */
	public boolean checkUsersByName(String usersname) throws Exception {
		List<UsersData> users = this.findByNamedQueryAndNamedParam("getUsersByName", "usersname", usersname);
		if(users.size() > 0){
			return false;
		}else{
			return true;
		}
	}
}
