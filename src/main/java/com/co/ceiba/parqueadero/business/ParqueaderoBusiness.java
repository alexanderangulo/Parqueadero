package com.co.ceiba.parqueadero.business;

public class ParqueaderoBusiness {

	private static final int DISPONIBILIDADMAXIMACARROS = 30;
	private static final int DISPONIBILIDADMAXMOTOS = 10;

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
		return (contadorCarros <= DISPONIBILIDADMAXIMACARROS);
	}

	public static boolean disponibilidadParqueaderoMotos(int contadorMotos) {
		return (contadorMotos <= DISPONIBILIDADMAXMOTOS);
	}

}
