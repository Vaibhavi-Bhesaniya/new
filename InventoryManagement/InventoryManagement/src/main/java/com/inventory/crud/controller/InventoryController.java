package com.inventory.crud.controller;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.crud.model.Inventory;
import com.inventory.crud.service.InventoryService;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	
	@PostMapping("/saveInventory")
	public void saveInventory(@RequestBody Inventory inventory) {
		System.out.println("name controller >>"+inventory.getInventoryName());
		inventory = inventoryService.saveInventoryService(inventory);
		System.out.println("Contoller inventory >>"+inventory);
	}
	
	@GetMapping("/getAllInventory/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") int id){
		Inventory inventory = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
