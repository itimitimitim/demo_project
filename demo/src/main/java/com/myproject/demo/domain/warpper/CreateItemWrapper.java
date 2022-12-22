package com.myproject.demo.domain.warpper;

public class CreateItemWrapper {
	
	private String itemName;
	private Integer alertThrehold;
	
	public CreateItemWrapper() {
	}
	
	public CreateItemWrapper(String itemName, Integer alertThrehold) {
		this.itemName = itemName;
		this.alertThrehold = alertThrehold;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getAlertThrehold() {
		return alertThrehold;
	}

	public void setAlertThrehold(Integer alertThrehold) {
		this.alertThrehold = alertThrehold;
	}
	
	
	

}
