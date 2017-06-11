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
 * Incomeinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "incomeinfo", catalog = "homefinance")
public class Incomeinfo implements java.io.Serializable {

	// Fields

	private Integer iid;
	private Incometarget incometarget;
	private String iuserid;
	private Double iamt;
	private Date idate;
	private String idescription;
	private String enteruser;
	private Date enterdate;
	private String approvestatus;
	private String iremark;

	// Constructors

	/** default constructor */
	public Incomeinfo() {
	}

	/** minimal constructor */
	public Incomeinfo(String iuserid, Double iamt, Date idate,
			String enteruser, Date enterdate) {
		this.iuserid = iuserid;
		this.iamt = iamt;
		this.idate = idate;
		this.enteruser = enteruser;
		this.enterdate = enterdate;
	}

	/** full constructor */
	public Incomeinfo(Incometarget incometarget, String iuserid, Double iamt,
			Date idate, String idescription, String enteruser, Date enterdate,
			String approvestatus, String iremark) {
		this.incometarget = incometarget;
		this.iuserid = iuserid;
		this.iamt = iamt;
		this.idate = idate;
		this.idescription = idescription;
		this.enteruser = enteruser;
		this.enterdate = enterdate;
		this.approvestatus = approvestatus;
		this.iremark = iremark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "iid", unique = true, nullable = false)
	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "intargetid")
	public Incometarget getIncometarget() {
		return this.incometarget;
	}

	public void setIncometarget(Incometarget incometarget) {
		this.incometarget = incometarget;
	}

	@Column(name = "iuserid", nullable = false, length = 18)
	public String getIuserid() {
		return this.iuserid;
	}

	public void setIuserid(String iuserid) {
		this.iuserid = iuserid;
	}

	@Column(name = "iamt", nullable = false, precision = 8)
	public Double getIamt() {
		return this.iamt;
	}

	public void setIamt(Double iamt) {
		this.iamt = iamt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "idate", nullable = false, length = 19)
	public Date getIdate() {
		return this.idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	@Column(name = "idescription", length = 256)
	public String getIdescription() {
		return this.idescription;
	}

	public void setIdescription(String idescription) {
		this.idescription = idescription;
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

	@Column(name = "approvestatus", length = 1)
	public String getApprovestatus() {
		return this.approvestatus;
	}

	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}

	@Column(name = "iremark", length = 256)
	public String getIremark() {
		return this.iremark;
	}

	public void setIremark(String iremark) {
		this.iremark = iremark;
	}

}