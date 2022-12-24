package com.myproject.demo.domain.warpper;

public class UpdateItemLCWrapper {
	
	private Integer itemID;
	private Double currentWeight;
	
	public UpdateItemLCWrapper() {
		
	}

	public UpdateItemLCWrapper(Integer itemID, Double currentWeight) {
		this.itemID = itemID;
		this.currentWeight = currentWeight;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Double currentWeight) {
		this.currentWeight = currentWeight;
	}

}
