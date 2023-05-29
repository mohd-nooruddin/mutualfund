package com.user.registration.entity;

import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerWallet")
public class UserWalletEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletId;
//	private Long userId;
	private int customerId;
	private double walletBalance;
	@Nullable
	private Date TransationDate;
	public UserWalletEntity() {
		super();
	}
	public UserWalletEntity(Long walletId, int userId, Double walletBalance, Date transationDate) {
		super();
		this.walletId = walletId;
		this.customerId = userId;
		this.walletBalance = walletBalance;
		TransationDate = transationDate;
	}
	public UserWalletEntity(int userId, Double walletBalance, Date transationDate) {
		super();
		this.customerId = userId;
		this.walletBalance = walletBalance;
		TransationDate = transationDate;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public int getUserId() {
		return customerId;
	}
	public void setUserId(int userId) {
		this.customerId = userId;
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
	@Override
	public String toString() {
		return "UserWalletEntity [walletId=" + walletId + ", userId=" + customerId + ", walletBalance="
				+ walletBalance + ", TransationDate=" + TransationDate + "]";
	}
	
	

}