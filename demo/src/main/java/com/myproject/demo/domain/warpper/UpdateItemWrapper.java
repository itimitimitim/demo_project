package com.myproject.demo.domain.warpper;

public class UpdateItemWrapper {
	
	private Integer itemID;
	private Double distance;
	
	public UpdateItemWrapper() {
	}
	
	public UpdateItemWrapper(Integer itemID, Double distance) {
		this.itemID = itemID;
		this.distance = distance;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	

}
