package com.verizon.inventoryservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.verizon.inventoryservice.model.Inventory;

@Service
public class InventoryService {
	private List<Inventory> stores = new ArrayList<>();
	
	@PostConstruct
	public void setup() {
		stores.add(new Inventory(333, true));
		stores.add(new Inventory(403, true));
		stores.add(new Inventory(267, false));
		stores.add(new Inventory(167, false));
	}
	
	public boolean getStatus(int id) {
		Inventory storex =  stores.stream().filter(store -> store.getId() == id).findAny().orElse(null);
		return storex.isStatus();
	}

	public Inventory createStore() {
		int randomId = (int) (Math.random()*300);
		Inventory storex = new Inventory(randomId, false);
		return storex;
	}
}
