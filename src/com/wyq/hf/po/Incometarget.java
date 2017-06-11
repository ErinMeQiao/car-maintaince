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
 * Incometarget entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "incometarget", catalog = "homefinance")
public class Incometarget implements java.io.Serializable {

	// Fields

	private Integer intargetid;
	private String intargetname;
	private String iremark;
	private Set<Incomeinfo> incomeinfos = new HashSet<Incomeinfo>(0);

	// Constructors

	/** default constructor */
	public Incometarget() {
	}

	/** minimal constructor */
	public Incometarget(String intargetname) {
		this.intargetname = intargetname;
	}

	/** full constructor */
	public Incometarget(String intargetname, String iremark,
			Set<Incomeinfo> incomeinfos) {
		this.intargetname = intargetname;
		this.iremark = iremark;
		this.incomeinfos = incomeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "intargetid", unique = true, nullable = false)
	public Integer getIntargetid() {
		return this.intargetid;
	}

	public void setIntargetid(Integer intargetid) {
		this.intargetid = intargetid;
	}

	@Column(name = "intargetname", nullable = false, length = 30)
	public String getIntargetname() {
		return this.intargetname;
	}

	public void setIntargetname(String intargetname) {
		this.intargetname = intargetname;
	}

	@Column(name = "iremark", length = 256)
	public String getIremark() {
		return this.iremark;
	}

	public void setIremark(String iremark) {
		this.iremark = iremark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "incometarget")
	public Set<Incomeinfo> getIncomeinfos() {
		return this.incomeinfos;
	}

	public void setIncomeinfos(Set<Incomeinfo> incomeinfos) {
		this.incomeinfos = incomeinfos;
	}

}