package com.myproject.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myproject.demo.domain.EnumDomain.AlertStatus;

@Entity
@Table(name="loadcell_stock")
public class LoadcellEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemID;
	
	@Column(name="itemname")
	private String itemName;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="itemweight")
	private Double itemWeight;
	
	@Column(name="currentweight")
	private Double currentWeight;

	@Column(name="tare")
	private Double tare;
	
	@Column(name="alertthrehold")
	private Integer alertThrehold;
	
	@Column(name="alertstatus")
	@Enumerated(EnumType.STRING)
	private AlertStatus alertStatus;
	
	public LoadcellEntity() {
		
	}

	public LoadcellEntity(String itemName, Integer amount, Double itemWeight, Double currentWeight, Double tare,
			Integer alertThrehold, AlertStatus alertStatus) {
		this.itemName = itemName;
		this.amount = amount;
		this.itemWeight = itemWeight;
		this.currentWeight = currentWeight;
		this.tare = tare;
		this.alertThrehold = alertThrehold;
		this.alertStatus = alertStatus;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
	}

	public Double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public Integer getAlertThrehold() {
		return alertThrehold;
	}

	public void setAlertThrehold(Integer alertThrehold) {
		this.alertThrehold = alertThrehold;
	}

	public AlertStatus getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStatus(AlertStatus alertStatus) {
		this.alertStatus = alertStatus;
	}

	public Double getTare() {
		return tare;
	}

	public void setTare(Double tare) {
		this.tare = tare;
	}
}
