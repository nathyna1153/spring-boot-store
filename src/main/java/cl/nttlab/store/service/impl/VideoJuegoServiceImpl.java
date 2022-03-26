package cl.nttlab.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.nttlab.store.dao.ICategoriaDAO;
import cl.nttlab.store.dao.IVideoJuegoDAO;
import cl.nttlab.store.model.Categoria;
import cl.nttlab.store.model.VideoJuego;
import cl.nttlab.store.service.IVideoJuegoService;

@Service
public class VideoJuegoServiceImpl implements IVideoJuegoService {
	
	@Autowired
	private IVideoJuegoDAO videoJuegoDao;
	
	@Autowired
	private ICategoriaDAO categoriaDao;
		
	

	@Override
	public List<VideoJuego> obtenerTodosVideoJuegos() {
		// TODO Auto-generated method stub
		return videoJuegoDao.findAll();
	}




	public VideoJuego save(VideoJuego videoJuego) {
		// TODO Auto-generated method stub
		return videoJuegoDao.save(videoJuego);
	}




	@Override
	public VideoJuego findById(Long id) {
		// TODO Auto-generated method stub
		Optional<VideoJuego> videoJuego = videoJuegoDao.findById(id);
		if(videoJuego.isEmpty()) {
			return null;
		}
		return videoJuego.get();
	}




	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		videoJuegoDao.deleteById(id);
	}




	@Override
	public List<VideoJuego> findByNombre(String nombre) {
		List<VideoJuego> videoJuegoList = videoJuegoDao.findByNombreContaining(nombre);
		return videoJuegoList;
	}




	@Override
	public List<VideoJuego> findByIdCargoria(Long idCategoria) {
		
		Optional<Categoria> categoria = categoriaDao.findById(idCategoria);
		if(categoria.isEmpty()) {
			return null;
		}
		List<VideoJuego> videoJuegoList = videoJuegoDao.findByCategoria(categoria.get());
		return videoJuegoList;
	}
	
	
	
	
	
	
	
	
	

}
