package com.easysoft.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patent_after_2007_52_30w database table.
 * 
 */
@Entity
@Table(name="patent_after_2007_52_30w")
@NamedQuery(name="PatentAfter20075230w.findAll", query="SELECT p FROM PatentAfter20075230w p")
public class PatentAfter20075230w implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ad;

	private String an;

	private String db;

	private String pd;

	private String pn;

	@Lob
	private String shencha;

	private String sysid;

	public PatentAfter20075230w() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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