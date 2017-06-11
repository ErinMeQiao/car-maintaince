package com.wyq.hf.web.action;

import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.wyq.hf.service.syslogin.SysLogin;
import com.wyq.hf.service.sysmanage.UserManage;
import com.yinbo.web.utils.Struts2Utils;
import com.google.code.kaptcha.Constants;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private static final String USER_OBJ = "userObj";
	private static final String LOGIN_USER = "loginUser";
	private static final String USERID = "userid";
	private static final String EXCEPTION = "exception";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private String userid;
	private String pwd;
	private String kaptchafield;
	private SysLogin sysLogin;
	private UserManage userManage;

	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}

	public String sysLogin() {
		HttpSession session = Struts2Utils.getSession();
		int validateFlag = 0;
		String validateCode = "";
		if (null == Struts2Utils.getSession().getAttribute(
				Constants.KAPTCHA_SESSION_KEY)) {
			addActionError("获取验证码为null!");
			return INPUT;
		}
		
		validateCode = Struts2Utils.getSession().getAttribute(
				Constants.KAPTCHA_SESSION_KEY).toString();
		try {
			validateFlag = sysLogin.validateAdminLogin(this, validateCode);
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.error("admin login validate error!" + e.getMessage());
			addActionError("登陆校验异常!");
			return EXCEPTION;
		}
		if (validateFlag == 6) {
			addActionError("对不起，请您输入用户ID!");
			return INPUT;
		}

		if (validateFlag == 7) {
			addActionError("对不起，请您输入密码!");
			return INPUT;
		}

		if (validateFlag == 8) {
			addActionError("对不起，请您输入验证码!");
			return INPUT;
		}
		if (validateFlag == 1) {
			addActionError("对不起，您输入的验证码不正确!");
			return INPUT;
		}

		if (validateFlag == 2) {
			addActionError("对不起，您输入的用户ID不存在!");
			return INPUT;
		}

		if (validateFlag == 3) {
			addActionError("对不起，您输入的用户密码不正确!");
			return INPUT;
		}

		if (validateFlag == 4) {
			addActionError("对不起，用户没有激活!");
			return INPUT;
		}
		//默认密码初次登陆需要其修改密码
		if (validateFlag == 5) {
			//暂不实现
		}

		saveLoginSucInfo(session);
		session.setAttribute(USERID, userid);
		session.setAttribute(USER_OBJ, userManage.get(userid));
		saveLoginSucInfo(session);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String sysLogout() {
		HttpSession session = Struts2Utils.getSession();
		ServletContext application;
		if (session != null) {
			application = session.getServletContext();
			HashMap loginUser = (HashMap) application.getAttribute(LOGIN_USER);
			if (loginUser == null) {
				loginUser = new HashMap();
				application.setAttribute(LOGIN_USER, loginUser);
			}
			if (session.getAttribute(USERID) != null) {
				String userid = (String) session.getAttribute(USERID);
				if (loginUser != null && loginUser.containsKey(userid)) {
					loginUser.remove(userid);
				}
				if (session != null) {
					session.invalidate();
				}
				logger.debug("用户ID " + userid + "已经从全局用户列表被清除");
			}
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	private void saveLoginSucInfo(HttpSession session) {
		ServletContext application = session.getServletContext();
		HashMap loginUser = (HashMap) application.getAttribute(LOGIN_USER);
		if (loginUser == null) {
			loginUser = new HashMap();
			application.setAttribute(LOGIN_USER, loginUser);
		}
		if (loginUser != null && loginUser.containsKey(userid)) {
			HashMap loginSession = (HashMap) application.getAttribute("loginSession");
			HttpSession oldSession = (HttpSession) loginSession.get(loginUser.get(userid));
			if (oldSession != null&& (!oldSession.getId().equals(session.getId()))) {
				oldSession.invalidate();
			}
			loginUser.remove(userid);
		}
		loginUser.put(userid, session.getId());
		logger.debug("用户ID " + userid + "已经保存到全局用户列表!");
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getKaptchafield() {
		return kaptchafield;
	}

	public void setKaptchafield(String kaptchafield) {
		this.kaptchafield = kaptchafield;
	}

	public SysLogin getSysLogin() {
		return sysLogin;
	}

	public void setSysLogin(SysLogin sysLogin) {
		this.sysLogin = sysLogin;
	}
}
