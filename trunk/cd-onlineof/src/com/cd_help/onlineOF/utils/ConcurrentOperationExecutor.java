/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.cd_help.onlineOF.api.PrivilegeDataDao;
import com.cd_help.onlineOF.api.UsersDataDao;
import com.cd_help.onlineOF.data.PrivilegeData;
import com.cd_help.onlineOF.data.UsersSession;

/**
 * <b><code></code></b>
 * <p/>
 * 权限控制切面
 * <p/>
 * <b>Creation Time:</b> Aug 13, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Aspect
@SuppressWarnings("unchecked")
public class ConcurrentOperationExecutor {
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name="usersDataDao")
	private UsersDataDao usersDataDao;
	
	@SuppressWarnings("unused")
	@Autowired
	@Resource(name="privilegeDataDao")
	private PrivilegeDataDao privilegeDataDao;
	
	@SuppressWarnings("unused")
	@Pointcut("this(com.cd_help.onlineOF.api.*Manager)")
	private void allMethod() {
	};

	/**
	 * ����֪ͨ
	 * @throws Throwable 
	 */
	@Around("allMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws AppException {
		System.out.println("环绕通知--->strat");
		String methodName = pjp.getSignature().getName();
		System.out.println("执行的方法名:���"+methodName);
		Object o = null; // �
		UsersSession userSession = (UsersSession)pjp.getArgs()[pjp.getArgs().length-1];
		try{
			List<String> privilegeCodes = this.getPrivilegeByRoleId(userSession.getUsersVo().getRoleId());
			if(this.havaPrivilegeMethod(methodName, privilegeCodes)){
				try {
					o = (Object) pjp.proceed();
				} catch (Throwable e) {
					throw new AppException("000000","系统错误!请联系管理员",e);
				}
			}else{
				throw new AppException("0000011","对不起!您没有足够权限!");
			}
		}catch(Exception e){
			throw new AppException("000000","系统错误!请联系管理员",e);
		}
		return o;
	}
	
	private List<String> getPrivilegeByRoleId(String roleId) throws Exception{
		List<PrivilegeData> plist = privilegeDataDao.findByNamedQueryAndNamedParam("getPrivilegeByRoleId", "roleId", roleId);
		Iterator iterator = plist.iterator();
		List<String> privilegeCodes = new ArrayList<String>();
		while(iterator.hasNext()){
			PrivilegeData p = (PrivilegeData)iterator.next();
			privilegeCodes.add(p.getMethodName());
		}
		return privilegeCodes;
	}
	
	public boolean havaPrivilegeMethod(String methodName,List<String> privilegeCodes) throws Exception{
		List<PrivilegeData> plist = privilegeDataDao.findByNamedQueryAndNamedParam("getPrivilegeByMethodName", "methodName", methodName);
		PrivilegeData p = null;
		if(plist.size() > 0){
			p = (PrivilegeData)plist.get(0);
		}
		if(privilegeCodes.contains(p.getMethodName())){
			return true;
		}else{
			return false;
		}
	}

	public void setUsersDataDao(UsersDataDao usersDataDao) {
		this.usersDataDao = usersDataDao;
	}

	public void setPrivilegeDataDao(PrivilegeDataDao privilegeDataDao) {
		this.privilegeDataDao = privilegeDataDao;
	}
}

