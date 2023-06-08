package com.wishlist.mf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist")
public class WishlistEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wishlistId;
	private long customerId;
	private long mutualfundId;
	private String fundHouse;
	private String schemaName;
	private Double currentPrice;
	private Double delta;

	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getMutualfundId() {
		return mutualfundId;
	}

	public void setMutualfundId(long mutualfundId) {
		this.mutualfundId = mutualfundId;
	}

	public String getFundHouse() {
		return fundHouse;
	}

	public void setFundHouse(String fundHouse) {
		this.fundHouse = fundHouse;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Double getDelta() {
		return delta;
	}

	public void setDelta(Double delta) {
		this.delta = delta;
	}

	public WishlistEntity(long wishlistId, long customerId, long mutualfundId, String fundHouse, String schemaName,
			Double currentPrice, Double delta) {
		super();
		this.wishlistId = wishlistId;
		this.customerId = customerId;
		this.mutualfundId = mutualfundId;
		this.fundHouse = fundHouse;
		this.schemaName = schemaName;
		this.currentPrice = currentPrice;
		this.delta = delta;
	}

	public WishlistEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
