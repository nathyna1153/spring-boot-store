package cl.nttlab.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nttlab.store.model.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Long>{
	
	Categoria findByNombreCategoria(String nombreCategoria);

}
