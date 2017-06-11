package com.wyq.hf.web.action.payout;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.wyq.hf.po.Payoutinfo;
import com.wyq.hf.service.payout.PayoutManager;
import com.wyq.hf.web.action.util.StrutsWebUtils;
import com.yinbo.utils.DateTimeUtils;
import com.yinbo.web.utils.Struts2Utils;

@SuppressWarnings("serial")
public class PayoutManagerAction extends ActionSupport {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String APPROVES = "1";
	
	private static final String OBJ_LIST = "objList";

	private static final String ENDTIME = "enddate";

	private static final String STARTTIME = "startdate";

	private static final String PUSERID = "pUserid";

	private static final String USERID = "userid";
	
	private static final String QUESTURL = "payout/payoutlist.action";
	
	/**
	 * 消费明细服务接口.
	 */
	private PayoutManager payoutManager;
	
	public PayoutManager getPayoutManager() {
		return payoutManager;
	}

	public void setPayoutManager(PayoutManager payoutManager) {
		this.payoutManager = payoutManager;
	}

	/**
	 * 消费信息实体.
	 */
	private Payoutinfo payoutInfo;
	
	/**
	 * 支出者.
	 */
	private String pUserid;
	
	public String findPayoutList() {		
		StrutsWebUtils.savePreUrl(QUESTURL,PUSERID,STARTTIME,ENDTIME);		
		HttpServletRequest req = Struts2Utils.getRequest();
		List<Payoutinfo> objList = null;
		try {
			if(!StrutsWebUtils.isInSingleMarks(req,PUSERID,STARTTIME,ENDTIME)){
				objList = this.getPayoutManager().findPayoutinfoList(req);
			}			
			req.setAttribute(OBJ_LIST, objList);
		} catch (RuntimeException e) {
			logger.error("query consume list error!" + e.getMessage());
			addActionError("获取家庭支出信息异常!");
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String payoutAdd(){
		this.setPayoutInfo(new Payoutinfo());
		this.getPayoutInfo().setPdate(DateTimeUtils.currentDate());
		return SUCCESS;
	}
	public String payoutEnter() {
		//获取记录者.
		String userid = (String) Struts2Utils.getSession().getAttribute(USERID);
		this.getPayoutInfo().setEnteruser(userid);
		this.getPayoutInfo().setEnterdate(DateTimeUtils.currentDate());
		try {
			this.getPayoutManager().add(this.getPayoutInfo());
		} catch (RuntimeException e) {
			logger.error("支出录入异常...");
			addActionError("支出录入异常");
			e.printStackTrace();
			return ERROR;
		}
		addActionMessage("支出录入成功!");
		return SUCCESS;
	}
	
	public String payoutDelete(){
		
		try {
			this.getPayoutManager().delete(this.getPayoutInfo().getPid());
		} catch (RuntimeException e) {
			logger.error("删除支出信息异常!");
			e.printStackTrace();
			addActionError("删除支出信息异常");
			return ERROR;
		}
		addActionMessage("支出信息删除成功!");
		return SUCCESS;
	}
	
	public String payoutDetails(){
		try {
			this.payoutInfo = this.getPayoutManager().get(this.getPayoutInfo().getPid());
		} catch (RuntimeException e) {
			logger.error("查询支出信息明细异常!");
			e.printStackTrace();
			addActionError("查询支出信息明细异常");
			return ERROR;
		}
		addActionMessage("查询支出信息明细成功!");
		return SUCCESS;
	}
	
	public String payoutUpdate(){
		try {
			this.getPayoutManager().save(this.getPayoutInfo());
		} catch (RuntimeException e) {
			logger.error("修改支出信息异常!");
			e.printStackTrace();
			addActionError("修改支出信息异常");
			return ERROR;
		}
		addActionMessage("修改支出信息成功!");
		return SUCCESS;
	}

	public Payoutinfo getPayoutInfo() {
		return payoutInfo;
	}

	public void setPayoutInfo(Payoutinfo payoutInfo) {
		this.payoutInfo = payoutInfo;
	}

	public String getPUserid() {
		return pUserid;
	}

	public void setPUserid(String userid) {
		pUserid = userid;
	}
	public String enterApprove(){		
		try {
			this.payoutInfo = this.getPayoutManager().get(this.getPayoutInfo().getPid());
		} catch (RuntimeException e) {
			logger.error("查询信息异常");
			e.printStackTrace();
			addActionError("查询支出信息异常");
			return ERROR;
		}		
		this.getPayoutInfo().setApprovestatus(APPROVES);		
		try {
			this.getPayoutManager().save(this.getPayoutInfo());
		} catch (RuntimeException e) {
			logger.error("更新支出录入审批状态异常");
			e.printStackTrace();
			addActionError("更新支出录入审批状态异常");
			return ERROR;
		}		
		addActionMessage("支出录入审批成功!");
		return SUCCESS;
	}
}
