package com.wyq.hf.web.action.income;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.wyq.hf.po.Incomeinfo;
import com.wyq.hf.service.income.IncomeManager;
import com.wyq.hf.web.action.util.StrutsWebUtils;
import com.yinbo.utils.DateTimeUtils;
import com.yinbo.web.utils.Struts2Utils;

@SuppressWarnings("serial")
public class IncomeManagerAction extends ActionSupport {
	
	private static final String APPROVES = "1";
	
	private static final String ENDDATE = "enddate";

	private static final String STARTDATE = "startdate";

	private static final String IUSERID = "iUserid";
	
	private static final String OBJ_LIST = "objList";

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private static final String USERID = "userid";
	
	private static final String QUESTURL = "income/incomelist.action";
	
	/**
	 * 收入明细服务接口.
	 */
	private IncomeManager incomeManager;
	/**
	 * 收入信息实体.
	 */
	private Incomeinfo incomeInfo;
	
	/**
	 * 收入者.
	 */
	private String iUserid;
	
	public String getIUserid() {
		return iUserid;
	}

	public void setIUserid(String userid) {
		iUserid = userid;
	}

	public IncomeManager getIncomeManager() {
		return incomeManager;
	}

	public void setIncomeManager(IncomeManager incomeManager) {
		this.incomeManager = incomeManager;
	}
	
	public String findIncomeList() {		
		StrutsWebUtils.savePreUrl(QUESTURL,IUSERID,STARTDATE,ENDDATE);		
		HttpServletRequest req = Struts2Utils.getRequest();
		List<Incomeinfo> objList = null;
		try {
			if(!StrutsWebUtils.isInSingleMarks(req,IUSERID,STARTDATE,ENDDATE)){
				objList = this.getIncomeManager().findIncomeList(req);
			}			
			req.setAttribute(OBJ_LIST, objList);
		} catch (RuntimeException e) {
			logger.error("query income list error!" + e.getMessage());
			addActionError("获取家庭收入信息异常!");
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String incomeAdd(){
		this.setIncomeInfo(new Incomeinfo());
		this.getIncomeInfo().setIdate(DateTimeUtils.currentDate());
		return SUCCESS;
	}

	public String incomeEnter() {
		StrutsWebUtils.savePreUrl(QUESTURL);
		//获取记录者.
		String userid = (String) Struts2Utils.getSession().getAttribute(USERID);
		this.getIncomeInfo().setEnteruser(userid);
		this.getIncomeInfo().setEnterdate(DateTimeUtils.currentDate());
		try {
			this.getIncomeManager().add(this.getIncomeInfo());
		} catch (RuntimeException e) {
			logger.error("收入录入异常...");
			addActionError("收入录入异常");
			e.printStackTrace();
			return ERROR;
		}
		addActionMessage("收入录入成功!");
		return SUCCESS;
	}
	
	public String incomeDelete(){
		try {
			this.getIncomeManager().delete(this.getIncomeInfo().getIid());
		} catch (RuntimeException e) {
			logger.error("删除收入信息异常!");
			e.printStackTrace();
			addActionError("删除收入信息异常");
			return ERROR;
		}
		addActionMessage("收入信息删除成功!");
		return SUCCESS;
	}
	
	public String incomeDetails(){
		try {
			this.incomeInfo = this.getIncomeManager().get(this.getIncomeInfo().getIid());
		} catch (RuntimeException e) {
			logger.error("查询收入信息明细异常!");
			e.printStackTrace();
			addActionError("查询收入信息明细异常");
			return ERROR;
		}
		addActionMessage("查询收入信息明细成功!");
		return SUCCESS;
	}
	
	public String incomeUpdate(){
		try {
			this.getIncomeManager().save(this.getIncomeInfo());
		} catch (RuntimeException e) {
			logger.error("修改收入信息异常!");
			e.printStackTrace();
			addActionError("修改收入信息异常");
			return ERROR;
		}
		addActionMessage("修改收入信息成功!");
		return SUCCESS;
	}

	public Incomeinfo getIncomeInfo() {
		return incomeInfo;
	}

	public void setIncomeInfo(Incomeinfo incomeInfo) {
		this.incomeInfo = incomeInfo;
	}
	
	public String enterApprove(){		
		try {
			this.incomeInfo = this.getIncomeManager().get(this.getIncomeInfo().getIid());
		} catch (RuntimeException e) {
			logger.error("查询收入信息异常");
			e.printStackTrace();
			addActionError("查询收入信息异常");
			return ERROR;
		}		
		this.getIncomeInfo().setApprovestatus(APPROVES);		
		try {
			this.getIncomeManager().save(this.getIncomeInfo());
		} catch (RuntimeException e) {
			logger.error("更新收入录入审批状态异常");
			e.printStackTrace();
			addActionError("更新收入录入审批状态异常");
			return ERROR;
		}		
		addActionMessage("收入录入审批成功!");
		return SUCCESS;
	}
}
