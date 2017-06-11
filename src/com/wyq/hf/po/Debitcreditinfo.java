package com.wyq.hf.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Debitcreditinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "debitcreditinfo", catalog = "homefinance")
public class Debitcreditinfo implements java.io.Serializable {

	// Fields

	private Integer dbid;
	private String cduser;
	private Double cdamt;
	private String cdname;
	private Date cddate;
	private String cddescription;
	private String cdflag;
	private String repayflag;
	private String restatusapp;
	private String approvestatus;
	private String enteruser;
	private Date enterdate;
	private String cdremark;

	// Constructors

	/** default constructor */
	public Debitcreditinfo() {
	}

	/** minimal constructor */
	public Debitcreditinfo(String cduser, Double cdamt, String cdname,
			Date cddate, String cdflag, String repayflag, String restatusapp,
			String approvestatus, String enteruser, Date enterdate) {
		this.cduser = cduser;
		this.cdamt = cdamt;
		this.cdname = cdname;
		this.cddate = cddate;
		this.cdflag = cdflag;
		this.repayflag = repayflag;
		this.restatusapp = restatusapp;
		this.approvestatus = approvestatus;
		this.enteruser = enteruser;
		this.enterdate = enterdate;
	}

	/** full constructor */
	public Debitcreditinfo(String cduser, Double cdamt, String cdname,
			Date cddate, String cddescription, String cdflag, String repayflag,
			String restatusapp, String approvestatus, String enteruser,
			Date enterdate, String cdremark) {
		this.cduser = cduser;
		this.cdamt = cdamt;
		this.cdname = cdname;
		this.cddate = cddate;
		this.cddescription = cddescription;
		this.cdflag = cdflag;
		this.repayflag = repayflag;
		this.restatusapp = restatusapp;
		this.approvestatus = approvestatus;
		this.enteruser = enteruser;
		this.enterdate = enterdate;
		this.cdremark = cdremark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "dbid", unique = true, nullable = false)
	public Integer getDbid() {
		return this.dbid;
	}

	public void setDbid(Integer dbid) {
		this.dbid = dbid;
	}

	@Column(name = "cduser", nullable = false, length = 18)
	public String getCduser() {
		return this.cduser;
	}

	public void setCduser(String cduser) {
		this.cduser = cduser;
	}

	@Column(name = "cdamt", nullable = false, precision = 8)
	public Double getCdamt() {
		return this.cdamt;
	}

	public void setCdamt(Double cdamt) {
		this.cdamt = cdamt;
	}

	@Column(name = "cdname", nullable = false, length = 30)
	public String getCdname() {
		return this.cdname;
	}

	public void setCdname(String cdname) {
		this.cdname = cdname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cddate", nullable = false, length = 19)
	public Date getCddate() {
		return this.cddate;
	}

	public void setCddate(Date cddate) {
		this.cddate = cddate;
	}

	@Column(name = "cddescription", length = 256)
	public String getCddescription() {
		return this.cddescription;
	}

	public void setCddescription(String cddescription) {
		this.cddescription = cddescription;
	}

	@Column(name = "cdflag", nullable = false, length = 1)
	public String getCdflag() {
		return this.cdflag;
	}

	public void setCdflag(String cdflag) {
		this.cdflag = cdflag;
	}

	@Column(name = "repayflag", nullable = false, length = 1)
	public String getRepayflag() {
		return this.repayflag;
	}

	public void setRepayflag(String repayflag) {
		this.repayflag = repayflag;
	}

	@Column(name = "restatusapp", nullable = false, length = 1)
	public String getRestatusapp() {
		return this.restatusapp;
	}

	public void setRestatusapp(String restatusapp) {
		this.restatusapp = restatusapp;
	}

	@Column(name = "approvestatus", nullable = false, length = 1)
	public String getApprovestatus() {
		return this.approvestatus;
	}

	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}

	@Column(name = "enteruser", nullable = false, length = 18)
	public String getEnteruser() {
		return this.enteruser;
	}

	public void setEnteruser(String enteruser) {
		this.enteruser = enteruser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enterdate", nullable = false, length = 19)
	public Date getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	@Column(name = "cdremark", length = 512)
	public String getCdremark() {
		return this.cdremark;
	}

	public void setCdremark(String cdremark) {
		this.cdremark = cdremark;
	}

}