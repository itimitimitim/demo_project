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
import com.myproject.demo.domain.warpper.UpdateItemLCWrapper;
import com.myproject.demo.entity.LoadcellEntity;
import com.myproject.demo.entity.StockEntity;
import com.myproject.demo.repositories.LoadcellRepositories;
import com.myproject.demo.service.LoadcellService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/lc")
public class LoadcellController {
	
	@Autowired
	private LoadcellService loadcellService;
	
	@Autowired
	private LoadcellRepositories loadcellRepository;
	
	@GetMapping("/items")
	public List<LoadcellEntity> items(){
		return loadcellRepository.findAll();
	}
	
	@PostMapping("/createItem")
	public void createItem(@RequestBody CreateItemWrapper wrapper) {
		loadcellService.createItem(wrapper);
	}
	
	@PostMapping("/editItem")
	public void editItem(@RequestBody EditItemWrapper wrapper) {
		loadcellService.editItem(wrapper);
	}
	
	@PostMapping("/updateItem")
	public void updateItem(@RequestBody UpdateItemLCWrapper wrapper) {
		loadcellService.updateItem(wrapper);
	}
	
	@PostMapping("/setItemWeight")
	public void setItemHigh(@RequestParam Integer itemID) {
		loadcellService.setItemWeight(itemID);
	}
	
	@GetMapping("/findItemByID")
	public LoadcellEntity findItem(@RequestParam("itemID")Integer itemID) {
		return loadcellService.findItem(itemID);
	}
	
	@DeleteMapping("/deleteItem")
	public void deleteItem(@RequestParam("id")Integer id) {
		loadcellService.deleteItem(id);
	}
	
	

}
