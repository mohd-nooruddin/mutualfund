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
	private int walletId;
	private int customerId;
	private double walletBalance = 0;
	@Nullable
	private Date TransationDate;

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Date getTransationDate() {
		return TransationDate;
	}

	public void setTransationDate(Date transationDate) {
		TransationDate = transationDate;
	}

	public CustomerWalletEntity(int walletId, int customerId, double walletBalance, Date transationDate) {
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
