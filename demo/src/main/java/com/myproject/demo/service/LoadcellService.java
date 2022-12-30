package com.myproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.domain.EnumDomain.AlertStatus;
import com.myproject.demo.domain.warpper.CreateItemWrapper;
import com.myproject.demo.domain.warpper.EditItemWrapper;
import com.myproject.demo.domain.warpper.UpdateItemLCWrapper;
import com.myproject.demo.entity.LoadcellEntity;
import com.myproject.demo.entity.StockEntity;
import com.myproject.demo.repositories.LoadcellRepositories;

@Service
public class LoadcellService {
	
	@Autowired
	private LoadcellRepositories loadcellRepository;
	
	@Autowired
	private ThrowService throwService;
	
	public void createItem(CreateItemWrapper wrapper) {
		throwService.checkItemnameAlreadyuseLC(wrapper.getItemName());
		throwService.checkAlertThrehold(wrapper.getAlertThrehold());
		
		LoadcellEntity entity = new LoadcellEntity(wrapper.getItemName(), 0, 0.00, 0.00, wrapper.getAlertThrehold(), AlertStatus.LOW);
		loadcellRepository.save(entity);
	}
	
	public void editItem(EditItemWrapper wrapper) {
		throwService.checkItemIDLC(wrapper.getItemID());
		throwService.checkItemnameAlreadyuseLC(wrapper.getItemName());
		throwService.checkAlertThrehold(wrapper.getAlertThrehold());
		
		LoadcellEntity entity = loadcellRepository.findById(wrapper.getItemID()).get();
		entity.setItemName(wrapper.getItemName());
		entity.setAlertThrehold(wrapper.getAlertThrehold());
		loadcellRepository.save(entity);
		
		UpdateItemLCWrapper domain = new UpdateItemLCWrapper(wrapper.getItemID(), entity.getCurrentWeight());
		updateItem(domain);
		
	}
	
	public void setItemWeight(Integer itemID) {
		throwService.checkItemIDLC(itemID);
		
		LoadcellEntity entity = loadcellRepository.findById(itemID).get();
		entity.setItemWeight(entity.getCurrentWeight());
		loadcellRepository.save(entity);
		
		UpdateItemLCWrapper wrapper = new UpdateItemLCWrapper(itemID, entity.getCurrentWeight());
		updateItem(wrapper);
	}
	
	public void updateItem(UpdateItemLCWrapper wrapper) {
		throwService.checkItemIDLC(wrapper.getItemID());
		
		LoadcellEntity entity = loadcellRepository.findById(wrapper.getItemID()).get();
		entity.setCurrentWeight(wrapper.getCurrentWeight());
		loadcellRepository.save(entity);
		
		updateAmount(wrapper.getItemID(), wrapper.getCurrentWeight());
	}
	
	public void updateAmount(Integer itemID, Double currentWeight) {
		throwService.checkItemIDLC(itemID);
		
		LoadcellEntity entity = loadcellRepository.findById(itemID).get();
		entity.setAmount((int)((entity.getCurrentWeight()/entity.getItemWeight())));
		loadcellRepository.save(entity);
		
		updateAlertStatus(itemID);
	}
	
	public void updateAlertStatus(Integer itemID) {
		throwService.checkItemIDLC(itemID);
		
		LoadcellEntity entity = loadcellRepository.findById(itemID).get();
		
		if(entity.getAlertThrehold() >= entity.getAmount()) {
			entity.setAlertStatus(AlertStatus.LOW);
		}else{
			entity.setAlertStatus(AlertStatus.NORMAL);
		}
		loadcellRepository.save(entity);
	}
	
	public LoadcellEntity findItem(Integer itemID) {
		throwService.checkItemIDLC(itemID);
		
		LoadcellEntity entity = loadcellRepository.findById(itemID).get();
		return entity;
	}
	
	public void deleteItem(Integer itemID) {
		throwService.checkItemIDLC(itemID);
		
		loadcellRepository.deleteById(itemID);
	}
	

}
