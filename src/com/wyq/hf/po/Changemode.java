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
 * Changemode entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "changemode", catalog = "homefinance")
public class Changemode implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mname;
	private String remark;
	private Set<Financeinfo> financeinfos = new HashSet<Financeinfo>(0);
	private Set<Payoutinfo> payoutinfos = new HashSet<Payoutinfo>(0);

	// Constructors

	/** default constructor */
	public Changemode() {
	}

	/** minimal constructor */
	public Changemode(String mname) {
		this.mname = mname;
	}

	/** full constructor */
	public Changemode(String mname, String remark,
			Set<Financeinfo> financeinfos, Set<Payoutinfo> payoutinfos) {
		this.mname = mname;
		this.remark = remark;
		this.financeinfos = financeinfos;
		this.payoutinfos = payoutinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "mid", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "mname", nullable = false, length = 20)
	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Column(name = "remark", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "changemode")
	public Set<Financeinfo> getFinanceinfos() {
		return this.financeinfos;
	}

	public void setFinanceinfos(Set<Financeinfo> financeinfos) {
		this.financeinfos = financeinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "changemode")
	public Set<Payoutinfo> getPayoutinfos() {
		return this.payoutinfos;
	}

	public void setPayoutinfos(Set<Payoutinfo> payoutinfos) {
		this.payoutinfos = payoutinfos;
	}

}