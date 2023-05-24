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
	private Long userId;
	private Double walletBalance;
	@Nullable
	private Date TransationDate;
	public UserWalletEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserWalletEntity(Long walletId, Long userId, Double walletBalance, Date transationDate) {
		super();
		this.walletId = walletId;
		this.userId = userId;
		this.walletBalance = walletBalance;
		TransationDate = transationDate;
	}
	public UserWalletEntity(Long userId, Double walletBalance, Date transationDate) {
		super();
		this.userId = userId;
		this.walletBalance = walletBalance;
		TransationDate = transationDate;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "UserWalletEntity [walletId=" + walletId + ", userId=" + userId + ", walletBalance="
				+ walletBalance + ", TransationDate=" + TransationDate + "]";
	}
	
	

}