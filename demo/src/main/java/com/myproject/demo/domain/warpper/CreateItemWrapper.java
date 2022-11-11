package com.myproject.demo.domain.warpper;

public class CreateItemWrapper {
	
	private String itemName;
	private Integer amount;
	
	public CreateItemWrapper() {
	}
	
	public CreateItemWrapper(String itemName, Integer amount) {
		this.itemName = itemName;
		this.amount = amount;
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
	
	

}
