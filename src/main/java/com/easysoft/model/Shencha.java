package com.easysoft.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shencha database table.
 * 
 */
@Entity
@NamedQuery(name="Shencha.findAll", query="SELECT s FROM Shencha s")
public class Shencha implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ad;

	private String an;

	private String db;

	@Id
	private int id;

	private String pd;

	private String pn;

	@Lob
	private String shencha;

	private String sysid;

	public Shencha() {
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAn() {
		return this.an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPd() {
		return this.pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getShencha() {
		return this.shencha;
	}

	public void setShencha(String shencha) {
		this.shencha = shencha;
	}

	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

}