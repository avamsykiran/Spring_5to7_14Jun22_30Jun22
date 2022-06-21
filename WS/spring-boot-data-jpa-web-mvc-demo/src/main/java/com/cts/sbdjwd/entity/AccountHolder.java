package com.cts.sbdjwd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_holders")
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ahId;
	@Column(name="fnm",nullable = false)
	private String fullName;
	@Column(name="eid",nullable = false,unique = true)
	private String emailId;
	@Column(name = "cb")
	private Double currentBalance;
	
	public AccountHolder() {
		// TODO Auto-generated constructor stub
	}

	public AccountHolder(String fullName, String emailId) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
	}

	public Long getAhId() {
		return ahId;
	}

	public void setAhId(Long ahId) {
		this.ahId = ahId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "AccountHolder [ahId=" + ahId + ", fullName=" + fullName + ", emailId=" + emailId + ", currentBalance="
				+ currentBalance + "]";
	}
	
	
	
}
