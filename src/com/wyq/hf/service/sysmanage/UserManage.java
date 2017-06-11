package com.wyq.hf.service.sysmanage;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Userinfo;
import com.yinbo.service.EntityManager;

public interface UserManage extends EntityManager<Userinfo,String> {

	public Userinfo findUser(String userid, String pwd);
	
	public List<Userinfo> findUserList(HttpServletRequest request);

	public Userinfo findObjBy(String proString, Object obj);
	
	public List<Userinfo> findBy(String proString, Object obj);
}
