package com.wishlist.mf.entity;

public class MutualFunds {
	private String fundHouse;
	private String schemaName;
	private Double currentPrice;
	private Double delta;

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

	public MutualFunds(String fundHouse, String schemaName, Double currentPrice, Double delta) {
		super();
		this.fundHouse = fundHouse;
		this.schemaName = schemaName;
		this.currentPrice = currentPrice;
		this.delta = delta;
	}

	public MutualFunds() {
		super();
		// TODO Auto-generated constructor stub
	}

}