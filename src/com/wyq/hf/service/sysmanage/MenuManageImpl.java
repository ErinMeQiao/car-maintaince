package com.wyq.hf.service.sysmanage;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.dao.MenuDAO;
import com.wyq.hf.po.Menu;
import com.wyq.hf.po.Roleinfo;
import com.wyq.hf.po.Userinfo;
import com.yinbo.orm.HibernateEntityDao;
import com.yinbo.service.AbstractEntityManager;

public class MenuManageImpl extends AbstractEntityManager<Menu,Integer> implements MenuManage {
	private MenuDAO menuDAO;
	private UserManage userManage;
	private RoleManage roleManage;
	public RoleManage getRoleManage() {
		return roleManage;
	}

	public void setRoleManage(RoleManage roleManage) {
		this.roleManage = roleManage;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}	
	@Override
	protected HibernateEntityDao<Menu> getEntityDao() {
		return menuDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findMenuListByRole(String userid) {
		List<Menu> menuList = new ArrayList<Menu>();
		if (StringUtils.isNotBlank(userid)) {
			Userinfo user = userManage.get(userid);
			Roleinfo roleinfo = this.getRoleManage().get(user.getRoleinfo().getRoleid());
			if (roleinfo != null) {
				String privilege = roleinfo.getPrivilege();
				if (StringUtils.isNotBlank(privilege)) {
					String[] menuids = privilege.split(",");
					Menu menu;
					List<Menu> templist = null;
					for (String menuid : menuids) {
						menu = new Menu();
						templist = getEntityDao().find(
								"from Menu m where m.menuid=? and m.state='1'",
								Integer.parseInt(menuid));
						if (!templist.isEmpty()) {
							menu = templist.get(0);
						}
						menuList.add(menu);
					}
				}
			}
		} else {
			menuList = getEntityDao().findBy("state", "1");
		}
		return menuList;
	}
}
