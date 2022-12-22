package com.myproject.demo.domain.warpper;

public class EditItemWrapper {
	
	private Integer itemID;
	private String itemName;
	private Integer alertThrehold;
	
	public EditItemWrapper() {
	}

	public EditItemWrapper(Integer itemID, String itemName, Integer alertThrehold) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.alertThrehold = alertThrehold;
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

	public Integer getAlertThrehold() {
		return alertThrehold;
	}

	public void setAlertThrehold(Integer alertThrehold) {
		this.alertThrehold = alertThrehold;
	}
	

}
