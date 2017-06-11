package com.wyq.hf.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Payoutinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payoutinfo", catalog = "homefinance")
public class Payoutinfo implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Payouttarget payouttarget;
	private Changemode changemode;
	private String puserid;
	private Double pamt;
	private Date pdate;
	private String pdescription;
	private Date enterdate;
	private String enteruser;
	private String approvestatus;
	private String premark;

	// Constructors

	/** default constructor */
	public Payoutinfo() {
	}

	/** minimal constructor */
	public Payoutinfo(String puserid, Double pamt, Date pdate,
			String pdescription, String enteruser) {
		this.puserid = puserid;
		this.pamt = pamt;
		this.pdate = pdate;
		this.pdescription = pdescription;
		this.enteruser = enteruser;
	}

	/** full constructor */
	public Payoutinfo(Payouttarget payouttarget, Changemode changemode,
			String puserid, Double pamt, Date pdate, String pdescription,
			Date enterdate, String enteruser, String approvestatus,
			String premark) {
		this.payouttarget = payouttarget;
		this.changemode = changemode;
		this.puserid = puserid;
		this.pamt = pamt;
		this.pdate = pdate;
		this.pdescription = pdescription;
		this.enterdate = enterdate;
		this.enteruser = enteruser;
		this.approvestatus = approvestatus;
		this.premark = premark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ptargetid")
	public Payouttarget getPayouttarget() {
		return this.payouttarget;
	}

	public void setPayouttarget(Payouttarget payouttarget) {
		this.payouttarget = payouttarget;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mid")
	public Changemode getChangemode() {
		return this.changemode;
	}

	public void setChangemode(Changemode changemode) {
		this.changemode = changemode;
	}

	@Column(name = "puserid", nullable = false, length = 18)
	public String getPuserid() {
		return this.puserid;
	}

	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

	@Column(name = "pamt", nullable = false, precision = 8)
	public Double getPamt() {
		return this.pamt;
	}

	public void setPamt(Double pamt) {
		this.pamt = pamt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pdate", nullable = false, length = 19)
	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	@Column(name = "pdescription", nullable = false, length = 100)
	public String getPdescription() {
		return this.pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enterdate", length = 19)
	public Date getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	@Column(name = "enteruser", nullable = false, length = 18)
	public String getEnteruser() {
		return this.enteruser;
	}

	public void setEnteruser(String enteruser) {
		this.enteruser = enteruser;
	}

	@Column(name = "approvestatus", length = 1)
	public String getApprovestatus() {
		return this.approvestatus;
	}

	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}

	@Column(name = "premark", length = 256)
	public String getPremark() {
		return this.premark;
	}

	public void setPremark(String premark) {
		this.premark = premark;
	}

}