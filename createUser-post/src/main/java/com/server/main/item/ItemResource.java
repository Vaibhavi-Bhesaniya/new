package com.server.main.item;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ItemResource {
	@Autowired
	private ItemDaoService service;

	@GetMapping("/items")
	public List<Item> retriveAllItems() {
		return service.findAll();
	}

	@GetMapping("/item/{id}")
	public Item retriveItem(@PathVariable int id) {
		System.out.println("cLL gET "+ id);
		return service.findOne(id);
	}

	@PostMapping("/items1")
	public ResponseEntity<Object> createItem(@Valid @RequestBody Item item) {
		System.out.println("cLL POST");
		Item sevedItem = service.save(item);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedItem.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}