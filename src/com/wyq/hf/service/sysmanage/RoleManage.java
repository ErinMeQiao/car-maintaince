package com.wyq.hf.service.sysmanage;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.wyq.hf.po.Roleinfo;
import com.yinbo.service.EntityManager;

public interface RoleManage extends EntityManager<Roleinfo,Integer> {
	
	public List<Roleinfo> findRoleAll(String propStr, boolean asc);
	
	public List<Roleinfo> findRoleList(HttpServletRequest request);

	public List<Roleinfo> findBy(String proString, Object obj);
	
	public Roleinfo findObjBy(String proString, Object obj);
}
