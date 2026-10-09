package com.app.logica;
//esto es el backend*****************
//flujo de datos de una API

import com.app.persistencia.ControladoraPersistencia;
import java.util.List;
public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	// Desde aquí la usamos como "puente" para guardar datos.
	
	//creo objecto de la ControladoraPersistencia
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- ARTISTA -----
	// Método de la capa lógica para crear un artista.
	// Antes de guardarlo en la BD, se hacen validaciones.
	
	public void crearArtista(Artista art) throws Exception {
		// Validación: el artista debe tener un nombre SE VALIDA
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
		//throw new Exception quiere decir que genere un codigo pero que no avance 
			throw new Exception("El artista debe tener un nombre.");
		}
		// Validación: el artista debe tener un género musical 
		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un género musical.");
		}
		// Validación: la edad debe ser positiva
		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		}

		// AGREGAR AL MENOS UNA VALIDACIÓN MAS**************
		// Fecha de nacimiento no nula y en el pasado/presente
        if (art.getFechaNacimiento() == null) {
            throw new Exception("El artista debe tener una fecha de nacimiento.");
        }
		// Si pasa todas las validaciones, recién ahí se manda a la persistencia
		//LE PASSA EL DATO A LA CONTROLADORAPERSISTENCIA 
			// CONTROLADORAPERSISTENCIA  ESTA elige el metodo necesario
			controlPersis.crearArtista(art);
	}

	// ontiene todos los artistas desde la persistencia
		public List<Artista> listarArtistas() {
			return controlPersis.buscarTodosLosArtistas();
		}
		
		// busca un artista por ID
		public Artista buscarUnArtista(int id) {
			return controlPersis.buscarArtista(id);
		}
	
	// ----- CANCIÓN -----
	// Método de la capa lógica para crear una canción.
	// Se valida que tenga datos coherentes antes de persistirla.
	public void crearCancion(Cancion can) throws Exception {
		// Validación: el título no puede estar vacío
		if (can.getTitulo() == null || can.getTitulo().isEmpty()) {
			throw new Exception("La canción debe tener un título.");
		}
		// Validación: la duración debe ser mayor a cero
		if (can.getDuracion() <= 0) {
			throw new Exception("La duración debe ser mayor a 0 segundos.");
		}
		// Validación: el año debe tener sentido
		if (can.getAnio() < 1900) {
			throw new Exception("El año de la canción debe ser válido.");
		}
		
		// AGREGAR AL MENOS UNA VALIDACIÓN MAS

		// Si pasa todas las validaciones, se guarda en la base de datos
		controlPersis.crearCancion(can);
	}
	
	//obtiene todas las canciones desde la persistencia
		public List<Cancion> listarCanciones() {
			return controlPersis.buscarTodasLasCanciones();
		}

		//busca una canción por ID
		public Cancion buscarUnaCancion(int id) {
			return controlPersis.buscarCancion(id);
		}
	
	
}


