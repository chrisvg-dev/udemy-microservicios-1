package springbootservicioproducto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootservicioproducto.models.dao.ProductoDao;
import springbootservicioproducto.models.entity.Producto;

@Service
public class IProductoServiceImpl implements IProductoService {
	
	@Autowired private ProductoDao productoDao;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return this.productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return this.productoDao.findById(id).orElse(null);
	}

}
