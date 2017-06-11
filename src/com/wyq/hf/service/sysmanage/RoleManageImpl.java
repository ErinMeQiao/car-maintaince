package com.wyq.hf.service.sysmanage;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.dao.RoleinfoDAO;
import com.wyq.hf.po.Roleinfo;
import com.yinbo.orm.HibernateEntityDao;
import com.yinbo.orm.support.Page;
import com.yinbo.service.AbstractEntityManager;
import com.yinbo.service.DisplaytagPagerUtils;


public class RoleManageImpl extends AbstractEntityManager<Roleinfo,Integer> implements RoleManage {

	private RoleinfoDAO roleinfoDAO;
	
	@Override
	protected HibernateEntityDao<Roleinfo> getEntityDao() {
		return this.roleinfoDAO;
	}
	
	
	public List<Roleinfo> findRoleAll(String propStr, boolean asc) {
		return getEntityDao().getAll(StringUtils.trim(propStr), asc);
	}

	public List<Roleinfo> findBy(String proString, Object obj) {
		return  getEntityDao().findBy(StringUtils.trim(proString), obj);
	}
	
	public Roleinfo findObjBy(String proString, Object obj) {
		return getEntityDao().findUniqueBy(StringUtils.trim(proString), obj);
	}
	
	public void setRoleinfoDAO(RoleinfoDAO roleinfoDAO) {
		this.roleinfoDAO = roleinfoDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Roleinfo> findRoleList(HttpServletRequest request) {
		String isExport = DisplaytagPagerUtils.getIsExport(request);
		int pageIndex = StringUtils.isEmpty(isExport) ? DisplaytagPagerUtils.getPageIndex(request) : 1;
		int pageSize = StringUtils.isEmpty(isExport) ? Page.DEFAULT_PAGE_SIZE : Page.MAX_PAGE_SIZE;
		StringBuffer querybuffer = new StringBuffer(
				"from Roleinfo r where 1=? ");
		querybuffer.append(getQueryCondition(request));
		Page page = getEntityDao().pagedQuery(querybuffer.toString(),
				pageIndex, pageSize, 1);
		List<Roleinfo> list = (List<Roleinfo>) page.getResult();
		request.setAttribute(DisplaytagPagerUtils.RS_SIZE, (int) (page
				.getTotalCount()));
		return list;
	}

	@Override
	protected String getQueryCondition(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer("");
		String rolename = request.getParameter("rolename");
		if (StringUtils.isNotBlank(rolename)) {
			buf.append(" and r.rolename like ").append("'%");
			buf.append(rolename).append("%'");
			request.setAttribute("rolename", rolename);
		}
		String roletype = request.getParameter("roletype");
		if (StringUtils.isNotBlank(roletype)) {
			buf.append(" and r.roletype = ").append("'");
			buf.append(roletype).append("'");
			request.setAttribute("roletype", roletype);
		}
		buf.append(" order by r.roleid asc");
		return buf.toString();
	}
}
