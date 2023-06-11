package com.mutualfunds.mf.entity;

import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerWallet")
public class CustomerWalletEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletId;
	private Long customerId;
	private Double walletBalance = 0.0;
	@Nullable
	private Date TransationDate;

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Date getTransationDate() {
		return TransationDate;
	}

	public void setTransationDate(Date transationDate) {
		TransationDate = transationDate;
	}

	public CustomerWalletEntity(Long walletId, Long customerId, Double walletBalance, Date transationDate) {
		super();
		this.walletId = walletId;
		this.customerId = customerId;
		this.walletBalance = walletBalance;
		TransationDate = transationDate;
	}

	public CustomerWalletEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerWalletEntity [walletId=" + walletId + ", customerId=" + customerId + ", walletBalance="
				+ walletBalance + ", TransationDate=" + TransationDate + "]";
	}

}
