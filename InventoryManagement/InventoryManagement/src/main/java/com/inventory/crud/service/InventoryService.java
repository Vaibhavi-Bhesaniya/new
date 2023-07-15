package com.inventory.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.crud.model.Inventory;
import com.inventory.crud.repository.InvetoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InvetoryRepository invetoryRepository;
	
	public Inventory saveInventoryService(Inventory inventory) {
		System.out.println("name >>>"+inventory.getInventoryName());
		return invetoryRepository.save(inventory);
	}

	public Inventory getInventoryById(int id) {
		Optional<Inventory> optionalUser = invetoryRepository.findById(id);
        return optionalUser.get();
	}
}
