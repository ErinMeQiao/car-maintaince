package com.wyq.hf.service.sysmanage;

import java.util.List;

import com.wyq.hf.po.Menu;
import com.yinbo.service.EntityManager;

public interface MenuManage extends EntityManager<Menu,Integer> {
	

	public List<Menu> findMenuListByRole(String userid);
}
