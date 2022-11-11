package com.myproject.demo.domain.warpper;

public class EditItemWrapper {
	
	private Integer itemID;
	private String itemName;
	
	public EditItemWrapper() {
	}

	public EditItemWrapper(Integer itemID, String itemName) {
		this.itemID = itemID;
		this.itemName = itemName;
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
	

}
