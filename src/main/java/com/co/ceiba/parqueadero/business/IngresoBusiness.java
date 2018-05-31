package com.co.ceiba.parqueadero.business;

import java.util.Calendar;

public class IngresoBusiness {
	public  boolean validarDiaIngreso(Calendar fechaIngre, String placa) {
	return ((fechaIngre.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY 
				|| fechaIngre.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
					&& (placa.charAt(0) == "A".charAt(0)));
					
		}
}
