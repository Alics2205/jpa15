package com.app.presentacion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.app.logica.Artista;
import com.app.logica.Cancion;
import com.app.logica.ControladoraLogica;


public class Main {
	public static void main(String[] args) {
		
		Calendar cal1 = new GregorianCalendar(1972, Calendar.AUGUST, 9);
		Date fechaJuanes = cal1.getTime();

		Calendar cal2 = new GregorianCalendar(2009, Calendar.DECEMBER, 11);
		Date fechaChepe = cal2.getTime();

		ControladoraLogica conLog = new ControladoraLogica();
		try {
			// CREAR AL MENOS DOS ARTISTAS, Y DOS CANCIONES
			
			Artista a1 = new Artista("Juanes", "Pop", "colombiano", 45, fechaJuanes);
			conLog.crearArtista(a1);

			Artista a2 = new Artista("Chepe", "Tango", "argentino", 17, fechaChepe);
			conLog.crearArtista(a2);

			Cancion c1 = new Cancion("y", 2.34f, 2000);
			conLog.crearCancion(c1);
			
			Cancion c2 = new Cancion("4", 4.67f, 2009);
			conLog.crearCancion(c2);
		} catch (Exception e) {
			System.out.println("No se pudo crear el elemento: " + e.getMessage());
		}

	}
}