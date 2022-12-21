package com.myproject.demo.domain.warpper;

public class EditItemWrapper {
	
	private Integer itemID;
	private String itemName;
	private Double itemHigh;
	
	public EditItemWrapper() {
	}

	public EditItemWrapper(Integer itemID, String itemName, Double itemHigh) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemHigh = itemHigh;
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

	public Double getItemHigh() {
		return itemHigh;
	}

	public void setItemHigh(Double itemHigh) {
		this.itemHigh = itemHigh;
	}
	

}
