package com.mutualFundTransactions.mf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mutual_fund_transaction")
public class MutualFundTransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portfolio_id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "mutual_funds_id")
	private Long mutualFundsId;

	@Column(name = "price")
	private Double price;

	@Column(name = "unit")
	private Integer unit;

	// Constructors, getters, and setters

	public MutualFundTransactionEntity() {
		// Default constructor
	}


	public MutualFundTransactionEntity(Long id, Long userId, Long mutualFundsId, String type, Double price,
			Integer unit, Double investedWallet) {
		super();
		this.id = id;
		this.userId = userId;
		this.mutualFundsId = mutualFundsId;
		this.price = price;
		this.unit = unit;
	}

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
}
