package com.wyq.hf.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Userinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "homefinance")
public class Userinfo implements java.io.Serializable {

	// Fields

	private String userid;
	private Roleinfo roleinfo;
	private String usename;
	private String password;
	private String isactive;
	private String telphone;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String usename, String password, String isactive) {
		this.usename = usename;
		this.password = password;
		this.isactive = isactive;
	}

	/** full constructor */
	public Userinfo(Roleinfo roleinfo, String usename, String password,
			String isactive, String telphone) {
		this.roleinfo = roleinfo;
		this.usename = usename;
		this.password = password;
		this.isactive = isactive;
		this.telphone = telphone;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false, length = 18)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid")
	public Roleinfo getRoleinfo() {
		return this.roleinfo;
	}

	public void setRoleinfo(Roleinfo roleinfo) {
		this.roleinfo = roleinfo;
	}

	@Column(name = "usename", nullable = false, length = 30)
	public String getUsename() {
		return this.usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	@Column(name = "password", nullable = false, length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "isactive", nullable = false, length = 1)
	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "telphone", length = 20)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

}