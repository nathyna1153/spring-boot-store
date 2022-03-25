package cl.nttlab.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.nttlab.store.model.VideoJuego;



public interface IVideoJuegoService {
	
	List<VideoJuego> obtenerTodosVideoJuegos();

	VideoJuego save(VideoJuego juegoActual);

	VideoJuego findById(Long id);
	
	void eliminar(Long id);	
}
