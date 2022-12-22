package com.myproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.domain.EnumDomain.AlertStatus;
import com.myproject.demo.domain.warpper.CreateItemWrapper;
import com.myproject.demo.domain.warpper.EditItemWrapper;
import com.myproject.demo.domain.warpper.UpdateItemWrapper;
import com.myproject.demo.entity.StockEntity;
import com.myproject.demo.repositories.StockRepositories;

@Service
public class StockService {
	
	@Autowired
	private StockRepositories stockRepository;
	
	@Autowired
	private ThrowService throwService;
	
	public void createItem(CreateItemWrapper wrapper) {
		throwService.checkItemnameAlreadyuse(wrapper.getItemName());
		
		StockEntity entity = new StockEntity();
		entity.setItemName(wrapper.getItemName());
		entity.setAmount(0);
		entity.setDistance(0.00);
		entity.setMaxDistance(0.00);
		entity.setAlertThrehold(wrapper.getAlertThrehold());
		entity.setAlertStatus(AlertStatus.LOW);
		stockRepository.save(entity);
	}
	
	public void editItem(EditItemWrapper wrapper) {
		StockEntity entity = stockRepository.findById(wrapper.getItemID()).get();
		entity.setItemName(wrapper.getItemName());
		entity.setAlertThrehold(wrapper.getAlertThrehold());
		stockRepository.save(entity);
		
		UpdateItemWrapper domain = new UpdateItemWrapper(wrapper.getItemID(), entity.getDistance());
		updateItem(domain);
		
	}
	
	public void setMaxDistance(Integer itemID) {
		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setMaxDistance(entity.getDistance());
		stockRepository.save(entity);
		
		UpdateItemWrapper wrapper = new UpdateItemWrapper(itemID, entity.getDistance());
		updateItem(wrapper);
	}
	
	public void setItemHigh(Integer itemID) {
		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setItemHight(entity.getMaxDistance() - entity.getDistance());
		stockRepository.save(entity);
		
		UpdateItemWrapper wrapper = new UpdateItemWrapper(itemID, entity.getDistance());
		updateItem(wrapper);
	}
	
	public void updateItem(UpdateItemWrapper wrapper) {
		StockEntity entity = stockRepository.findById(wrapper.getItemID()).get();
		entity.setDistance(wrapper.getDistance());
		stockRepository.save(entity);
		
		updateAmount(wrapper.getItemID(), wrapper.getDistance());
	}
	
	public void updateAmount(Integer itemID, Double distance) {
		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setAmount((int)((entity.getMaxDistance() - distance)/entity.getItemHight()));
		stockRepository.save(entity);
		
		updateAlertStatus(itemID);
	}
	
	public void updateAlertStatus(Integer itemID) {
		StockEntity entity = stockRepository.findById(itemID).get();
		
		if(entity.getAlertThrehold() >= entity.getAmount()) {
			entity.setAlertStatus(AlertStatus.LOW);
		}else {
			entity.setAlertStatus(AlertStatus.NORMAL);
		}
		stockRepository.save(entity);
	}
	
//	public StockEntity findItem(Integer id) {
//		StockEntity entity = stockRepository.findById(id).get();
//		return entity;
//		
//	}
//	
//	public List<StockEntity> findItemByName(String itemName) {
//		List<StockEntity> list = new ArrayList<StockEntity>();
//		list.addAll(stockRepository.findByItemName(itemName));
//		return list;
//		
//	}
	
	public void deleteItem(Integer id) {
		stockRepository.deleteById(id);
		
	}

}
