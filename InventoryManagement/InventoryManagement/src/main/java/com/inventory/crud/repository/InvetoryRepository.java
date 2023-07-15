package com.inventory.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.crud.model.Inventory;

public interface InvetoryRepository extends CrudRepository<Inventory, Integer>{

}
