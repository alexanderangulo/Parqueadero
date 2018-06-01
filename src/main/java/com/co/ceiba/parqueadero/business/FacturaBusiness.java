package com.co.ceiba.parqueadero.business;

import java.util.Calendar;

public class FacturaBusiness {
	public static final int VALORHORACARRO = 1000;
	public static final int VALORDIACARRO = 8000;
	public static final int VALORHORAMOTO = 500;
	public static final int VALORDIAMOTO = 4000;
	public static final int VALORCILINDRAJE = 2000;
	public static final int CARRO=1;
	public static final int MOTO=2;
	
	
	public static String calcularDuracion(Calendar fechaIngre, Calendar fechaSalida) {

		long diferenciaMinutos = 0;
		long diferenciaHoras = 0;
		long diferenciaDias = 0;
		diferenciaMinutos = (fechaSalida.get(Calendar.MINUTE) - fechaIngre.get(Calendar.MINUTE));
		diferenciaHoras = (fechaSalida.get(Calendar.HOUR_OF_DAY) - fechaIngre.get(Calendar.HOUR_OF_DAY));
		diferenciaDias = (fechaSalida.get(Calendar.DAY_OF_YEAR) - fechaIngre.get(Calendar.DAY_OF_YEAR));
		if (diferenciaMinutos != 0) {
			++diferenciaHoras;
		}
		if (diferenciaHoras >= 9 && diferenciaHoras <= 24) {
			diferenciaHoras = 0;
			++diferenciaDias;
		}
		return (diferenciaDias + " " + diferenciaHoras);

	}

	public static int calculoDcobro(int tipoVehiculo, Calendar fechaIngre, Calendar fechaSalida, int cilindraje) {
		int costo = 0;
		if (tipoVehiculo == CARRO) {
			String[] resultado = calcularDuracion(fechaIngre, fechaSalida).split(" ");
			String dia = resultado[0];
			String hora = resultado[1];
			int costoDCarro = Integer.parseInt(dia) * VALORDIACARRO;
			int costoHCarro = Integer.parseInt(hora) * VALORHORACARRO;
			return costoDCarro + costoHCarro;

		} else if (tipoVehiculo == MOTO) {

			String[] resultado = calcularDuracion(fechaIngre, fechaSalida).split(" ");
			String dia = resultado[0];
			String hora = resultado[1];
			int costoDMoto = Integer.parseInt(dia) * VALORDIAMOTO;
			int costoHMoto = Integer.parseInt(hora) * VALORHORAMOTO;
			if (cilindraje <= 500) {
				return costoDMoto + costoHMoto;
			}
			return costoDMoto + costoHMoto + VALORCILINDRAJE;
		}

		return costo;
	}
}