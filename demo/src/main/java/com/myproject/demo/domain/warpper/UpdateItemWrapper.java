package com.myproject.demo.domain.warpper;

public class UpdateItemWrapper {
	
	private Integer itemID;
	private Double currentDistance;
	
	public UpdateItemWrapper() {
		
	}
	
	public UpdateItemWrapper(Integer itemID, Double currentDistance) {
		this.itemID = itemID;
		this.currentDistance = currentDistance;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Double getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(Double currentDistance) {
		this.currentDistance = currentDistance;
	}


}
