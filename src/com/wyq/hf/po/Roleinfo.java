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
 * Roleinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roleinfo", catalog = "homefinance")
public class Roleinfo implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	private String remark;
	private String privilege;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	// Constructors

	/** default constructor */
	public Roleinfo() {
	}

	/** minimal constructor */
	public Roleinfo(String rolename, String privilege) {
		this.rolename = rolename;
		this.privilege = privilege;
	}

	/** full constructor */
	public Roleinfo(String rolename, String remark, String privilege,
			Set<Userinfo> userinfos) {
		this.rolename = rolename;
		this.remark = remark;
		this.privilege = privilege;
		this.userinfos = userinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename", nullable = false, length = 20)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "remark", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "privilege", nullable = false, length = 256)
	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleinfo")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}