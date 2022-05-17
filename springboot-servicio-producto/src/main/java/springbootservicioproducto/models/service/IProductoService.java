package springbootservicioproducto.models.service;

import java.util.List;

import springbootservicioproducto.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	public Producto findById(Long id);
}