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
	public void editUser(@RequestBody EditItemWrapper wrapper) {
		stockService.editItem(wrapper);
	}
	
	@PostMapping("/findItem")
	public StockEntity findItem(@RequestParam("id")Integer id) {
		return stockService.findItem(id);
	}
	
//	@PostMapping("/findUserByName")
//	public List<StockEntity> findUserByName(@RequestParam("itemName")String itemName) {
//		return stockService.findItemByName(itemName);
//	}
	
	@DeleteMapping("/deleteItem")
	public void deleteItem(@RequestParam("id")Integer id) {
		stockService.deleteItem(id);
	}

}
