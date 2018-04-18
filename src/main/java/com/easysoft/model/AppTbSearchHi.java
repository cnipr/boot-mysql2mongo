package com.easysoft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APP_TB_SEARCH_HIS database table.
 * 
 */
@Entity
@Table(name="APP_TB_SEARCH_HIS")
@NamedQuery(name="AppTbSearchHi.findAll", query="SELECT a FROM AppTbSearchHi a")
public class AppTbSearchHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CHANNEL_ID")
	private String channelId;

	@Column(name="CHANNEL_NAME")
	private String channelName;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Lob
	@Column(name="DIS_EXP")
	private String disExp;

	@Column(name="DIS_EXP_BAK1")
	private String disExpBak1;

	@Column(name="SEARCH_TYPE")
	private BigDecimal searchType;

	@Lob
	@Column(name="TRS_EXP")
	private String trsExp;

	@Column(name="TRS_EXP_BAK1")
	private String trsExpBak1;

	@Column(name="TRS_OPTION")
	private BigDecimal trsOption;

	@Column(name="TRS_SYNONYM")
	private String trsSynonym;

	@Column(name="TRS_TABLE")
	private String trsTable;

	@Column(name="USER_IP")
	private String userIp;

	private String username;

	@Id
	@Column(name="UUID")
	private String uuid;

	public AppTbSearchHi() {
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

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDisExp() {
		return this.disExp;
	}

	public void setDisExp(String disExp) {
		this.disExp = disExp;
	}

	public String getDisExpBak1() {
		return this.disExpBak1;
	}

	public void setDisExpBak1(String disExpBak1) {
		this.disExpBak1 = disExpBak1;
	}

	public BigDecimal getSearchType() {
		return this.searchType;
	}

	public void setSearchType(BigDecimal searchType) {
		this.searchType = searchType;
	}

	public String getTrsExp() {
		return this.trsExp;
	}

	public void setTrsExp(String trsExp) {
		this.trsExp = trsExp;
	}

	public String getTrsExpBak1() {
		return this.trsExpBak1;
	}

	public void setTrsExpBak1(String trsExpBak1) {
		this.trsExpBak1 = trsExpBak1;
	}

	public BigDecimal getTrsOption() {
		return this.trsOption;
	}

	public void setTrsOption(BigDecimal trsOption) {
		this.trsOption = trsOption;
	}

	public String getTrsSynonym() {
		return this.trsSynonym;
	}

	public void setTrsSynonym(String trsSynonym) {
		this.trsSynonym = trsSynonym;
	}

	public String getTrsTable() {
		return this.trsTable;
	}

	public void setTrsTable(String trsTable) {
		this.trsTable = trsTable;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}