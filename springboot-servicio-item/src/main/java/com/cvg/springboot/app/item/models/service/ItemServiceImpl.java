package com.cvg.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cvg.springboot.app.item.models.Item;
import com.cvg.springboot.app.item.models.Producto;

@Service("itemServiceRestTemplate")
public class ItemServiceImpl implements ItemService {
	private static final String URL = "http://servicio-productos/productos";
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		System.out.println("hello");
		// TODO Auto-generated method stub
		List<Producto> productos = Arrays.asList(
				this.clienteRest.getForObject(
						URL, 
						Producto[].class
				)
		);
		return productos.stream()
				.map(prod -> new Item(prod, 1))
				.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Producto producto = this.clienteRest.getForObject(
				URL.concat("/").concat(id.toString()), 
				Producto.class
		);
		return new Item(producto, cantidad);
	}

}
