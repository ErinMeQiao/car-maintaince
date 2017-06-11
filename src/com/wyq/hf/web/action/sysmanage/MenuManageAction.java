package com.wyq.hf.web.action.sysmanage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.yinbo.web.utils.Struts2Utils;
import com.wyq.hf.context.Constants;
import com.wyq.hf.po.Menu;
import com.wyq.hf.service.sysmanage.MenuManage;

@SuppressWarnings("serial")
public class MenuManageAction extends ActionSupport {
	
	private static final String MENU_LIST = "menuList";

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private MenuManage menuManage;
	
	public String findMenuList() {
		if (null != Struts2Utils.getSession().getAttribute(Constants.USERID)) {
			String userid = Struts2Utils.getSession().getAttribute(
					Constants.USERID).toString();
			List<Menu> menuList = menuManage.findMenuListByRole(userid);
			Struts2Utils.getRequest().setAttribute(MENU_LIST, menuList);
		}
		return SUCCESS;
	}
	
	public MenuManage getMenuManage() {
		return menuManage;
	}

	public void setMenuManage(MenuManage menuManage) {
		this.menuManage = menuManage;
	}
	
}
