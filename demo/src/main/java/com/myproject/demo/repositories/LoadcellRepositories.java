package com.myproject.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.demo.entity.LoadcellEntity;

@Repository
public interface LoadcellRepositories extends JpaRepository<LoadcellEntity, Integer> {
	public List<LoadcellEntity> findByItemName(String itemName);

}
