package com.wyq.hf.service.finance;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.dao.FinanceinfoDAO;
import com.wyq.hf.po.Financeinfo;
import com.wyq.hf.po.Userinfo;
import com.yinbo.orm.support.Page;
import com.yinbo.service.AbstractEntityManager;
import com.yinbo.service.DisplaytagPagerUtils;
import com.yinbo.web.utils.Struts2Utils;

public class FinanceManagerImpl extends AbstractEntityManager<Financeinfo,Integer> implements FinanceManager{
	private static final String USER_OBJ = "userObj";
	
	private FinanceinfoDAO financeinfoDAO;

	@Override
	protected FinanceinfoDAO getEntityDao() {
		return financeinfoDAO;
	}

	public void setFinanceinfoDAO(FinanceinfoDAO financeinfoDAO) {
		this.financeinfoDAO = financeinfoDAO;
	}
	@SuppressWarnings("unchecked")
	public List<Financeinfo> findFinanceList(HttpServletRequest request){
		String isExport = DisplaytagPagerUtils.getIsExport(request);
		int pageIndex = StringUtils.isEmpty(isExport) ? DisplaytagPagerUtils.getPageIndex(request) : 1;
		int pageSize = StringUtils.isEmpty(isExport) ? Page.DEFAULT_PAGE_SIZE : Page.MAX_PAGE_SIZE;
		StringBuffer querybuffer = new StringBuffer("from Financeinfo t where 1=? ");
		querybuffer.append(getQueryCondition(request));
		Page page = getEntityDao().pagedQuery(querybuffer.toString(),pageIndex, pageSize, 1);
		List<Financeinfo> list = (List<Financeinfo>) page.getResult();
		request.setAttribute(DisplaytagPagerUtils.RS_SIZE, (int) (page.getTotalCount()));
		return list;		
	}
	
	
	@Override
	protected String getQueryCondition(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer("");
		String starttime = request.getParameter("startdate");//开始日期
		String endtime = request.getParameter("enddate");//结束日期
		String userid = request.getParameter("fUserid");//用户ID
		//对用户查看权限进行限制
		Userinfo loginuser = (Userinfo) Struts2Utils.getSession().getAttribute(USER_OBJ);
		if(loginuser.getRoleinfo().getRoleid() != 1){
			buf.append(" and t.fuserid = ").append("'"+loginuser.getUserid()+"'");
		}
		if (StringUtils.isNotBlank(userid)) {
			buf.append(" and t.fuserid = ").append("'"+userid+"'");
		}
		if (StringUtils.isNotBlank(starttime)&& StringUtils.isNotBlank(endtime)) {
			starttime = StringUtils.trim(starttime);
			endtime = StringUtils.trim(endtime);
			buf.append(" and t.fdate between ").append("'").append(starttime).append("'");
			buf.append(" and ").append("'").append(endtime).append("'");
			request.setAttribute("startdate", starttime);
			request.setAttribute("enddate", endtime);
		} else if (StringUtils.isNotBlank(starttime)&& StringUtils.isBlank(endtime)) {
			starttime = StringUtils.trim(starttime);
			buf.append(" and t.fdate >=").append("'").append(starttime).append("'");
			request.setAttribute("startdate", starttime);
		} else if (StringUtils.isBlank(starttime)&& StringUtils.isNotBlank(endtime)) {
			endtime = StringUtils.trim(endtime);
			buf.append(" and t.fdate <=").append("'").append(endtime).append("'");
			request.setAttribute("enddate", endtime);
		}
		buf.append(" order by t.fdate desc");
		return buf.toString();
	}
}
