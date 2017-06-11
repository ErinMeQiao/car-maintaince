package com.wyq.hf.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Payouttarget entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payouttarget", catalog = "homefinance")
public class Payouttarget implements java.io.Serializable {

	// Fields

	private Integer ptargetid;
	private String ptargetname;
	private String premark;
	private Set<Payoutinfo> payoutinfos = new HashSet<Payoutinfo>(0);

	// Constructors

	/** default constructor */
	public Payouttarget() {
	}

	/** minimal constructor */
	public Payouttarget(String ptargetname) {
		this.ptargetname = ptargetname;
	}

	/** full constructor */
	public Payouttarget(String ptargetname, String premark,
			Set<Payoutinfo> payoutinfos) {
		this.ptargetname = ptargetname;
		this.premark = premark;
		this.payoutinfos = payoutinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ptargetid", unique = true, nullable = false)
	public Integer getPtargetid() {
		return this.ptargetid;
	}

	public void setPtargetid(Integer ptargetid) {
		this.ptargetid = ptargetid;
	}

	@Column(name = "ptargetname", nullable = false, length = 30)
	public String getPtargetname() {
		return this.ptargetname;
	}

	public void setPtargetname(String ptargetname) {
		this.ptargetname = ptargetname;
	}

	@Column(name = "premark", length = 256)
	public String getPremark() {
		return this.premark;
	}

	public void setPremark(String premark) {
		this.premark = premark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payouttarget")
	public Set<Payoutinfo> getPayoutinfos() {
		return this.payoutinfos;
	}

	public void setPayoutinfos(Set<Payoutinfo> payoutinfos) {
		this.payoutinfos = payoutinfos;
	}

}