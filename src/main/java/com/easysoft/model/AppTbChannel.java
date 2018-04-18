package com.easysoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the app_tb_channel database table.
 * 
 */
@Entity
@Table(name="app_tb_channel")
@NamedQuery(name="AppTbChannel.findAll", query="SELECT a FROM AppTbChannel a")
public class AppTbChannel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHANNEL_ID")
	private String channelId;

	@Column(name="CHANNEL_NAME")
	private String channelName;

	@Column(name="CHANNEL_SN")
	private int channelSn;

	@Column(name="CHANNEL_TYPE")
	private int channelType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PUB_DATE_FROM")
	private Date pubDateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PUB_DATE_TO")
	private Date pubDateTo;

	@Column(name="TRS_COUNT")
	private int trsCount;

	@Column(name="TRS_TABLE")
	private String trsTable;

	public AppTbChannel() {
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getChannelSn() {
		return this.channelSn;
	}

	public void setChannelSn(int channelSn) {
		this.channelSn = channelSn;
	}

	public int getChannelType() {
		return this.channelType;
	}

	public void setChannelType(int channelType) {
		this.channelType = channelType;
	}

	public Date getPubDateFrom() {
		return this.pubDateFrom;
	}

	public void setPubDateFrom(Date pubDateFrom) {
		this.pubDateFrom = pubDateFrom;
	}

	public Date getPubDateTo() {
		return this.pubDateTo;
	}

	public void setPubDateTo(Date pubDateTo) {
		this.pubDateTo = pubDateTo;
	}

	public int getTrsCount() {
		return this.trsCount;
	}

	public void setTrsCount(int trsCount) {
		this.trsCount = trsCount;
	}

	public String getTrsTable() {
		return this.trsTable;
	}

	public void setTrsTable(String trsTable) {
		this.trsTable = trsTable;
	}

}