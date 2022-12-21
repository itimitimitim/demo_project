package com.myproject.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class StockEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemID;
	
	@Column(name="itemname")
	private String itemName;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="itemhigh")
	private Double itemHight;
	
	@Column(name="distance")
	private Double distance;
	
	@Column(name="maxdistance")
	private Double maxDistance;
	
	public StockEntity() {
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getItemHight() {
		return itemHight;
	}

	public void setItemHight(Double itemHight) {
		this.itemHight = itemHight;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	
	
}
