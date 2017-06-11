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
 * Financetarget entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "financetarget", catalog = "homefinance")
public class Financetarget implements java.io.Serializable {

	// Fields

	private Integer ftargetid;
	private String ftargetname;
	private String fremark;
	private Set<Financeinfo> financeinfos = new HashSet<Financeinfo>(0);

	// Constructors

	/** default constructor */
	public Financetarget() {
	}

	/** minimal constructor */
	public Financetarget(String ftargetname) {
		this.ftargetname = ftargetname;
	}

	/** full constructor */
	public Financetarget(String ftargetname, String fremark,
			Set<Financeinfo> financeinfos) {
		this.ftargetname = ftargetname;
		this.fremark = fremark;
		this.financeinfos = financeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ftargetid", unique = true, nullable = false)
	public Integer getFtargetid() {
		return this.ftargetid;
	}

	public void setFtargetid(Integer ftargetid) {
		this.ftargetid = ftargetid;
	}

	@Column(name = "ftargetname", nullable = false, length = 30)
	public String getFtargetname() {
		return this.ftargetname;
	}

	public void setFtargetname(String ftargetname) {
		this.ftargetname = ftargetname;
	}

	@Column(name = "fremark", length = 256)
	public String getFremark() {
		return this.fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "financetarget")
	public Set<Financeinfo> getFinanceinfos() {
		return this.financeinfos;
	}

	public void setFinanceinfos(Set<Financeinfo> financeinfos) {
		this.financeinfos = financeinfos;
	}

}