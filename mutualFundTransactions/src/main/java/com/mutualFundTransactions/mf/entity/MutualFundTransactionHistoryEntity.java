package com.mutualFundTransactions.mf.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "mutualfund_transaction_history")
public class MutualFundTransactionHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portfolio_id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "mutual_funds_id")
	private Long mutualFundsId;

	@Column(name = "type")
	private String type;

	@Column(name = "price")
	private Double price;

	@Column(name = "unit")
	private Integer unit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_date")
	private Date transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMutualFundsId() {
		return mutualFundsId;
	}

	public void setMutualFundsId(Long mutualFundsId) {
		this.mutualFundsId = mutualFundsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public MutualFundTransactionHistoryEntity(Long id, Long userId, Long mutualFundsId, String type, Double price,
			Integer unit, Date transactionDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.mutualFundsId = mutualFundsId;
		this.type = type;
		this.price = price;
		this.unit = unit;
		this.transactionDate = transactionDate;
	}

	public MutualFundTransactionHistoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
