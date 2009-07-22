/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.RestaurantData;
import com.cd_help.onlineOF.data.UsersData;
import com.cd_help.onlineOF.utils.AppException;
import com.cd_help.onlineOF.utils.BeanUtilsHelp;
import com.cd_help.onlineOF.web.vo.UsersVo;

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

	public void delete(String id) throws AppException {
	    this.delete((UsersData)this.get(UsersData.class, id));
	}

	public UsersVo get(String id) throws AppException {
		UsersData usersData = (UsersData)this.get(UsersData.class, id);
		UsersVo usersVo = new UsersVo();
		BeanUtilsHelp.copyProperties(usersVo, usersData);
		return usersVo;
	}

	public List<UsersVo> loadAll() throws AppException {
		List<UsersData> usersList = this.findByNamedQuery("loadAllUsers");
		List<UsersVo> usersVos = new ArrayList<UsersVo>();
		for(UsersData users : usersList){
			UsersVo usersVo = new UsersVo();
			BeanUtilsHelp.copyProperties(usersVo, users);
			if(null != users.getRestaurantId() && users.getRestaurantId().length()>0){
				usersVo.setRestaurantName(((RestaurantData)this.get(RestaurantData.class, users.getRestaurantId())).getName());
			}
			usersVos.add(usersVo);
		}
		return usersVos;
	}

	public void update(String id) throws AppException {

	}

	public UsersVo login(String usersname, String password)
			throws AppException {
		List<UsersData> usersList = this.findByNamedQueryAndNamedParam("login", "usersname",usersname);
		if(usersList.size() > 0){
			UsersData users = usersList.get(0);
			UsersVo usersVo = new UsersVo();
			BeanUtilsHelp.copyProperties(usersVo,users);
			return usersVo;
		}else{
           return null;			
		}
	}
}
