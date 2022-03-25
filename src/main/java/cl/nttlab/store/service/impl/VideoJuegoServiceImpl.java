package cl.nttlab.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.nttlab.store.dao.IVideoJuegoDAO;
import cl.nttlab.store.model.VideoJuego;
import cl.nttlab.store.service.IVideoJuegoService;

@Service
public class VideoJuegoServiceImpl implements IVideoJuegoService {
	
	@Autowired
	private IVideoJuegoDAO videoJuegoDao;
	
	
	

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
		return videoJuegoDao.findById(id).get();
	}




	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		videoJuegoDao.deleteById(id);
	}
	
	
	
	
	
	
	
	
	

}
