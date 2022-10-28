package com.myproject.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.StockEntity;
import com.myproject.demo.repositories.StockRepositories;

@Service
public class StockService {
	
	@Autowired
	private StockRepositories stockRepository;
	
	public void createItem(String itemName, Integer amount) {
		StockEntity entity = new StockEntity();
		entity.setItemName(itemName);
		entity.setAmount(amount);
		stockRepository.save(entity);
		
	}
	
	public void editItem(Integer id, String itemName) {
		StockEntity entity = stockRepository.findById(id).get();
		entity.setItemName(itemName);
		stockRepository.save(entity);
		
	}
	
	public StockEntity findItem(Integer id) {
		StockEntity entity = stockRepository.findById(id).get();
		return entity;
		
	}
	
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
