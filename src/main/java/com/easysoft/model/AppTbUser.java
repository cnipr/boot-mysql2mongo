package com.easysoft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APP_TB_USER database table.
 * 
 */
@Entity
@Table(name="APP_TB_USER")
@NamedQuery(name="AppTbUser.findAll", query="SELECT a FROM AppTbUser a")
public class AppTbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private String administername;

	private String department;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date expiretime;

	private String fax;

	private BigDecimal memberpoint;

	private String memo;

	private String mobile;

	private String password;

	private String phone;

	private String realname;

	@Temporal(TemporalType.DATE)
	private Date registertime;

	/**
	 * 当数据库中没有主键时，需要人为的指定一个
	 */
	@Id
	private String username;

	private BigDecimal userstate;

	private BigDecimal usertype;

	public AppTbUser() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdministername() {
		return this.administername;
	}

	public void setAdministername(String administername) {
		this.administername = administername;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpiretime() {
		return this.expiretime;
	}

	public void setExpiretime(Date expiretime) {
		this.expiretime = expiretime;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public BigDecimal getMemberpoint() {
		return this.memberpoint;
	}

	public void setMemberpoint(BigDecimal memberpoint) {
		this.memberpoint = memberpoint;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getUserstate() {
		return this.userstate;
	}

	public void setUserstate(BigDecimal userstate) {
		this.userstate = userstate;
	}

	public BigDecimal getUsertype() {
		return this.usertype;
	}

	public void setUsertype(BigDecimal usertype) {
		this.usertype = usertype;
	}

}