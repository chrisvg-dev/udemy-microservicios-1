package springbootservicioproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootservicioproducto.models.entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long> {
	
}
