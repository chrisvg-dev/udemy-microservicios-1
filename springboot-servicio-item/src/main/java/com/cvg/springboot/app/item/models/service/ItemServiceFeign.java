package com.cvg.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cvg.springboot.app.item.clientes.ProductoClienteRest;
import com.cvg.springboot.app.item.models.Item;
import com.cvg.springboot.app.item.models.Producto;

@Service("itemServiceFeign")
@Primary
public class ItemServiceFeign implements ItemService  {
	
	@Autowired
	private ProductoClienteRest clienteFeign; 

	@Override
	public List<Item> findAll() {		
		return this.clienteFeign.listar()
				.stream()
				.map(prod -> new Item(prod, 1))
				.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Producto prod = this.clienteFeign.detalle(id);
		System.out.println(prod);
		return new Item(prod, cantidad);
	}
}
