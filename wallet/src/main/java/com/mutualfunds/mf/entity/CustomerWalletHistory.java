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
	private Long id;
	private Long customerId;
	private Double walletAmount;
	private String description;
	private Date transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(Double walletAmount) {
		this.walletAmount = walletAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerWalletHistory(Long id, Long customerId, Double walletAmount, String description,
			Date transactionDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.walletAmount = walletAmount;
		this.description = description;
		this.transactionDate = transactionDate;
	}

	public CustomerWalletHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerWalletHistory [id=" + id + ", customerId=" + customerId + ", walletAmount=" + walletAmount
				+ ", description=" + description + ", transactionDate=" + transactionDate + "]";
	}

}
