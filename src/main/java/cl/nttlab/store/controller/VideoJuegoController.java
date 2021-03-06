package cl.nttlab.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cl.nttlab.store.model.VideoJuego;
import cl.nttlab.store.service.IVideoJuegoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/videojuego")
public class VideoJuegoController {
	
		@Autowired
		private IVideoJuegoService videoJuegoService;
		
		/* Traer listado de juegos*/
		@GetMapping(value = "", produces = "application/json")
		public ResponseEntity<?> obtenerTodo(){
		List<VideoJuego> videoJuegos = null;
		Map<String, Object> response = new HashMap<>();
		try {
			videoJuegos = videoJuegoService.obtenerTodosVideoJuegos();
		}catch (DataAccessException ex) {
			response.put("mensaje", "Errores al realizar la consulta.");
			response.put("error", ex.getMessage() + " : " + ex.getMostSpecificCause().getMessage());		
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (videoJuegos.size() == 0) {
			response.put("mensaje", "No hay video juegos registrados en la base de datos.");
			response.put("video juegos", videoJuegos);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "Actualmente la base de datos cuenta con: " + videoJuegos.size() + " registros");
		response.put("video juegos", videoJuegos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		
		/*mostrar un juego por id*/
		@GetMapping(value = "/videoJuegos/{id}", produces = "application/json")
		public ResponseEntity<?> showOne(@PathVariable Long id) {
			VideoJuego videoJuego = null;
			Map<String, Object> response = new HashMap<>();
			try {
				videoJuego = videoJuegoService.findById(id);
			} catch (DataAccessException ex) {
				response.put("mensaje", "Error al realizar la consulta.");
				response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if (videoJuego == null) {
				response.put("mensaje", "El video juego ID: " + id + " no existe en nuestros registros.");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<VideoJuego>(videoJuego, HttpStatus.OK);
		}
		
		/* Crea un nuevo juego, metodo Post*/
		@PostMapping(value = "/", produces = "application/json")
		public ResponseEntity<?> crear(@RequestBody VideoJuego videoJuego){
			
			VideoJuego nuevoVideoJuego = null;
			Map<String, Object> response = new HashMap<>();
			try {
				List<VideoJuego> videoJuegos = videoJuegoService.obtenerTodosVideoJuegos();
				if(videoJuegos != null) {
					for (VideoJuego e : videoJuegos) {
						if (e.getNombre().equalsIgnoreCase(videoJuego.getNombre())) {
							response.put("mensaje",
									"Error al registrar nuevo juego, ya que el juego existe en nuestros registros");
							return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
						}
					}
				}
				nuevoVideoJuego = videoJuegoService.save(videoJuego);
			}catch(DataAccessException ex) {
				response.put("mensaje", "Error al registrar un nuevo juego.");
				response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El nuevo juego se ha creado con exito.");
			response.put("video juego",  nuevoVideoJuego);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		/*actualiza datos del juego con putMapping*/
		@PutMapping(value = "videojuego/{id}", produces = "application/json")
		public ResponseEntity<?> actualizar(@RequestBody VideoJuego  videoJuego, @PathVariable Long id) {
			VideoJuego juegoActual = videoJuegoService.findById(id);
			VideoJuego juegoActualizado =null;
			Map<String, Object> response = new HashMap<>();
			if(juegoActual == null) {
				response.put("mensaje", "Nose puede editar. El empleado ID: " + id + "no existe" );
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			try {
				juegoActual.setNombre(videoJuego.getNombre());
				juegoActual.setPlataforma(videoJuego.getPlataforma());
				juegoActual.setCalificacion(videoJuego.getCalificacion());
				juegoActual.setAnio(videoJuego.getAnio());
				juegoActual.setUrl(videoJuego.getUrl());
				juegoActual.setCategoria(videoJuego.getCategoria());
				juegoActual.setPrecio(videoJuego.getPrecio());
				
				juegoActualizado = videoJuegoService.save(juegoActual);
			}catch (DataAccessException ex) {
				response.put("mensaje", "No se pudo actualizar ");
				response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);		
			}
			
			response.put("mensaje", "Juego Actualizado con exito");
			response.put("juego", juegoActualizado);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		/*Eliminar juego*/
		@DeleteMapping(value = "videojuegos/{id}")
		public ResponseEntity<?> eliminar(@PathVariable Long id){
			Map<String, Object> response = new HashMap<>();
			try {
			videoJuegoService.eliminar(id);
			}catch (DataAccessException ex) {
				response.put("mensaje", "Error al eliminar EL JUEGO de la base de datos.");
				response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "Juego eliminado exitosamente!!!!!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			
		}
				
		/*listar todos los videos juegos ++
		 * crear nuevo juevo	++
		 * traer un video juego por id ++
		 * traer un video juego por nombre
		 * traer por categoria
		 * Modificar el juego 		++
		 * Eliminar juego
		 * */

}
