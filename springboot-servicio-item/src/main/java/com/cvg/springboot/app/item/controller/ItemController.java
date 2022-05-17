package com.cvg.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvg.springboot.app.item.models.Item;
import com.cvg.springboot.app.item.models.Producto;
import com.cvg.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	@Qualifier("itemServiceFeign")
	private ItemService itemService;
	
	@GetMapping
	public List<Item> listar() {
		return this.itemService.findAll();
	}
	
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/{id}/cantidad/{cant}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cant) {
		return this.itemService.findById(id, cant);
	}
	
	public Item metodoAlternativo(Long id, Integer cant) {
		Item item = new Item();
		Producto prod = new Producto();
		
		item.setCantidad(cant);
		prod.setId(id);
		prod.setNombre(null);
		prod.setPrecio(0.0);
		item.setProducto(prod);
		return item;
	}
	
	
}
