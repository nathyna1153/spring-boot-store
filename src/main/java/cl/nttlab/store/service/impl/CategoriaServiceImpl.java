package cl.nttlab.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.nttlab.store.dao.ICategoriaDAO;
import cl.nttlab.store.model.Categoria;
import cl.nttlab.store.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	
	@Autowired
	private ICategoriaDAO categoriaDao;

	@Override
	public List<Categoria> obtenerTodasCategorias() {
		return categoriaDao.findAll();
	}
}
