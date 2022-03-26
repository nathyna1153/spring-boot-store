package cl.nttlab.store.service;

import java.util.List;

import cl.nttlab.store.model.Categoria;

public interface ICategoriaService {

	List<Categoria> obtenerTodasCategorias();

	Categoria findById(Long id);

}
