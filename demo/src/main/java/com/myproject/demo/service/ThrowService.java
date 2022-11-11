package com.myproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myproject.demo.repositories.StockRepositories;

@Service
public class ThrowService {
	
	@Autowired
	private StockRepositories stockRepository;
	
//	public void checkItemnameAlreadyuse(String itemName) {
//		if(!stockRepository.findByItemName(itemName).isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this item name is already in stock ");
//		}
//	}

}
