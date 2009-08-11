/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.utils;

import java.util.Map;

import com.cd_help.onlineOF.data.UsersSession;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <b><code></code></b>
 * <p/>
 * 登陆Session拦截器
 * <p/>
 * <b>Creation Time:</b> Aug 11, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@SuppressWarnings("serial")
public class CheckUserSessionInterceptor extends AbstractInterceptor{

	public static final String LOGIN_KEY = "session";
    public static final String LOGIN_PAGE = "global.login";
    
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation actionInvocation) throws Exception {
	    
		System.out.println("开始拦截");
        // 对LoginAction不做该项拦截
        Object action = actionInvocation.getAction();
        System.out.println("拦截 :"+action.getClass().getSimpleName());
        // 确认Session中是否存在LOGIN
        Map session = actionInvocation.getInvocationContext().getSession();
        UsersSession userSession = (UsersSession) session.get(LOGIN_KEY);
        if (userSession != null) {
        	System.out.println("loginUser is not null");
            return actionInvocation.invoke();
        } else {
        	System.out.println("loginUser is null");
            return LOGIN_PAGE;
        }
	}
}
