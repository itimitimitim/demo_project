package com.myproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myproject.demo.repositories.LoadcellRepositories;
import com.myproject.demo.repositories.StockRepositories;

@Service
public class ThrowService {
	
	@Autowired
	private StockRepositories stockRepository;
	
	@Autowired
	private LoadcellRepositories loadcellRepository;
	
	public void checkItemID(Integer itemID) {
		if(stockRepository.findById(itemID).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dont have ID: "+itemID);
		}
	}
	
	public void checkItemIDLC(Integer itemID) {
		if(loadcellRepository.findById(itemID).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dont have ID: "+itemID);
		}
	}
	
	public void checkItemnameAlreadyuse(String itemName) {
		if(!stockRepository.findByItemName(itemName).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This item name is already in stock");
		}
	}
	
	public void checkItemnameAlreadyuseLC(String itemName) {
		if(!loadcellRepository.findByItemName(itemName).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This item name is already in stock");
		}
	}
	
	public void checkAlertThrehold(Integer alertThrehold) {
		if(alertThrehold < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Threhold must be positive");
		}
	}

}
