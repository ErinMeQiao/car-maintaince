package com.wyq.hf.web.action.debitcredit;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.wyq.hf.po.Debitcreditinfo;
import com.wyq.hf.service.debitcredit.DebitcreditManager;
import com.wyq.hf.web.action.util.StrutsWebUtils;
import com.yinbo.utils.DateTimeUtils;
import com.yinbo.web.utils.Struts2Utils;

@SuppressWarnings("serial")
public class DebitcreditManagerAction extends ActionSupport {
	
	private static final String APPROVES = "1";

	private static final String CDFLAG = "0";

	private static final String ENDDATE = "enddate";

	private static final String STARTDATE = "startdate";

	private static final String DUSERID = "dUserid";
	
	private static final String OBJ_LIST = "objList";

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private static final String USERID = "userid";
	
	private static final String QUESTURL = "debitcredit/debitcreditlist.action";
	
	/**
	 * 借贷明细服务接口.
	 */
	private DebitcreditManager debitcreditManager;
	/**
	 * 借贷信息实体.
	 */
	private Debitcreditinfo debitcreditInfo;
	
	public DebitcreditManager getDebitcreditManager() {
		return debitcreditManager;
	}

	public void setDebitcreditManager(DebitcreditManager debitcreditManager) {
		this.debitcreditManager = debitcreditManager;
	}

	public Debitcreditinfo getDebitcreditInfo() {
		return debitcreditInfo;
	}

	public void setDebitcreditInfo(Debitcreditinfo debitcreditInfo) {
		this.debitcreditInfo = debitcreditInfo;
	}

	public String getDUserid() {
		return dUserid;
	}

	public void setDUserid(String userid) {
		dUserid = userid;
	}

	/**
	 * 借贷者.
	 */
	private String dUserid;
	
	public String findDebitcreditList() {		
		StrutsWebUtils.savePreUrl(QUESTURL,DUSERID,STARTDATE,ENDDATE);		
		HttpServletRequest req = Struts2Utils.getRequest();
		List<Debitcreditinfo> objList = null;
		try {
			if(!StrutsWebUtils.isInSingleMarks(req,DUSERID,STARTDATE,ENDDATE)){
				objList = this.getDebitcreditManager().findDebitcreditList(req);
			}			
			req.setAttribute(OBJ_LIST, objList);
		} catch (RuntimeException e) {
			logger.error("query debitcredit list error!" + e.getMessage());
			addActionError("获取家庭借贷信息异常!");
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String debitcreditAdd(){
		this.setDebitcreditInfo(new Debitcreditinfo());
		this.getDebitcreditInfo().setCddate(DateTimeUtils.currentDate());
		return SUCCESS;
	}

	public String debitcreditEnter() {
		StrutsWebUtils.savePreUrl(QUESTURL);
		//获取记录者.
		String userid = (String) Struts2Utils.getSession().getAttribute(USERID);
		this.getDebitcreditInfo().setEnteruser(userid);
		this.getDebitcreditInfo().setEnterdate(DateTimeUtils.currentDate());
		//借出金额记为正，贷入金额记为负
		if(this.getDebitcreditInfo().getCdflag().equals(CDFLAG)){
			this.getDebitcreditInfo().setCdamt(this.getDebitcreditInfo().getCdamt()* -1);
		}
		try {
			this.getDebitcreditManager().add(this.getDebitcreditInfo());
		} catch (RuntimeException e) {
			logger.error("借贷录入异常...");
			addActionError("借贷录入异常");
			e.printStackTrace();
			return ERROR;
		}
		addActionMessage("借贷录入成功!");
		return SUCCESS;
	}
	
	public String debitcreditDelete(){
		try {
			this.getDebitcreditManager().delete(this.getDebitcreditInfo().getDbid());
		} catch (RuntimeException e) {
			logger.error("删除借贷信息异常!");
			e.printStackTrace();
			addActionError("删除借贷信息异常");
			return ERROR;
		}
		addActionMessage("借贷信息删除成功!");
		return SUCCESS;
	}
	
	public String debitcreditDetails(){
		try {
			this.debitcreditInfo = this.getDebitcreditManager().get(this.getDebitcreditInfo().getDbid());
		} catch (RuntimeException e) {
			logger.error("查询借贷信息明细异常!");
			e.printStackTrace();
			addActionError("查询借贷信息明细异常");
			return ERROR;
		}
		addActionMessage("查询借贷信息明细成功!");
		return SUCCESS;
	}
	
	public String debitcreditUpdate(){
		//借出金额记为正，贷入金额记为负
		if(this.getDebitcreditInfo().getCdflag().equals(CDFLAG)){
			this.getDebitcreditInfo().setCdamt(this.getDebitcreditInfo().getCdamt()* -1);
		}
		try {
			this.getDebitcreditManager().save(this.getDebitcreditInfo());
		} catch (RuntimeException e) {
			logger.error("修改借贷信息异常!");
			e.printStackTrace();
			addActionError("修改借贷信息异常");
			return ERROR;
		}
		addActionMessage("修改借贷信息成功!");
		return SUCCESS;
	}
	
	public String enterApprove(){
		
		try {
			this.debitcreditInfo = this.getDebitcreditManager().get(this.getDebitcreditInfo().getDbid());
		} catch (RuntimeException e) {
			logger.error("查询借贷信息异常");
			e.printStackTrace();
			addActionError("查询借贷信息异常");
			return ERROR;
		}		
		this.getDebitcreditInfo().setApprovestatus(APPROVES);		
		try {
			this.getDebitcreditManager().save(this.getDebitcreditInfo());
		} catch (RuntimeException e) {
			logger.error("更新借贷录入审批状态异常");
			e.printStackTrace();
			addActionError("更新借贷录入审批状态异常");
			return ERROR;
		}		
		addActionMessage("借贷录入审批成功!");
		return SUCCESS;
	}
	
	public String rebankApprove(){
		
		try {
			this.debitcreditInfo = this.getDebitcreditManager().get(this.getDebitcreditInfo().getDbid());
		} catch (RuntimeException e) {
			logger.error("查询借贷信息异常");
			e.printStackTrace();
			addActionError("查询借贷信息异常");
			return ERROR;
		}		
		this.getDebitcreditInfo().setRestatusapp(APPROVES);		
		try {
			this.getDebitcreditManager().save(this.getDebitcreditInfo());
		} catch (RuntimeException e) {
			logger.error("更新借贷偿还审批状态异常");
			e.printStackTrace();
			addActionError("更新借贷偿还审批状态异常");
			return ERROR;
		}
		addActionMessage("借贷偿还审批成功!");
		return SUCCESS;
	}
	
	public String rebankAmt(){
		
		try {
			this.debitcreditInfo = this.getDebitcreditManager().get(this.getDebitcreditInfo().getDbid());
		} catch (RuntimeException e) {
			logger.error("查询借贷信息异常");
			e.printStackTrace();
			addActionError("查询借贷信息异常");
			return ERROR;
		}		
		this.getDebitcreditInfo().setRepayflag(APPROVES);		
		try {
			this.getDebitcreditManager().save(this.getDebitcreditInfo());
		} catch (RuntimeException e) {
			logger.error("更新借贷偿还状态异常");
			e.printStackTrace();
			addActionError("更新借贷偿还状态异常");
			return ERROR;
		}
		addActionMessage("借贷偿还成功!");
		return SUCCESS;
	}
}
