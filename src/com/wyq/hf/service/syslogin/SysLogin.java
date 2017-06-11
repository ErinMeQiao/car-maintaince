
package com.wyq.hf.service.syslogin;

import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Userinfo;
import com.wyq.hf.web.action.LoginAction;
import com.yinbo.service.EntityManager;

public interface SysLogin extends EntityManager<Userinfo,String> {
	

	public int validateAdminLogin(LoginAction login, String validateCode);
	

	public void doUserLogin(HttpServletRequest request);
	
}
