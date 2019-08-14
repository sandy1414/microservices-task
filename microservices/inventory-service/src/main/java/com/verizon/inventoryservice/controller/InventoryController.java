package com.verizon.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.inventoryservice.model.Inventory;
import com.verizon.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/store")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(method=RequestMethod.GET, value="/create")
	public Inventory createInventory() {
		return inventoryService.createStore();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public boolean getStatus(@PathVariable int id) {
		return inventoryService.getStatus(id);
	}
}
