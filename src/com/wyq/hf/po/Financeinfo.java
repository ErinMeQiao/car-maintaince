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
 * Financeinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "financeinfo", catalog = "homefinance")
public class Financeinfo implements java.io.Serializable {

	// Fields

	private Integer fid;
	private Financetarget financetarget;
	private Changemode changemode;
	private String fuserid;
	private Double famt;
	private Date fdate;
	private String fdescription;
	private Date enterdate;
	private String enteruser;
	private String ohandstatus;
	private String appohand;
	private String approvestatus;
	private String fremark;

	// Constructors

	/** default constructor */
	public Financeinfo() {
	}

	/** minimal constructor */
	public Financeinfo(String fuserid, Double famt, Date fdate, Date enterdate,
			String enteruser, String ohandstatus, String appohand) {
		this.fuserid = fuserid;
		this.famt = famt;
		this.fdate = fdate;
		this.enterdate = enterdate;
		this.enteruser = enteruser;
		this.ohandstatus = ohandstatus;
		this.appohand = appohand;
	}

	/** full constructor */
	public Financeinfo(Financetarget financetarget, Changemode changemode,
			String fuserid, Double famt, Date fdate, String fdescription,
			Date enterdate, String enteruser, String ohandstatus,
			String appohand, String approvestatus, String fremark) {
		this.financetarget = financetarget;
		this.changemode = changemode;
		this.fuserid = fuserid;
		this.famt = famt;
		this.fdate = fdate;
		this.fdescription = fdescription;
		this.enterdate = enterdate;
		this.enteruser = enteruser;
		this.ohandstatus = ohandstatus;
		this.appohand = appohand;
		this.approvestatus = approvestatus;
		this.fremark = fremark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "fid", unique = true, nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ftargetid")
	public Financetarget getFinancetarget() {
		return this.financetarget;
	}

	public void setFinancetarget(Financetarget financetarget) {
		this.financetarget = financetarget;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mid")
	public Changemode getChangemode() {
		return this.changemode;
	}

	public void setChangemode(Changemode changemode) {
		this.changemode = changemode;
	}

	@Column(name = "fuserid", nullable = false, length = 18)
	public String getFuserid() {
		return this.fuserid;
	}

	public void setFuserid(String fuserid) {
		this.fuserid = fuserid;
	}

	@Column(name = "famt", nullable = false, precision = 8)
	public Double getFamt() {
		return this.famt;
	}

	public void setFamt(Double famt) {
		this.famt = famt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fdate", nullable = false, length = 19)
	public Date getFdate() {
		return this.fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	@Column(name = "fdescription", length = 100)
	public String getFdescription() {
		return this.fdescription;
	}

	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enterdate", nullable = false, length = 19)
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

	@Column(name = "ohandstatus", nullable = false, length = 1)
	public String getOhandstatus() {
		return this.ohandstatus;
	}

	public void setOhandstatus(String ohandstatus) {
		this.ohandstatus = ohandstatus;
	}

	@Column(name = "appohand", nullable = false, length = 1)
	public String getAppohand() {
		return this.appohand;
	}

	public void setAppohand(String appohand) {
		this.appohand = appohand;
	}

	@Column(name = "approvestatus", length = 1)
	public String getApprovestatus() {
		return this.approvestatus;
	}

	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}

	@Column(name = "fremark", length = 256)
	public String getFremark() {
		return this.fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

}