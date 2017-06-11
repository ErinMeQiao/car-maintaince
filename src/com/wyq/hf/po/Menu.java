package com.wyq.hf.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Menu entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu", catalog = "homefinance")
public class Menu implements java.io.Serializable {

	// Fields

	private Integer menuid;
	private String menuname;
	private String menuurl;
	private Integer parentmenuid;
	private String remark;
	private String state;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String menuname, String menuurl, Integer parentmenuid,
			String state) {
		this.menuname = menuname;
		this.menuurl = menuurl;
		this.parentmenuid = parentmenuid;
		this.state = state;
	}

	/** full constructor */
	public Menu(String menuname, String menuurl, Integer parentmenuid,
			String remark, String state) {
		this.menuname = menuname;
		this.menuurl = menuurl;
		this.parentmenuid = parentmenuid;
		this.remark = remark;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "menuid", unique = true, nullable = false)
	public Integer getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	@Column(name = "menuname", nullable = false, length = 100)
	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	@Column(name = "menuurl", nullable = false, length = 100)
	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	@Column(name = "parentmenuid", nullable = false)
	public Integer getParentmenuid() {
		return this.parentmenuid;
	}

	public void setParentmenuid(Integer parentmenuid) {
		this.parentmenuid = parentmenuid;
	}

	@Column(name = "remark", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "state", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}