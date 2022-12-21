package com.myproject.demo.domain.warpper;

public class CreateItemWrapper {
	
	private String itemName;
	private Double itemHigh;
	
	public CreateItemWrapper() {
	}
	
	public CreateItemWrapper(String itemName, Double itemHigh) {
		this.itemName = itemName;
		this.itemHigh = itemHigh;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemHigh() {
		return itemHigh;
	}

	public void setItemHigh(Double itemHigh) {
		this.itemHigh = itemHigh;
	}

	
	

}
