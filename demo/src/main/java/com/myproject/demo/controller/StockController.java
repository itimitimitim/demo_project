package com.myproject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.domain.warpper.CreateItemWrapper;
import com.myproject.demo.domain.warpper.EditItemWrapper;
import com.myproject.demo.domain.warpper.UpdateItemWrapper;
import com.myproject.demo.entity.StockEntity;
import com.myproject.demo.repositories.StockRepositories;
import com.myproject.demo.service.StockService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockRepositories stockRepository;

	@GetMapping("/items")
	public List<StockEntity> items(){
		return stockRepository.findAll();
	}
	
	@PostMapping("/createItem")
	public void createItem(@RequestBody CreateItemWrapper wrapper) {
		stockService.createItem(wrapper);
	}
	
	@PostMapping("/editItem")
	public void editItem(@RequestBody EditItemWrapper wrapper) {
		stockService.editItem(wrapper);
	}
	
	@PostMapping("/updateItem")
	public void updateItem(@RequestBody UpdateItemWrapper wrapper) {
		stockService.updateItem(wrapper);
	}
	
	@PostMapping("/setMaxDistance")
	public void updateMaxDistance(@RequestParam Integer itemID) {
		stockService.setMaxDistance(itemID);
	}
	
	@PostMapping("/setItemHigh")
	public void setItemHigh(@RequestParam Integer itemID) {
		stockService.setItemHigh(itemID);
	}
	
	@GetMapping("/findItemByID")
	public StockEntity findItem(@RequestParam("itemID")Integer itemID) {
		return stockService.findItem(itemID);
	}
	
//	@PostMapping("/findUserByName")
//	public List<StockEntity> findUserByName(@RequestParam("itemName")String itemName) {
//		return stockService.findItemByName(itemName);
//	}
	
	@DeleteMapping("/deleteItem")
	public void deleteItem(@RequestParam("id")Integer itemID) {
		stockService.deleteItem(itemID);
	}

}
