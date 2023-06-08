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

	public void setMutualFundId(long mutualfundId) {
		this.mutualfundId = mutualfundId;
	}

	public WishlistEntity(long wishlistId, long customerId, long mutualfundId) {
		super();
		this.wishlistId = wishlistId;
		this.customerId = customerId;
		this.mutualfundId = mutualfundId;
	}

	public WishlistEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
