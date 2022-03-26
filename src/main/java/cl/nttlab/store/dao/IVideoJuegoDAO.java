package cl.nttlab.store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nttlab.store.model.Categoria;
import cl.nttlab.store.model.VideoJuego;

@Repository
public interface IVideoJuegoDAO extends JpaRepository<VideoJuego, Long>{
	
	VideoJuego findByNombre(String nombre);
	
	List<VideoJuego> findByNombreContaining(String nombre);
	
	List<VideoJuego> findByCategoria(Categoria categoria);
	
	Optional<VideoJuego> findById(Long id);
	

}
