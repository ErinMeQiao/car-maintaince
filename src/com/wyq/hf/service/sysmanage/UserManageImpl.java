package com.wyq.hf.service.sysmanage;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.dao.UserinfoDAO;
import com.wyq.hf.po.Userinfo;
import com.wyq.hf.context.Constants;
import com.yinbo.orm.HibernateEntityDao;
import com.yinbo.orm.support.Page;
import com.yinbo.service.AbstractEntityManager;
import com.yinbo.service.DisplaytagPagerUtils;
import com.yinbo.utils.Crypto;

public class UserManageImpl extends AbstractEntityManager<Userinfo,String> implements UserManage {
	private UserinfoDAO userinfoDAO;

	@Override
	protected HibernateEntityDao<Userinfo> getEntityDao() {
		return userinfoDAO;
	}

	@SuppressWarnings("unchecked")
	public Userinfo findUser(String userid, String pwd) {
		List<Userinfo> list = getEntityDao().find(
				"from Userinfo u where u.userid=? and u.password=?", new Object[] {
						userid, Crypto.GetMessageDigest(pwd, "MD5") });
		return list.size() > 0 ? list.get(0) : null; 
	}
	
	@SuppressWarnings("unchecked")
	public List<Userinfo> findUserList(HttpServletRequest request) {
		String isExport = DisplaytagPagerUtils.getIsExport(request);
		int pageIndex = StringUtils.isEmpty(isExport) ? DisplaytagPagerUtils.getPageIndex(request) : 1;
		int pageSize = StringUtils.isEmpty(isExport) ? Page.DEFAULT_PAGE_SIZE : Page.MAX_PAGE_SIZE;
		StringBuffer querybuffer = new StringBuffer(
				"from Userinfo u where 1=? ");
		querybuffer.append(getQueryCondition(request));
		Page page = getEntityDao().pagedQuery(querybuffer.toString(),
				pageIndex, pageSize, 1);
		List<Userinfo> list = (List<Userinfo>) page.getResult();
		request.setAttribute(DisplaytagPagerUtils.RS_SIZE, (int) (page
				.getTotalCount()));
		return list;
	}
	
	@Override
	protected String getQueryCondition(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer(" and u.userid != ").append("'")
				.append(Constants.SUPERADMIN).append("'");

		String uid = request.getParameter("uid");
		if (StringUtils.isNotBlank(uid)) {
			buf.append(" and u.userid like ").append("'%");
			buf.append(uid).append("%'");
			request.setAttribute("uid", uid);
		}

		String username = request.getParameter("username");
		if (StringUtils.isNotBlank(username)) {
			buf.append(" and u.usename like ").append("'%");
			buf.append(username).append("%'");
			request.setAttribute("username", username);
		}

		String roleid = request.getParameter("roleid");
		if (StringUtils.isNotBlank(roleid)) {
			buf.append(" and u.roleinfo.roleid = ").append(roleid);
			request.setAttribute("roleid", roleid);
		}

		String isactive = request.getParameter("isactive");
		if (StringUtils.isNotBlank(isactive)) {
			buf.append(" and u.isactive = ").append(isactive);
			request.setAttribute("isactive", isactive);
		}

		buf.append(" order by u.userid asc");
		return buf.toString();
	}

	public Userinfo findObjBy(String proString, Object obj) {
		return getEntityDao().findUniqueBy(StringUtils.trim(proString), obj);
	}

	public List<Userinfo> findBy(String proString, Object obj) {
		return  getEntityDao().findBy(StringUtils.trim(proString), obj);
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}
}
