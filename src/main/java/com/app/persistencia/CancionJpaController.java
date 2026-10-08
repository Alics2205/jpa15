package com.app.persistencia;

import com.app.logica.Cancion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CancionJpaController {
	
	// "Fábrica" de conexiones con la base de datos.
	// Nos permite crear EntityManager, que son los que realmente hacen el trabajo.
	
	private EntityManagerFactory emf = null;

	// En el constructor indicamos qué unidad de persistencia usar.
	// El nombre "ejemplojpa" debe coincidir con el que está en persistence.xml.

	public CancionJpaController() {
		emf = Persistence.createEntityManagerFactory("ejemplojpa");
	}

	// Método que devuelve un nuevo EntityManager (una conexión lista para trabajar).
	// Podés pensarlo como: "dame un empleado que se conecte a la BD".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método para crear (persistir) una Canción en la base de datos.
	public void crear(Cancion canc) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (traemos al empleado).
			em = getEntityManager();
			
			// Iniciamos la transacción (arranca la promesa de que se hará todo o nada).
			em.getTransaction().begin();
			
			
			// Guardamos el objeto Cancion en la base (todavía no confirmado).
			em.persist(canc);
			
			// Confirmamos la transacción: ahora sí, el dato queda guardado en la BD.
			em.getTransaction().commit();
			
		} finally {
			// Cerramos la conexión si estaba abierta (el empleado termina su turno).
			if (em != null) {
				em.close();
			}
			
		}
	}
}

