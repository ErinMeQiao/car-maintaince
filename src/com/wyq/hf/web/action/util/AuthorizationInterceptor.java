package com.wyq.hf.web.action.util;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yinbo.web.utils.Struts2Utils;


@SuppressWarnings("serial")
public class AuthorizationInterceptor extends AbstractInterceptor {
	private static final String RELOGIN = "relogin";
	private static final String USERID = "userid";
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session = Struts2Utils.getSession();
		if (null != session.getAttribute(USERID)) {
			logger.debug("获取session有效!");
			return invocation.invoke();
		}
		logger.debug("session为空!");
        return RELOGIN;
	}

}
