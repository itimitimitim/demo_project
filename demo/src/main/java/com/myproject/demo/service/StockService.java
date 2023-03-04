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
		throwService.checkAlertThrehold(wrapper.getAlertThrehold());
		
		StockEntity entity = new StockEntity(wrapper.getItemName(), 0, 0.00, 0.00, 0.00, wrapper.getAlertThrehold(), AlertStatus.LOW);
		stockRepository.save(entity);
	}
	
	public void editItem(EditItemWrapper wrapper) {
		throwService.checkItemID(wrapper.getItemID());
		throwService.checkItemnameAlreadyuse(wrapper.getItemName());
		throwService.checkAlertThrehold(wrapper.getAlertThrehold());
		
		StockEntity entity = stockRepository.findById(wrapper.getItemID()).get();
		entity.setItemName(wrapper.getItemName());
		entity.setAlertThrehold(wrapper.getAlertThrehold());
		stockRepository.save(entity);

		updateItem(new UpdateItemWrapper(wrapper.getItemID(), entity.getCurrentDistance()));
		
	}
	
	public void setMaxDistance(Integer itemID) {
		throwService.checkItemID(itemID);
		
		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setMaxDistance(entity.getCurrentDistance());
		stockRepository.save(entity);

		updateItem(new UpdateItemWrapper(itemID, entity.getCurrentDistance()));
	}
	
	public void setItemHigh(Integer itemID) {
		throwService.checkItemID(itemID);
		
		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setItemHight(Math.abs((entity.getMaxDistance() - entity.getCurrentDistance())));
		stockRepository.save(entity);

		updateItem(new UpdateItemWrapper(itemID, entity.getCurrentDistance()));
	}
	
	public void updateItem(UpdateItemWrapper wrapper) {
		throwService.checkItemID(wrapper.getItemID());
		
		StockEntity entity = stockRepository.findById(wrapper.getItemID()).get();
		entity.setCurrentDistance(wrapper.getCurrentDistance());
		stockRepository.save(entity);
		
		updateAmount(wrapper.getItemID(), wrapper.getCurrentDistance());
	}
	
	public void updateAmount(Integer itemID, Double currentDistance) {
		throwService.checkItemID(itemID);

		StockEntity entity = stockRepository.findById(itemID).get();
		entity.setAmount((int)((entity.getMaxDistance() - currentDistance)/entity.getItemHight()));
		stockRepository.save(entity);
		
		updateAlertStatus(itemID);
	}
	
	public void updateAlertStatus(Integer itemID) {
		throwService.checkItemID(itemID);
		
		StockEntity entity = stockRepository.findById(itemID).get();
		
		if(entity.getAlertThrehold() >= entity.getAmount()) {
			entity.setAlertStatus(AlertStatus.LOW);
		}else{
			entity.setAlertStatus(AlertStatus.NORMAL);
		}
		stockRepository.save(entity);
	}
	
	public StockEntity findItem(Integer itemID) {
		throwService.checkItemID(itemID);
		
		StockEntity entity = stockRepository.findById(itemID).get();
		return entity;
		
	}
	
//	public List<StockEntity> findItemByName(String itemName) {
//		List<StockEntity> list = new ArrayList<StockEntity>();
//		list.addAll(stockRepository.findByItemName(itemName));
//		return list;
//		
//	}
	
	public void deleteItem(Integer itemID) {
		throwService.checkItemID(itemID);
		
		stockRepository.deleteById(itemID);
	}
}
