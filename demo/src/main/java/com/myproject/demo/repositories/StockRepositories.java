package com.myproject.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.demo.entity.StockEntity;

@Repository
public interface StockRepositories extends JpaRepository<StockEntity, Integer> {
//	public List<StockEntity> findByItemName(String itemName);
}
