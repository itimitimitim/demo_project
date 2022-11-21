package com.myproject.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.domain.warpper.CreateItemWrapper;
import com.myproject.demo.domain.warpper.EditItemWrapper;
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
		entity.setAmount(wrapper.getAmount());
		stockRepository.save(entity);
		
	}
	
	public void editItem(EditItemWrapper wrapper) {
		StockEntity entity = stockRepository.findById(wrapper.getItemID()).get();
		entity.setItemName(wrapper.getItemName());
		stockRepository.save(entity);
		
	}
	
	public StockEntity findItem(Integer id) {
		StockEntity entity = stockRepository.findById(id).get();
		return entity;
		
	}
	
	public List<StockEntity> findItemByName(String itemName) {
		List<StockEntity> list = new ArrayList<StockEntity>();
		list.addAll(stockRepository.findByItemName(itemName));
		return list;
		
	}
	
	public void deleteItem(Integer id) {
		stockRepository.deleteById(id);
		
	}

}
