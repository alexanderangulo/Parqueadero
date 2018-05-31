package com.co.ceiba.parqueadero.business;

public class ParqueaderoBusiness {

	private static final int numMaxCarro = 30;
	private static final int numMaxMoto = 10;

	public static int contadorDCarros(int contadorCarros) {
		return ++contadorCarros;
	}

	public static int restarCarros(int contadorCarros) {
		return --contadorCarros;
	}

	public static int contadorDMotos(int contadorMotos) {
		return ++contadorMotos;
	}

	public static int restarMotos(int contadorMotos) {
		return --contadorMotos;
	}

	public static boolean disponibilidadParqueaderoCarros(int contadorCarros) {
		return (contadorCarros <= numMaxCarro);
	}

	public static boolean disponibilidadParqueaderoMotos(int contadorMotos) {
		return (contadorMotos <= numMaxMoto);
	}

}
