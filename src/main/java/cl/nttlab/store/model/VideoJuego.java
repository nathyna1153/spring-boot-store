package cl.nttlab.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "video_juego")
public class VideoJuego  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	@Size(min = 2, max = 45)
	private String nombre;
	
	@Column(name = "plataforma", nullable = false)
	private String plataforma;
	
	@Column(name = "calificacion", nullable = false)
	private int calificacion; 
	
	@Column(name = "anio")	
	private String anio;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "precio", nullable = false)
	private int precio;
	
	@ManyToOne
	@JoinColumn(name ="id_categoria")
	private Categoria categoria;
	
	/*constructor vacio*/
	public VideoJuego() {
		
	}
	
	/* getter and setter*/
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
	
	
	
	
	
	
	
	

}
