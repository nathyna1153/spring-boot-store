package cl.nttlab.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.nttlab.store.model.Categoria;
import cl.nttlab.store.service.ICategoriaService;


@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS cross-origin resource sharing
@RestController
@RequestMapping(value = "/categoria")
class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	

	@GetMapping(value = "", produces = "application/json")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categoria> obtenerTodasCategorias(){
		return categoriaService.obtenerTodasCategorias();
	}
}
