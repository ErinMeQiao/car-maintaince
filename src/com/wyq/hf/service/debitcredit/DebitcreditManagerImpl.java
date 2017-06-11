package com.wyq.hf.service.debitcredit;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.wyq.hf.dao.DebitcreditinfoDAO;
import com.wyq.hf.po.Debitcreditinfo;
import com.wyq.hf.po.Userinfo;
import com.yinbo.orm.support.Page;
import com.yinbo.service.AbstractEntityManager;
import com.yinbo.service.DisplaytagPagerUtils;
import com.yinbo.web.utils.Struts2Utils;

public class DebitcreditManagerImpl extends AbstractEntityManager<Debitcreditinfo,Integer> implements DebitcreditManager{
	private static final String USER_OBJ = "userObj";
	private DebitcreditinfoDAO debitcreditinfoDAO;

	@Override
	protected DebitcreditinfoDAO getEntityDao() {
		return debitcreditinfoDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Debitcreditinfo> findDebitcreditList(HttpServletRequest request){
		String isExport = DisplaytagPagerUtils.getIsExport(request);
		int pageIndex = StringUtils.isEmpty(isExport) ? DisplaytagPagerUtils.getPageIndex(request) : 1;
		int pageSize = StringUtils.isEmpty(isExport) ? Page.DEFAULT_PAGE_SIZE : Page.MAX_PAGE_SIZE;
		StringBuffer querybuffer = new StringBuffer("from Debitcreditinfo t where 1=? ");
		querybuffer.append(getQueryCondition(request));
		Page page = getEntityDao().pagedQuery(querybuffer.toString(),pageIndex, pageSize, 1);
		List<Debitcreditinfo> list = (List<Debitcreditinfo>) page.getResult();
		request.setAttribute(DisplaytagPagerUtils.RS_SIZE, (int) (page.getTotalCount()));
		return list;		
	}
	
	
	@Override
	protected String getQueryCondition(HttpServletRequest request) {
		StringBuffer buf = new StringBuffer("");
		String starttime = request.getParameter("startdate");//开始日期
		String endtime = request.getParameter("enddate");//结束日期
		String userid = request.getParameter("dUserid");//用户ID
		//对用户查看权限进行限制
		Userinfo loginuser = (Userinfo) Struts2Utils.getSession().getAttribute(USER_OBJ);
		if(loginuser.getRoleinfo().getRoleid() != 1){
			buf.append(" and t.cduser = ").append("'"+loginuser.getUserid()+"'");
		}
		if (StringUtils.isNotBlank(userid)) {
			buf.append(" and t.cduser = ").append("'"+userid+"'");
		}
		if (StringUtils.isNotBlank(starttime)&& StringUtils.isNotBlank(endtime)) {
			starttime = StringUtils.trim(starttime);
			endtime = StringUtils.trim(endtime);
			buf.append(" and t.cddate between ").append("'").append(starttime).append("'");
			buf.append(" and ").append("'").append(endtime).append("'");
			request.setAttribute("startdate", starttime);
			request.setAttribute("enddate", endtime);
		} else if (StringUtils.isNotBlank(starttime)&& StringUtils.isBlank(endtime)) {
			starttime = StringUtils.trim(starttime);
			buf.append(" and t.cddate >=").append("'").append(starttime).append("'");
			request.setAttribute("startdate", starttime);
		} else if (StringUtils.isBlank(starttime)&& StringUtils.isNotBlank(endtime)) {
			endtime = StringUtils.trim(endtime);
			buf.append(" and t.cddate <=").append("'").append(endtime).append("'");
			request.setAttribute("enddate", endtime);
		}
		buf.append(" order by t.cddate desc");
		return buf.toString();
	}

	public void setDebitcreditinfoDAO(DebitcreditinfoDAO debitcreditinfoDAO) {
		this.debitcreditinfoDAO = debitcreditinfoDAO;
	}

}
