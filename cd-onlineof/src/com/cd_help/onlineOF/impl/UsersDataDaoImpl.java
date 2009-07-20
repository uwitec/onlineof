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
import com.cd_help.onlineOF.utils.AppException;
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
	}

	public UsersVo get(String id) throws AppException {
		return null;
	}

	public List<UsersVo> loadAll() throws AppException {
		List<UsersVo> usersVos = this.findByNamedQuery("loadAllUsers");
		return usersVos;
	}

	public void update(String id) throws AppException {

	}

	public UsersVo login(String usersname, String password)
			throws AppException {
		UsersVo usersVo = null;
		List<UsersVo> usersVoList = this.findByNamedQueryAndNamedParam("login", "usersname",usersname);
		if(usersVoList.size() > 0){
			usersVo = usersVoList.get(0);
			return usersVo;
		}else{
           return null;			
		}
	}
}
