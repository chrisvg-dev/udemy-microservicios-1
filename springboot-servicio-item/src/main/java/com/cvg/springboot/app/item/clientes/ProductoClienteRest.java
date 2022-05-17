package com.cvg.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cvg.springboot.app.item.models.Producto;

@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {
	
	@GetMapping("/productos")
	public List<Producto> listar();
	
	@GetMapping("/productos/{id}")
	public Producto detalle(@PathVariable Long id);
}
