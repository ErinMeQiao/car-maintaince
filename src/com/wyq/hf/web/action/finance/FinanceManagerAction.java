package com.wyq.hf.web.action.finance;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.wyq.hf.po.Financeinfo;
import com.wyq.hf.service.finance.FinanceManager;
import com.wyq.hf.web.action.util.StrutsWebUtils;
import com.yinbo.utils.DateTimeUtils;
import com.yinbo.web.utils.Struts2Utils;

@SuppressWarnings("serial")
public class FinanceManagerAction extends ActionSupport {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String APPROVES = "1";
	
	private static final String ENDDATE = "enddate";

	private static final String STARTDATE = "startdate";

	private static final String FUSERID = "fUserid";
	
	private static final String OBJ_LIST = "objList";

	private static final String USERID = "userid";
	
	private static final String QUESTURL = "finance/financelist.action";
	
	/**
	 * 收入明细服务接口.
	 */
	private FinanceManager financeManager;
	/**
	 * 收入信息实体.
	 */
	private Financeinfo financeInfo;
	
	/**
	 * 收入者.
	 */
	private String fUserid;
	
	
	public String findFinanceList() {		
		StrutsWebUtils.savePreUrl(QUESTURL,FUSERID,STARTDATE,ENDDATE);		
		HttpServletRequest req = Struts2Utils.getRequest();
		List<Financeinfo> objList = null;
		try {
			if(!StrutsWebUtils.isInSingleMarks(req,FUSERID,STARTDATE,ENDDATE)){
				objList = this.getFinanceManager().findFinanceList(req);
			}			
			req.setAttribute(OBJ_LIST, objList);
		} catch (RuntimeException e) {
			logger.error("query Finance list error!" + e.getMessage());
			addActionError("获取家庭理财信息异常!");
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String financeAdd(){
		this.setFinanceInfo(new Financeinfo());
		this.getFinanceInfo().setFdate(DateTimeUtils.currentDate());
		return SUCCESS;
	}

	public String financeEnter() {
		StrutsWebUtils.savePreUrl(QUESTURL);
		//获取记录者.
		String userid = (String) Struts2Utils.getSession().getAttribute(USERID);
		this.getFinanceInfo().setEnteruser(userid);
		this.getFinanceInfo().setEnterdate(DateTimeUtils.currentDate());
		try {
			this.getFinanceManager().add(this.getFinanceInfo());
		} catch (RuntimeException e) {
			logger.error("理财信息录入异常...");
			addActionError("理财信息录入异常");
			e.printStackTrace();
			return ERROR;
		}
		addActionMessage("理财信息录入成功!");
		return SUCCESS;
	}
	
	public String financeDelete(){
		try {
			this.getFinanceManager().delete(this.getFinanceInfo().getFid());
		} catch (RuntimeException e) {
			logger.error("删除理财信息异常!");
			e.printStackTrace();
			addActionError("删除理财信息异常");
			return ERROR;
		}
		addActionMessage("理财信息删除成功!");
		return SUCCESS;
	}
	
	public String financeDetails(){
		try {
			this.financeInfo = this.getFinanceManager().get(this.getFinanceInfo().getFid());
		} catch (RuntimeException e) {
			logger.error("查询理财信息明细异常!");
			e.printStackTrace();
			addActionError("查询理财信息明细异常");
			return ERROR;
		}
		addActionMessage("查询理财信息明细成功!");
		return SUCCESS;
	}
	
	public String financeUpdate(){
		try {
			this.getFinanceManager().save(this.getFinanceInfo());
		} catch (RuntimeException e) {
			logger.error("修改理财信息异常!");
			e.printStackTrace();
			addActionError("修改理财信息异常");
			return ERROR;
		}
		addActionMessage("修改理财信息成功!");
		return SUCCESS;
	}

	public FinanceManager getFinanceManager() {
		return financeManager;
	}

	public void setFinanceManager(FinanceManager financeManager) {
		this.financeManager = financeManager;
	}

	public String getFUserid() {
		return fUserid;
	}

	public void setFUserid(String userid) {
		fUserid = userid;
	}

	public Financeinfo getFinanceInfo() {
		return financeInfo;
	}

	public void setFinanceInfo(Financeinfo financeInfo) {
		this.financeInfo = financeInfo;
	}
	
	public String enterApprove(){
		
		try {
			this.financeInfo = this.getFinanceManager().get(this.getFinanceInfo().getFid());
		} catch (RuntimeException e) {
			logger.error("查询理财信息异常");
			e.printStackTrace();
			addActionError("查询理财信息异常");
			return ERROR;
		}		
		this.getFinanceInfo().setApprovestatus(APPROVES);		
		try {
			this.getFinanceManager().save(this.getFinanceInfo());
		} catch (RuntimeException e) {
			logger.error("更新理财录入审批状态异常");
			e.printStackTrace();
			addActionError("更新理财录入审批状态异常");
			return ERROR;
		}		
		addActionMessage("理财录入审批成功!");
		return SUCCESS;
	}
	
	public String rebankApprove(){
		
		try {
			this.financeInfo = this.getFinanceManager().get(this.getFinanceInfo().getFid());
		} catch (RuntimeException e) {
			logger.error("查询理财信息异常");
			e.printStackTrace();
			addActionError("查询理财信息异常");
			return ERROR;
		}		
		this.getFinanceInfo().setAppohand(APPROVES);		
		try {
			this.getFinanceManager().save(this.getFinanceInfo());
		} catch (RuntimeException e) {
			logger.error("更新理财脱手审批状态异常");
			e.printStackTrace();
			addActionError("更新理财脱手审批状态异常");
			return ERROR;
		}
		addActionMessage("理财脱手审批成功!");
		return SUCCESS;
	}
	
	public String rebankAmt(){
		
		try {
			this.financeInfo = this.getFinanceManager().get(this.getFinanceInfo().getFid());
		} catch (RuntimeException e) {
			logger.error("查询理财信息异常");
			e.printStackTrace();
			addActionError("查询理财信息异常");
			return ERROR;
		}		
		this.getFinanceInfo().setOhandstatus(APPROVES);		
		try {
			this.getFinanceManager().save(this.getFinanceInfo());
		} catch (RuntimeException e) {
			logger.error("更新理财脱手状态异常");
			e.printStackTrace();
			addActionError("更新理财脱手状态异常");
			return ERROR;
		}
		addActionMessage("理财脱手成功!");
		return SUCCESS;
	}
}
