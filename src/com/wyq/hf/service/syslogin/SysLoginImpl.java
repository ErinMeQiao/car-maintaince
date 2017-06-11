package com.wyq.hf.service.syslogin;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.context.Constants;
import com.wyq.hf.po.Userinfo;
import com.wyq.hf.web.action.LoginAction;
import com.wyq.hf.service.sysmanage.UserManage;
import com.yinbo.orm.HibernateEntityDao;
import com.yinbo.service.AbstractEntityManager;

public class SysLoginImpl extends AbstractEntityManager<Userinfo,String> implements SysLogin{

	protected UserManage userManage;
	
	@Override
	protected HibernateEntityDao<Userinfo> getEntityDao() {
		return null;
	}

	public void doUserLogin(HttpServletRequest request) {
	}
	
	public int validateAdminLogin(LoginAction login, String validateCode) {
		String valCode  = StringUtils.trim(login.getKaptchafield());
		String userName = StringUtils.trim(login.getUserid());
		String pwd = StringUtils.trim(login.getPwd());
		if(StringUtils.isBlank(userName)){
			return 6;
		}
		if(StringUtils.isBlank(pwd)){
			return 7;
		}
		if(StringUtils.isBlank(valCode)){
			return 8;
		}		
		if (!validateCode(login, validateCode)) {
			return 1;
		}
		if (isUserExist(login)) {
			return 2;
		}
		
		Userinfo userinfo = userManage.findUser(StringUtils.trim(login.getUserid()), StringUtils.trim(login.getPwd()));
		if (null == userinfo) {
			return 3;
		}
		
		if ("0".equals(userinfo.getIsactive())) {
			return 4;
		}
		
		if(Constants.DEFAULTPWD.equals(StringUtils.trim(login.getPwd()))){
			return 5;
		}

		return 0;
	}

	private boolean validateCode(LoginAction login, String validateCode) {
		String checkImage = StringUtils.trim(login.getKaptchafield());
		return checkImage.equalsIgnoreCase(validateCode);
	}
	
	private boolean isUserExist(LoginAction login) {
		String userid = StringUtils.trim(login.getUserid());
		Userinfo obj = null;
		obj = userManage.get(userid);
		return (null == obj);
	}

	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}
}
