package com.myproject.demo.domain.warpper;

public class CreateItemWrapper {
	
	private String itemName;
	private Double itemHigh;
	private Integer alertThrehold;
	
	public CreateItemWrapper() {
	}
	
	public CreateItemWrapper(String itemName, Double itemHigh, Integer alertThrehold) {
		this.itemName = itemName;
		this.itemHigh = itemHigh;
		this.alertThrehold = alertThrehold;
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

	public Integer getAlertThrehold() {
		return alertThrehold;
	}

	public void setAlertThrehold(Integer alertThrehold) {
		this.alertThrehold = alertThrehold;
	}
	
	
	

}
