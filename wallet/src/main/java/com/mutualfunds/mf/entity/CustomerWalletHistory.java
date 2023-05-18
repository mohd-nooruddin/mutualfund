package com.mutualfunds.mf.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerWalletHistory")
public class CustomerWalletHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int walletId;
	private int customerId;
	private Double walletAmount;
	private int transactionTypeId;
	private Date transactionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(Double walletAmount) {
		this.walletAmount = walletAmount;
	}

	public int getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerWalletHistory(int id, int walletId, int customerId, Double walletAmount, int transactionTypeId,
			Date transactionDate) {
		super();
		this.id = id;
		this.walletId = walletId;
		this.customerId = customerId;
		this.walletAmount = walletAmount;
		this.transactionTypeId = transactionTypeId;
		this.transactionDate = transactionDate;
	}

	public CustomerWalletHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerWalletHistory [id=" + id + ", walletId=" + walletId + ", customerId=" + customerId
				+ ", walletAmount=" + walletAmount + ", transactionTypeId=" + transactionTypeId + ", transactionDate="
				+ transactionDate + "]";
	}
	
}
